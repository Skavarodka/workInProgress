package Laba9.Example1_15;

//Пример 3. Перехват исключения подходящим классом.

public class Ex3
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
        catch (RuntimeException e)
        {
            System.out.println("2");
        }
        catch (Exception e)
        {
            System.out.println("3");
        }
        System.out.println("4");
    }
}