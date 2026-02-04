package Homework.day1;

public enum TicketStatus {
    READY,
    RESERVED,
    CANCELED
    ;

    public boolean isReady(){
        return this==READY;
    }
}
