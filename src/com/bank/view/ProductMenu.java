package com.bank.view;

import com.bank.manager.MemberManager;
import com.bank.manager.ProductManager;
import com.bank.model.MemberDTO;

import java.util.Scanner;

public class ProductMenu {

    private Scanner sc = new Scanner(System.in);

    private MemberManager mm = new MemberManager();
    private ProductManager pm = new ProductManager();

    public void productMain(MemberDTO member){
        while(true){
            System.out.println(" ===== 상품메뉴 =====");
            System.out.println(" 1. 내 가입 상품");
            System.out.println(" 2. 적금");
            System.out.println(" 3. 대출");
            System.out.println(" 0. 뒤로 ");
            System.out.print("메뉴 선택 : ");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    mm.showMyProduct(member);
                    break;
                case 2 :
                    pm.subSavings(member);
                    break;
                case 3 :
                    pm.takeLoan(member);
                    break;
                default :
                    return;
            }
        }

    }
}
