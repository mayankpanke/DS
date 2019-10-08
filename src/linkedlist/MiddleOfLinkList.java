package linkedlist;

public class MiddleOfLinkList {

    public static void main(String[] args) {
        Node  head = new Node(10);
        head.nxt = new Node (20);
        head.nxt.nxt = new Node(30);
        head.nxt.nxt.nxt = new Node(40);
        //head.nxt.nxt.nxt.nxt = new Node(50);

        Node middle = findMiddle(head);

        System.out.println(middle.val);


    }

    private static Node findMiddle(Node head) {
        Node p1 = head;
        Node fp1 = head;

        while (fp1.nxt != null) {
            fp1 = fp1.nxt;
            if(fp1.nxt != null) {
                fp1 = fp1.nxt;
            }
            p1 = p1.nxt;
        }
        return p1;
    }

    static class Node {
        int val;
        Node nxt;

        public Node(int val) {
            this.val = val;
        }
    }
}
