package lr13;

//Напишите программу, которая создает два потока, которые выводят на экран числа от 1 до 10.
//Первый поток должен выводить только четные числа, а второй поток должен выводить только нечетные числа.

//Здесь мы создаем два потока, evenThread и oddThread, которые выводят на экран четные и нечетные числа соответственно.
//Мы используем объект-блокировку lock для синхронизации доступа к общей переменной number.
//В цикле while каждый поток проверяет, является ли текущее число четным или нечетным, и выводит его на экран соответствующим потоком.
//Если число не соответствует условию, поток вызывает метод wait() для ожидания, пока другой поток не выведет число на экран.
//Когда число было выведено, поток вызывает метод notifyAll(), чтобы оповестить другой поток о том, что он может продолжить свою работу.

public class Ex3 {
    private static final Object lock = new Object();

    private static int number = 1;

    public static void main(String[] args) {
        Thread evenThread = new Thread(() -> {
            synchronized (lock) {
                while (number < 11) {
                    if (number % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + number);
                        number++;
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notifyAll();
                }
            }
        }, "POTOK ЧЕТНЫЙ: ");

        Thread oddThread = new Thread(() -> {
            synchronized (lock) {
                while (number < 11) {
                    if (number % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + number);
                        number++;
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notifyAll();
                }
            }
        }, "POTOK НЕЧЕТНЫЙ: ");

        evenThread.start();
        oddThread.start();
    }
}
