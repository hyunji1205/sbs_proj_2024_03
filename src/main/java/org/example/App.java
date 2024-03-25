package App;

import org.example.controller.ArticleController;
import org.example.controller.Controller;
import org.example.controller.MemberController;
import org.example.dto.Article;
import org.example.util.Util;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private List<Article> articles;

    public App() {
        articles = new ArrayList<>();

    }

    public void start() {
        System.out.println("== 프로그램 시작 ==");

        Scanner sc = new Scanner(System.in);

        MemberController memberController = new MemberController(sc);
        ArticleController articleController = new ArticleController(sc);

        articleController.makeTestData();
        memberController.makeTestData();

        while (true) {
            System.out.printf("명령어입력 : ");
            String cmd = sc.nextLine();
            cmd = cmd.trim();

            if (cmd.length() == 0) {
                continue;
            }

            if (cmd.equals("exit")) { // 만약 내가 이 단어를 적는다면 멈추게 한다.
                break;
            }

            String[] cmdBits = cmd.split(" "); // article write
            String controllerName = cmdBits[0]; // article
            String actionMethodName = cmdBits[1];

            Controller controller = null;

            if ( controllerName.equals("article")){
                controller = articleController;
            }
            else if ( controllerName.equals("member")){
                controller = memberController;
            }
            else {
                System.out.println("존재하지 않는 명령어입니다.");
                continue;
            }

            controller.doAction(cmd, actionMethodName);
        }

        sc.close();
        System.out.println("== 업로드 완료 ==");
    }


}