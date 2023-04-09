package testing_interface.test2;

public class ThirdSubClass extends SuperClass{
    protected int intFieldEx4;

    ThirdSubClass(String str1, int int1) {
        super(str1);
        intFieldEx4 = int1;
    }

    ThirdSubClass(ThirdSubClass thirdSubObject) {
        super(thirdSubObject);
        this.intFieldEx4 = thirdSubObject.intFieldEx4;
    }

    String showObject(ThirdSubClass obj) {
        String show;
        show = this.getClass().getSimpleName() + "\n" + obj.string + " " +
        " " + obj.intFieldEx4;
        return show;
    }
}
