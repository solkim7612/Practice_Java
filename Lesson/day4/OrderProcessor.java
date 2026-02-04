package Lesson.day4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class OrderProcessor {
    /**
     * 과제 1: 조건에 맞는 주문들만 골라내기 (Predicate 활용)
     * 예: 가격이 1000원 이상인 주문만, 혹은 메뉴명이 "커피"인 주문만 필터링
     */
    public List<OrderEntity> filterOrders(List<OrderEntity> orders, Predicate<OrderEntity> condition) {
        List<OrderEntity> result = new ArrayList<>();
        // TODO: orders를 순회하며 condition.test()가 true인 것만 result에 담으세요.

        for(OrderEntity order: orders){
            if(condition.test(order)) result.add(order);
        }

        return result;
    }
    // =filter()
    // =and, or 로 조립?

    /**
     * 과제 2: 주문 리스트를 다른 형태의 리스트로 변환하기 (Function 활용)
     * 예: List<OrderEntity> -> List<OrderResponse> 또는 List<String> (메뉴명 리스트)
     */
    public <R> List<R> transformOrders(List<OrderEntity> orders, Function<OrderEntity, OrderResponse> transformer) {
        List<R> result = new ArrayList<>();
        // TODO: orders를 순회하며 transformer.apply() 결과를 result에 담으세요.

        for(OrderEntity order:orders){
            R r= (R) transformer.apply(order);
            result.add(r);
        }

        return result;
    }
    // =map()

    /**
     * 과제 3: 필터링된 주문들에 대해 특정 작업 수행하기 (Consumer 활용)
     * 예: 준비된 주문들만 골라서 "배송 시작" 로그 출력하기
     */
    public void executeAction(List<OrderEntity> orders, Predicate<OrderEntity> condition, Consumer<OrderEntity> action) {
        // TODO: condition.test()를 통과한 주문에 대해서만 action.accept()를 실행하세요.
        for(OrderEntity order:orders){
            if(condition.test(order)){
                action.accept(order);
            }
        }
    }
    // =forEach()

    /**
     * 과제 4: 주문이 없을 때 기본 주문 생성하기 (Supplier 활용)
     */
    public OrderEntity getOrDefault(OrderEntity order, Supplier<OrderEntity> defaultSupplier) {
        // TODO: order가 null이면 defaultSupplier.get() 결과를 반환하고, 아니면 order를 반환하세요.
        return order? order :  defaultSupplier.get();
    }
}
