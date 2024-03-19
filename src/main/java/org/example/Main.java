package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 프로젝트 시작 ==");
        Scanner sc = new Scanner(System.in);
        // 키보드를 스캔한다

        System.out.printf("명령어) ");
        String cmd = sc.nextLine();
        // sc.nextLine() : 한 라인을 의미 (엔터치기 전까지)
        // sc.next : 띄어쓰기 전까지
        // 사용자의 키보드를 받는다
        // 여기서 멈춤
        System.out.printf("입력된 명령어 : %s\n", cmd);

        System.out.printf("명령어) ");
        int num = sc.nextInt();
        System.out.printf("입력된 명령어 : %d\n", num);



        sc.close();
        // 닫기 버튼
        System.out.println("== 프로젝트 끝 ==");
    }
}