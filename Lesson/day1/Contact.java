package Lesson.day1;

import java.util.ArrayList;
import java.util.Scanner;

public class Contact {
    private String name;
    private String phoneNum;

    @Override
    public String toString() {
        return "이름은" + name + "\n" + "전화번호는" + phoneNum;
    }

    Contact(String name, String phoneNum) {
        if (name == null) {
            System.out.println("null안됨");
            return;
        }

        if (phoneNum == null) {
            System.out.println("전화번호를 입력하세요");
            return;
        }

        this.name = name;
        this.phoneNum = phoneNum;
    }
}

class AddressBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Contact> contacts = new ArrayList<>();

        System.out.println("=======나만의 주소록 만들기=======");

        while (true) {
            System.out.println("\n[1]추가 [2] 목록 [3] 종료");
            System.out.println("선택하세요");

            String menu = scanner.nextLine();

            if (menu.equals("1")) {
                System.out.println("이름 입력하세요: ");
                String name = scanner.nextLine();
                System.out.println("전화번호 입력하세요: ");
                String phoneNum = scanner.nextLine();


                Contact contact = new Contact(name, phoneNum);
                contacts.add(contact);
                System.out.println("저장되었습니다.");

            } else if (menu.equals("2")) {
                if (contacts.isEmpty()) {
                    System.out.println("없습니다");
                } else {
                    for (int i = 0; i < contacts.size(); i++) {
                        Contact contact = contacts.get(i);
                        System.out.println(contact);
                    }
                }
            } else if (menu.equals("3")) {
                System.out.println("프로그램 종료");
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }

        }
        scanner.close();
    }
}


