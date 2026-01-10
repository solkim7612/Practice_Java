package Lesson.day4;

public class OrderEntity {
    private Long id;
    private String menuName;
    private int quantity;
    private int price;
    private int cost;
    private boolean isReady;

    public OrderEntity(Long id, OrderRequest request, int price, int cost) {
        this.id = id;
        this.menuName = request.getMenuName();
        this.quantity = request.getQuantity();
        this.price = price;
        this.cost = cost;
    }


    public void complete(){
        this.isReady=true;
    }

    public Long getId() {
        return id;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getCost() {
        return cost;
    }

    public boolean isReady(){
        return isReady;
    }
}
