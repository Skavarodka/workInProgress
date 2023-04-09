package lab10.Ex3;

//В этой программе мы используем библиотеку jsoup для подключения к сайту и получения его HTML-кода.
//        Затем мы ищем все ссылки на странице, используя метод "select()", который принимает CSS-селектор,
//        и выводим абсолютный URL каждой ссылки в консоль с помощью метода "attr()".

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ExHTML {
    public static void main(String[] args) {
        String url = "https://itlearn.ru/first-steps";
        try {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                System.out.println(link.attr("abs:href"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
