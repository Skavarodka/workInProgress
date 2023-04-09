package test8.test1;

//Пример 6. Чтение из одного файла и запись в другой файл дан- ных посимвольно.

import java.io.*;

public class Example6 {
    public static void main(String[] args) throws IOException {
        Reader in = null; // можно сразу записать FileReader in=null;
        Writer out = null; // можно сразу записать FileWriter out =null;
        try {
            // File createF1 = new File("C:\\Users\\konstantin.sokolov\\IdeaProjects\\workInProgress\\Ex6TestFile1.txt");
            //createF1.createNewFile();
            //System.out.println(createF1.getAbsolutePath());
            in = new FileReader("C:\\Users\\konstantin.sokolov\\IdeaProjects\\workInProgress\\Ex6TestFile1.txt"); // файл для чтения
            // File createF2 = new File("C:\\Users\\konstantin.sokolov\\IdeaProjects\\workInProgress\\Ex6TestFile2.txt");
            //createF2.createNewFile();
            //System.out.println(createF2.getAbsolutePath());
            out = new FileWriter("C:\\Users\\konstantin.sokolov\\IdeaProjects\\workInProgress\\Ex6TestFile2.txt", true);
            // Данные считываются и записываются побайтно, как и для
            // InputStream/OutputStream
            int oneByte; // переменная, в которую считываются данные
            while ((oneByte = in.read()) != -1) {
                // out.write((char)oneByte); // запись с уничтожением ранее
                                            // существующих данных
                out.append((char)oneByte); // запись с добавлением данных в конец
                System.out.println((char)oneByte);
            }
        } catch (IOException e) {
            System.out.println("ERROR!!! " + e);
        } finally {
            in.close();
            out.close();
        }
    }
}
