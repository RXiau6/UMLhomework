/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author rxiau6-PC
 */
public class Product {

    private String id;
    private String category;
    private String name;
    private int price;
    private String photo;
    private String description;

    public Product(String id, String category, String name, int price, String photo, String description) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.photo = photo;
        this.description = description;
    }
    public Product(){
        
    }

    public String toString() {
        return "Product{" + "id=" + id + ",category=" + category + ",name=" + name + ","
                + "price=" + price + ",photo=" + photo + ",description=" + description + "}";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
