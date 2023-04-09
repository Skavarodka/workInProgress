package Laba9.Example1_15;

//Пример 2. Исключение перехвачено перехватчиком предка.

public class Ex2
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println("0");
            throw new RuntimeException("Непроверяемая ошибка");
        }
        catch (Exception e)
        {
            System.out.println("1");
            System.out.println("2" + e);
        }
        System.out.println("3");
    }
}