package Chapter1;

import java.util.Scanner;

public class GameLauncher {
    private static final int MAX_NICKNAME = 8;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String nickname = getValidNickname();
        System.out.printf("%s님 환영합니다.\n", nickname);

        System.out.println("============================= 직업 목록 =============================");
        for (Job job : Job.values()) {
            System.out.println(job.toString());
        }
        System.out.println("====================================================================");
        Job job = getValidJob();

        Character user1 = new Character(nickname, job);
        System.out.println("====================================================================");
        System.out.println(user1.toString());
        System.out.println("====================================================================");

        scanner.close();
    }

    private static String getValidNickname() {
        while (true) {
            System.out.println("새로운 캐릭터를 생성합니다. 사용할 닉네임을 입력하세요.(8자 이내): ");
            String input = scanner.nextLine();

            if (input.isEmpty()) continue;

            if (input.length() > MAX_NICKNAME) {
                System.out.println("닉네임은 " + MAX_NICKNAME + "자를 초과할 수 없습니다.");
                System.out.println("====================================================================");
                continue;
            }
            return input;
        }
    }

    private static Job getValidJob() {
        while (true) {
            System.out.println("직업을 선택해 주세요(번호 입력): ");
            String input = scanner.nextLine();

            if (input.isEmpty()) continue;

            try {
                int code = Integer.parseInt(input);
                return Job.fromCode(code);
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("1~4번 중 직업을 선택해 주세요.");
            }
            System.out.println("====================================================================");
        }
    }

}
