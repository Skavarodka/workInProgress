package test8.test1;

// Пример 10. Выполнить чтение из одного файла и запись в дру- гой файл с использованием класса PrintWriter.

import java.io.*;

public class Example10 {
    public static void main(String[] args) throws IOException {
        BufferedReader bReader = null;
        PrintWriter pWriter = null;
        try {
            // создание потоков
            bReader = new BufferedReader(new InputStreamReader(new FileInputStream(
                    "C:\\Users\\konstantin.sokolov\\IdeaProjects\\workInProgress\\Ex6TestFile1.txt"), "cp1251"));
            pWriter = new PrintWriter("C:\\Users\\konstantin.sokolov\\IdeaProjects\\workInProgress\\Ex6TestFile2.txt", "cp1251");
            //pWriter = new PrintWriter(System.out);
            // Переписывание информации из одного файла в другой
            int lineCount = 0;
            String s;
            while ((s = bReader.readLine()) != null) {
                lineCount++;
                System.out.println(lineCount + ": " + s);
            }
        } catch (IOException e) {
            System.out.println("error" + e);
        } finally {
            bReader.close();
            pWriter.flush();
            pWriter.close();
        }
    }
}
