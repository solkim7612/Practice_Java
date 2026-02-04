package Homework.day2;

public class ResponseDTO {
    private final long id;
    private final String membership;
    private final double totalPrice;
    private final String status;

    ResponseDTO(TicketEntity entity) {
        this.id = entity.getId();
        this.membership = entity.getType().name();
        this.totalPrice = entity.getType().calc();
        this.status = entity.getStatus().name();
    }

    //getter

    public long getId() {
        return id;
    }

    public String getMembership() {
        return membership;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }
}
