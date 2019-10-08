package linkedlist;

public class Reverse {

    private class Node{
        Integer data;
        Node next;
    }

    private Node head;

    private void add(Integer no) {
        if(head == null) {
            head = new Node();
            head.data = no;
            return;
        }
        Node currentNode = head;
        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }
        Node newNode = new Node();
        newNode.data = no;
        currentNode.next = newNode;
    }

    private void reverse() {
        Node currentNode = head;
        Node previous = null;
        Node next;
        while (currentNode != null) {
            next = currentNode.next;
            currentNode.next = previous;
            previous = currentNode;
            currentNode = next;
        }
        head = previous;
    }
    private void printList() {
        Node node = head;
        do {
            System.out.println(node.data);
        } while((node  = node.next) != null);
    }

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        reverse.add(1);
        reverse.add(2);
        reverse.add(3);
        reverse.printList();
        reverse.reverse();
        reverse.printList();
    }

}
