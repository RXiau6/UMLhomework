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
public class Account {

    private String id;
    private double balance;
    private double rate;
    //Constructor 

    public Account(String id, double initialBalance, double rate) {
        this.id = id;
        this.rate = rate;
        this.balance = initialBalance;
        System.out.printf("產生新物件%s\n",id);
    }
    //Constructor 

    public Account(double initialBalance) {
        if (initialBalance > 0.0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    public void credit(double amount) {
        balance = balance + amount;
    }

    public double getBalance() {
        return balance;
    }

    public void debit(double amount) {
        balance = balance - amount;
    }

}


