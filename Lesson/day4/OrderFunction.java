package Lesson.day4;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class OrderFunction {
    private final OrderService orderService;

    public OrderFunction(OrderService orderService) {
        this.orderService = orderService;
    }

    public List<OrderEntity> findOrders(Predicate<OrderEntity> condition) {
        return orderService.repo.values().stream()
                .filter(condition)
                .toList();
    }

    public <R> List<R> transformOrders(Function<OrderEntity, R> transformer) {
        return orderService.repo.values().stream()
                .map(transformer)
                .toList();
    }

    public void processOrders(Predicate<OrderEntity> condition, Consumer<OrderEntity> action) {
        findOrders(condition).forEach(action);
    }

    public OrderEntity getOrderSafe(Long id, Supplier<OrderEntity> defaultSupplier) {
        return Optional.ofNullable(orderService.repo.get(id)).orElseGet(defaultSupplier);
    }
}
