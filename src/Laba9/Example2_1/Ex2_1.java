package Laba9.Example2_1;

//определить экспериментально, ошибки каких классов будут сгенерированы;
//создать обработчики исключительных ситуаций с использованием выявленных классов и
//всех секций конструкции обработчика с соответствующими сообщениями,позволяющими корректно выполнить программу.

//В программе, вычисляющей среднее значение среди положительных элементов одномерного массива (тип элементов int),
//вводимого с клавиатуры, могут возникать ошибки в следующих случаях:
//        –	ввод строки вместо числа; InputMismatchException NoSuchElementException RuntimeException
//        –	несоответствие числового типа данных; InputMismatchException NoSuchElementException RuntimeException
//        –	положительные элементы отсутствуют. ArithmeticException RuntimeException



import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex2_1
{
    static Scanner in = new Scanner(System.in);
    static int temp = 0;
    public static int m(int x) {

        System.out.println("Введите элементы массива");
        int[] arInt = new int[x];
        try {


            for (int i = 0; i < arInt.length; i++) {
                int j = in.nextInt();
                arInt[i] = j;

                if (j > 0) {
                    temp += arInt[i];
                }
            }
            if (temp <= 0) {
                throw new ArithmeticException("Отсутсвуют положительные элементы");
            }
        } catch (InputMismatchException | ArithmeticException e) {
            System.out.println(e);
            m(x);
        } finally {
            System.out.println("END");
        }
        return temp /= x;
    }
    public static void main(String[] args)
    {
        System.out.println("Введите размер массива");
        int temp = in.nextInt();
        m(temp);



            }
        }

