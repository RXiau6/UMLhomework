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
public class dog    extends Pet { 
 
public dog( String    name    ) 
{ 
        super(name);    //呼叫父類別的建構子 
} 
@Override        //取代父類別的 sayHello()，重新定義這個方法所執行的指令 
public void sayHello() 
{ 
        super.sayHello();    //呼叫父類別的 sayHello() 
        System.out.println("我是一隻狗!"); 
} 
public void bark()    //定義屬於 dog 類別專屬的方法 bark() 
{ 
        System.out.println("汪汪!"); 
} 
 
public static void main(String[] args) { 
                dog    d1 = new dog("小黑"); 
                d1.sayHello(); //呼叫的  sayHello()是在 dog 類別中重新定義的 sayHello()喔! 
                d1.bark(); 
        } 
} 