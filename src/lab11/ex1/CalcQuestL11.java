package lab11.ex1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.List;

public class CalcQuestL11 {

    public static void main(String[] args) {
        List<Integer> arrLis = new ArrayList<>();
        System.out.println(getRunningTime(arrLis));
        System.out.println(addFirstArr(arrLis));
        System.out.println(addLastL(arrLis));
        System.out.println(addMid(arrLis));
    }

    //вычисления времени добавления n количества элементов в коллекции
    public static long getRunningTime(Collection<Integer> collection) {
        //точка старта отсчета времени
        long start = System.currentTimeMillis();

        //блок кода в котором выполняется операция добавления
        for (int i = 0; i < 11000000; i++) {
            collection.add(i);
        }

        long end = System.currentTimeMillis();

        return end - start;
    }

   // 1.	Сравнение времени выполнения операции добавление элемента в начало коллекции;
    public static long addFirstArr(List<Integer> collection) {
        long start = System.currentTimeMillis();
        collection.add(0, 1);
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long addFirst(Deque<Integer> deque) {
        long start = System.currentTimeMillis();
        deque.addFirst(1);
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long addLastL(List<Integer> list) {
        long start = System.currentTimeMillis();
        list.add(list.size(), 1);
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long addLast(Deque<Integer> deque) {
        long start = System.currentTimeMillis();
        deque.addLast(1);
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long addMid(List<Integer> list) {
        long start = System.currentTimeMillis();
        list.add(list.size() / 2, 1);

        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long remFirst(List<Integer> list) {
        long start = System.currentTimeMillis();
        list.remove(0);
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long remFirst(Deque<Integer> deque) {
        long start = System.currentTimeMillis();
        deque.removeFirst();
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long remLast(List<Integer> list) {
        long start = System.currentTimeMillis();
        list.remove(list.size() - 1);
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long remLast(Deque<Integer> list) {
        long start = System.currentTimeMillis();
        list.removeLast();
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long remMid(List<Integer> list) {
        long start = System.currentTimeMillis();
        list.remove(list.size() / 2);
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long remMid(Deque<Integer> list) {
        long start = System.currentTimeMillis();

        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long getElement(List<Integer> list) {
        long start = System.currentTimeMillis();
        System.out.println(list.get(list.size() / 2));
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long getElement(Deque<Integer> list) {
        long start = System.currentTimeMillis();

        long end = System.currentTimeMillis();
        return end - start;
    }
}
