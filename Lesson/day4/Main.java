package Lesson.day4;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderService service = new OrderService();

        while (true) {
            System.out.println();
            System.out.println("***********************************");
            System.out.println("카페에 오신 걸 환영합니다.");
            System.out.println();
            System.out.println("user menu>>");
            System.out.println("1. 카페주문");
            System.out.println("2. 개별 영수증 출력");
            System.out.println();
            System.out.println("admin menu>>");
            System.out.println("a. 개별 주문완료");
            System.out.println("b. 모든 주문내역");
            System.out.println("c. 해당 메뉴조회");
            System.out.println("d. 총매출 내역");
            System.out.println("e. 주문완료 내역");
            System.out.println("***********************************");
            System.out.println();
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("카페 주문>>");
                System.out.println("주문할 메뉴: ");
                String menu = scanner.nextLine();
                System.out.println("주문할 수량: ");
                int quantity = Integer.parseInt(scanner.nextLine());

                OrderRequest request = new OrderRequest(menu, quantity);
                service.registerOrder(request);
                System.out.println("주문 완료>>");
                System.out.println("***********************************");

            } else if (choice.equals("2")) {
                System.out.println("개별 영수증 출력>>");
                System.out.println("영수증 출력할 order ID: ");
                Long id = Long.valueOf(scanner.nextLine());

                OrderResponse response = service.getReceipt(id);
                System.out.println("영수증 출력 완료>>");
                System.out.println(response);
                System.out.println("***********************************");

            } else if (choice.equals("a")) {
                System.out.println("주문 처리중>>");
                System.out.println("주문완료할 order ID: ");
                Long id = Long.valueOf(scanner.nextLine());

                service.completeOreder(id);
                System.out.println(id + "번 주문 완료>>");
                System.out.println("***********************************");

            } else if (choice.equals("b")) {
                List<OrderResponse> responses = service.getAllReceipts();
                System.out.println("모든 주문 내역>>");
                System.out.println(responses);
                System.out.println("***********************************");

            } else if (choice.equals("c")) {
                System.out.println("해당 메뉴 조회>>");
                System.out.println("조회할 메뉴: ");
                String menu = scanner.nextLine();

                List<OrderResponse> responses = service.findOrdersByMenuName(menu);
                System.out.println("해당 메뉴 내역>>");
                System.out.println(responses);
                System.out.println("***********************************");

            } else if (choice.equals("d")) {
                int totalRevenue = service.calculateTotalRevenue();
                System.out.println("총매출 내역>>");
                System.out.println(totalRevenue);
                System.out.println("***********************************");

            } else if (choice.equals("e")) {
                Long count= service.countCompletedOrders();
                System.out.println("주문완료 내역>>");
                System.out.println(count+"건");
                System.out.println("***********************************");

            } else {
                System.out.println("잘못된 입력입니다. 다시 입력하세요.");
            }
        }
    }
}
