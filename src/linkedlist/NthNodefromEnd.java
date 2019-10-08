package linkedlist;

public class NthNodefromEnd {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.nxt = new Node(20);
        head.nxt.nxt = new Node(30);
        head.nxt.nxt.nxt = new Node(40);
        head.nxt.nxt.nxt.nxt = new Node(50);

       //find length - 2;
        Node p1 = head;
        Node p2 = head;

        int count = 0;

        while(count < 2 && p2 != null) {
            p2 = p2.nxt;
            count++;
        }
        while(p2.nxt != null) {
            p2 = p2.nxt;
            p1 = p1.nxt;
        }

        System.out.println(p1.val);
    }

    static class Node {
        int val;
        Node nxt;

        public Node(int i) {
            this.val = i;
            this.nxt = null;
        }
    }
}
