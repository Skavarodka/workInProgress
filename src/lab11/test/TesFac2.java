package lab11.test;

public class TesFac2 {
    public static void main(String[] args) {
        System.out.println(fact(6));
    }

    public static int fact(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fact(n - 2) + fact(n - 1);
        }
    }
}
