package lab11.ex1;


interface MyInterface {

    // абстрактный метод
    String reverse(String n);
}

public class Main {

    public static void main( String[] args ) {

        // объявление ссылки на MyInterface
        // присвоение лямбда-выражения ссылке
        MyInterface ref = (str) -> {

            String result = "";
            for (int i = str.length()-1; i >= 0 ; i--)
                result += str.charAt(i);
            return result;
        };
        // вызов метода из интерфейса
        System.out.println("Lambda reversed = " + ref.reverse("Lambda"));
    }

}