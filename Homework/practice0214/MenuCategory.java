package Homework.practice0214;

/**
 * TODO: 메뉴 카테고리 enum을 완성하세요.
 * <p>
 * 요구사항:
 * - COFFEE("커피"), DESSERT("디저트"), BEVERAGE("음료") 3가지 상수 정의
 * - displayName 필드와 getter 추가
 * <p>
 * 힌트: TicketType enum처럼 필드가 있는 enum을 만들어보세요.
 */
public enum MenuCategory {
    // TODO: enum 상수를 정의하세요
    COFFEE("커피"), DESSERT("디저트"), BEVERAGE("음료");

    // TODO: displayName 필드와 생성자, getter를 추가하세요
    private String displayName;

    MenuCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
