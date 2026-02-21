package Homework.practice0214;

import Homework.practice0214.dto.OrderRequest;
import Homework.practice0214.dto.OrderResponse;

import java.util.List;
import java.util.Map;

/**
 * 카페 주문 관리 시스템 - 실행 및 테스트용 메인 클래스
 *
 * 모든 TODO를 구현한 뒤 이 클래스를 실행하여 결과를 확인하세요.
 * 각 단계별 예상 출력이 주석에 적혀 있습니다.
 */
public class CafeApp {
    public static void main(String[] args) {
        OrderService service = new OrderService();

        // ========== 메뉴 등록 (HashMap에 저장) ==========
        service.addMenu(new MenuItem(1L, "아메리카노", MenuCategory.COFFEE, 4500));
        service.addMenu(new MenuItem(2L, "카페라떼", MenuCategory.COFFEE, 5000));
        service.addMenu(new MenuItem(3L, "초코케이크", MenuCategory.DESSERT, 6500));
        service.addMenu(new MenuItem(4L, "레몬에이드", MenuCategory.BEVERAGE, 5500));

        System.out.println("====== 1단계: 주문 접수 (HashMap + Queue) ======");
        OrderResponse order1 = service.placeOrder(new OrderRequest(1L, "김철수", 2));
        OrderResponse order2 = service.placeOrder(new OrderRequest(2L, "이영희", 1));
        OrderResponse order3 = service.placeOrder(new OrderRequest(3L, "박민수", 1));
        OrderResponse order4 = service.placeOrder(new OrderRequest(1L, "최지은", 3));
        System.out.println(order1);  // [주문 #1] 김철수님 | 아메리카노(커피) x2 | 9,000원 | WAITING
        System.out.println(order2);  // [주문 #2] 이영희님 | 카페라떼(커피) x1 | 5,000원 | WAITING
        System.out.println(order3);  // [주문 #3] 박민수님 | 초코케이크(디저트) x1 | 6,500원 | WAITING
        System.out.println(order4);  // [주문 #4] 최지은님 | 아메리카노(커피) x3 | 13,500원 | WAITING
        System.out.println("대기 주문 수: " + service.getWaitingOrderCount()); // 4

        System.out.println();
        System.out.println("====== 2단계: 주문 처리 (Queue - FIFO) ======");
        OrderResponse processed1 = service.processNextOrder();
        OrderResponse processed2 = service.processNextOrder();
        System.out.println("처리 시작: " + processed1);  // 김철수 (먼저 주문했으므로 먼저 나옴)
        System.out.println("처리 시작: " + processed2);  // 이영희 (그 다음)
        System.out.println("남은 대기 주문 수: " + service.getWaitingOrderCount()); // 2

        System.out.println();
        System.out.println("====== 3단계: 주문 완료 (Stack에 이력 저장) ======");
        OrderResponse completed1 = service.completeOrder(1L);
        OrderResponse completed2 = service.completeOrder(2L);
        System.out.println("완료: " + completed1);  // 김철수 - COMPLETED
        System.out.println("완료: " + completed2);  // 이영희 - COMPLETED
        System.out.println("완료 이력 수: " + service.getCompletedHistoryCount()); // 2

        System.out.println();
        System.out.println("====== 4단계: 되돌리기 (Stack - LIFO) ======");
        OrderResponse undone = service.undoLastComplete();
        System.out.println("되돌림: " + undone);  // 이영희 (LIFO - 마지막 완료가 먼저 되돌려짐)
        System.out.println("완료 이력 수: " + service.getCompletedHistoryCount()); // 1

        System.out.println();
        System.out.println("====== 5단계: 카테고리별 조회 (List + Stream) ======");
        List<OrderResponse> coffeeOrders = service.getOrdersByCategory(MenuCategory.COFFEE);
        System.out.println("커피 주문 목록:");
        coffeeOrders.forEach(o -> System.out.println("  " + o)); // 3건 (김철수, 이영희, 최지은)

        System.out.println();
        System.out.println("====== 6단계: 메뉴별 주문 횟수 (HashMap 집계) ======");
        Map<String, Long> countByMenu = service.getOrderCountByMenu();
        countByMenu.forEach((menu, count) ->
                System.out.println("  " + menu + ": " + count + "건"));
        // 아메리카노: 2, 카페라떼: 1, 초코케이크: 1

        System.out.println();
        System.out.println("====== 7단계: 매출 계산 (Stream 집계) ======");
        long revenue = service.calculateTotalRevenue();
        System.out.println("총 매출: " + String.format("%,d", revenue) + "원");
        // 김철수 아메리카노 x2 = 9,000원 (COMPLETED 상태만)

        System.out.println();
        System.out.println("====== 예외 처리 테스트 ======");
        try {
            service.placeOrder(new OrderRequest(999L, "테스트", 1));
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
