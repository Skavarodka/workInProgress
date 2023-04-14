package lr13;

//Напишите функцию, которая суммирует элементы в массиве целых чисел при помощи многопоточности.
//Количество потоков должно быть равно количеству ядер процессора.

public class Ex6 {
    static int[] arr = new int[]{10, 12, 13, 12, 11, 2, 3, 4, 5};
    static int sum = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            int a = arr.length / 2;
            for (int i = 0; i < a; i++) {
                sum += arr[i];
            }
        });

        Thread thread2 = new Thread(() -> {
            int a = arr.length / 2;
            for (int i = a; i < arr.length; i++) {
                sum += arr[i];
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sum);
    }
}
