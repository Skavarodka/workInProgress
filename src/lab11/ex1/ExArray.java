package lab11.ex1;

//Создать приложение, позволяющее ввести и вывести одномерный массив целых чисел.
// Для ввода и вывода массива разработать рекурсивные методы вместо циклов for.

import java.util.Scanner;

public class ExArray {
    static Scanner in = new Scanner(System.in);
    static int[] arTest;

    public static void main(String[] args) {

        System.out.println("Введите размер массива");
        int numbers = in.nextInt();
        arTest = new int[numbers];
        setArNum(numbers);
        getAr(numbers);
    }



    public static void setArNum(int z) {

        int a = z - 1;

            if (z > 0) {
                setArNum(z - 1);
                System.out.println("VVedite element");
                arTest[a] = in.nextInt();
            }
        }

        public static void getAr(int z) {
            int a = z - 1;
            if (z > 0 ) {
                getAr(z - 1);
                System.out.println(arTest[a]);
            }
        }
    }

