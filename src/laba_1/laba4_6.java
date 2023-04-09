package laba_1;

import java.util.Arrays;
import java.util.Random;

public class laba4_6 {
    public static void main(String[] args) {
        int[][] arrayOrig = new int[3][5];
        Random rnd = new Random();

        for (int i = 0 ; i < arrayOrig.length ; i++) {

            for (int j = 0 ; j < arrayOrig[i].length ; j++) {
                arrayOrig[i][j] = rnd.nextInt(10);
            }
        }
        int arrayM = rnd.nextInt(1 ,3);
        int arrayN = rnd.nextInt( 1, 5);
        System.out.println(Arrays.deepToString(arrayOrig));
        System.out.println(arrayM + " " + arrayN);
        int[][] arrayDel = new int[2][4];
        for ( int i = 0 ; i < 2 ; i++) {
            for ( int j = 0 ; j < 4 ; j++) {
                arrayDel[i][j] = arrayOrig[i + (i < arrayM ? 0 : 1)][j + (j < arrayN ? 0 : 1)]; // тернарный оператор
            }                                                // проверяет переменную на рандомное число индекса массива
        }                       // когда находит рандомное число повышает индекс в результате искомое рандомное число
        System.out.println(Arrays.deepToString(arrayDel)); // arrayM или arrayN как бы выпадает
    } // допустим число было 2 пойдет отсчет 0 1 остануться неизменными а с 2 < 2 пойдет увелечение на 1
} // в итоге получиться 0 1 3 4 5
