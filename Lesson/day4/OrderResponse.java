package Lesson.day4;

//get
public class OrderResponse {
    private String menuName;
    private int quantity;
    private int totalPrice;
    private String status;


    public OrderResponse(OrderEntity entity){
        this.menuName=entity.getMenuName();
        this.quantity=entity.getQuantity();
        this.totalPrice=entity.getPrice()*entity.getQuantity();
        this.status=entity.isReady()? "준비완료": "준비중";
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

    @Override
    public String toString() {
        return status+">>"+"메뉴: "+menuName+", 수량: "+quantity+", 총가격: "+totalPrice+"\n";
    }
}
