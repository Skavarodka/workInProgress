package testing_interface.test2;

public class Main {
    public static void main(String[] args) {
        SuperClass superClass = new SuperClass("стринговый супер класс");
        SuperClass superClass2 = new SuperClass(superClass);

        SubClass subClass = new SubClass("конструктор первого чарного подкласса", '2');
        SubClass subClass2 = new SubClass(subClass);

        ThirdSubClass thirdSubClass = new ThirdSubClass( "конструктор второго интового подкласса", 4);
        ThirdSubClass thirdSubClass2 = new ThirdSubClass(thirdSubClass);

        System.out.println(superClass2.showObject(thirdSubClass));

        System.out.println();
        System.out.println();

        System.out.println(superClass.showObject(superClass) + "\n" + superClass2.showObject(superClass2) +
                "\n" + subClass.showObject(subClass) + "\n" +  subClass2.showObject(subClass2) +
                "\n" + thirdSubClass.showObject(thirdSubClass) + "\n" + thirdSubClass2.showObject(thirdSubClass2));
    }
}
