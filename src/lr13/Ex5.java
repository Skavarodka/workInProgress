package lr13;

//Напишите функцию, которая находит максимальный элемент в массиве целых чисел при помощи многопоточности.
//Количество потоков должно быть равно количеству ядер процессора.

public class Ex5 {
    static int max1 = 0;
    static int max2 = 0;

    static int maxAll = 0;
    static void setMax1(int i) {
        max1 = i;
    }

    static void setMax2(int i) {
        max2 = i;
    }

    static void myFuncMe(int a, int b) {
        if (a > b) {
            maxAll = a;
        } else {
            maxAll = b;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 12, 13, 12, 111, 2, 3, 4, 5};

        Thread thread1 = new Thread(() -> {
            int max = arr[0];
            int a = arr.length / 2;
            for (int i = 0; i < a; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            setMax1(max);
        });

        Thread thread2 = new Thread(() -> {
            int max = arr[0];
            int a = arr.length / 2;
            for (int i = a; i < arr.length - 1; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            setMax2(max);
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myFuncMe(max1, max2);
        System.out.println(maxAll);
    }
}
