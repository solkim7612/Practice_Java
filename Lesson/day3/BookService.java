package Lesson.day3;

import java.awt.print.Book;
import java.util.HashMap;

public class BookService {
    // db 생성 (id별 entity 생성)
    private final HashMap<Long, BookEntity> bookrepo = new HashMap<>();
    private Long id = 1L;

    // CREATE method
    // Reqeust 매개변수 -> enttity 형식으로 변환 -> db 저장
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
    // repo에 해당 id의 entity 불러오기 -> 반환값인 response 미리 변환 -> db에 entity 제거
    public BookResponse delete(Long id) {
        BookEntity entity = bookrepo.get(id);

        if (entity == null) {
            throw new RuntimeException("해당 도서는 존재하지 않습니다.");
        }

        BookResponse response = new BookResponse(entity);

        bookrepo.remove(id);

        return response;
    }

    // UPDATE method1 (title, author, purchasePrice, vendor)
    // repo에 해당 id의 entity 불러오기 -> updateRequest 매개변수를 entity에 덮어쓰기
    // -> db에 저장
    public void update(Long id, BookUpdateRequest request) {
        BookEntity entity = bookrepo.get(id);

        if (entity == null) {
            throw new RuntimeException("해당 도서는 존재하지 않습니다.");
        }

        entity.setTitle(request.getTitle());
        entity.setAuthor(request.getAuthor());
        entity.setPurchasePrice(request.getPurchasePrice());
        entity.setVendor(request.getVendor());

        bookrepo.put(id, entity);
    }

    // UPDATE method2 (isBorrowed)
    // repo에 해당 id의 entity 불러오기 -> updateRequset
    public void borrow(Long id) {
        BookEntity entity = bookrepo.get(id);

        if (entity == null) {
            throw new RuntimeException("해당 도서는 존재하지 않습니다.");
        }

        if(entity.isBorrowed()==true){
            System.out.println("이미 대출 중입니다.");
        }

        entity.setBorrowed(true);
    }

}
