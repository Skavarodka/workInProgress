package Laba9.Example2_1;

//определить экспериментально, ошибки каких классов будут сгенерированы;
//создать обработчики исключительных ситуаций с использованием выявленных классов и
//всех секций конструкции обработчика с соответствующими сообщениями,позволяющими корректно выполнить программу.

//В программе, где требуется из матрицы вывести столбец с номером, заданным с клавиатуры, могут возникать ошибки в следующих случаях:
//        –	ввод строки вместо числа; InputMismatchException NoSuchElementException RuntimeException
//        –	нет столбца с таким номером. ArrayIndexOutOfBoundsException IndexOutOfBoundsException RuntimeException


import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ex2_2
{
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws RuntimeException
    {
        te(m());
    }
    public static void te(int[][] a) // показываем столбцы
    {
       try
        {
            System.out.println("Введите номер столбца");
            int test = in.nextInt();
            for (int i = 0; i < a.length; i++)
            {

                System.out.println(a[i][test]);

            }
        }
        catch (ArrayIndexOutOfBoundsException | InputMismatchException e)
        {
            System.out.println(e);
        }
        finally
        {
            System.out.println("Конец программы");
        }
    }

    public static int[][] m() // создаем матрицу
    {

        Random rnd = new Random();
        int[][] inArr = new int[5][5];

        for (int i = 0 ; i < inArr.length ; i++)
        {
            for (int j = 0 ; j < inArr[i].length ; j++)
            {
                inArr[i][j] = rnd.nextInt(5);
            }
        }



        System.out.println(Arrays.deepToString(inArr));
       // System.out.println(test);
        return inArr;

    }
}
