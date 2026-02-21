package Homework.practice0214.dto;

import Homework.practice0214.Order;

/**
 * TODO: 주문 응답 DTO를 완성하세요.
 * <p>
 * 요구사항:
 * - orderId (Long), customerName (String), menuName (String),
 * categoryName (String), quantity (int), totalPrice (int), status (String)
 * - Order 객체를 받는 생성자에서 각 필드를 변환하여 저장
 * - toString() 오버라이드 (출력 형식은 아래 참고)
 * <p>
 * 출력 형식:
 * "[주문 #1] 김철수님 | 아메리카노(커피) x2 | 9,000원 | WAITING"
 * <p>
 * 힌트:
 * - TicketResponse처럼 Entity → DTO 변환 생성자를 만드세요.
 * - String.format("%,d", price) 으로 천 단위 쉼표 표시 가능
 */
public class OrderResponse {
    // TODO: 필드를 선언하세요 (private final)
    private final Long orderId;
    private final String customerName;
    private final String menuName;
    private final String categoryName;
    private final int quantity;
    private final int totalPrice;
    private final String status;

    // TODO: Order를 받아서 변환하는 생성자를 만드세요
    //  - orderId       ← order.getId()
    //  - customerName  ← order.getCustomerName()
    //  - menuName      ← order.getMenuItem().getName()
    //  - categoryName  ← order.getMenuItem().getCategory().getDisplayName()
    //  - quantity      ← order.getQuantity()
    //  - totalPrice    ← order.getTotalPrice()
    //  - status        ← order.getStatus().name()
    public OrderResponse(Order order) {
        this.orderId = order.getId();
        this.customerName = order.getCustomerName();
        this.menuName = order.getMenuItem().getName();
        this.categoryName = order.getMenuItem().getCategory().getDisplayName();
        this.quantity = order.getQuantity();
        this.totalPrice = order.getTotalPrice();
        this.status = order.getStatus().name();
    }

    // TODO: getter 메서드를 만드세요
    public Long getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }

    // TODO: toString()을 오버라이드하세요
    // "[주문 #1] 김철수님 | 아메리카노(커피) x2 | 9,000원 | WAITING"
    @Override
    public String toString() {
        return String.format("[주문 #%s] %s님 | %s(%s) x%d | %d원 | %s", orderId, customerName, menuName, categoryName, quantity, totalPrice, status);
    }
}
