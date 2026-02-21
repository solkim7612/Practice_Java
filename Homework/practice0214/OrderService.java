package Homework.practice0214;

import Homework.practice0214.dto.OrderRequest;
import Homework.practice0214.dto.OrderResponse;
import Homework.practice0214.exception.OrderBusinessException;
import Homework.practice0214.exception.OrderErrorCode;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * ========================================================
 * 카페 주문 관리 시스템 (Cafe Order Management System)
 * ========================================================
 * <p>
 * 이 실습에서 활용하는 자료구조 4가지:
 * <p>
 * 1. HashMap  → 메뉴판 (ID로 빠르게 조회하는 해시 테이블)
 * 2. Queue    → 주문 대기열 (먼저 주문한 사람부터 처리하는 FIFO)
 * 3. Stack    → 완료 이력 (가장 최근 완료를 되돌리는 LIFO)
 * 4. List     → 전체 주문 기록 (순서대로 저장, 검색/필터링 활용)
 * <p>
 * 비유:
 * - HashMap = 벽에 붙은 메뉴판 (번호만 알면 바로 찾을 수 있음)
 * - Queue   = 카페 앞 줄 서기 (먼저 온 손님이 먼저 음료를 받음)
 * - Stack   = 쌓인 접시 더미 (맨 위 접시부터 치울 수 있음)
 * - List    = 주문 장부 (모든 주문을 순서대로 기록)
 */
public class OrderService {

    // ===================== 자료구조 선언 =====================

    // 메뉴판: 메뉴 ID → MenuItem 으로 O(1) 조회가능한 자료구조 프로퍼티 선언
    private final Map<Long, MenuItem> menuDb = new HashMap<>();

    // [Queue] 주문 대기열: 선입선출(FIFO) - LinkedList가 Queue 인터페이스를 구현
    private final Queue<Order> orderQueue = new LinkedList<>();

    // [Stack] 완료 이력: 후입선출(LIFO) - 가장 최근 완료부터 되돌리기
    private final Stack<Order> completedHistory = new Stack<>();

    // [List] 전체 주문 기록: 인덱스 기반 접근 + Stream 필터링
    private final List<Order> allOrders = new ArrayList<>();

    private long orderIdSequence = 1;

    // ===================== 메뉴 등록 (제공) =====================

    public void addMenu(MenuItem item) {
        menuDb.put(item.getId(), item);
    }

    // ===================== TODO 구현 영역 =====================

    /**
     * TODO 1: [HashMap 활용] 주문 접수
     * <p>
     * 카페에 손님이 주문을 넣는 상황입니다.
     * 메뉴판(HashMap)에서 메뉴를 찾고, 대기열(Queue)에 주문을 추가하세요.
     * <p>
     * 구현 순서:
     * 1. menuDb에서 request.getMenuId()로 MenuItem을 조회
     * - 없으면 OrderBusinessException(MENU_NOT_FOUND) 던지기
     * 2. Order 객체 생성 (id는 orderIdSequence++ 사용)
     * 3. orderQueue에 주문 추가 (대기열 진입)
     * 4. allOrders에도 주문 추가 (전체 기록 보관)
     * 5. OrderResponse로 변환하여 반환
     * <p>
     * 힌트:
     * - HashMap 조회: menuDb.get(key) → 없으면 null
     * - Queue 추가: offer() 또는 add()
     * - Optional.ofNullable()을 활용하면 null 체크가 깔끔해집니다
     */
    public OrderResponse placeOrder(OrderRequest request) {
        // TODO 1: 구현하세요
        MenuItem item = Optional.ofNullable(menuDb.get(request.getMenuId()))
                .orElseThrow(() -> new OrderBusinessException(OrderErrorCode.MENU_NOT_FOUND));

        Order order = new Order(orderIdSequence++,
                request.getCustomerName(),
                item,
                request.getQuantity(),
                OrderStatus.WAITING,
                LocalDateTime.now()
        );

        orderQueue.add(order);

        allOrders.add(order);

        return new OrderResponse(order);
    }

    /**
     * TODO 2: [Queue 활용] 다음 주문 처리 (바리스타가 주문을 꺼냄)
     * <p>
     * 바리스타가 대기열에서 다음 주문을 꺼내 준비를 시작합니다.
     * Queue의 FIFO 특성을 이용하여 '먼저 들어온 주문'을 먼저 꺼내세요.
     * <p>
     * 구현 순서:
     * 1. orderQueue에서 다음 주문을 꺼내기 (FIFO)
     * - 대기열이 비어있으면 OrderBusinessException(NO_WAITING_ORDER)
     * 2. 주문 상태를 PREPARING으로 변경
     * 3. OrderResponse로 변환하여 반환
     * <p>
     * 힌트:
     * - Queue 꺼내기: poll() → 비어있으면 null 반환
     * remove() → 비어있으면 예외 발생
     * - 조회만 하려면: peek()
     */
    public OrderResponse processNextOrder() {
        // TODO 2
        Order order = Optional.ofNullable(orderQueue.poll())
                .orElseThrow(() -> new OrderBusinessException(OrderErrorCode.NO_WAITING_ORDER));

        order.startPreparing();

        return new OrderResponse(order);
    }

