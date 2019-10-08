package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CloneListWithRandomPointer {

    public static void main(String[] args) {
        Node head = new Node(10);
        head.nxt = new Node(20);
        head.nxt.nxt = new Node(30);
        head.nxt.nxt.nxt = new Node(40);
        head.random = head.nxt.nxt;
        head.nxt.nxt.random = head;
        head.nxt.nxt.nxt.random = head.nxt.nxt.nxt;

        printList(head);

        Node cloned = cloneList(head);

        printList(cloned);

    }

    private static Node cloneList(Node head) {
        Node dummy = new Node(-1);
        Node cloneHead = null;

        Map<Integer, Node> map = new HashMap<>();
        Node tempHead = head;
        while(tempHead != null) {
            map.put(tempHead.val, new Node(tempHead.val));
            tempHead = tempHead.nxt;
        }
        while (head != null) {
            Node cloneNode = map.get(head.val);
            if(head.nxt != null)
                cloneNode.nxt = map.get(head.nxt.val);
            if(head.random != null)
                cloneNode.random = map.get(head.random.val);
            if(cloneHead == null){
                cloneHead = cloneNode;
                dummy.nxt = cloneHead;
            }
            head = head.nxt;
        }
        return dummy.nxt;
    }

    private static void printList(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp);
            temp = temp.nxt;
        }
    }

    static class Node {
        int val;
        Node nxt;
        Node random;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", nxt=" + ((nxt == null) ? null : nxt.val) +
                    ", random=" + ((random == null) ? null : random.val) +
                    '}';
        }
    }
}
