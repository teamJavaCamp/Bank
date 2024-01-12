package com.bank.view;

import com.bank.manager.BankManager;
import com.bank.manager.MemberManager;
import com.bank.model.AccountDTO;
import com.bank.model.MemberDTO;

import java.util.Scanner;

public class Mainmenu {

    private Scanner sc = new Scanner(System.in);

    private BankManager bm = new BankManager();
    private MemberManager mm = new MemberManager();
    private ProductMenu product = new ProductMenu();

    public Mainmenu(){}                         //기본 생성자

    public void mainMenu(MemberDTO member) {    //메인메뉴 메소드



//        AccountDTO acc = mm.searchAcc(member.getId());
        AccountDTO acc = member.getAccount(); //회원이 가진 계좌

        while(true){
            System.out.println(" ===== 메인메뉴 =====");
            System.out.println("1. 계좌 조회");
            System.out.println("2. 입금");
            System.out.println("3. 출금");
            System.out.println("4. 계좌이체");
            System.out.println("5. 마이페이지");
            System.out.println("6. 상품페이지");
            System.out.println("0. 로그아웃");


            int num = sc.nextInt();

            switch(num){
                case 1:
                    bm.showAcc(acc);
                    break;
                case 2 :
                    bm.deposit(acc);
                    break;
                case 3 :
                    bm.withdraw(acc);
                    break;
                case 4 :
                    bm.transfer(acc);
                    break;
                case 5 :
                    System.out.println(member);
                    break;
                case 6 :
                    product.productMain(member);      //상품페이지로
                    break;
                default :
                    return;
            }

        }
    }
}
