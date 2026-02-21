package Homework.practice0214.dto;

import Homework.practice0214.Order;

/**
 * TODO: 주문 요청 DTO를 완성하세요.
 * <p>
 * 요구사항:
 * - menuId (Long), customerName (String), quantity (int) 필드
 * - 생성자와 getter 구현
 * <p>
 * 힌트: ReservationRequest 클래스를 참고하세요.
 * DTO는 데이터를 담아 전달하는 그릇입니다. (Entity와 분리!)
 */
public class OrderRequest {
    // TODO: 필드를 선언하세요
    private Long menuId;
    private String customerName;
    private final int quantity;

    // TODO: 생성자를 만드세요
    public OrderRequest(Order order) {
        this.menuId = order.getMenuItem().getId();
        this.customerName = order.getCustomerName();
        this.quantity = order.getQuantity();
    }

    // TODO: getter 메서드를 만드세요
    public Long getMenuId() {
        return menuId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getQuantity() {
        return quantity;
    }
}
