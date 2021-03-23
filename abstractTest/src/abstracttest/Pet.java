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
public abstract class Pet { 
         
        private String name; 
        //private int age; 
         
        public Pet(    String    name      ) 
        { 
                this.name = name; //this  是指  "這個類別" 
                //System.out.printf("產生新物件:%s\n", name); 
        } 
        public abstract void move(); //只有方法名稱，暫時不要實作  因為每個子類別實作方式不一樣 
   
          public void sayHello() 
        { 
                System.out.printf("我是%s，大家好!\n", name); 
        } 
        public static void main(String[] args) { 
          //產生 Pet 物件  並執行此物件所擁有的方法 sayHello()       
                //Pet p1 = new Pet("小黑"); //抽象類別不可以被 new 來用 
                //p1.sayHello(); 
                 
                //用這種奇怪的方式使用(先實作再 new) 
                Pet p1= new Pet("小花"){//大括號內等於是一個匿名類別的內部，此匿名類別繼承了 Pet,因此要實作抽象類別 move() 
 
                        @Override 
                        public void move() { 
                                  System.out.println("在內部定義一個匿名類別，與繼承自 Pet 得到相同的結果"); 
                        } 
                };    //這裡的分號不可少! 
                p1.sayHello();
                p1.move();
        } 
} 
