package Lesson.day3;

import java.awt.print.Book;
import java.util.HashMap;

public class BookService {
    // db 생성 (id별 entity 생성)
    private final HashMap<Long, BookEntity> bookrepo = new HashMap<>();
    private Long id = 1L;

    // CREATE method
    // Reqeust 매개변수 -> entity 형식으로 변환 -> db 저장
    public void create(BookCreateRequest request) {
        BookEntity entity = new BookEntity(id++, request, false);
        bookrepo.put(entity.getId(), entity);
    }

    // READ method
    // repo에 해당 id의 entity 불러오기 -> entity를 response 형식으로 변환
    public BookResponse read(Long id) {
        BookEntity entity = bookrepo.get(id);

        if (entity == null) {
            throw new RuntimeException("해당 도서는 존재하지 않습니다.");
        }

        return new BookResponse(entity);
    }

    // DELETE method
    // read method -> db에 해당 entity 제거 -> read method 반환
    public BookResponse delete(Long id) {
        BookResponse deleteInfo=read(id);

        bookrepo.remove(id);

        return deleteInfo;
    }

    // UPDATE method1 (title, author, purchasePrice, vendor)
    // read method -> 해당 id의 entity 불러오기 -> request 매개변수 entity에 set -> db에 저장
    public void update(Long id, BookUpdateRequest request) {
        read(id);

        BookEntity entity = bookrepo.get(id);

        entity.update(request);

        bookrepo.put(id, entity);
    }

    // UPDATE method2 (isBorrowed)
    // read method -> 해당 id의 entity 불러오기 -> entity의 borrow 상태 변경 -> db에 저장
    public void borrow(Long id) {
        read(id);

        BookEntity entity = bookrepo.get(id);

        if (entity.isBorrowed() == true) {
            System.out.println("이미 대출 중입니다.");
        }

        entity.setBorrowed(true);

        bookrepo.put(id, entity);
    }

}
