package lab11.test;

public class NodeTes { // главный класс
    public static void main(String[] args) {
        // создание несвязанных узлов с помошью конструктора
        Node node0 = new Node(0, null); // 0-узел - будет головой в списке
        Node node1 = new Node(1, null);
        Node node2 = new Node( 2, null);
        Node node3 = new Node(3, null); // последний узел - будет хвостом в списке

        //связывание узлов в список с помошью ссылок

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        // вывод списка с использованием вспомогательной переменной реф
        // соответсвующей текущему значению ссылки при проходе списка

        Node ref = node0; // длдя проходу по такому списку достаточно помнить голову

        while (ref != null) {
            System.out.println(" " + ref.value);
            ref = ref.next;
        }
    }
}
