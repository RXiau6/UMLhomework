/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1_exception_fileIO;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 *
 * @author RXiau6
 */
public class readFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int student = 0;
        int exam = 0;
        int class_avg = 0;
        String[] names;
        int[][] grades;

        try {
            Scanner in = new Scanner(new File("score.csv"));
            String row = "";
            while (in.hasNextLine()) {
                student++;
                row = in.nextLine();
                //System.out.print(row + "\n");
                exam = row.split(",").length - 1;
            }
            in.close();
        } catch (Exception ex) {
            System.out.print("ERROR : " + ex + "\n");
        }
        System.out.printf("%d位學生\n%d次考試\n班級平均:%d\n", student, exam, class_avg);
        names = new String[student];
        grades = new int[student][exam];

        String[] rec;
        try {
            Scanner in = new Scanner(new File("score.csv"));
            int stu = 0;
            String row = "";
            while (in.hasNextLine()) {
                row = in.nextLine();
                rec = row.split(",");
                names[stu] = rec[0];

                for (int i = 0; i < exam; i++) {
                    grades[stu][i] = Integer.parseInt(rec[i + 1]);
                }
                stu++;
            }
        } catch (FileNotFoundException ex) {
            System.out.print("File error");
        }
        printGrade(grades,names);

    }

    public static void printGrade(int[][] x, String[] y) {
        System.out.print("名字  成績1 成績2\n");
        for (int i = 0; i < x.length; i++) {
            System.out.printf("%s",y[i]);
            for (int j = 0; j < x[i].length; j++) {
                System.out.printf(" %d",x[i][j]);
            }
            System.out.println("");
        }
        
        
        //System.out.println("");
    }

}
