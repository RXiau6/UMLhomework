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
public class Cat extends Pet {

    public Cat(String name) {
        super(name);    //呼叫父類別的建構子 
    }

    public Cat() //定義一個沒有參數的建構子 
    {
        this("標準貓"); //呼叫本身這個類別的另外一個建構子(前述有一個參數的) 
    }

    @Override
    public void sayHello() {
        super.sayHello();    //呼叫父類別的 sayHello() 
        System.out.println("我是一隻貓!");
    }

    public void meow() {
        System.out.println("喵喵!");
    }

    @Override
    public void move() {
        System.out.println("輕聲走兩步");
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat("小貓");
        cat1.sayHello();
        cat1.move();
    }
}
