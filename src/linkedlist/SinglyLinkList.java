package sll;

import java.util.Iterator;

public class SinglyLinkList {


    public static void main(String[] args) {
        SinglyLinkList list = new SinglyLinkList();
        list.createList(1, 2, 3, 4);
        list.printList();
        list.remove(2);
        list.printList();
        System.out.println("Size : " + list.size());
    }


    class ListIterator implements Iterator<Node> {
        Node currentNode;
        ListIterator() {
            currentNode = head;
        }

        @Override
        public boolean hasNext() {
            return currentNode.next != null;
        }

        @Override
        public Node next() {
            currentNode = currentNode.next;
            return currentNode;
        }
    }
    private int size() {
        if(head == null)
            return 0;
        int size = 1;
        for(Iterator<Node> itr = iterator(); itr.hasNext(); itr.next()) {
            size++;
        }
        return size;
    }

    private void remove(int i) {
        if(head.getData() == i) {
            head = head.next();
        }
        Node node = head;
        Node preNode=head;
        do {
            if (node.getData() == i) {
                preNode.nextNode(node.next());
            }
            preNode = node;
        }while ((node = node.next())!= null);

    }

    private Node head;

    private void createList(int ...nos) {
        Node node= new Node(nos[0]);
        head = node;
        for(int i=1; i <nos.length;i++){
            Node newNode = new Node(nos[i]);
            node.nextNode(newNode);
            node = newNode;
        }
    }

    private void printList() {
        Node node = head;
        do {
            System.out.println(node.getData());
        } while((node  = node.next()) != null);
    }

    static class Node {
        private Integer data;
        private Node next;
        Node(Integer data) {
            this.data = data;
        }

        void nextNode(Node newNode) {
            this.next = newNode;
        }

        Integer getData() {
            return this.data;
        }

        Node next() {
            return this.next;
        }
    }
    ListIterator iterator() {
        return new ListIterator();
    }
}
