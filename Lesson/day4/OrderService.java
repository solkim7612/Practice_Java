package Lesson.day4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService {

    HashMap<Long, OrderEntity> repo = new HashMap<>();
    Long id = 1L;


    public void registerOrder(OrderRequest request) {
        OrderEntity entity = new OrderEntity(id, request, 1200, 100);
        repo.put(id++, entity);
    }

    public OrderResponse getReceipt(Long id) {
        OrderEntity entity = repo.get(id);

        return new OrderResponse(entity);
    }

    public void completeOreder(Long id) {
        OrderEntity entity = repo.get(id);

        entity.complete();
    }

    //과제1: 모든 주문 내역 반환
    public List<OrderResponse> getAllReceipts() {
        Collection<OrderEntity> entities = repo.values();

        return entities.stream()
                .map(OrderResponse::new)
                .toList();
    }
    // map: 객체 생성

    //과제2: menuName 주문만 반환
    public List<OrderResponse> findOrdersByMenuName(String menuName) {
        return repo.values().stream()
                .filter(entity -> entity.getMenuName().contains(menuName))
                .map(OrderResponse::new)
                .toList();
    }
    //filter: boolean true 값만 통과

    //과제3: 모든 주문의 총 매출계산
    public int calculateTotalRevenue() {
        return repo.values().stream()
                .mapToInt(entity -> entity.getQuantity() * entity.getPrice())
                .sum();
    }
    //mapToInt: int로 변환

    //과제4: '준비완료'된 주문 카운트
    public long countCompletedOrders() {
        return repo.values().stream()
                .filter(OrderEntity::isReady)
                .count();
    }

}
