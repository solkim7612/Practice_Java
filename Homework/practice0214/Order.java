package Homework.practice0214;

import java.time.LocalDateTime;

/**
 * TODO: 주문 Entity 클래스를 완성하세요.
 * <p>
 * 요구사항:
 * - id (Long), customerName (String), menuItem (MenuItem), quantity (int) → final
 * - status (OrderStatus) → 변경 가능 (final X), 초기값 WAITING
 * - orderedAt (LocalDateTime) → final, 생성 시점에 LocalDateTime.now()
 * - 상태 변경 메서드: startPreparing(), complete(), cancel()
 * - getTotalPrice(): menuItem의 price * quantity 반환
 * - getter 메서드들
 * <p>
 * 힌트: Ticket 클래스에서 status만 변경 가능했던 패턴을 참고하세요.
 */
public class Order {
    // TODO: 필드를 선언하세요
    private Long id;
    private String customerName;
    private MenuItem menuItem;
    private final int quantity;
    private OrderStatus status;
    private final LocalDateTime orderedAt;

    // TODO: 생성자를 만드세요 (status는 WAITING, orderedAt은 now())
    public Order(Long id, String customerName, MenuItem menuItem, int quantity, OrderStatus status, LocalDateTime orderedAt) {
        this.id = id;
        this.customerName = customerName;
        this.menuItem = menuItem;
        this.quantity = quantity;
        this.status = OrderStatus.WAITING;
        this.orderedAt = LocalDateTime.now();
    }

    // TODO: 상태 변경 메서드 3개를 만드세요
    //  - startPreparing() → PREPARING
    //  - complete() → COMPLETED
    //  - cancel() → CANCELLED
    public void startPreparing() {
        this.status = OrderStatus.PREPARING;
    }

    public void complete() {
        this.status = OrderStatus.COMPLETED;
    }

    public void cancel() {
        this.status = OrderStatus.CANCELLED;
    }

    // TODO: getTotalPrice() 메서드를 만드세요(price * quantity)
    public int getTotalPrice() {
        return this.menuItem.getPrice()*this.quantity;
    }

    // TODO: getter 메서드들을 만드세요
    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getOrderedAt() {
        return orderedAt;
    }
}
