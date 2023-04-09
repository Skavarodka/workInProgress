package test8.test1;
// НЕРАБОТАЕТ, спросить про отработку ошибок

//Пример 4. Создать первый файл на диске и записать в него заданное количество вещественных чисел. Далее создать второй файл и переписать в него все числа из первого файла.
//        Программу составить в соответствии со следующим алгоритмом:
//        1. Создать новую папку My на диске.
//        2. В папке создать 1-й файл numIsh.txt.
//        3. В файл записать через поток числа, вводимые с клавиатуры.
//        4. В той же папке создать 2-й файл numRez.txt.
//        5. Последовательно считывая числа из 1-го файла numIsh.txt, переписать их во второй файл numRez.txt.
//        6. Закончить.
//        Более подробно распишем пункт 5 (чтение-запись):
//        5.1) открыть 1-й поток для чтения из 1-го файла numIsh.txt; 5.2) открыть 2-й поток для записи во 2-й файл numRez.txt; 5.3) пока не конец 1-го файла:
//        а) считать число из 1-го потока (файла numIsh.txt);
//        б) записать число во 2-й поток (файл numRez.txt);
//        в) вывести число на экран;
//        5.4) дописать остаток данных на диск; 5.5) закрыть 1-й поток;
//        5.6) закрыть 2-й поток.

import java.io.*;
import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {
        try {
            File testFileDir = new File("C:\\Users\\konstantin.sokolov\\IdeaProjects\\workInProgress\\My");
            testFileDir.mkdir();
            // Создание исходного файла numIsh.txt и запись в него чисел типа float
            File file1 = new File("C:\\Users\\konstantin.sokolov\\IdeaProjects\\workInProgress\\My\\numIsh.txt");
            file1.createNewFile();
            Scanner in = new Scanner(System.in, "cp1251");
            DataOutputStream writer1 = new DataOutputStream(new FileOutputStream(file1.getAbsolutePath()));
            System.out.println("Сколько вешественных чисел записать в файл?");
            int count = in.nextInt();
            System.out.println("Введите числа:");
            for (int i = 0; i < count; i++) {
                writer1.writeFloat(in.nextFloat());
                //writer1.flush();
               // writer1.close();
                // Создание файла numRez.txt и переписывание в него чисел из numIsh.txt
                File file2 = new File("C:\\Users\\konstantin.sokolov\\IdeaProjects\\workInProgress\\My\\numRez.txt");
                file2.createNewFile();
                // поток для чтения из исходного файла numIsh.txt
                DataInputStream reader1 = new DataInputStream(new FileInputStream(file1.getAbsolutePath()));
                // поток для записи в результирующий файл numRez.txt
                writer1 = new DataOutputStream(new FileOutputStream(file2.getAbsolutePath()));
                try {
                    //while (true) {
                        float number = reader1.readFloat();
                        writer1.writeFloat(number); // чтение и запись из одного файла в другой
                        System.out.println("Число " + number);
                    //}
                } catch (EOFException e) {
                    System.out.println("ERROR" + e);
                }
//                writer1.flush();
//                writer1.close();
                reader1.close();
            }
            writer1.flush();
            writer1.close();
        } catch (IOException e) {
            System.out.println("End of file" + e);
        }
    }
}
