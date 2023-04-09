package laba_1;

import java.util.Arrays;
import java.util.Scanner;

public class laba4_7 {
    public static void main(String[] args) {
        System.out.println("VVedite 2 chisla");
        Scanner in = new Scanner(System.in);
        int numbersM = in.nextInt();
        int numbersN = in.nextInt();
        int[][] myArr = new int[numbersM][numbersN];
        int countOfFirstJ = 0; //считаем сколько столбцов было заполнено снизу вверх
        int countOfRevers; // двигаем строки для заполнения задом наперед
        int count = 0;
        int arrCount = 1;
        System.out.println(Arrays.deepToString(myArr));
        for (int i = 0 ; count < myArr.length ; count++) {
                for (int j = 0 ; j < myArr[i].length - countOfFirstJ; j++) {
                    myArr[i][j] = arrCount++;
                }
                i++;
                countOfRevers = 1;
                for (int o = myArr.length - 1 - countOfFirstJ ; o > 0 ; o--) {
                    myArr[myArr.length - countOfRevers][numbersN- 1 - countOfFirstJ] = arrCount++;
                    countOfRevers++;
                }
            countOfFirstJ++;
        }
        System.out.println(Arrays.deepToString(myArr));
    }
}
