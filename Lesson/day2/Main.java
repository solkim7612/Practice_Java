package Lesson.day2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        회원가입
        Service svc=new Service();

        Scanner scanner = new Scanner(System.in);
        System.out.println("사용자의 이름을 입력해주세요: ");
        String name=scanner.nextLine();
        System.out.println("가입할 이메일을 입력해주세요: ");
        String email=scanner.nextLine();
        System.out.println("비밀번호를 입력해주세요: ");
        String password=scanner.nextLine();

        Request register=new Request(name, email, password);

        svc.register(register);
        System.out.println(name+"님 회원가입 하셨습니다.");

        
//        email 조회(회원조회)
        Response response = svc.find(1L);
        System.out.println("사용자 이름: "+ response.getName());
        System.out.println("사용자 이메일: "+response.getEmail());
    }
}
