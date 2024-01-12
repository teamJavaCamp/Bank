package com.bank.model;

public class AccountDTO {

    private String accNum;      //계좌번호

    private long balance;        //잔고

    public AccountDTO() {
    }

    public AccountDTO(String accNum, long balance) {
        this.accNum = accNum;
        this.balance = balance;
    }

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "계좌" +
                "계좌번호" + accNum +
                "잔고" + balance;
    }
}
