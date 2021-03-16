/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c109118106_w03;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;
import javafx.concurrent.Worker.State;

/**
 *
 * @author RXiau6
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private WebView web;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
       String url = "https://www.thsrc.com.tw/ArticleContent/743c51ac-124d-4b1a-a57b-1fd820848032";
        try{
        WebEngine webEngine = web.getEngine();
        webEngine.load(url);
       }catch(Exception ex){
           System.out.print(ex+"\n");
       }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void printPriceTable(){
        int [][] priceTable;
        priceTable = new int [12][12];
        
    }
    
}
