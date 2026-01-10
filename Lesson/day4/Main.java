package Lesson.day4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        OrderService service=new OrderService();

        while (true){
            System.out.println("카페주문");
            System.out.println("1. 메뉴: ");
            String menu=scanner.nextLine();
            System.out.println("2. 수량: ");
            int quantity=Integer.parseInt(scanner.nextLine());

            OrderRequest request=new OrderRequest(menu,quantity);

            service.registerOrder(request);

            service.getReceipt(1L);

            service.completeOreder(1L);

            service.getReceipt(1L);
        }
    }
}
