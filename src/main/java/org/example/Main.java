package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 프로젝트 시작 ==");
        Scanner sc = new Scanner(System.in);

        int lastArticleId = 0;

        while ( true ) {
            // 무한 반복
            System.out.printf("명령어) ");
            String cmd = sc.nextLine();
            cmd = cmd.trim();
            // trim - 공백제거

            if ( cmd.length() == 0 ) {
                continue;
            }

            if ( cmd.equals("exit") ) {
                break;
                // 반복문 빠져나가기
            }

            if ( cmd.equals("article write") ) {
                int id = lastArticleId + 1;
                lastArticleId = id;
                // 갱신
                System.out.printf("제목: ");
                String title = sc.nextLine();
                System.out.printf("내용: ");
                String body = sc.nextLine();

                System.out.printf("%d번 글이 생성되었습니다.\n", id);
            }

            else if ( cmd.equals("article list") ) {
                System.out.println("게시물이 없습니다.");
            }
            else {
                System.out.printf("%s(은)는 존재하지 않는 명령어입니다.\n", cmd);
            }
        }

        sc.close();
        System.out.println("== 프로젝트 끝 ==");
    }
}