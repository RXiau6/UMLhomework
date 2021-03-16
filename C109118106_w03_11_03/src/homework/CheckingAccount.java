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
public class CheckingAccount extends Account {
    private double balance;
    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void debit(double amount) {
        super.debit(amount);
        System.out.printf("已扣款%4f元，剩餘%4f元\n",amount,super.getBalance());
        if(balance<0){
            System.out.println("已透支，請注意消費");
        }
    }
    

}
