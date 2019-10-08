package linkedlist;

public class LoopInLinkList {

    public static void main(String[] args) {
        Node head = new Node(10);
        head.nxt = new Node(20);
        head.nxt.nxt = new Node(30);
        head.nxt.nxt.nxt = head.nxt.nxt;

        System.out.println(findLoop(head));
    }

    private static boolean findLoop(Node head) {
        Node p1 = head;
        Node fp1 = head;

        while(fp1 != null && fp1.nxt != null) {
            fp1 = fp1.nxt.nxt;
            p1 = p1.nxt;
            if(fp1 != null && fp1.val == p1.val){
                return true;
            }
        }
        return false;
    }

    static class Node {
        int val;
        Node nxt;

        public Node(int val) {
            this.val = val;
        }
    }
}
