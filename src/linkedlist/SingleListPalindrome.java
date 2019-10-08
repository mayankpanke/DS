package linkedlist;

public class SingleListPalindrome {

    public static void main(String[] args) {
        Node head = new Node("a");
        head.nxt = new Node("b");
        head.nxt.nxt = new Node("c");
        head.nxt.nxt.nxt = new Node("b");
        head.nxt.nxt.nxt.nxt = new Node("a");

        System.out.println(checkPalindrome(head));
    }

    private static boolean checkPalindrome(Node head) {
        Node p = head;
        Node fp = head;

        while(fp != null && fp.nxt != null){
            fp = fp.nxt.nxt;
            p = p.nxt;
        }
        Node next;
        Node previous = null;
        Node current = p;
        while (current != null) {
            next = current.nxt;
            current.nxt = previous;
            previous = current;
            current = next;
        }
        fp = previous;
        while(head != null && fp != null){
            if(!head.s.equals(fp.s)) {
                return false;
            }
            head = head.nxt;
            fp = fp.nxt;
        }
        return true;
    }

    static class Node {
        String s;
        Node nxt;

        public Node(String s) {
            this.s = s;
        }
    }
}
