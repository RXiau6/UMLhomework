/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RXiau6
 */
public class ProductDAO {

    //在各個方法中在操作資料之前必須先進行取得連線，因為太久沒跟資料庫連線，資料庫會自動斷線，這就出現問題無法進行操作，因此，必須先取得連線。
    private Connection conn; //連線物件

    public List<Product> getAllProducts() {
        conn = DBConnection.getConnection();
        String query = "select * from product";
        List<Product> product_list = new ArrayList();

        try {
            PreparedStatement state
                    = conn.prepareStatement(query); //conn連線動作 prepareStatement  用query查詢
            ResultSet rset = state.executeQuery(); //executeQuery查詢

            while (rset.next()) {
                Product product = new Product();
                product.setId(rset.getString("id"));
                product.setCategory(rset.getString("category"));
                product.setName(rset.getString("name"));
                product.setPrice(rset.getInt("price"));
                product.setPhoto(rset.getString("photo"));
                product.setDescription(rset.getString("description"));
                product_list.add(product);
            }
        } catch (SQLException ex) {
            System.out.println("getAllproducts異常:" + ex.toString());
        }
        return product_list;
    }

    public boolean add(Product product) {
        conn = DBConnection.getConnection();
        String query = "insert into product(id,category,name,price,photo,description) VALUES (?,?,?,?,?,?)";
        boolean success = false;
        try {
            PreparedStatement state = conn.prepareStatement(query);
            state.setString(1, product.getId());
            state.setString(2, product.getCategory());
            state.setString(3, product.getName());
            state.setInt(4, product.getPrice());
            state.setString(5, product.getPhoto());
            state.setString(6, product.getDescription());

            state.execute();
            //state.executeUpdate();
            success = true;
        } catch (SQLException ex) {
            System.out.println("add異常:" + ex.toString());
        }
        return success;
    }

    public boolean delete(String id) {
        conn = DBConnection.getConnection();
        String query = "delete from product where id =?";
        boolean sucess = false;
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, id);
            //statement.execute();
            sucess = statement.executeUpdate() > 0;
            if (sucess) {
                System.out.println("Record deleted successfully.");
            } else {
                System.out.println("Record not found.");
            }
        } catch (SQLException ex) {
            System.out.println("delete異常:\n" + ex.toString());
        }
        return sucess;
    }

    public void update(Product product) {
        conn = DBConnection.getConnection();
        String query
                = "update product set name=?, price= ? where id = ?";
        try {
            PreparedStatement state = conn.prepareStatement(query);
            state.setString(1, product.getName());
            state.setInt(2, product.getPrice());
            state.setString(3, product.getId());
            state.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("update異常:" + ex.toString());
        }
    }

    //選擇特定姓名，輸入正確姓名"孫大毛"或是"孫%"或是"%毛"
    public List<Product> selectByName(String name_str) {
        conn = DBConnection.getConnection();
        boolean success = false;
        List<Product> product_list = new ArrayList();
        //String query = String.format("select * from product where name like '%s%s'", name_str, "%");
        //String query = String.format("select * from product where name like '%s'", name_str);
        String query = "select * from product where name like ?";
        try {
            PreparedStatement state = conn.prepareStatement(query);
            state.setString(1, name_str);

            ResultSet rset = state.executeQuery();
            while (rset.next()) {
                Product product = new Product();
                product.setId(rset.getString("id"));
                product.setName(rset.getString("name"));
                product.setPrice(rset.getInt("price"));
                product_list.add(product);
            }
        } catch (SQLException ex) {
            System.out.println("資料庫selectByName操作異常:" + ex.toString());
        }
        return product_list;
    }

    //選擇某個product_id
    public Product selectByID(String id) {
        conn = DBConnection.getConnection();
        boolean success = false;
        String query = "select * from product where id = ?";
        //String query = String.format("select * from product where product_id = '%s'", id);
        Product product = new Product();
        try {
            PreparedStatement state = conn.prepareStatement(query);
            state.setString(1, id);
            ResultSet rset = state.executeQuery();

            while (rset.next()) {
                success = true;
                product.setId(rset.getString("id"));
                product.setName(rset.getString("name"));
                product.setPrice(rset.getInt("price"));
            }
        } catch (SQLException ex) {
            System.out.println("資料庫selectByID操作異常:" + ex.toString());
        }

        if (success) {
            return product;
        } else {
            return null;
        }

    }

    //若是有多個不唯一的product_id，查詢結果可能會有多個，以ArrayList回傳
    public List<Product> selectAllByID(String id) {
        conn = DBConnection.getConnection();
        List<Product> product_list = new ArrayList();
        boolean success = false;
        String query = "select * from product where product_id = ?";
        //String query = String.format("select * from product where product_id = '%s'", id);
        Product product = new Product();
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(0, id);
            ResultSet rset = ps.executeQuery();

            while (rset.next()) {
                success = true;

                product.setId(rset.getString("product_id"));
                product.setName(rset.getString("name"));
                product.setPrice(rset.getInt("price"));
                product_list.add(product);
            }
        } catch (SQLException ex) {
            System.out.println("資料庫selectByID操作異常:" + ex.toString());
        }

        if (success) {
            return product_list;
        } else {
            return null;
        }

    }

    //測試一下
    public static void main(String[] args) {

        ProductDAO prdao = new ProductDAO();

        // add a product record
            //System.out.println(prdao.add(new Product("p-j-115", "茶飲", "鮮奶茶", 55, "milk_tea.png", "鮮奶茶")));
        //delete a record
            //System.out.println(prdao.delete("p-j-115"));

        // select All
        System.out.println("product list");
        
        List<Product> product_list = prdao.getAllProducts();
        for (Product product : product_list) {
            System.out.println(product);
        }
        System.out.println("--------------");

        //new ProductDAO();
        // add a product record
            //System.out.println(prdao.add(new Product("p-j-116", "茶飲", "奶茶", 30, "milk_tea.png", "奶茶")));

        // select name
        List<Product> someProducts;
        //someProducts= prdao.selectByName("孫%");
        someProducts = prdao.selectByName("%西瓜汁");

        for (Product product : someProducts) {
            System.out.println(product);
        }

        System.out.println(prdao.delete("p-j-116"));

    }
}
