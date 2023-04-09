package lab11.ex1;

import java.util.Scanner;
//Создать приложение с использованием рекурсии для перевода целого числа, введенного с клавиатуры,
// в двоичную систему счисления.
public class Ex2RecBin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numbers = in.nextInt();
        toBin(numbers);
    }

    static void toBin(int x) {
        String sr = "";
        if (x != 0) {
            toBin(x / 2);
            sr = sr + x % 2;
        }
        System.out.printf(sr);
    }
}
