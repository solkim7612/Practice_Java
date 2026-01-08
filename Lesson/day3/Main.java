package Lesson.day3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookService service = new BookService();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("*** 도서 관리 시스템 ***");
            System.out.println("1. 도서 등록");
            System.out.println("2. 도서 조회");
            System.out.println("3. 도서 삭제");
            System.out.println("4. 도서 수정");
            System.out.println("5. 도서 대출");
            System.out.println("6. 종료");
            System.out.println(">> 실행할 메뉴를 선택해주세요: ");
            String menu = scanner.nextLine();

            if (menu.equals("1")) {
                System.out.println(">> 도서를 등록합니다.");

                System.out.println("책 제목을 입력하세요: ");
                String title = scanner.nextLine();
                System.out.println("책 저자를 입력하세요: ");
                String author = scanner.nextLine();
                System.out.println("책 가격을 입력하세요: ");
                int purchasePrice = Integer.parseInt(scanner.nextLine());
                System.out.println("책 구매처를 입력하세요: ");
                String vendor = scanner.nextLine();

                BookCreateRequest request = new BookCreateRequest(title, author, purchasePrice, vendor);
                service.create(request);

                System.out.println("*** 도서 등록 완료 ***");

            } else if (menu.equals("2")) {
                System.out.println(">> 도서를 조회합니다.");

                System.out.println("조회할 도서ID를 입력해주세요: ");
                Long id = Long.valueOf(scanner.nextLine());

                try {
                    BookResponse response = service.read(id);
                    System.out.println("*** 조회내역 ***");
                    System.out.println("책제목: " + response.getTitle());
                    System.out.println("책저자: " + response.getAuthor());
                    System.out.println("책상태: " + response.getStatus());
                } catch (Exception e) {
                    System.out.println("존재하지 않는 도서ID 입니다.");
                }

            } else if (menu.equals("3")) {
                System.out.println(">> 도서를 삭제합니다.");

                System.out.println("삭제할 도서ID를 입력해주세요: ");
                Long id = Long.valueOf(scanner.nextLine());

                try {
                    BookResponse response = service.delete(id);
                    System.out.println("*** 도서 삭제 완료 ***");
                    System.out.println("책제목: " + response.getTitle());
                    System.out.println("책저자: " + response.getAuthor());
                } catch (Exception e) {
                    System.out.println("존재하지 않는 도서ID 입니다.");
                }

            } else if (menu.equals("4")) {
                System.out.println(">> 도서를 수정합니다.");

                System.out.println("수정할 도서ID를 입력해주세요: ");
                Long id = Long.valueOf(scanner.nextLine());

                try {
                    BookResponse response = service.read(id);
                    System.out.println("*** 수정전 내역 ***");
                    System.out.println("책제목: " + response.getTitle());
                    System.out.println("책저자: " + response.getAuthor());
                    System.out.println("책상태: " + response.getStatus());

                    System.out.println("수정할 책 제목을 입력하세요: ");
                    String title = scanner.nextLine();
                    System.out.println("수정할 책 저자를 입력하세요: ");
                    String author = scanner.nextLine();
                    System.out.println("수정할 책 가격을 입력하세요: ");
                    int purchasePrice = Integer.parseInt(scanner.nextLine());
                    System.out.println("수정할 책 구매처를 입력하세요: ");
                    String vendor = scanner.nextLine();

                    BookUpdateRequest request = new BookUpdateRequest(title, author, purchasePrice, vendor);
                    service.update(id, request);

                    System.out.println("*** 도서 수정 완료 ***");
                } catch (Exception e) {
                    System.out.println("존재하지 않는 도서ID 입니다.");
                }

            } else if (menu.equals("5")) {
                System.out.println(">> 도서를 대출합니다.");

                System.out.println("대출할 도서ID를 입력해주세요: ");
                Long id = Long.valueOf(scanner.nextLine());

                try {
                    service.borrow(id);

                    System.out.println("*** 도서 대출 완료 ***");
                } catch (Exception e) {
                    System.out.println("존재하지 않는 도서ID 입니다.");
                }

            } else if (menu.equals("6")) {
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }

    }
}
