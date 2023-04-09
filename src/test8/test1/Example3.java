package test8.test1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

//Пример 3. Прочитать и вывести на экран информацию из
// предварительно созданного файла с использованием буфера в 5 байт.
public class Example3 {
    //считывание по пять символов(буфер)
    public static void readAllByArray(InputStream in) throws IOException {
        byte[] buff = new byte[5];
        while (true) {
            int count = in.read(buff);
            if (count != -1) { // если не конец файла
                System.out.println("количество = " + count + ", buff = " + Arrays.toString(buff) + ", str = " +
                        new String(buff, 0, count, "cp1251")); // UTF8 данные буфера преобразовываются в строку
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\konstantin.sokolov\\IdeaProjects\\workInProgress\\TestFile.txt";
        InputStream inFile = null; // переменна обьявлена до секции трай чтобы не ограничивать ее видимость
        try {
            inFile = new FileInputStream(fileName);
            readAllByArray(inFile);
        } catch (IOException e) {
            System.out.println("Ошибка открытия-закрытия файла " + fileName + e);
        } finally { // корректное закрытие потока
            if (inFile != null) {
                try {
                    inFile.close();
                } catch (IOException ignore) {
                    /*NOP*/ // No OPeration ничего не делать
                }
            }
        }
    }
}
