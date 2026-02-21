package Homework.practice0214;

/**
 * TODO: 메뉴 아이템 클래스를 완성하세요.
 * <p>
 * 요구사항:
 * - id (Long), name (String), category (MenuCategory), price (int) 필드
 * - 모든 필드는 final로 선언 (불변 객체)
 * - 생성자와 getter 구현
 * <p>
 * 힌트: Ticket 클래스의 구조를 참고하세요.
 */
public class MenuItem {
    // TODO: 필드를 선언하세요 (private final)
    private final Long id;
    private final String name;
    private final MenuCategory category;
    private final int price;

    // TODO: 생성자를 만드세요
    public MenuItem(Long id, String name, MenuCategory category, int price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // TODO: getter 메서드를 만드세요
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public MenuCategory getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }
}
