package Homework.day2;

public class TicketEntity {
    private long id;
    private TicketType type;
    private TicketStatus status;

    TicketEntity(long id, TicketType type, TicketStatus stauts) {
        this.id = id;
        this.type = type;
        this.status = stauts;
    }

    public boolean isReady() {
        return this.status == TicketStatus.READY;
    }

    public void reserve() {
        if (isReady()) this.status = TicketStatus.RESERVED;
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
