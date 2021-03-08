/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c109118106_w02;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import c109118106_w02.GradeBook2D;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Formatter;
import java.io.File;

/**
 *
 * @author RXiau6
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    private String[] names;
    private int [][] grades;
    private String fileName = "score.csv";

    GradeBook2D grade = new GradeBook2D();
    @FXML
    private Button read_btn;
    @FXML
    private Button score_btn;
    @FXML
    private Button stu_btn;
    @FXML
    private Button exam_btn;
    @FXML
    private Button person_btn;
    @FXML
    private Button class_btn;
    @FXML
    private TextArea result;
    @FXML
    private Button fileChoose_btn;
    
    public void openFile(File fileName){
        Scanner input ;
        String row ="";
        String line = "";
        int stuOfNum= 0;
        int exam = 0;
        try{    //算考試次數&考生人數
           input = new Scanner (fileName);
           while (input.hasNextLine()){
               line = input.nextLine();
               System.out.println("---"+line);
               if(!line.isEmpty()){
                   stuOfNum++;
                   row = line;
               }
           }
           System.out.printf("學生人數：%d\n",stuOfNum);
           exam = row.split(",").length-1;
           System.out.printf("考試次數：%d\n",exam);
            
        }catch(FileNotFoundException ex){
            System.out.printf("File ERROR");
        }
        names = new String [stuOfNum];
        grades = new int [stuOfNum][exam];   //設定array size f or names&grades
        try {   //input score to array
            input =new Scanner (fileName);
            int stu =0;
            while (input.hasNextLine()){
                line = input.nextLine();
                System.out.println("---"+line);
                if (!line.isEmpty()){
                    String [] rec = line.split(",");
                    names[stu] = rec [0];
                 
                    for (int i=0;i<exam;i++){
                        grades[stu][i]=Integer.parseInt(rec[i+1]);
                    }
                    stu++;
                }
            }
        } catch(FileNotFoundException ex){
            System.out.println("FileERROR");
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void readScore(ActionEvent event) {
        System.out.print(grade.outputGrades());
//    result.appendText(grade.outputGrades());
    }

    @FXML
    private void printScore(ActionEvent event) {
    }

    @FXML
    private void countStu(ActionEvent event) {
    }

    @FXML
    private void countExam(ActionEvent event) {
    }

    @FXML
    private void accPersonalAvg(ActionEvent event) {
    }

    @FXML
    private void accClassAvg(ActionEvent event) {
    }

    @FXML
    private void fileChoose(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("選取成績檔案");
        File selectedFile = fileChooser.showOpenDialog(null);
        
        if(selectedFile != null){
            result.setText(selectedFile.getAbsolutePath()+"<=開啟檔名\n");
            openFile(selectedFile);
            grade.setGrades(grades);
        } else {
            return;
        }
        
    }
    
}
