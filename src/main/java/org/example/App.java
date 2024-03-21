package org.example;

import org.example.dto.Article;
import org.example.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static List<Article> articles;

    static {
        articles = new ArrayList<>();
    }

    public void start() {
        System.out.println("== 프로젝트 시작 ==");

        makeTestData();

        Scanner sc = new Scanner(System.in);

        while (true) {
            // 무한 반복
            System.out.printf("명령어) ");
            String cmd = sc.nextLine();
            cmd = cmd.trim();
            // trim - 공백제거

            if (cmd.length() == 0) {
                continue;
            }

            if (cmd.equals("exit")) {
                break;
                // 반복문 빠져나가기
            }


            if (cmd.equals("article write")) {
                int id = articles.size() + 1;
                // articles.size();
                // 데이터를 몇개 넣었냐를 반환

                String regDate = Util.getNowDateStr();
                System.out.printf("제목: ");
                String title = sc.nextLine();
                System.out.printf("내용: ");
                String body = sc.nextLine();

                Article article = new Article(id, regDate, title, body);
                // 객체 만들어서 묶어주기
                articles.add(article);

                System.out.printf("%d번 글이 생성되었습니다.\n", id);
            } else if (cmd.equals("article list")) {
                if (articles.size() == 0) {
                    System.out.println("게시물이 없습니다.");
                    continue;
                }

                System.out.println("번호 | 조회 | 제목");
                for (int i = articles.size() - 1; i >= 0; i--) {
                    Article article = articles.get(i);

                    System.out.printf("%4d | %4d | %s\n", article.id, article.hit, article.title);
                }

            } else if (cmd.startsWith("article detail ")) {
                // startsWith - 초반만 겹친다

                String[] cmdBits = cmd.split(" ");
                // 문장을 쪼개서 3조각으로 놓는다
                int id = Integer.parseInt(cmdBits[2]); // "1" -> 1
                // 문장 1을 숫자 1로 바꿔준다

                Article foundArticle = getArticleById(id);

                if (foundArticle == null) {
                    System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
                    continue;
                }

                foundArticle.increaseHit();
                ;

                System.out.printf("번호 : %d\n", foundArticle.id);
                System.out.printf("날짜 : %s\n", foundArticle.regDate);
                System.out.printf("제목 : %s\n", foundArticle.title);
                System.out.printf("내용 : %s\n", foundArticle.body);
                System.out.printf("조회 : %d\n", foundArticle.hit);

            } else if (cmd.startsWith("article modify ")) {
                String[] cmdBits = cmd.split(" ");
                int id = Integer.parseInt(cmdBits[2]);

                Article foundArticle = getArticleById(id);

                if (foundArticle == null) {
                    System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
                    continue;
                }

                System.out.printf("제목 : ");
                String title = sc.nextLine();
                System.out.printf("내용 : ");
                String body = sc.nextLine();

                foundArticle.title = title;
                foundArticle.body = body;

                System.out.printf("%d번 게시물이 수정되었습니다.\n", id);

            } else if (cmd.startsWith("article delete ")) {
                String[] cmdBits = cmd.split(" ");
                int id = Integer.parseInt(cmdBits[2]); // "1" -> 1

                int foundIndex = getArticleIndexById(id);

                if (foundIndex == -1) {
                    System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
                    continue;
                }

                // size() => 3
                // index : 0, 1, 2
                // id : 1. 2. 3
                articles.remove(foundIndex);
                System.out.printf("%d번 게시물은 삭제되었습니다.\n", id);
            }

            else {
                System.out.printf("%s(은)는 존재하지 않는 명령어입니다.\n", cmd);
            }
        }

        sc.close();
        System.out.println("== 프로젝트 끝 ==");
    }

    private int getArticleIndexById(int id) {
        int i = 0;
        for ( Article article : articles ) {
            if ( article.id == id ) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private Article getArticleById(int id) {
        int index = getArticleIndexById(id);

            if ( index != -1 ) {
                return articles.get(index);
            }

        return null;
    }

    private void makeTestData() {
        System.out.println("테스트를 위한 게시물 데이터를 생성합니다.");

        articles.add(new Article(1, Util.getNowDateStr(), "제목 1", "내용 1", 12));
        articles.add(new Article(2, Util.getNowDateStr(), "제목 2", "내용 2", 1));
        articles.add(new Article(3, Util.getNowDateStr(), "제목 3", "내용 3", 103));
    }
}