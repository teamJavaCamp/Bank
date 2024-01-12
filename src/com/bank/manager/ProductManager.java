package com.bank.manager;

import com.bank.model.LoanDTO;
import com.bank.model.MemberDTO;
import com.bank.model.ProductDTO;
import com.bank.model.SavingsDTO;

import java.util.Scanner;

public class ProductManager {

    private Scanner sc = new Scanner(System.in);

    public ProductManager() {

    }

    public void subSavings(MemberDTO member){

        int deposit = savingDeposit();           //월납입금

        if((deposit * 10000) > member.getAccount().getBalance()){
            System.out.println();
            System.out.println(" ** 잔고가 부족합니다. ** ");
            System.out.println();
            return;
        }

        double interestRate = savingRate();   //금리
        int period=0;             //개월수

        if(interestRate == 4.0){
            period = 12;
        }else if(interestRate == 4.5){
            period = 24;
        }else if(interestRate == 5.0){
            period = 48;
        }
        System.out.println("==============================");
        System.out.println("월 납입금 : " + deposit + "만원");
        System.out.println("금리 : " + interestRate + "%") ;
        System.out.println("가입기간 : " + period + "개월");
        System.out.println("==============================");

        System.out.println("선택한 상품이 맞습니까 ?");
        System.out.print("1)네    2)아니요    : ");
        int num = sc.nextInt();
        switch(num){
            case 1 :
                ProductDTO savings = new SavingsDTO(1,period, interestRate, deposit);
                member.getProduct().add(savings);
                member.getAccount().setBalance(member.getAccount().getBalance() - (deposit * 10000));
                System.out.println("가입이 완료되었습니다.");

                break;
            case 2 :
                System.out.println("취소합니다.");
                break;
            default :
                break;
        }
    }

    public int savingDeposit(){
        while (true) {
            System.out.println("*** 적금 가입 메뉴  ***");
            System.out.print("월 납입 할 금액을 입력하세요 (한도 : 50만원), (단위 : 만원) : ");
            int deposit = sc.nextInt();          // 납입 금액
            sc.nextLine();
            if (deposit > 50) {
                System.out.println();
                System.out.println("납입 한도를 초과했습니다. 다시 입력해주세요.");
                System.out.println();
            }else if(deposit < 0) {
                System.out.println();
                System.out.println("잘못된 입력입니다.");
                System.out.println();
            }else {
                return deposit;
            }
        }
    }
    public double savingRate(){
        while (true) {
            System.out.println("***** 상품의 기간 선택 *****");
            System.out.println("1) 12개월 (금리 4%)");
            System.out.println("2) 24개월 (금리 4.5%)");
            System.out.println("3) 48개월 (금리 5%)");
            System.out.print("상품 기간을 선택해 주세요 : ");
            int yearsToDeposit = sc.nextInt();

            double interestRate;
            switch (yearsToDeposit) {
                case 1:
                    interestRate = 4.0;
                    return interestRate;
                case 2:
                    interestRate = 4.5;
                    return interestRate;
                case 3:
                    interestRate = 5.0;
                    return interestRate;
                default:
                    System.out.println("잘못 입력을했습니다. 다시 선택해주세요");
                    break;
            }
        }

    }




    public void takeLoan(MemberDTO member){

        int takeLoan;       //대출받을 금액
        int period;         //상환기간 개월
        double loanRate;     //이자율
        ProductDTO product;

        if(member.getAge() < 19){
            System.out.println();
            System.out.println(" ** 미성년자는 대출 받기가 어렵습니다. ** ");
            System.out.println();
            return;
        }

        while(true){

            int a;

            if(member.getAge() < 29){
                a = 1000;
            }else if(member.getAge() < 39){
                a = 3000;
            }else if(member.getAge() < 49){
                a = 5000;
            }else {
                a = 3000;
            }

            System.out.println(" ====== 대출 메뉴 ======");
            System.out.println(" ** 최대 대출 가능 금액은 " + a + "만원 입니다. ** ");
            System.out.print(" 대출받을 금액을 입력하세요 (단위 : 만원): ");

            takeLoan = sc.nextInt();

            if(takeLoan <= a && takeLoan > 0){
                break;
            }
            System.out.println();
            System.out.println(" ** 잘못된 금액입니다. ** ");
            System.out.println();
        }

        while(true){
            System.out.println("===== 대출메뉴 =====");
            System.out.println(" 1) 12개월 (이자율 4.0%) ");
            System.out.println(" 2) 24개월 (이자율 4.18%) ");
            System.out.println(" 3) 36개월 (이자율 4.36%) ");
            System.out.println(" 4) 48개월 (이자율 4.5%) ");
            System.out.println(" 0) 메인메뉴로 ");

            System.out.print(" 대출 상환 기간 선택 :  ");

            int select = sc.nextInt();

            switch (select){
                case 1:
                    period = 12;
                    loanRate = 4.0;
                    product = new LoanDTO(2,period,loanRate,takeLoan);
                    member.addProduct(product);
                    member.getAccount().setBalance(member.getAccount().getBalance() + (takeLoan * 10000));
                    System.out.println("대출이 완료되었습니다.");
                    return;
                case 2:
                    period = 24;
                    loanRate = 4.18;
                    product = new LoanDTO(2,period,loanRate,takeLoan);
                    member.addProduct(product);
                    member.getAccount().setBalance(member.getAccount().getBalance() + (takeLoan * 10000));
                    System.out.println("대출이 완료되었습니다.");
                    return;
                case 3:
                    period = 36;
                    loanRate = 4.36;
                    product = new LoanDTO(2,period,loanRate,takeLoan);
                    member.addProduct(product);
                    member.getAccount().setBalance(member.getAccount().getBalance() + (takeLoan * 10000));
                    System.out.println("대출이 완료되었습니다.");
                    return;
                case 4:
                    period = 48;
                    loanRate = 4.5;
                    product = new LoanDTO(2,period,loanRate,takeLoan);
                    member.addProduct(product);
                    member.getAccount().setBalance(member.getAccount().getBalance() + (takeLoan * 10000));
                    System.out.println("대출이 완료되었습니다.");
                    return;
                case 0:
                    return;
                default:
                    System.out.println();
                    System.out.println(" ** 잘못된 입력입니다. ** ");
                    System.out.println();
            }
        }
    }
}
