/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework;

/**
 *
 * @author RXiau6
 */
public class SavingsAccount extends Account {
double balance;
    public SavingsAccount(double initialBalance) {
        super(initialBalance);
        balance=initialBalance;
    }
@Override
public void debit(double amount){
    if (balance>=amount){
        balance = balance-amount;
        System.out.print(balance+"\n");
    }else {
        System.out.println("餘額不足，扣款失敗");
    }
}
}
