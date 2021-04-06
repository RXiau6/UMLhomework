/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c109118106_w04;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import models.Order;
import models.Ob_List;

/**
 *
 * @author RXiau6
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Label item_name;
    @FXML
    private Label item_price;
    @FXML
    private ImageView item_image;
    @FXML
    private ComboBox<String> quantity;
    @FXML
    private TableColumn<?, ?> order_item_name;
    @FXML
    private TableColumn<?, ?> order_item_price;
    @FXML
    private TableColumn<?, ?> order_item_qty;
    @FXML
    private TextArea display;
    @FXML
    private AnchorPane menuPane;
    @FXML
    private TableView<?> cart;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        for (int i=1;i<=10;i++){
            String num = String.format("%02d",i);
            quantity.getItems().addAll(num);
        }
    }    

    @FXML
    private void addto_cart(ActionEvent event) {
        Ob_List.add_to_cart(item_id, 0, order_list);
    }

    @FXML
    private void delete_order(ActionEvent event) {
    }

    @FXML
    private void check(ActionEvent event) {
    }

    @FXML
    private void select_menu(ActionEvent event) {
    }
    
}
