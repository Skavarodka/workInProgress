package test8.test1;
//Пример 2. Прочитать и вывести на экран информацию из трех источников: файла на диске, интернет-страницы и массива типа byte.
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Example2 {
    //метод для чтения данных из потока побайтам с выводом
    public static void readAllByByte(InputStream in) throws IOException {
        while (true) {
            int oneByte = in.read(); // читает один байт
            if (oneByte != -1) { //признак отсутсвия конца файла
                System.out.println((char)oneByte);
            } else {
                System.out.println("\n" + "end");
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            // с потоком связан файл
            InputStream inFile = // фбстрактный класс остальные классы его потомки с похожим именем
                    new FileInputStream("C:\\Users\\konstantin.sokolov\\IdeaProjects\\workInProgress\\TestFile.txt");
            readAllByByte(inFile);
            System.out.println("\n\n\n");
            inFile.close();

            // c потоком связана интернет страница
            InputStream inUrl = new URL("http://google.com").openStream();
            readAllByByte(inUrl);
            System.out.println("\n\n\n");
            inUrl.close();

            // с потоком связан массив байт
            InputStream inArray = new ByteArrayInputStream(new byte[] {7, 9, 3, 7, 4});
            readAllByByte(inArray);
            System.out.println("\n\n\n");
            inArray.close();
        } catch (IOException e) {
            System.out.println("Warning " + e);
        }
    }
}
