package Homework.day2;

public enum TicketType {
    VIP(200000, 0.1),
    REGULAR(100000, 0.05)
    ;

    private int price;
    private double fee;

    TicketType(int price, double fee) {
        this.price=price;
        this.fee=fee;
    }

    public double calc(){
        return price+price*fee;
    }

    //getter
    public double getFee() {
        return fee;
    }

    public int getPrice() {
        return price;
    }
}
