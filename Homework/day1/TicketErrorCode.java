package Homework.day1;

public enum TicketErrorCode {
    TICKET_NOT_FOUND("T-001", "해당 티켓을 찾을 수 없습니다."),
    ALREADY_RESERVED("T-002", "이미 예약되었거나 취소된 티켓입니다."),
    INVALID_PAYMENT("T-003", "결제 정보가 유효하지 않습니다.");

    private String code;
    private String message;

    TicketErrorCode(String code, String message){
        this.code=code;
        this.message=message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
