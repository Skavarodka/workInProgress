package lab10.Ex4;

//Эта программа является примером чтения данных из файла Excel в формате XLSX с использованием библиотеки Apache POI.
//В начале программы мы импортируем необходимые классы из библиотеки Apache POI, которые позволяют работать с Excel-файлами.
//Затем мы определяем основной метод программы main, который выбрасывает исключение IOException, связанное с чтением файла.
//Далее мы открываем файл Excel для чтения, используя объект FileInputStream. Затем мы создаем экземпляр книги Excel из файла,
//используя класс XSSFWorkbook.
//Далее мы получаем лист из книги по его имени, используя метод getSheet: После этого мы перебираем все строки и ячейки на листе,
//используя цикл for. Внутри цикла мы выводим на экран значение каждой ячейки с помощью метода toString(),
//который преобразует значение ячейки в строку. В конце программы мы закрываем файл и освобождаем ресурсы,
//используя методы close(): Таким образом, эта программа читает содержимое Excel-файла в формате XLSX и выводит его на экран.

import org.apache.poi.EmptyFileException;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Ex2Excel {
    public static void main(String[] args) throws IOException {
        try {
            //открываем файл для чтения
            String filePath = "src/lab10/Ex4/Ex5.xlsx";
            FileInputStream inputStream = new FileInputStream(filePath);

            //создаем экземпляр книги эксель из файла
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

            //получаем лист из книги по его имени
            XSSFSheet sheet = workbook.getSheet("Товары");

            //перебираем строки и ячейки листа
            for (Row row : sheet) {
                for (Cell cell : row) {
                    //выводим значение ячейки на экран
                    System.out.println(cell.toString() + "\t");
                }
                System.out.println();
            }
            workbook.close();
            inputStream.close();
        } catch (NotOfficeXmlFileException e){
            System.out.println("Указан не Excel-файл. Укажите файл example.xlsx и запустите программу снова.");
        }catch (EmptyFileException e){
            System.out.println("Указан пустой файл.");
        }catch (NullPointerException e){
            System.out.println("Не найдена указанная книга \"Товары\"");
        }
    }
}
