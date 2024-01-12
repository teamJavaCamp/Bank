package com.bank.view;

import com.bank.manager.MemberManager;

import java.util.Scanner;

public class AdminMenu {
    private Scanner sc = new Scanner(System.in);

    private MemberManager mm = new MemberManager();

    public AdminMenu(){}

    public void adminMain(){

        while(true){
            System.out.println("관리자 모드");
            System.out.println("1. 회원 전체 조회");
            System.out.println("2. 회원 정보 변경");
            System.out.println("0. 뒤로");
            System.out.print("메뉴 선택 : ");

            int num = sc.nextInt();
            switch (num){
                case 1 :
                    mm.showMemberAll();
                    break;
                case 2 :
                    mm.editInfo();
                    break;
                default :
                    return;
            }

        }



    }
}
