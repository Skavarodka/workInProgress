package lab11.ex1;

//Заполнить HashMap 10 объектами <Integer, String>. Найти строки у которых ключ> 5. Если ключ = 0, вывести строки через запятую.
//Перемножить все ключи, где длина строки>5.

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MapHashEx6 {
    static HashMap<Integer, String> hashMap = new HashMap<>();
    static Random thrnd = new Random();
    static String str = "";

    public static void main(String[] args) {
        recMapHash(0, "вывести строки через запятую", 10);
        System.out.println(hashMap);
        findKey();
        hashMap.remove(0);
        findValues();
    }

    public static void findKey() {
        for (Integer ke : hashMap.keySet()) {
            if (ke > 5) {
                System.out.print(ke + " ");
            } else if (ke == 0) {
                String temp = hashMap.get(ke);
                List<String> tempStr = List.of(temp.split(" "));
                System.out.println(tempStr);
            }
        }
    }

    public static void findValues() {
        long i = 1;
        for (Integer kek : hashMap.keySet()) {
            if (hashMap.get(kek).length() > 5) {
                i *= kek;
            }
        }
        System.out.println();
        System.out.println("перемножили ключи: " + i);
    }

    public static void recMapHash(Integer key, String value, Integer num) {
        if (num != 0) {
            hashMap.put(key,value);
            recMapHash(thrnd.nextInt(1000), str + thrnd.nextInt(150000), num - 1);
        }
    }
}
