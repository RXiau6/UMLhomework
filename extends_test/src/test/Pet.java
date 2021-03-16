/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author RXiau6
 */
public class Pet {

    private String name;    //instance variable, field  實體變數或欄位 
    //private int age; 

    public Pet(String name) {
        this.name = name; //this  是指  "這個類別" 
        System.out.printf("產生新物件:%s\n", name);
    }

    public void sayHello() {
        System.out.printf("我是%s，大家好!\n", name);
    }

    public static void main(String[] args) {
        //     產生 Pet 物件  並執行此物件所擁有的方法 sayHello()     
        Pet p1 = new Pet("小黑");
        p1.sayHello();
        new Pet("小花");
    }
}
