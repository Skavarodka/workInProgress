package Laba9.Example1_15;

//Исключение IllegalArgumentException – неверные аргументы.

public class Ex12
{
    public static void m(String str, double chislo)
    {
        if (str == null)
        {
            throw new IllegalArgumentException("Строка введена неверно");
        }
        if (chislo > 0.001)
        {
            throw new IllegalArgumentException("Неверное число");
        }
    }

    public static void main(String[] args)
    {
        m("null", 0.001);
    }

}
