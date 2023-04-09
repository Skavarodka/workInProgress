package test8.test1;

//Пример 9. Чтение из одного файла и запись в другой файл
//данных построчно с использованием буферизации символьных потоков основанных на байтовых файловых потоках.

import java.io.*;

public class Example9 {
    public static void main(String[] args) throws IOException {
        BufferedReader breader = null;
        BufferedWriter bwritter = null;
        try {
            // Создание потоков для чтения и записи с нужной кодировкой
            breader = new BufferedReader(new InputStreamReader(new FileInputStream
                    ("C:\\Users\\konstantin.sokolov\\IdeaProjects\\workInProgress\\Ex6TestFile1.txt"), "cp1251"));
            bwritter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream
                    ("C:\\Users\\konstantin.sokolov\\IdeaProjects\\workInProgress\\Ex6TestFile2.txt"), "cp1251"));
            // Переписывание информации из одного файла в другой
            int lineCount = 0;
            String s;
            while ((s = breader.readLine()) != null) {
                lineCount++;
                System.out.println(lineCount + ":" + s);
                bwritter.write(lineCount + ":" + s); // запись бе перевода строки
                bwritter.newLine(); // принудительный переход на новую строку
            }
        } catch (IOException e) {
            System.out.println("ERROR" + e);
        } finally {
            breader.close();
            bwritter.flush();
            bwritter.close();
        }
    }
}
