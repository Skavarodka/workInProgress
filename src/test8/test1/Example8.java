package test8.test1;

//Пример 8. Прочитать и вывести на экран информацию из трех источников:
//        файла на диске, интернет-страницы и массива данных типа byte.
//        Указать кодировку, поддерживающую кириллицу. (Сравнить с работой программы, приведенной в примере 2.)

import java.io.*;
import java.net.URL;

public class Example8 {
    public static void readAllByByte(Reader in) throws IOException {
        while (true) {
            int oneByte = in.read(); // читает один байт
            if (oneByte != -1) { //признак конца файла
                System.out.println((char) oneByte);
            } else {
                System.out.println("\n" + "Конец");
                break;
            }
        }
    }

    public static void main(String[] args) {
        try {
            // с потоком связан файл
            InputStream inFile = new FileInputStream("C:\\Users\\konstantin.sokolov\\IdeaProjects\\workInProgress\\Ex6TestFile1.txt"); // байтовый поток
            Reader rdFile = new InputStreamReader(inFile, "cp1251"); // символьный поток
            readAllByByte(rdFile);
            System.out.println("\n\n\n");
            inFile.close();
            rdFile.close();

            // c потоком связана интернет страница
            InputStream inUrl = new URL("http://google.com").openStream(); // байтовый поток
            Reader rUrl = new InputStreamReader(inUrl, "cp1251"); // символьный поток
            readAllByByte(rUrl);
            System.out.print("\n\n\n");
            inUrl.close();
            rUrl.close();

            // С потоком связан массив типа byte
            InputStream inArray = new ByteArrayInputStream(new byte[] {1, 2, 3, 4, 5, 5});
            Reader rArray = new InputStreamReader(inArray, "cp1251");
            readAllByByte(rArray);
            System.out.print("\n\n\n");
            inArray.close();
            rArray.close();
        } catch (IOException e) {
            System.out.println("ERROR!" + e);
        }
    }
}
