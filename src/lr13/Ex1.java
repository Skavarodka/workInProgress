package lr13;

//1. Напишите программу, которая запускает два потока и выводит на экран их имена и текущее время в течение 10 секунд.

//В этой программе создаются два потока t1 и t2, каждый из которых выводит на экран свое имя и текущее время в течение 10 секунд.
//Метод sleep() используется для приостановки выполнения потока на 1 секунду, чтобы можно было увидеть изменение времени.
//Метод join() используется для ожидания завершения выполнения потоков.

import java.time.LocalTime;

public class Ex1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0 ; i < 10 ; i++) {
                System.out.println(Thread.currentThread().getName() + LocalTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "PERVI POTOK : ");

        Thread t2 = new Thread(() -> {
            for (int i = 0 ; i < 10 ; i++) {
                System.out.println(Thread.currentThread().getName() + LocalTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "VTOROI POTOK : ");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
