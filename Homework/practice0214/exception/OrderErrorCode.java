package Homework.practice0214.exception;

/**
 * TODO: 에러 코드 enum을 완성하세요.
 *
 * 요구사항:
 * - 아래 5가지 에러 코드를 정의하세요:
 *   MENU_NOT_FOUND     ("O-001", "해당 메뉴를 찾을 수 없습니다.")
 *   ORDER_NOT_FOUND    ("O-002", "해당 주문을 찾을 수 없습니다.")
 *   NO_WAITING_ORDER   ("O-003", "대기 중인 주문이 없습니다.")
 *   NO_COMPLETED_ORDER ("O-004", "되돌릴 완료 주문이 없습니다.")
 *   ORDER_NOT_CANCELLABLE ("O-005", "취소할 수 없는 주문 상태입니다.")
 * - code (String), message (String) 필드와 getter
 *
 * 힌트: TicketErrorCode 구조를 그대로 참고하세요.
 */
public enum OrderErrorCode {
    // TODO: enum 상수를 정의하세요
    MENU_NOT_FOUND("O-001", "해당 메뉴를 찾을 수 없습니다."),
    ORDER_NOT_FOUND("O-002", "해당 주문을 찾을 수 없습니다."),
    NO_WAITING_ORDER("O-003", "대기 중인 주문이 없습니다."),
    NO_COMPLETED_ORDER("O-004", "되돌릴 완료 주문이 없습니다."),
    ORDER_NOT_CANCELLABLE("O-005", "취소할 수 없는 주문 상태입니다.")
    ;

    // TODO: 필드, 생성자, getter를 만드세요
    private String code;
    private String message;

    OrderErrorCode(String code, String message){
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
