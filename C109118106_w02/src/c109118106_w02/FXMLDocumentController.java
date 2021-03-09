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
    @FXML
    private Button class_btn1;
    @FXML
    private Button class_btn2;
    @FXML
    private Button class_btn21;
    @FXML
    private Button class_btn211;
    @FXML
    private Button class_btn212;
    @FXML
    private Button class_btn2121;
    
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
    private void printScore(ActionEvent event) {
        try{
        result.setText(grade.outputGrades());
        }catch (Exception ex){
            result.setText("ERROR\nERROR MESSANGE : "+ex);
        }
    }

    @FXML
    private void countStu(ActionEvent event) {
        try {
            int stu = grade.getNumberOfStudent();
            String ans = String.format("共%3d位考生",stu);
            result.setText(ans);
        }catch (Exception ex){
            result.setText("ERROR\nERROR MESSANGE : "+ex);
        }
    }

    @FXML
    private void countExam(ActionEvent event) {
        try {
            int examCount = grade.getNumberOfScore();
            String ans = String.format("共%3d次考試", examCount);
            result.setText(ans);
        }catch (Exception ex){
            result.setText(("ERROR\nERROR MESSANGE : "+ex));
        }
    }

    @FXML
    private void accPersonalAvg(ActionEvent event) {
        try{
            result.setText("");
            double [] stuAvg;
            stuAvg = new double [grades.length];
            stuAvg = grade.getStuAverages();
            for (int i=0;i<stuAvg[i];i++){
                String ans = String.format("%s的平均成績為%f\n",names[i],stuAvg[i]);
                result.appendText(ans);
            }
            
        }catch(Exception ex){
            System.out.print(ex);
        }
    }

    @FXML
    private void accClassAvg(ActionEvent event) {
        double classAvg = grade.get_classAvg();
        String ans = String.format("班級平均為%f",classAvg);
        try {
            result.setText(ans);
        }catch (Exception ex){
            result.setText("ERROR\n ERROR MESSANGE : "+ex);
        }
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

    @FXML
    private void Failcount(ActionEvent event) {
        int fail = grade.getFailed();
        String ans = String.format ("不及格人數為%d",fail);
        try {
            result.setText(ans);
        }catch (Exception ex){
            result.setText("ERROR\nERROR MESSANGE");
        }
    }

    @FXML
    private void get_lowest(ActionEvent event) {
        int lowest = grade.getMinimum();
        String ans = String.format("最低分為%d",lowest);
        try {
            result.setText(ans);
        } catch (Exception ex){
            result.setText("ERROR\nERROR MESSANGE : "+ex);
        }
    }

    @FXML
    private void get_highest(ActionEvent event) {
        int high = grade.getMaximum();
        String ans = String.format("最高分為%d",high);
        try {
            result.setText(ans);
        } catch (Exception ex){
            result.setText("ERROR\nERROR MESSANGE : "+ex);
        }
    }

    @FXML
    private void get_personHi(ActionEvent event) {
        try{
            result.setText("");
            double [] stuHi;
            stuHi = new double [grades.length];
            stuHi = grade.getPersonHigh();
            for (int i=0;i<stuHi.length;i++){
                String ans = String.format("%s的最高成績為%f\n",names[i],stuHi[i]);
                result.appendText(ans);
            }
            
        }catch(Exception ex){
            System.out.print(ex);
        }
    }

    @FXML
    private void get_personLo(ActionEvent event) {
        try{
            result.setText("");
            double [] stuLo;
            stuLo = new double [grades.length];
            stuLo = grade.getPersonLow();
            for (int i=0;i<stuLo.length;i++){
                String ans = String.format("%s的最低成績為%f\n",names[i],stuLo[i]);
                result.appendText(ans);
            }
            
        }catch(Exception ex){
            System.out.print(ex);
        }
    }

    @FXML
    private void get_examAvg(ActionEvent event) {
        double [] examAvg;
        int [] grade_temp;
        examAvg =  new double [grades[0].length];
        for (int i=0;i<examAvg.length;i++){
            grade_temp=new int [grades[i].length];
            for (int j=0;j<grades[i].length;j++){
                grade_temp[j] =  grades[i][j];
            }
            examAvg[i]=grade.getAvg(grade_temp);
        }
        try{
            for (int i=0;i<examAvg.length;i++){
                String ans = String.format("第%d次考試平均為%f\n",i+1,examAvg[i]);
                result.appendText(ans);
            }
        } catch (Exception ex){
            result.setText("ERROR\nERROR MESSANGE : "+ex);
        }
    }
    
}
