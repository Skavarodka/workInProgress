package tictactoe;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YA {
    public static void main(String[] args) {
        // write your code here
        Scanner in = new Scanner(System.in);
        System.out.println("X"+"O"+"X");
        System.out.println("X"+"O"+"X");
        System.out.println("X"+"O"+"X");
        System.out.println("Enter the text");

        String num = in.next();

        Character[][] ticTacStart = new Character[3][3];

        List<Character> ticTacList = new ArrayList<>();

        int counter = 0;
        for (int i = 0; i < num.length(); i++){
            ticTacList.add(num.charAt(counter++));
        }
        System.out.println(ticTacList);
        counter = 0;
        for (int i = 0; i < ticTacStart.length; i++){
            for (int j = 0; j < ticTacStart[i].length; j++) {
                ticTacStart[i][j] = num.charAt(counter++);
            }
        }
        askTest(ticTacStart);
        askWinner(ticTacStart);
    }
    static void askWinner(Character[][] ticTacStart) {
        boolean xWin = false;
        boolean oWin = false;
        boolean noWin = false;
        Character n00 = ticTacStart[0][0];
        Character n01 = ticTacStart[0][1];
        Character n02 = ticTacStart[0][2];
        Character n10 = ticTacStart[1][0];
        Character n11 = ticTacStart[1][1];
        Character n12 = ticTacStart[1][2];
        Character n20 = ticTacStart[2][0];
        Character n21 = ticTacStart[2][1];
        Character n22 = ticTacStart[2][2];

        //горизонталь
        if ((n00.equals(n01) & n00.equals(n02)) & n00.equals('X')) {
            xWin = true;
            oWin = false;
        }
        if ((n10.equals(n11) & n10.equals(n12)) & n10.equals('X')) {
            xWin = true;
            oWin = false;
        }
        if ((n20.equals(n21) & n20.equals(n22)) & n20.equals('X')) {
            xWin = true;
            oWin = false;
        }

        //вертикаль
        if ((n00.equals(n10) & n00.equals(n20)) & n00.equals('X')) {
            xWin = true;
            oWin = false;
        }
        if ((n01.equals(n11) & n01.equals(n21)) & n01.equals('X')) {
            xWin = true;
            oWin = false;
        }
        if ((n02.equals(n12) & n02.equals(n22)) & n02.equals('X')) {
            xWin = true;
            oWin = false;
        }

        //диагонали
        if ((n00.equals(n11) & n00.equals(n22)) & n00.equals('X')) {
            xWin = true;
            oWin = false;
        }
        if ((n20.equals(n11) & n20.equals(n02)) & n20.equals('X')) {
            xWin = true;
            oWin = false;
        }

        if (oWin) System.out.println("O wins");
        if (xWin) System.out.println("X wins");
    }

    static void askTest(Character[][] ticTacStart) {
        System.out.println("---------");
        System.out.println("| "+ticTacStart[0][0] +" "+ticTacStart[0][1]+" "+ticTacStart[0][2]+" |");
        System.out.println("| "+ticTacStart[1][0] +" "+ticTacStart[1][1]+" "+ticTacStart[1][2]+" |");
        System.out.println("| "+ticTacStart[2][0] +" "+ticTacStart[2][1]+" "+ticTacStart[2][2]+" |");
        System.out.println("---------");
    }
}
