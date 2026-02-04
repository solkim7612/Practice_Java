package Homework.day1;

public enum TicketType {
    VIP("우수회원", 200000, 0.1f),
    REGULAR("일반회원", 100000, 0.05f);

    private final String type;
    private final int price;
    private final float fee;

    TicketType(String type, int price, float fee) {
        this.type = type;
        this.price = price;
        this.fee = fee;
    }

    //Getter
    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public float getFee() {
        return fee;
    }

    public float calculateTotalPrice() {
        return (price + price * fee);
    }
}
