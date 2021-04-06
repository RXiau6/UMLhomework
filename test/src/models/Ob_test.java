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
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Order;

public class Ob_test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        //簡單的ArrayList
        ArrayList<String> simple_list = new ArrayList();
        simple_list.add("p-j-100");
        simple_list.add("p-j-101");
        System.out.println("筆數:" + simple_list.size());
        System.out.println("內容:" + simple_list.get(0));
        */
        //簡單的ArrayList
        List<Order> simple_order_list = new ArrayList();
        simple_order_list.add(new Order("p-101", "葡萄汁", 80, 3));
        simple_order_list.add(new Order("p-102", "番茄汁", 70, 1));
        System.out.println("筆數:" + simple_order_list.size());
        System.out.println("內容:" + simple_order_list.get(0).getName());

        //印出每一筆內容
        for (int i = 0; i < simple_order_list.size(); i++) {
            System.out.println(simple_order_list.get(i).getId() + ":" + simple_order_list.get(i).getName());
        }

        double total = 0;
        //將所有的訂單顯示在表格   計算總金額
        for (Order od : simple_order_list) {
            //加總
            total += od.getPrice() * od.getQty();
        }

        //顯示總金額
        String total_msg = String.format("%s %d\n", "總金額:", Math.round(total));
        //display.setText(total_msg);
        System.out.println(total_msg);

        //寫成方法呼叫方法比較好
        check_tatal(simple_order_list);

        //加入購物車
        add_to_cart("p-101", 5, simple_order_list);
        add_to_cart("p-103", 5, simple_order_list);

        /*
        ObservableList  可被觀察(監視)的串列
        有新增或刪除都會處動table的更新，也就是發生任何改變時都被通知
        A list that allows listeners to track changes when they occur.
         */
        ObservableList<Order> order_list;
        //訂單串列
        //訂單陣列串列初始化FXCollections類別有很多靜態方法可以操作ObservableList的"訂單陣列串列"
        order_list = FXCollections.observableArrayList();
        //前面新增一個空的串列，現在若已知有兩筆訂單可以這樣設定
        
        
        order_list = FXCollections.observableArrayList(
                new Order("p-101", "葡萄汁", 80, 3),
                new Order("p-102", "番茄汁", 70, 1)
        );

        //也可以這樣臨時加入一筆訂單
        order_list.add(new Order("p-103", "西瓜汁", 80, 3));

        //印出每一筆內容
        for (int i = 0; i < order_list.size(); i++) {
            System.out.println(order_list.get(i).getId() + ":" + order_list.get(i).getName());
        }

        check_tatal(order_list);

    }

    //參數使用List最好，物件多型可以通吃喔! 
    //請試試看改成ArrayList或是ObservableList
    public static void check_tatal(List<Order> list) {
        double total = 0;
        //將所有的訂單顯示在表格   計算總金額
        for (Order od : list) {
            //加總
            total += od.getPrice() * od.getQty();
        }

        //顯示總金額於display
        String total_msg = String.format("%s %d\n", "總金額:", Math.round(total));
        //display.setText(total_msg);
        System.out.println(total_msg);

    }

    //加入購物車
    private static void add_to_cart(String item_id, int qty, List<Order> order_list) {

        boolean duplication = false;
        for (Order ord : order_list) {
            if (ord.getId().equals(item_id)) {
                duplication = true;
            }
        }

        if (duplication) {
            System.out.println(item_id + "購物車已經有了，請直接去修改數量!");
        } else {
            Order new_ord = new Order(item_id, "菊花茶", 100, qty); //產品資訊可以查得到不可能寫死
            order_list.add(new_ord);
            System.out.println(item_id + "加入購物車數量:" + qty);
        }

        check_tatal(order_list);

    }

}
