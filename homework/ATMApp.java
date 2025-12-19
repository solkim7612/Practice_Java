package homework;

import java.util.Scanner;

public class ATMApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount myAccount = new BankAccount(10000);

        System.out.println("=== 깐깐한 ATM 시스템 ===");

        while (true) {
            System.out.println("\n----------------------------------");
            System.out.println("현재 잔액: " + myAccount.getBalance() + "원");
            System.out.println("[1]입금 [2]출금 [3]종료");
            System.out.print("선택> ");

            String menu = scanner.nextLine();

            try {
                if (menu.equals("1")) {
                    System.out.print("입금할 금액: ");
                    int amount = Integer.parseInt(scanner.nextLine());

                    myAccount.deposit(amount);

                } else if (menu.equals("2")) {
                    System.out.print("출금할 금액: ");
                    int amount = Integer.parseInt(scanner.nextLine());
                    
                    myAccount.withdraw(amount);

                } else if (menu.equals("3")) {
                    System.out.println("안녕히 가세요.");
                    break;
                } else {
                    System.out.println("잘못된 메뉴입니다.");
                }

            } catch (NumberFormatException e) {
                System.out.println(">>> [에러] 숫자로만 입력해주세요!");
            } catch (BalanceInsufficientException e) {
                System.out.println(">>> [출금 실패] " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(">>> [입력 오류] " + e.getMessage());
            } catch (Exception e) {
                System.out.println(">>> [알 수 없는 에러] " + e.getMessage());
            }
        }
    }
}
