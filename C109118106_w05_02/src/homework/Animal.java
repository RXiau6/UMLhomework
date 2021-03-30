/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework;

/**
 *
 * @author rxiau6-PC
 */
public abstract class Animal implements Moveable {
    private String name;
    public abstract void eat();
    public void move (){System.out.println("animal moves");}
    public void sleep(){System.out.println("animal sleeps");}
}
