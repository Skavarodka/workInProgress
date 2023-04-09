package shildt.lambda;

//        11 Метод, возвращающий количество экземпляров объекта,
//        /!найденных по критериям, задаваемым параметром
//        11 функционального интерфейса MyFunc

public class InstanceObjectRefDem {
    static <T> int counter(T[] vals, MyFunc<T> f, T v) {
        int count = 0;

        for (int i = 0 ; i < vals.length ; i++) {
            if (f.func(vals[i], v)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int count;

        //создать массив объектов типа HighTemp
        HighTemp[] weekDayHighs = {
                new HighTemp(89), new HighTemp(82),
                new HighTemp(90), new HighTemp(89),
                new HighTemp(89), new HighTemp(91),
                new HighTemp(84), new HighTemp(83)
        };

//11 Использовать метод counter() вместе с массивами
//11 объектов типа HighTemp. Обратите внимание на то,
//1 что ссылка на метод экземпляра sameTemp()
//11 передается в качестве второго параметра
        count = counter(weekDayHighs, HighTemp::sameTemp, new HighTemp(89));
        System.out.println("Dney s max temp 89: " + count);

        //А теперь создать и использовать вместе с данным
        //методом еще один массив объектов типа HighTemp
        HighTemp[] weekDayHighs2 = {
                new HighTemp(32),new HighTemp(12),
                new HighTemp(24),new HighTemp(19),
                new HighTemp(18),new HighTemp(12),
                new HighTemp(-1),new HighTemp(13)
        };
        count = counter(weekDayHighs2, HighTemp::sameTemp, new HighTemp(12));
        System.out.println("Dney s max temp 12: " + count);

//      А теперь воспользоваться методом lessThanTemp(),
//      чтобы выяснить, сколько дней температура была
//      меньше заданной
        count = counter(weekDayHighs, HighTemp::lessThanTemp, new HighTemp(89));
        System.out.println("Dney kogda temp bil menche 89: " + count);
        count = counter(weekDayHighs2, HighTemp::lessThanTemp, new HighTemp(19));
        System.out.println("Dney kogda temp bil menche 19: " + count);
    }

}
