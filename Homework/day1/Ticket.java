package Homework.day1;

public class Ticket {
    private long id;
    private TicketType type;
    private TicketStatus status;

    //예약함수
    public void reserve(){
        if(status.isReady()) {
            status=TicketStatus.RESERVED;
        }
    }


    //getter
    public long getId() {
        return id;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public TicketType getType() {
        return type;
    }
}
