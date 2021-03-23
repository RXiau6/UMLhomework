/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework;

/**
 *
 * @author rxiau6-PC
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("-----------------CheckingAccountTEST-----------------");
        CheckingAccount ckac = new CheckingAccount(1000);
        for (int i = 0; i <= 2; i++) {
            ckac.debit(500);
        }
        System.out.println("-----------------SavingsAccountTEST-----------------");
        SavingsAccount svac = new SavingsAccount(1000);
        for (int i = 0; i <= 2; i++) {
            svac.debit(500);
        }
    }

}
