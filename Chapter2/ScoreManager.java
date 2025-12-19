package Chapter2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ScoreManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> scoreMap = new HashMap<>();

        System.out.println("시험 점수 관리 시스템");

        while (true) {
            System.out.println("\n [1] 점수등록/수정 [2] 점수조회 [3] 전체출력 [4] 종료");
            System.out.println("선택: ");
            String menu = scanner.nextLine();

            if (menu == null) {
                continue;
            }

            switch (menu) {
                case "1": {
                    System.out.println("학생 이름: ");
                    String name = scanner.nextLine();
                    System.out.println("점수: ");

                    try {
                        int score = Integer.parseInt(scanner.nextLine());
                        scoreMap.put(name, score);
                        System.out.println(name + "님의 점수가 저장되었습니다.");
                    } catch (NumberFormatException e) {
                        System.out.println("숫자만 입력해주세요");
                    }
                    break;
                }
                case "2": {
                    System.out.println("조회할 학생 이름: ");
                    String name = scanner.nextLine();

                    if (scoreMap.containsKey(name)) {
                        System.out.println(scoreMap.get(name) + "점");
                    } else {
                        System.out.println("등록되지 않은 학생입니다.");
                    }
                    break;
                }

                case "3": {
                    System.out.println("전체 학생 점수 리스트");
                    if (scoreMap.isEmpty()) {
                        System.out.println("데이터없음");
                    } else {
                        for (String key : scoreMap.keySet()) {
                            System.out.println(scoreMap.get(key));
                        }
                    }
                    break;
                }

                case "4": {
                    System.out.println("프로그램 종료");
                    scanner.close();
                    return;
                }

                default: {
                    System.out.println("잘못된 입력");
                    break;
                }
            }
        }

    }
}
