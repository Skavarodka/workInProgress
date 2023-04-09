package testing_interface.test2;

public class SuperClass {
    protected String string;
    SuperClass(String chr1) {
        this.string = chr1;
    }

    SuperClass(SuperClass supObject) {
        this.string = supObject.string;
    }

    String showObject(SuperClass obj) {
        String show;
        show = this.getClass().getSimpleName() + "\n" + obj.string;
        return show;
    }
}
