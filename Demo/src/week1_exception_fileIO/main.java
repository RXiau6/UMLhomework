/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1_exception_fileIO;

import java.util.Scanner;
import java.util.Formatter;
import java.io.FileNotFoundException;

/**
 *
 * @author RXiau6
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x = 10;
        int y = 0;
        int ans;
        Scanner input = new Scanner(System.in);

        int[] arr;
        arr = new int[3];

        try {
            for (int i = 0; i <= 3; i++) {
                arr[i] = input.nextInt();
            }

        } catch (Exception ex) {

            System.out.print("ERROR\nERROR MESSAGE:" + ex.toString() + "\n");

        }

    }
}
