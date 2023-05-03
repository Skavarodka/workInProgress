package lab10.Ex3;

//Данная программа предназначена для парсинга (извлечения данных) с HTML-страницы, в данном случае - новостей с сайта fat.urfu.ru.
//        Сначала программа использует метод connect() из библиотеки Jsoup для получения HTML-кода страницы.
//        Затем, с помощью метода select(), программа извлекает список новостей из HTML-кода.
//        Для каждой новости в списке программа выводит в консоль ее тему и дату.
//        Для этого она применяет методы getElementsByClass() и childNodes() из библиотеки Jsoup.


import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Ex2HTML {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("src/lab10/Ex3/jsonEx3.txt");

            //Получение HTML кода страницы
            Document doc = Jsoup.connect("http://fat.urfu.ru/index.html").get();

            //Извлекаем список новостей
            Elements newsParent = doc.select("body > table > tbody > tr > td > div > table > " +
                    "tbody > tr:nth-child(5) > td:nth-child(3) > table > tbody > " +
                    "tr > td:nth-child(1)");
            fileWriter.write(newsParent.toString());
            fileWriter.flush();
            fileWriter.close();
            //Выводит последние 10 новостей в консоль
            for (int i = 3 ; i < 20 ; i++) {
                if (!(i % 2 == 0)) {
                    List<Node> nodes = newsParent.get(0).childNodes();
                    System.out.println("Тема : " + ((Element) nodes.get(i)).getElementsByClass("blocktitle").get(0).childNodes().get(0) + "\n");
                    System.out.println("Дата : " + ((Element) nodes.get(i)).getElementsByClass("blockdate").get(0).childNodes().get(0) + "\n");
                }
            }
        } catch (HttpStatusException e) {
            System.out.println("Ошибка попробуйте переподключиться к сайту");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
