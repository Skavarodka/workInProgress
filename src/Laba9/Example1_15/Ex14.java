package Laba9.Example1_15;

//Обработка исключения, порожденного одним методом m() в другом (в методе main).

public class Ex14
{
    public static void m(int x) throws ArithmeticException
    {
        int h = 10 / x;
    }

    public static void main(String[] args)
    {
        try
        {


            int l = args.length;
            System.out.println("размер массива равен " + l);
            m(l);
        }
        catch (ArithmeticException e)
        {
            System.out.println("ошибка деления на ноль");
        }
    }
}
