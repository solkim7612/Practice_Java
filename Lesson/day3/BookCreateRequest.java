package Lesson.day3;

// post 요청
public class BookCreateRequest {
    private String title;
    private String author;
    private int purchasePrice;
    private String vendor;

    // 매개변수
    public BookCreateRequest(String title, String author, int purchasePrice, String vendor) {
        this.title=title;
        this.author=author;
        this.purchasePrice=purchasePrice;
        this.vendor=vendor;
    }

    // Getter
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public String getVendor() {
        return vendor;
    }

}

