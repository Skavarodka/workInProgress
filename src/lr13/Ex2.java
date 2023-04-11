package lr13;

//Напишите программу, которая запускает поток и выводит на экран числа от 1 до 10 с задержкой в 1 секунду между выводами.
//В этой программе создается поток t, который выводит на экран числа от 1 до 10 с задержкой в 1 секунду между выводами.
//Метод sleep() используется для приостановки выполнения потока на 1 секунду.

public class Ex2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 1; i < 11; i++) {
                System.out.println(i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        thread.join();
    }
}
