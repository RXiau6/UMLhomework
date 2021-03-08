/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author RXiau6
 */
public class P_02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String row = "";
        String[] text;
        int students = 0;
        int exam = 0;

        try {
            Scanner input = new Scanner(new File("score.csv"));

            while (input.hasNextLine()) {
                row = input.nextLine();
                exam = row.split(",").length - 1;
                students++;
            }
        } catch (FileNotFoundException err) {
            System.out.print(err.toString());
        }

        int[][] scores;
        scores = new int[students][exam+1];
        String [] names;
        names = new String [students];
        int stu =0;
        try {
            Scanner input = new Scanner(new File("score.csv"));
            while (input.hasNextLine()) {
                row = input.nextLine();
                text = row.split(",");
                names[stu]=text[0];
                for(int i=0;i<text.length-1;i++){
                    scores[stu][i]=Integer.parseInt(text[i+1]);
                }
                scores[stu][2]=(scores[stu][0]+scores[stu][1])/2;
               stu++; 
            }
        } catch (FileNotFoundException ex) {
            System.out.print(ex.toString());
        }
        double classAvg=getClassAvg(scores);
        System.out.printf("考生人數：%d\n考試次數：%d\n班級平均：%.2f\n",students,exam,classAvg);
        printScoreList(scores,names);
    }
    public static double getClassAvg(int score[][]){
        int times=0;
        double total=0;
        for(int i=0;i<score.length;i++){
            if(times<score.length){
                total+=score[i][score[i].length-1];
            }
            times++;
        }
        return total/score.length;
    }
    public static void printScoreList(int score [][],String names[]){
        System.out.println("--------------------------------");
        System.out.print("  姓名 成績01 成績02 個人平均\n");
        for(int i=0;i<score.length;i++){
            System.out.printf("%4s",names[i]);
            for (int j=0;j<score[i].length;j++){
            System.out.printf("%5d  ",score[i][j]);
            }
            System.out.println("");
        }
        System.out.println("--------------------------------");
    }
}
