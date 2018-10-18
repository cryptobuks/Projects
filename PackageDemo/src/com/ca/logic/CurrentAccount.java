package com.ca.logic;

public class CurrentAccount extends Account{

    public CurrentAccount(String accountNo, String customerName, Double balance) {
        this.accountNo = accountNo;
        this.customerName = customerName;
        this.balance = balance;
    }

    @Override
    public void depositAmount(Double amount) {
        this.balance += amount;
    }

    @Override
    public void withdrawAmount(Double amount) {
        if(this.balance>amount ){
            this.balance-=amount;
        }
    }

    public void displayBalance() {
        System.out.println(customerName + " with Account No. " + accountNo + " has balance of " + balance);
    }

}
