package lab11.ex1;

//8. Разработать проект, в котором для ввода, вывода и изменения односвязного линейного списка создать следующие методы:
//        а) с использованием цикла:
//        •	ввод с головы createHead();
//        •	ввод с хвоста createTail();
//        •	вывод (возвращается строка, сформированная из элементов списка) toString();
//        •	добавление элемента в начало списка AddFirst();
//        •	добавление элемента в конец списка AddLast();
//        •	вставка элемента в список с указанным номером Insert();
//        •	удаление элемента с головы списка RemoveFirst();
//        •	удаление последнего элемента списка RemoveLast();
//        •	удаление из списка элемента с указанным номером
//        	Remove();
//        б) с использованием рекурсии:
//        •	ввод с головы createHeadRec();
//        •	ввод с хвоста createTailRec();
//        •	вывод (возвращается строка, сформированная из элементов списка) toStringRec().




public class Ex8Node {
    static  Node head = null;
    public static String toStrings() {
        String str = "";
        Node ref = head;
        while(ref != null){
            str = str + " " + ref.value;
            ref = ref.next;
        }
        return str;
    }

    public static void toStringRec(Node ref) {
        String str = "";
        if (ref == null) {
            System.out.println();
        } else {
            str += ref.value;
            ref = ref.next;
            toStringRec(ref);
        }
        System.out.print(str);
    }

    public static void createHead() {
        for (int i = 9; i >= 0; i--) {
            head = new Node(i, head);
        }
    }

    public static void createHeadRec(int count) {
        if (count != 0) {
            head = new Node(count, head);
            count--;
            createHeadRec(count);
        }
    }

    public static void createTail() {
        for (int i = 0; i < 10; i++) {
            head = new Node(i, head);
        }
    }

    public static Node createTailRec(Node ref, int count) {
        if (count != 0) {
            ref.next = createTailRec(new Node(count - 1, null), count -1 );
        }
        return ref;
    }

    public static void addFirst(int val) {
        head = new Node(val, head);
    }

    public static void addLast(int val) {
        Node ref = head;
        while (ref.next != null) {
           ref = ref.next;
        }
        ref.next = new Node(val, null);
    }

    public static void insert(int val, int value) {
        Node ref = head;
        int count = 1;
        Node nodNext = new Node(value, null);
        while (ref.next != null && count < val) {
            ref = ref.next;
            count++;
        }
        nodNext.next = ref.next;
        ref.next = nodNext;
    }

    public static void removeFirst() {
        head = head.next;
    }

    public static void removeLast() {
        Node ref = head;
        while (ref.next.next != null) {
            ref = ref.next;
        }
        ref.next = null;
    }

    public static void remove(int x) {
        Node ref = head;
        int count = 1;
        while (ref.next != null && count < x) {
            ref = ref.next;
            count++;
        }
        ref.next = ref.next.next;
    }
    public static void main(String[] args) {
        //createHeadRec(5);
        createHead();
        //createTail();
        addFirst(404);
        addLast(101);
        insert(5, 202);
        removeFirst();
        removeLast();
        remove(4);
        Node ref = head;
        System.out.println(toStrings());
        toStringRec(ref);
        System.out.println();
        toStringRec(createTailRec(new Node(5, null),5));
    }
}