    /**
     * TODO 3: [Stack 활용] 주문 완료 처리
     * <p>
     * 음료 제조가 끝나 손님에게 전달합니다.
     * 완료된 주문을 Stack에 쌓아두면 나중에 '되돌리기'가 가능합니다.
     * <p>
     * 구현 순서:
     * 1. allOrders에서 orderId로 주문을 찾기
     * - 없으면 OrderBusinessException(ORDER_NOT_FOUND)
     * 2. 주문 상태를 COMPLETED로 변경
     * 3. completedHistory(Stack)에 push
     * 4. OrderResponse로 변환하여 반환
     * <p>
     * 힌트:
     * - List에서 특정 조건 검색: stream().filter().findFirst()
     * - Stack 추가: push()
     */
    public OrderResponse completeOrder(Long orderId) {
        // TODO 3: 구현하세요
        Order order = allOrders.stream()
                .filter(o -> o.getId().equals(orderId))
                .findFirst()
                .orElseThrow(() -> new OrderBusinessException(OrderErrorCode.ORDER_NOT_FOUND));

        order.complete();

        completedHistory.push(order);

        return new OrderResponse(order);
    }

    /**
     * TODO 4: [Stack 활용] 최근 완료 주문 되돌리기 (Undo)
     * <p>
     * "잘못된 주문을 완료 처리했어요!" → 가장 최근 완료를 되돌립니다.
     * Stack의 LIFO 특성으로 '마지막에 완료한 주문'부터 되돌립니다.
     * <p>
     * 구현 순서:
     * 1. completedHistory에서 가장 최근 완료 주문을 꺼내기 (LIFO)
     * - 이력이 비어있으면 OrderBusinessException(NO_COMPLETED_ORDER)
     * 2. 주문 상태를 다시 PREPARING으로 변경
     * 3. OrderResponse로 변환하여 반환
     * <p>
     * 힌트:
     * - Stack 꺼내기: pop() → 제거하면서 반환
     * - 조회만: peek() → 꺼내지 않고 확인
     * - 비어있는지: empty()
     */
    public OrderResponse undoLastComplete() {
        // TODO 4: 구현하세요
        Order order = Optional.ofNullable(completedHistory.pop())
                .orElseThrow(() -> new OrderBusinessException(OrderErrorCode.NO_COMPLETED_ORDER));

        order.startPreparing();

        return new OrderResponse(order);
    }

    /**
     * TODO 5: [List + Stream] 카테고리별 주문 조회
     * <p>
     * "커피 주문만 보여주세요" 같은 필터링 요청을 처리합니다.
     * <p>
     * 구현 순서:
     * 1. allOrders를 Stream으로 변환
     * 2. MenuItem의 category가 파라미터와 일치하는 것만 필터
     * 3. OrderResponse로 변환
     * 4. List로 수집하여 반환
     * <p>
     * 힌트: stream().filter(조건).map(변환).collect(Collectors.toList())
     */
    public List<OrderResponse> getOrdersByCategory(MenuCategory category) {
        // TODO 5: 구현하세요
        return allOrders.stream()
                .filter(o -> o.getMenuItem().getCategory().getDisplayName().equals(category))
                .map(OrderResponse::new)
                .collect(Collectors.toList());
    }

    /**
     * TODO 6: [HashMap + Stream] 메뉴별 주문 횟수 집계
     * <p>
     * "어떤 메뉴가 가장 많이 팔렸나요?" → 통계 데이터를 Map으로 반환합니다.
     * 결과 예시: {"아메리카노": 2, "카페라떼": 1, "초코케이크": 1}
     * <p>
     * 힌트: Collectors.groupingBy(분류기준, Collectors.counting())
     */
    public Map<String, Long> getOrderCountByMenu() {
        // TODO 6: 구현하세요
        return allOrders.stream()
                .collect(Collectors.groupingBy(
                        o -> o.getMenuItem().getCategory().getDisplayName(),
                        Collectors.counting()
                ));
    }

    /**
     * TODO 7: [List + Stream] 총 매출 계산
     * <p>
     * COMPLETED 상태인 주문들의 총 금액(수량 x 가격)을 합산하세요.
     * <p>
     * 힌트: filter() → mapToInt() → sum()
     */
    public long calculateTotalRevenue() {
        // TODO 7: 구현하세요
        return allOrders.stream()
                .filter(o -> o.getStatus()==OrderStatus.COMPLETED)
                .mapToInt(Order::getTotalPrice)
                .sum();
    }

    // ===================== 유틸리티 메서드 (제공) =====================

    public int getWaitingOrderCount() {
        return orderQueue.size();
    }

    public int getCompletedHistoryCount() {
        return completedHistory.size();
    }

    public int getTotalOrderCount() {
        return allOrders.size();
    }
}
