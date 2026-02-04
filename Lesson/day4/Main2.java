package Lesson.day4;

public class Main2 {
    public static void main(String[] args) {
        OrderFunction function=new OrderFunction(new OrderService());
        function.findOrders(order -> order.getPrice()>1000);
        function.transformOrders(OrderEntity::getMenuName);
        function.processOrders(order-> !order.isReady(), order->{
            order.complete();
            System.out.println(order.getMenuName());
        });
        function.getOrderSafe(100L, ()->new OrderEntity(100L, new OrderRequest("ss", 1), 1000, 2));
    }

}
