package Laba9.Example1_15;

//Пример 4. Перехват исключения подходящим классом.

public class Ex4
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println("0");
            throw new RuntimeException("Непроверяемая ошибка");
        }
        catch (NullPointerException e)
        {
            System.out.println("1");
        }
        catch (Exception e)
        {
            System.out.println("2");
        }
        catch (Error e)
        {
            System.out.println("3");
        }
        System.out.println("4");
    }
}