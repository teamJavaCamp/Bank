package com.bank.model;

public class SavingsDTO extends ProductDTO {

    private double interestRate;     //금리
    private int monthly;            //매달 납입 금액

    public SavingsDTO() {
    }

    public SavingsDTO(int type, int period, double interestRate, int monthly) {
        super(type, period);
        this.interestRate = interestRate;
        this.monthly = monthly;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getMonthly() {
        return monthly;
    }

    public void setMonthly(int monthly) {
        this.monthly = monthly;
    }

    @Override
    public String toString() {
        return "**** 적금 ****" + "\n" +
                "금리 : " + interestRate + "%\n" +
                "월납입금 : " + monthly + "만원 \n" +
                "가입기간 : " + super.getPeriod() + "개월 \n";
    }
}
