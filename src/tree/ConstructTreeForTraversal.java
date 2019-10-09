package tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeForTraversal {
    static class Node {
        int data;
        Node left;
        Node right;
        
        Node(int data) {
            this.data = data;
        }

    }
    public static void main(String[] args) {
        Node root = constructTree(new int[]{3,9,20,15,7},
                                  new int[]{9,3,15,20,7});
    }

    private static Node constructTree(int[] preOrder, int[] inOrder) {
        Map<Integer, Integer> inOrderLookUp = new HashMap();
        for(int index = 0; index < inOrder.length; index++){
            inOrderLookUp.put(inOrder[index], index);
        }

        Node root = prepare(preOrder, 0, preOrder.length, inOrder, 0, inOrder.length, inOrderLookUp);
        return root;
    }

    private static Node prepare(int[] preOrder, int startPreOder, int  endPreOrder,
                                int[] inOrder, int startInOrder, int endInOrder, Map<Integer, Integer> inOrderLookUp) {
        if(startInOrder > endInOrder || startPreOder > endPreOrder - 1){
            return null;
        }
        Node node = new Node(preOrder[startPreOder]);
        int rootIndexOnInOrder  = inOrderLookUp.get(preOrder[startPreOder]);
        node.left = prepare(preOrder, startPreOder + 1, endPreOrder, inOrder, startInOrder,
                rootIndexOnInOrder - 1, inOrderLookUp);

        node.right = prepare(preOrder, startPreOder + (rootIndexOnInOrder - startInOrder) + 1 , endPreOrder,
                                inOrder, rootIndexOnInOrder + 1, endInOrder, inOrderLookUp );
        return node;
    }

}
