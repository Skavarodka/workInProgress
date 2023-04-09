package Laba9.Example1_15;


//Далее приведены примеры с использованием конструкции try- finally.
//Перехват брошенного исключения catch не производится. Секция finally выполняется всегда.
////Пример 8. Генерация исключения в методе.

public class Ex8
{
    public static int m()
    {
        try
        {
            System.out.println("0");
            throw new RuntimeException();
        }
        finally
        {
            System.out.println("1");
        }
    }

    public static void main(String[] args)
    {
        System.out.println(m());
    }
}
