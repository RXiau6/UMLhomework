/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1_exception_fileIO;
import java.io.FileNotFoundException;
import java.util.Formatter;

/**
 *
 * @author RXiau6
 */
public class fileIO_demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            System.out.print("try start\n");
        Formatter out =new Formatter("doc.txt ");
        out.format("%s,%s\n","num","count");
        out.format("%s,%d\n","A10",25);
        out.format("%s,%d\n","A20",30);
        out.flush();
        out.close();
        System.out.print("try over\n");
        }
        catch(FileNotFoundException ex){
            System.out.print("Save Errorn\n");
        }
        finally{
            System.out.print("finally over\n");
        }
    }
    
}
