package Lesson.day3;

// get 요청
public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private String status;

    // 매개변수
    BookResponse(BookEntity entity) {
        this.id=entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();

        if(entity.isBorrowed()==true){
            status="대출불가";
        } else{
            status="대출가능";
        }
    }

    // Getter
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getStatus() {
        return status;
    }

}
