package laba_1;

import java.util.Arrays;
import java.util.Random;

public class laba_1 {
    public static void main(String[] args) {
        int[][] array = new int[3][5];
        Random rnd = new Random();
        //int arRnd = rnd.nextInt(100);
        for (int i = 0 ; i < array.length ; i++) {
            for (int j = 0 ; j < array[i].length ; j++) {
            array[i][j] = rnd.nextInt(100);
            }
        }
        System.out.println(Arrays.deepToString(array));
        int[][] arraySort = new int[array[1].length][array.length];
        System.out.println(Arrays.deepToString(arraySort));
        for (int i = 0 ; i < array.length ; i++) {
            for (int j = 0 ; j < array[i].length ; j++) {
                arraySort[j][i] = array[i][j];
            }
        }
        System.out.println(Arrays.deepToString(arraySort));
    }

}
