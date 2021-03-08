/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg00_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author RXiau6
 */
public class Main {

    /**
     * @param args the command line arguments
     * 題目>https://tg.pe/xs9k
     */
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        collectToList(names);
        System.out.println("Guest List : ");
        printUpperCase(names);
    }
    static void collectToList(List<String> names){
        Scanner input = new Scanner(System.in);
        String name;
        while (true){
            System.out.print("input Name : ");
            name = input.nextLine();
            if (name.equals("quit")){
                break;
            }
            names.add(name);
        }
        
        
    }
    static void printUpperCase(List<String> names){
        for (int i=0;i < names.size();i++){
            String name = names.get(i);
            System.out.println(name.toUpperCase());
        }
    }
    
}
