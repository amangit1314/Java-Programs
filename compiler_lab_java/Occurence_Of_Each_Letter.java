package compiler_lab_java;

import java.io.*;
import java.util.*;

public class Occurence_Of_Each_Letter {
    public static void main(String[] args) {
        //declares variables
        String[] sentence = new String [23];
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countE = 0;
        int countF = 0;
        int countG = 0;
        int countH = 0;
        int countI = 0;
        int countJ = 0;
        int countK = 0;
        int countL = 0;
        int countM = 0;
        int countN = 0;
        int countO = 0;
        int countP = 0;
        int countQ = 0;
        int countR = 0;
        int countS = 0;
        int countT = 0;
        int countU = 0;
        int countV = 0;
        int countW = 0;
        int countX = 0;
        int countY = 0;
        int countZ = 0;
        char words;

        //Get user input
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter a Filename: ");
        String filename = keyboard.nextLine();

        //Open file for reading
        Scanner inputStream = null;

        //catch exception
        try {
            inputStream = new Scanner(new File(filename));
        }
        catch(FileNotFoundException e) {
            System.out.print("Error opening the " + filename);
            System.exit(0);
        }

        //read form file and store in an array
        while(inputStream.hasNextLine()) {
            for (int i = 0; i < sentence.length; i++) {
                sentence[i] = inputStream.nextLine();
                //counts the occurrence of each letter in each line of aman.txt
                for(int j = 0; j < sentence[i].length() ;j++) {
                    words = sentence[i].charAt(j);
                    if(words == 'A' || words == 'a')
                        countA++;

                    if(words == 'B' || words == 'b')
                        countB++;

                    if(words == 'C' || words == 'c')
                        countC++;

                    if(words == 'D' || words == 'd')
                        countD++;

                    if(words == 'E' || words == 'e')
                        countE++;

                    if(words == 'F' || words == 'f')
                        countF++;

                    if(words == 'G' || words == 'g')
                        countG++;

                    if(words == 'H' || words == 'h')
                        countH++;

                    if(words == 'I' || words == 'i')
                        countI++;

                    if(words == 'J' || words == 'j')
                        countJ++;

                    if(words == 'K' || words == 'k')
                        countK++;

                    if(words == 'L' || words == 'l')
                        countL++;

                    if(words == 'M' || words == 'm')
                        countM++;

                    if(words == 'N' || words == 'n')
                        countN++;

                    if(words == 'O' || words == 'o')
                        countO++;

                    if(words == 'P' || words == 'p')
                        countP++;

                    if(words == 'Q' || words == 'q')
                        countQ++;

                    if(words == 'R' || words == 'r')
                        countR++;

                    if(words == 'S' || words == 's')
                        countS++;

                    if(words == 'T' || words == 't')
                        countT++;

                    if(words == 'U' || words == 'u')
                        countU++;

                    if(words == 'V' || words == 'v')
                        countV++;

                    if(words == 'W' || words == 'w')
                        countW++;

                    if(words == 'X' || words == 'x')
                        countX++;

                    if(words == 'Y' || words == 'y')
                        countY++;

                    if(words == 'Z' || words == 'z')
                        countZ++;

                }
            }
        }

        //close file
        inputStream.close();

        // Displaying results
        System.out.println("The file gettysburg.txt contains the following: ");
        for(char i = 65 ; i <= 90;) {
            int[] count = {countA, countB, countC, countD, countE, countF, countG, countH, countI, countJ, countK, countL, countM, countN, countO, countP, countQ, countR, countS, countT, countU, countV, countW, countX, countY, countZ};
            for(int j = 0; j< count.length;) {
                System.out.println("Number of " + i +"'s: " + count[j]);
                j++;
                i++;
            }
        }
    }
}