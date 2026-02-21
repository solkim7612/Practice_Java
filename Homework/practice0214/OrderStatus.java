package Homework.practice0214;

/**
 * TODO: 주문 상태 enum을 완성하세요.
 * <p>
 * 요구사항:
 * - WAITING (대기), PREPARING (준비 중), COMPLETED (완료), CANCELLED (취소) 4가지 상태
 * - isCancellable() 메서드: WAITING 또는 PREPARING일 때만 true 반환
 * <p>
 * 힌트: TicketStatus의 isReservable() 패턴을 참고하세요.
 */
public enum OrderStatus {
    // TODO: enum 상수를 정의하세요
    WAITING, PREPARING, COMPLETED, CANCELLED;

    // TODO: isCancellable() 메서드를 만드세요
    public boolean isCancellable(OrderStatus status) {
        return status == OrderStatus.WAITING || status == OrderStatus.PREPARING;
    }
}
