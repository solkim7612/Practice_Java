package Homework.day2;

public class TicketException extends RuntimeException {
    public TicketException(TicketErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
