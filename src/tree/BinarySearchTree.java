package tree;

public class BinarySearchTree {
    private Node root;

    public void add(int value){
        Node node = new Node(value);
        if(root == null) {
            root = node;
        } else {
            Node parent = findParent(root, value);
            if(value <= parent.data) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        }
    }

    public Node getRoot() {
        return root;
    }

    private Node findParent(Node startNode, int value) {
        if(value < startNode.data ) {
            if(startNode.left == null)
                return startNode;
            else
                return findParent(startNode.left, value);
        } else {
            if(startNode.right == null)
                return startNode;
            return findParent(startNode.right, value);
        }
    }

    static class Node {
        private final int data;
        private Node left;
        private Node right;
        Node(int value) {
            this.data = value;
        }

        int getData() {
            return data;
        }

        Node getLeft() {
            return left;
        }
        Node getRight() {
            return right;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(10);
        binarySearchTree.add(5);
        binarySearchTree.add(15);
        binarySearchTree.add(7);
        binarySearchTree.add(9);
        binarySearchTree.add(6);
    }
}
