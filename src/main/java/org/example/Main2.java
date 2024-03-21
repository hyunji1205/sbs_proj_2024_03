//package org.example;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main2 {
//    private static List<Article> articles = new ArrayList<>();
//    private static int lastArticleId = 0;
//
//    public static void main(String[] args) {
//        System.out.println("== 프로젝트 시작 ==");
//        Scanner sc = new Scanner(System.in);
//
//        while (true) {
//            System.out.printf("명령어) ");
//            String cmd = sc.nextLine();
//            cmd = cmd.trim();
//
//            if (cmd.length() == 0) {
//                continue;
//            }
//
//            if (cmd.equals("exit")) {
//                break;
//            }
//
//            if (cmd.equals("article write")) {
//                int id = lastArticleId + 1;
//                lastArticleId = id;
//
//                String regDate = Util.getNowDateStr();
//                System.out.printf("제목: ");
//                String title = sc.nextLine();
//                System.out.printf("내용: ");
//                String body = sc.nextLine();
//
//                Article article = new Article(id, regDate, title, body);
//                articles.add(article);
//
//                System.out.printf("%d번 글이 생성되었습니다.\n", id);
//            } else if (cmd.equals("article list")) {
//                if (articles.size() == 0) {
//                    System.out.println("게시물이 없습니다.");
//                    continue;
//                }
//
//                System.out.println("번호 | 조회 | 제목");
//                for (int i = articles.size() - 1; i >= 0; i--) {
//                    Article article = articles.get(i);
//                    System.out.printf("%4d | %4d | %s\n", article.getId(), article.getHit(), article.getTitle());
//                }
//            } else if (cmd.startsWith("article detail ")) {
//                String[] cmdBits = cmd.split(" ");
//                int id = Integer.parseInt(cmdBits[2]);
//
//                Article foundArticle = getArticleById(id);
//
//                if (foundArticle == null) {
//                    System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
//                    continue;
//                }
//
//                foundArticle.increaseHit();
//
//                System.out.printf("번호 : %d\n", foundArticle.getId());
//                System.out.printf("날짜 : %s\n", foundArticle.getRegDate());
//                System.out.printf("제목 : %s\n", foundArticle.getTitle());
//                System.out.printf("내용 : %s\n", foundArticle.getBody());
//                System.out.printf("조회 : %d\n", foundArticle.getHit());
//            } else if (cmd.startsWith("article modify ")) {
//                String[] cmdBits = cmd.split(" ");
//                int id = Integer.parseInt(cmdBits[2]);
//
//                Article foundArticle = getArticleById(id);
//
//                if (foundArticle == null) {
//                    System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
//                    continue;
//                }
//
//                System.out.printf("제목 : ");
//                String title = sc.nextLine();
//                System.out.printf("내용 : ");
//                String body = sc.nextLine();
//
//                foundArticle.setTitle(title);
//                foundArticle.setBody(body);
//
//                System.out.printf("%d번 게시물이 수정되었습니다.\n", id);
//            } else if (cmd.startsWith("article delete ")) {
//                String[] cmdBits = cmd.split(" ");
//                int id = Integer.parseInt(cmdBits[2]);
//
//                Article foundArticle = getArticleById(id);
//
//                if (foundArticle == null) {
//                    System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
//                    continue;
//                }
//
//                articles.remove(foundArticle);
//                System.out.printf("%d번 게시물은 삭제되었습니다.\n", id);
//            } else {
//                System.out.printf("%s(은)는 존재하지 않는 명령어입니다.\n", cmd);
//            }
//        }
//
//        sc.close();
//        System.out.println("== 프로젝트 끝 ==");
//    }
//
//    private static Article getArticleById(int id) {
//        for (Article article : articles) {
//            if (article.getId() == id) {
//                return article;
//            }
//        }
//        return null;
//    }
//}
//
//class Article {
//    private int id;
//    private String regDate;
//    private String title;
//    private String body;
//    private int hit;
//
//    public Article(int id, String regDate, String title, String body) {
//        this.id = id;
//        this.regDate = regDate;
//        this.title = title;
//        this.body = body;
//        this.hit = 0;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getRegDate() {
//        return regDate;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public int getHit() {
//        return hit;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//
//    public void increaseHit() {
//        hit++;
//    }
//}