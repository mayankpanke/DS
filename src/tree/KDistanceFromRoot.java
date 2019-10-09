package tree;

import java.util.LinkedList;
import java.util.Queue;

public class KDistanceFromRoot {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(80);

        printNodesFromDistance(root, 2);

    }

    private static void printNodesFromDistance(Node root, int distance) {
        if(root == null){
            return;
        }
        if(distance == 0){
            System.out.println(root.data);
            return;
        }
        Queue<Node> queue  = new LinkedList<>();
        queue.add(root);
        int currentDistance = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                Node node = queue.poll();
                if(currentDistance == distance){
                    System.out.println(node.data);
                } else {
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            currentDistance++;
        }
    }
}
