package lr13;

//Напишите программу, которая создает 10 потоков и каждый поток выводит на экран свой номер.

public class Ex4 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
        }
    }
}
