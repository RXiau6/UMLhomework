/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c109118106_w10;

/**
 *
 * @author RXiau6
 */
public class Product {
    
    private String id;
    private String category;
    private String name;
    private int price;
    private String description;
    private String photo;

    public Product(String id, String category, String name, int price, String description, String photo) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.description = description;
        this.photo = photo;
    }
    public Product(){
        
    }
    @Override
    public String toString(){
        return "Product{" + "id=" + id + ",category=" + category +",name=" + name + ","
                + "price=" + price + ",photo=" + photo + ",description=" + description +"}";
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
