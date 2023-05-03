package lab10.Ex2;

//Здесь мы используем библиотеку JSON.simple для работы с файлом JSON.
//        Мы создаем экземпляр класса JSONParser, который используется для чтения файла JSON.
//        Затем мы преобразуем объект в JSONObject и получаем ключ корневого элемента.
//        Мы получаем массив книг, проходим по каждой книге и получаем значения полей.

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class JsonRead {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            JSONParser parser = new JSONParser();
            Object object = parser.parse(new FileReader("src/lab10/Ex2/jsonEx2.json"));
            JSONObject jsonObject = (JSONObject) object;
            System.out.println(" Корневой элемент: " + jsonObject.keySet().iterator().next());
            JSONArray jsonArray = (JSONArray) jsonObject.get("books");
            MyJsonSearchAddRemove myJsonSearchAddRemove = new MyJsonSearchAddRemove(jsonObject);

            for (Object o : jsonArray) {
                JSONObject book = (JSONObject) o;
                System.out.println("\n Текущий элемент: book ");
                System.out.println("Название книги: " + book.get("title"));
                System.out.println("Автор: " + book.get("author"));
                System.out.println("Год издания: " + book.get("year"));
            }

            myJsonSearchAddRemove.searchInMyJson();
            myJsonSearchAddRemove.addInMyJson();
            System.out.println("Enter the remove title name");
            myJsonSearchAddRemove.removeMyJson(in.nextLine());
            FileWriter file = new FileWriter("src/lab10/Ex2/jsonEx3.json");
            file.write(jsonObject.toJSONString());
            System.out.println("JSON файл успешно записан");
            file.flush();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
