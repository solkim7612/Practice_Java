package Homework.day1;

public class TicketResponse {
    private final Long ticketId;
    private final String membershipName;
    private final float totalPrice;
    private final String status;


    public TicketResponse(Ticket ticket) {
        ticketId=ticket.getId();
        membershipName=ticket.getType().getType();
        totalPrice=ticket.getType().calculateTotalPrice();
        status=ticket.getStatus().name();
    }

    public String getStatus() {
        return status;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public String getMembershipName() {
        return membershipName;
    }
}
