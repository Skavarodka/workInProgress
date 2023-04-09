package test8.test1;

//Пример 5. Создать файл на диске, ввести заданное с клавиату- ры количество строк текста и записать их в файл в формате UTF-8.

import java.io.*;
import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя файла: ");
        String fileNameIn = in.nextLine();

        try {
            // Создается файл
            File f1 = new File(fileNameIn);
            f1.createNewFile();
            System.out.println("Полный путь файла: " + f1.getAbsolutePath());
            System.out.print("Введите количество строк для записи в файл: ");
            int string = in.nextInt();
            // Создается поток для записи с учетом типа данных – DataOutputStream,
            // и ему в качестве параметра передается поток FileOutputStream
            DataOutputStream writer1 = new DataOutputStream(new FileOutputStream(f1));
            in.nextLine(); // очистка буфера
            for (int i = 0 ; i < string ; i++) {
                System.out.println("Введите строку для записи в файл: ");
                String str = in.nextLine();
                writer1.writeUTF(str); //или writer1.writeUTF(s +"\n" ); – запись отдельных строк
            }
            writer1.flush();
            writer1.close();

            // Чтение и вывод данных из созданного файла
            DataInputStream reader1 = new DataInputStream(new FileInputStream(f1));

            while (true) {
                System.out.println(reader1.readUTF());
            }
        } catch (Exception e) {
            System.out.println("eroror" + e);
        }
    }
}
