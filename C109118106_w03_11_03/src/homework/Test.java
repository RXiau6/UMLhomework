/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework;

import homework.Account;
import homework.CheckingAccount;
import homework.SavingsAccount;

/**
 *
 * @author RXiau6
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CheckingAccount ckac = new CheckingAccount(1000);
        SavingsAccount svac = new SavingsAccount(1000);
        System.out.println("------支票帳戶測試------");
        System.out.println(ckac.getBalance());
        ckac.debit(10000);
        System.out.println(ckac.getBalance());
        System.out.println("------儲蓄帳戶測試------");
        System.out.println(svac.getBalance());
        svac.debit(10000);
        System.out.println(svac.getBalance());
    }

}
