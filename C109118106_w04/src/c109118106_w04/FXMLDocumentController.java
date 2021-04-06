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
    private ComboBox<?> quantity;
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
        // TODO
    }    

    @FXML
    private void addto_cart(ActionEvent event) {
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
