package org.example;

public interface BankAccountInterface {
    String fetchbalance(String password);
    String addMoney(double amout);
    String withdrawMoney(double amount , String password);
    String changepassword(String oldPassword, String newPassword);
    double calculateInterest(int year);
}
