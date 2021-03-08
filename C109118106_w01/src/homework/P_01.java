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
public class P_01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] fruit = {"fruit0", "fruit1", "fruit2", "fruit3", "fruit4", "fruit5", "fruit6"};
        int[] selected = {3, 9, 0, 2};
        int i =0;
        try {
            
            int flag = 1;
            while (flag==1){
                System.out.print("User choose:" + fruit[selected[i]]+"\n");
                i++;
            }
        } 
        catch (ArrayIndexOutOfBoundsException err) {
            System.out.print("選擇超出範圍！！\n");
            System.out.print("錯誤訊息：");
            System.out.print(err.toString()+"\n");
            System.out.printf("ERROR NUMBER : \"%d\"\n",selected[i]);
            i++;
            
        }
        for (i=i;i<selected.length;i++){
            System.out.print("User choose:" + fruit[selected[i]]+"\n");
        }

    }

}
