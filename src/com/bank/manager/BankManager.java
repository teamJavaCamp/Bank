package com.bank.manager;

import com.bank.model.AccountDTO;

import java.util.Scanner;

public class BankManager {

    private Scanner sc = new Scanner(System.in);

    public BankManager(){}              //기본생성자

    public void showAcc(AccountDTO acc){                //계좌 조회
        System.out.println("====== 내 계좌 정보 ======");
        System.out.println("계좌번호 : " + acc.getAccNum());
        System.out.println("   잔고 : " + acc.getBalance() + " 원");
    }

    public void deposit(AccountDTO acc){                //입금

        System.out.print("입금할 금액 : ");
        long deposit = sc.nextLong();

        if(deposit <= 0){
            System.out.println();
            System.out.println(" ** 잘못된 금액입니다. ** ");
            System.out.println();
            return;
        }

        acc.setBalance(acc.getBalance() + deposit);

        System.out.println();
        System.out.println(" ** 입금 완료 **");
        System.out.println();

    }

    public void withdraw(AccountDTO acc){                //출금

        System.out.print("출금할 금액 : ");
        long withdraw = sc.nextLong();

        if(withdraw <= 0){
            System.out.println();
            System.out.println(" ** 잘못된 금액입니다. ** ");
            System.out.println();
            return;
        }

        if(acc.getBalance() < withdraw){
            System.out.println();
            System.out.println(" ** 출금할 금액이 잔고보다 큽니다. ** ");
            System.out.println();
        }else{
            acc.setBalance(acc.getBalance() - withdraw);
            System.out.println();
            System.out.println(" ** 출금 완료 ** ");
            System.out.println();
        }

    }

    public void transfer(AccountDTO acc){             //이체

        System.out.print("어떤 계좌로 돈을 보낼까요? : ");
        String accNum = sc.nextLine();
        System.out.println();

        if(acc.getAccNum().equals(accNum)) {                //내 계좌로는 보낼 수 없다.
            System.out.println();
            System.out.println(" ** 이 계좌로 보낼 수 없습니다. **");
            System.out.println();
            return;
        }


        System.out.print("이체할 금액 : ");
        long transfer = sc.nextLong();

        if(acc.getBalance() < transfer){
            System.out.println();
            System.out.println(" ** 이체할 금액이 잔고보다 큽니다. ** ");
            System.out.println();
            return;
            }

        acc.setBalance(acc.getBalance() - transfer );
        System.out.println();
        System.out.println(" ** 성공적으로 이체 되었습니다. ** ");
        System.out.println();
    }
}
