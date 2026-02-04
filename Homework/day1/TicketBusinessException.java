package Homework.day1;

public class TicketBusinessException extends RuntimeException {
    TicketErrorCode errorCode;

    TicketBusinessException(TicketErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode=errorCode;
    }

    public TicketErrorCode getErrorCode() {
        return errorCode;
    }
}
