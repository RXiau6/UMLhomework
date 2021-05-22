/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab15_javafx_student_crud_tableview;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author RXiau6
 */
public class CrudStudentTableViewController implements Initializable {

    @FXML
    private TextField queryID;
    @FXML
    private TextField queryName;
    @FXML
    private TableView<?> table_product;
    @FXML
    private TableColumn<?, ?> col_id;
    @FXML
    private TableColumn<?, ?> col_name;
    @FXML
    private TableColumn<?, ?> col_price;
    @FXML
    private TableColumn<?, ?> col_photo;
    @FXML
    private TableColumn<?, ?> col_description;
    @FXML
    private Pagination pagination;
    @FXML
    private TableColumn<?, ?> col_category;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void update(ActionEvent event) {
    }

    @FXML
    private void delete(ActionEvent event) {
    }

    @FXML
    private void insert(ActionEvent event) {
    }

    @FXML
    private void blankRecord(ActionEvent event) {
    }

    @FXML
    private void findID(ActionEvent event) {
    }

    @FXML
    private void findName(ActionEvent event) {
    }

    @FXML
    private void findAll(ActionEvent event) {
    }
    
}
