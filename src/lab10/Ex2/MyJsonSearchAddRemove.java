package lab10.Ex2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Iterator;
import java.util.Scanner;

public class MyJsonSearchAddRemove {
    JSONObject jsonObject;
    Scanner in = new Scanner(System.in);

    MyJsonSearchAddRemove(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public void searchInMyJson() {
        JSONArray jsonArray = (JSONArray) jsonObject.get("books");
        System.out.println("Enter the author name");
        String authorName = in.nextLine();
        for (Object o : jsonArray) {
            JSONObject var = (JSONObject) o;
            if (authorName.equals(var.get("author"))) {
                System.out.println("\n Текущий элемент: book ");
                System.out.println("Название книги: " + var.get("title"));
                System.out.println("Автор: " + var.get("author"));
                System.out.println("Год издания: " + var.get("year"));
            }
        }
    }

    void addInMyJson() {
        JSONArray jsonArray = (JSONArray) jsonObject.get("books");
        System.out.println("Enter the title name");
        String titleName = in.nextLine();
        System.out.println("Enter the author name");
        String authorName = in.nextLine();
        System.out.println("Enter the year");
        Integer year = in.nextInt();
        JSONObject newBook = new JSONObject();
        newBook.put("title", titleName);
        newBook.put("author", authorName);
        newBook.put("year", year);
        jsonArray.add(newBook);
    }

    void removeMyJson(String string) {
        JSONArray jsonArray = (JSONArray) jsonObject.get("books");
        Iterator iterator = jsonArray.iterator();
        while (iterator.hasNext()) {
            JSONObject book = (JSONObject) iterator.next();
            if (string.equals(book.get("title"))) {
                iterator.remove();
            }
        }
    }
}

//1. Для поиска книг по автору воспользуетесь JSONArray.stream() для создания потока элементов массива и метод filter()
//  для фильтрации элементов по заданному автору.
//    Пример:

//    JSONArray jsonArray = (JSONArray) jsonObject.get("books");
//    String author = "Иванов";
//jsonArray.stream()
//        .filter(book -> book instanceof JSONObject)
//        .map(book -> (JSONObject) book)  вот тут нет каста
//        .filter(book -> author.equals(book.get("author")))  здесь не те методы
//        .forEach(book -> {
//        System.out.println("\nТекущий элемент: book");
//        System.out.println("Название книги: " + book.get("title"));
//        System.out.println("Автор: " + book.get("author"));
//        System.out.println("Год издания: " + book.get("year"));
//        });

