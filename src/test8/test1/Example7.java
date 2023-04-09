package test8.test1;

import java.io.*;

//Пример 7. Чтение из одного файла и запись в другой файл дан- ных построчно с использованием буфера в 1 килобайт.

public class Example7 {
    public static void main(String[] args) throws IOException {
        BufferedReader breader = null;
        BufferedWriter bwritter = null;
        try {
            // создание файловых символьных потоков для записи и чтения
            breader = new BufferedReader(new FileReader("C:\\Users\\konstantin.sokolov\\IdeaProjects\\workInProgress\\Ex6TestFile1.txt"), 1024);
            bwritter = new BufferedWriter(new FileWriter("C:\\Users\\konstantin.sokolov\\IdeaProjects\\workInProgress\\Ex6TestFile2.txt"));
            int lineCount = 0; // счетчик строк
            String s;
            // переписывание информации из одного файла в другой
            while ((s = breader.readLine()) != null) {
                lineCount++;
                System.out.println(lineCount + " : " + s);
                bwritter.write(s);
                bwritter.newLine();
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
