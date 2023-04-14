package shildt.mnogopotochnost;

//А до тех пор рассмотрим несложный пример программы, неправильно реализующей
//простую форму поставщика и потребителя данных. Эта программа состоит
//из четырех классов: Q - синхронизируемой очереди; Producer - поточного
//объекта, создающего элементы очереди; Consumer - поточного объекта, принимающего
//элементы очереди; а также РС - мелкого класса, в котором создаются
//объекты классов Q, Producer и Consumer. Ниже приведен исходный код этой
//программы.

public class WaitNotyfyNotyfyAllTest {
    //Q class
    int n;
    boolean valueSet = false;

    synchronized int get() {
        while (!valueSet)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println("POLUCHENO: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        while (valueSet)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        this.n = n;
        valueSet = true;
        System.out.println("OTPRAVLENO: " + n);
        notify();
    }
}

class Producer implements Runnable {
    WaitNotyfyNotyfyAllTest q;

    Producer(WaitNotyfyNotyfyAllTest q) {
        this.q = q;
        new Thread(this, "POSTAVCHIK").start();
    }

    public void run() {
        int i = 0;

        while (true) {
            q.put(i++);
        }
    }
}

class Consumer implements Runnable {
    WaitNotyfyNotyfyAllTest q;

    Consumer(WaitNotyfyNotyfyAllTest q) {
        this.q = q;
        new Thread(this, "POTREBITEL").start();
    }

    public void run() {
        while (true) {
            q.get();
        }
    }
}

class PC {
    public static void main(String[] args) {
        WaitNotyfyNotyfyAllTest q = new WaitNotyfyNotyfyAllTest();
        new Producer(q);
        new Consumer(q);

        System.out.println("DLA OSTANOWKI NAJMITE CTRL+C");
    }
}