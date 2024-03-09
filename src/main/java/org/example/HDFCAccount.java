package org.example;

import java.util.UUID;

public class HDFCAccount implements BankAccountInterface{
    private String name;
    private String accountNo;
    private String password;
    private double amount;
    private double balance;
    final double rateOfInterest = 7.1;
    final String IFSCCode = "HDFC3201";

    //default parameter
    public HDFCAccount() {
    }

    public HDFCAccount(String name, String password, double balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.accountNo = String.valueOf(UUID.randomUUID());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    @Override
    public String fetchbalance(String password) {
        if(this.password.equals(password)){
            return "your balance is : " + this.balance;
        }
        return "Incorrect password";
    }

    @Override
    public String addMoney(double amout) {
        this.balance += amout;
        return "amount added successfully . new balance is " +this.balance;
    }

    @Override
    public String withdrawMoney(double amount, String password) {
        if(this.password.equals(password)) {
            if (this.balance < amount) {
                return "Insufficient balance";
            }
            this.balance -= amount;
            return "amount detucted successfully : new balance is : " + this.balance;
        }
        return "Incorect password";

    }

    @Override
    public String changepassword(String oldPassword, String newPassword) {
        if(this.password.equals(oldPassword)){
            this.password = newPassword;
            return "password change successfully";
        }
        return "Incorrect original password";
    }

    @Override
    public double calculateInterest(int year) {
        return (this.balance * year * rateOfInterest) / 100.0;
    }

    @Override
    public String toString() {
        return "HDFCAccount{" +
                "name='" + name + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", password='" + password + '\'' +
                ", amount=" + amount +
                ", balance=" + balance +
                ", rateOfInterest=" + rateOfInterest +
                ", IFSCCode='" + IFSCCode + '\'' +
                '}';
    }
}
