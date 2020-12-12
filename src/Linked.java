import java.awt.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Linked<Lab> {
    Node head = null;
    Node tail = null;

    // I made an array list of node and used a for loop with it returning -1
    public int Cycle(Node head) {
        List<Node> present = new ArrayList<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            if (present.contains(cur)) {
                return present.indexOf(cur);
            }
            else {
                present.add(cur);
            }
        }
        return -1;
    }
    // adds a specific element into a collection. if head = null than head == node
    // else tail. next = node with tail = node outside of else
    public void add(Lab value) {
        Node node = new Node(value);
        if (this.head == null) {
            head = node;
        }
        else {
            tail.next = node;
        }
        tail = node;
    }

    // Lab is any type like type E value etc. 
    private class Node<Lab>{
        Lab data;
        Node next;

        public Node(Lab value) {
            data = value;
        }
    }

    // test the code here.
    public static void main(String[] args){
        Linked<Integer> list = new Linked<>();
        Linked<Integer> list2 = new Linked<>();
        list.add(3);
        list.add(2);
        list.add(0);
        list.add(-4);
        list.head.next.next.next.next = list.head.next;
        list2.add(1);
        list2.add(2);
        list2.head.next.next = list2.head;
        System.out.println(list.Cycle(list.head));
        System.out.println(list2.Cycle(list2.head));

    }
}




