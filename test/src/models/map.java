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
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import models.Product;

public class map {

    public static void main(String[] args) {

        //簡單tree map展示
        TreeMap<String, Integer> item_price_dict = new TreeMap();
        item_price_dict.put("p-j-100", 300);
        item_price_dict.put("p-j-101", 250);

        //已知"p-j-101"，要得到產品價格
        System.out.println(item_price_dict.get("p-j-101"));
        //印出每一筆內容
        for (String key : item_price_dict.keySet()) {
            System.out.println(key + ":" + item_price_dict.get(key));
        }

        //產品的處理
        //通常我們將資料放入2維陣列，但陣列長度需要事先知道，超級不方便
        String[][] product_array = {
            {"p-j-101", "果汁", "奇異果汁", "70", "kiwi.png", "紐西蘭特選，酸甜的口味，令人忍不住再喝一口"},
            {"p-j-102", "果汁", "椰子汁", "80", "coconut.png", "產品描述"},
            {"p-j-103", "果汁", "水蜜桃汁", "90", "peach.png", "產品描述"},
            {"p-j-104", "果汁", "葡萄汁", "100", "grapes.png", "產品描述"},
            {"p-j-105", "果汁", "草莓汁", "100", "strawberry.png", "產品描述"},
            {"p-j-106", "果汁", "芒果汁", "100", "mango.png", "產品描述"},
            {"p-j-107", "果汁", "櫻桃汁", "120", "cherry.png", "產品描述"},
            {"p-j-108", "果汁", "香蕉汁", "75", "banana.png", "產品描述"},
            {"p-j-109", "果汁", "橘子汁", "65", "orange.png", "產品描述"},
            {"p-j-110", "果汁", "西瓜汁", "60", "watermelon.png", "產品描述"},
            {"p-t-112", "茶飲", "紅茶", "45", "blacktea.jpg", "產品描述"},
            {"p-t-113", "茶飲", "綠茶", "45", "greentea.jpg", "產品描述"},
            {"p-t-114", "茶飲", "珍珠奶茶", "50", "perlmilktea.jpg", "產品描述"}
        };


        //我們不用ArrayList，使用map更方便，是更好的寫法
        //已知一個產品編號，與得知其產品名稱價格等詳細資訊，使用(key, value)的Map比較方便!
        TreeMap<String, Product> product_dict = new TreeMap();
        Product product;
        for (int i = 0; i < product_array.length; i++) {
            //可以從product_array取得資料，
            //也可以從array_of_product取得資料，這更方便
            product = new Product(
                    product_array[i][0],
                    product_array[i][1],
                    product_array[i][2],
                    Integer.parseInt(product_array[i][3]),
                    product_array[i][4],
                    product_array[i][5]);

            //塞入map字典內
            product_dict.put(product.getId(), product);
        }

        //印出每一筆內容
        for (String key : product_dict.keySet()) {
            System.out.println(product_dict.get(key).getId() + ":" + product_dict.get(key).getName());
        }

        //已知"p-j-101"，要得到產品名稱，可以這樣用，太方便了
        System.out.println(product_dict.get("p-j-101").getName());

    }
}

