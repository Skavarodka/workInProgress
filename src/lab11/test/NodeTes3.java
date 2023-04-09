package lab11.test;

public class NodeTes3 {
    public static void main(String[] args) {
        Node head = null;
        Node newtail = new Node(404, null);
        for (int i = 9 ; i >= 0 ; i--) {
            head = new Node(i,head);
        }


        Node ref = head;
        while (ref.next.next != null) {
            System.out.println(" " + ref.value);
            ref = ref.next;
        }
        ref.next = null;


        while (ref != null) {
            System.out.println("S " + ref.value);
            ref = ref.next;
        }
    }
}
