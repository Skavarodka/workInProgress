package shildt.mnogopotochnost;

public class Ex2 implements Runnable{
    Thread thread;

    Ex2() {
        //создать новый, второй поток исполнения
        thread = new Thread(this, "Dem thread");
        System.out.println("Dem thread create : " + thread);
        thread.start();//запустить поток исполнения
    }
    //Точка входа во второй поток исполнения
    public void run() {
        try {
            for (int i = 5; i != 0; i--) {
                System.out.println("Dem thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Dem thread stopping");
        }
        System.out.println("Dem thread End");
    }
}

class ThreadDem{
    public static void main(String[] args) {
        new Ex2();
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("main thread; " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("main thread stopping");
        }
        System.out.println("main thread End");
    }
}