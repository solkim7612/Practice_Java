package Homework.practice0214.exception;

/**
 * TODO: 커스텀 예외 클래스를 완성하세요.
 * <p>
 * 요구사항:
 * - RuntimeException을 상속
 * - OrderErrorCode를 필드로 보유
 * - 생성자에서 super(errorCode.getMessage()) 호출
 * - getErrorCode() getter
 * <p>
 * 힌트: TicketBusinessException 구조를 그대로 참고하세요.
 */
public class OrderBusinessException extends RuntimeException {
    // TODO: errorCode 필드를 선언하세요
    private OrderErrorCode errorCode;

    // TODO: 생성자를 만드세요 (부모에게 message 전달)
    public OrderBusinessException(OrderErrorCode errorCode) {
        super(errorCode.getMessage());
    }

    // TODO: getErrorCode() getter를 만드세요
    public OrderErrorCode getErrorCode() {
        return errorCode;
    }
}
