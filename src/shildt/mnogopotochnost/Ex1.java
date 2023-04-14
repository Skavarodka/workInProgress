package shildt.mnogopotochnost;

//11 Управление главным потоком исполнения
public class Ex1 {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread);//текущий поток исполнения

        //изменить имя потока исполнения
        thread.setName("мой поток");
        System.out.println("после смены имени " + thread);
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("главный поток прерван");
        }
    }
}
