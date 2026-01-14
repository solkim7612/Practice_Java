package Lesson.day4;

//post
public class OrderRequest {
        private String menuName;
        private int quantity;

    public OrderRequest(String menuName, int quantity) {
        this.menuName = menuName;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getMenuName() {
        return menuName;
    }
}
