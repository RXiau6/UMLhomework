/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstracttest;

/**
 *
 * @author rxiau6-PC
 */
public class Dog extends Pet {

    public Dog(String name) {
        super(name);    //呼叫父類別的建構子 
    }

    @Override        //取代父類別的 sayHello()，重新定義這個方法所執行的指令 
    public void sayHello() {
        super.sayHello();    //呼叫父類別的 sayHello() 
        System.out.println("我是一隻狗!");
    }

    public void bark() //定義屬於 Dog 類別專屬的方法 bark() 
    {
        System.out.println("汪汪!");
    }

    //實作 move()抽象方法 
    @Override
    public void move() {
        System.out.println("我大跳 5 公尺");
    }

    public static void main(String[] args) {
        Dog d1 = new Dog("小黑");
        d1.sayHello(); //呼叫的  sayHello()是在 Dog 類別中重新定義的 sayHello()喔! 
        d1.move();
    }
}
