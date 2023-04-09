package lab11.test;

public class NodeTes2 {
    public static void main(String[] args) {
        Node head = null;
        Node newtail = new Node(404, null);
        for (int i = 9 ; i >= 0 ; i--) {
            head = new Node(i,head);
        }

        int k = 1;
        Node ref = head;
        while (ref != null && (k<2)) {
            System.out.println(" " + ref.value);
            ref = ref.next;
            k++;
        }

        newtail.next = ref.next.next;
        ref.next = newtail;
        System.out.println(newtail.next);
    }
}
