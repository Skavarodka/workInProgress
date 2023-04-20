package lab11.ex1;

//7. В кругу стоят N человек, пронумерованных от 1 до N. При ведении счета по кругу вычеркивается каждый второй человек,
//пока не останется один. Составить две программы, моделирующие процесс. Одна из программ должна использовать класс ArrayList,
//а вторая — LinkedList. Какая из двух программ работает быстрее? Почему?

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ArrEx7 {
    static Random thrnd = new Random();
    static int seed = thrnd.nextInt(1, 1000000);

    public static long countingArr(List arLis) {


        int count = 0;
        long start = System.currentTimeMillis();

        for (int c = 0; c < seed; c++) {
            arLis.add(c);
        }

        while (arLis.size() > 1) {
            for (int i = 0; i < arLis.size(); i++) {
                count++;
                if (count == 2) {
                    arLis.remove(i);
                    i--;
                    count = 0;
                }
            }
        }
        System.out.println(arLis.size() + " " + arLis.get(0));
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static void countingLink() {}

    public static void main(String[] args) {
       List<Integer> arLis = new ArrayList<>();
       List<Integer> linkLis = new LinkedList<>();
       long a = countingArr(arLis);
       long b = countingArr(linkLis);
        System.out.println(a + " " + b);
       if (a < b) {
           System.out.println("ArrayList быстрее. Т.к. доступ к элементам осуществляется при помощи индексов, а в LinkedList переходом по цепочке");
       } else {
           System.out.println("LinkedList быстрее в случаях когда удаление или вставка происходят в начале или конце списка");
       }
    }

    static long getRunTime(List<Integer> list) {
        long start = System.currentTimeMillis();

        //cod her

        long end = System.currentTimeMillis();
        return end - start;
    }
}
