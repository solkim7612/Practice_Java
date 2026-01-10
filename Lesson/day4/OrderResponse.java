package Lesson.day4;

public class OrderResponse {
    private String menuName;
    private int quantity;
    private int totalPrice;
    private String status;


    public OrderResponse(String menuName, int quantity, int totalPrice, String status){
        this.menuName=menuName;
        this.quantity=quantity;
        this.totalPrice=totalPrice;
        this.status=status;
    }


    public String getMenuName() {
        return menuName;
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
}
