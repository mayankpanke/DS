package tree;

import java.util.Iterator;

public class BTreeTraversal {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        System.out.println("inOrderTraverse");
        inOrderTraverse(root);
        System.out.println("preOrderTraverse");
        preOrderTraverse(root);
        System.out.println("postOrderTraverse");
        postOrderTraverse(root);

    }

    private static void postOrderTraverse(Node node) {
        if(node == null) {
            return;
        }
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.println(node.data);
    }

    private static void preOrderTraverse(Node node) {
        if(node == null)
            return;
        System.out.println(node.data);
        preOrderTraverse(node.left);
        preOrderTraverse((node.right));
    }

    private static void inOrderTraverse(Node node) {
        if(node == null){
            return;
        }
        inOrderTraverse(node.left);
        System.out.println(node.data);
        inOrderTraverse(node.right);
    }

    static class InOrderTraverseItr implements Iterator<Node> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Node next() {
            return null;
        }
    }
}
