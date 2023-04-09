package testing_interface.test2;

public class SubClass extends SuperClass{
    protected char charEx5;

    SubClass(String str1, char chr1) {
        super(str1);
        this.charEx5 = chr1;
    }

    SubClass(SubClass subObject) {
        super(subObject);
        this.charEx5 = subObject.charEx5;
    }

    String showObject(SubClass obj) {
        String show;
        show = this.getClass().getSimpleName() + "\n" + obj.string + " " + obj.charEx5;
        return show;
    }
}
