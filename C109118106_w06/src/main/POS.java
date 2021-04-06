/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;



import java.util.TreeMap;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import models.Order;
import models.Product;



/**
 *
 * @author rxiau6-PC
 */
public class POS extends Application {

    //ObservableList    order_list有新增或刪除都會處動table的更新，也就是發生任何改變時都被通知
    private ObservableList<Order> order_list;
    //顯示訂單詳情表格
    private TableView table;

    //顯示訂單詳情表格
    private TextArea display;
    GridPane menu;

    //根容器 所有的元件都放在裡面container，最後再放進布景中scene，布景再放進舞台中stage
    VBox root;

    //放所有產品  產品編號  產品物件
    private final TreeMap<String, Product> product_dict = new TreeMap();
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

    private void prepareProduct() {

        //read_product_from_file(); //從檔案或資料庫讀入產品菜單資訊
        for (int i = 0; i < product_array.length; i++) {
            Product product = new Product(
                    product_array[i][0],
                    product_array[i][1],
                    product_array[i][2],
                    Integer.parseInt(product_array[i][3]),
                    product_array[i][4],
                    product_array[i][5]);

            product_dict.put(product.getId(), product);
        }

    }

    private void prepareProductMenu() {

        int row = 0;
        int col = 0;

        menu = new GridPane();
        menu.setVgap(10);
        menu.setHgap(10);

        for (String item_id : product_dict.keySet()) {

            //定義新增一筆按鈕
            Button btn = new Button();
            btn.setPrefSize(180, 100);
            //btn.setText(product_dict.get(item_id).getName());

            //Creating a graphic (image)
            Image img = new Image("/imgs/" + product_dict.get(item_id).getImgSrc());
            ImageView view = new ImageView(img);
            view.setFitHeight(100);
            view.setPreserveRatio(true);
            //Setting a graphic to the button
            btn.setGraphic(view);


            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    //新增一筆
                    //order_list.add(new Order("p-109", "新增的果汁", 30, 1));
                    //System.out.println("add a row");
                    addToCart(item_id);
                    check();
                }
            });

            if (col == 5) {
                col = 0;
                row++;
            }
            menu.add(btn, col, row);
            col++;
        }

    }

    //計算總金額
    public void check() {
        double total = 0;
        //將所有的訂單顯示在表格   計算總金額
        for (Order od : order_list) {
            //加總
            total += od.getPrice() * od.getQty();
        }

        //顯示總金額於display
        String totalmsg = String.format("%s %d\n", "總金額:", Math.round(total));
        display.setText(totalmsg);

    }

    //加入購物車 檢查是否有重複的飲料
    public void addToCart(String item_id) {

        boolean duplication = false;
        for (Order ord : order_list) {
            if (ord.getId().equals(item_id)) {
                duplication = true;
            }
        }

        if (duplication) {
            System.out.println(item_id + "已經加入購物車");
        } else {
            Order new_ord = new Order(
                    item_id,
                    product_dict.get(item_id).getName(),
                    product_dict.get(item_id).getPrice(),
                    1);
            order_list.add(new_ord);
            System.out.println(item_id);
        }
    }

    //初始化所有元件與事件並將所有元件放入root
    public void initMyComponents() {

        //訂單陣列串列初始化FXCollections類別有很多靜態方法可以操作ObservableList的"訂單陣列串列"
        order_list = FXCollections.observableArrayList();

        //也可以這樣加入一筆訂單
        //order_list.add(new Order("p-103", "西瓜汁", 80, 3));
        // display
        display = new TextArea();

        //表格初始化
        table = new TableView();
        table.setEditable(true); //表格允許修改
        //表格項目來自於order_list，依據置放順序顯示
        table.setItems(order_list);

        //table也可以這樣放入訂單
        //table.getItems().add(new Order("p-104", "奇異果汁", 50, 2));
        //定義第一個欄位column"品名"，其值來自於Order物件的某個String變數
        TableColumn<Order, String> order_item_name = new TableColumn("品名");
        //置放哪個變數值?指定這個欄位放置Order的"name"實例變數值
        order_item_name.setCellValueFactory(new PropertyValueFactory("name"));
        //order_item_name.setCellFactory(TextFieldTableCell.forTableColumn());
        order_item_name.setPrefWidth(100); //設定欄位寬度
        order_item_name.setMinWidth(100);

        TableColumn<Order, Integer> order_item_price = new TableColumn("價格");
        order_item_price.setCellValueFactory(new PropertyValueFactory("price"));
        //order_item_price.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        TableColumn order_item_qty = new TableColumn("數量");
        order_item_qty.setCellValueFactory(new PropertyValueFactory("qty"));
        //這個欄位值內容可以被修改，因為qty是整數，因此須將整數轉為字串
        order_item_qty.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        //把3個欄位加入table中
        table.getColumns().addAll(order_item_name, order_item_price, order_item_qty);

        //表格最後一欄是空白，不要顯示!
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        //定義數量欄位被修改後進行那些動作
        order_item_qty.setOnEditCommit(new EventHandler<CellEditEvent>() {
            @Override
            public void handle(CellEditEvent event) {

                int row_num = event.getTablePosition().getRow();//哪一筆被修改
                int new_val = (Integer) event.getNewValue(); //改成甚麼數值 需要將物件轉為整數
                Order target = (Order) event.getTableView().getItems().get(row_num); //取得該筆果汁傳參考呼叫
                //修改成新的數值 該筆訂單存放於order_list
                target.setQty(new_val);
                check();
                System.out.println(order_list.get(row_num).getQty()); //顯示修改後的數值
            }
        });

        //定義新增一筆按鈕
        Button btn = new Button();
        btn.setText("新增一筆");
        btn.getStylesheets().add("/css/bootstrap3.css");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //新增一筆
                //order_list.add(new Order("p-109", "新增的果汁", 30, 1));
                //System.out.println("add a row");
                addToCart("p-j-104");
                check();
            }
        });
        //定義刪除一筆按鈕
        Button btndelete = new Button("刪除一筆");
        btndelete.getStylesheets().add("/css/bootstrap3.css");
        btndelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //取得哪一筆該被刪除
                Object selectedItem = table.getSelectionModel().getSelectedItem();
                //從表格table中或是從order_list刪除這一筆，擇一進行
                table.getItems().remove(selectedItem);
                //order_list.remove(selectedItem);
                check();
            }
        });

        //放置兩個按鈕
        HBox hb_btn = new HBox();
        hb_btn.getChildren().addAll(btn, btndelete);
        hb_btn.setSpacing(10);
        hb_btn.setAlignment(Pos.CENTER_RIGHT);

        //根節點容器
        root = new VBox();
        root.getChildren().addAll(menu, hb_btn, table, display);
        root.setSpacing(10);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.getStylesheets().add("/css/bootstrap3.css");
    }

    //建構子
    public POS() {
        prepareProduct();
        prepareProductMenu();
    }

    @Override
    public void start(Stage stage) {
        initMyComponents();
        Scene scene = new Scene(root);
        stage.setTitle("表格展示");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

