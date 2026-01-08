package Lesson.day3;

public class BookEntity {
    private Long id;
    private String title;
    private String author;
    private int purchasePrice;
    private String vendor;
    private boolean isBorrowed;

    public BookEntity(Long id, BookCreateRequest request, boolean isBorrowed) {
        this.id = id;
        this.title = request.getTitle();
        this.author = request.getAuthor();
        this.purchasePrice = request.getPurchasePrice();
        this.vendor = request.getVendor();
        this.isBorrowed = isBorrowed;
    }

    // Setter
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    // Getter
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public String getVendor() {
        return vendor;
    }
}
