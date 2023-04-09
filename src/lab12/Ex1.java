package lab12;

//1. Напишите функцию, которая принимает на вход массив целых чисел и возвращает новый массив,
// содержащий только четные числа из исходного массива.

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("VVedite razmer masiva");
        int size = in.nextInt();
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0 ; i < size ; i++) {
            arr[i] = random.nextInt();
        }
        System.out.println("Masssiv");
        System.out.println(Arrays.toString(arr));

        int[] arrResult = funcia(arr);

        System.out.println("massiv posle funcii");
        System.out.println(Arrays.toString(arrResult));
    }

    public static int[] funcia(int[] arr) {
        return Arrays.stream(arr).filter(x -> x % 2 == 0).toArray();
    }
}
