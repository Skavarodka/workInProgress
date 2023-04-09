package test8.test1;

import java.io.File;

//Пример 1. Создание файлов и папок.
public class Example1 {
    public static void main(String[] args) {
        try {
            // Создание файла в текущей папке (где расположен файл Example1.java)
            File testFile = new File("TestFile.txt");
            testFile.createNewFile();
            if (testFile.exists()) {
                System.out.println("Создан!!");
                System.out.println("Полный путь: " + testFile.getAbsolutePath());
            }
            // Создание файла на диске  и вывод полного пути
            File testFile2 = new File("C:\\javaex\\TestFile2.txt");
            testFile2.createNewFile();
            System.out.println("Полный путь: " + testFile2.getAbsolutePath());
            // Создание нескольких вложенных папок
            File testFile3 = new File("C:\\javaex\\papkaJava\\PapkaNew\\Papka3");
            testFile3.mkdirs();
            System.out.println("Полный путь: " + testFile3.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Ошибка " + e);
        }
    }
}
