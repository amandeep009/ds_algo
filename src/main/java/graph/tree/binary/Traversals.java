package graph.tree.binary;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Traversals {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left=new Node(4);
//        dfsInOrder(root);
//        System.out.println("\n");
//        dfsPreOrder(root);
        levelOrder(root);
    }

    private static void dfsInOrder(Node node) {
        if(node==null)
            return;
        dfsInOrder(node.left);
        System.out.print(node.data+ " ->");
        dfsInOrder(node.right);
    }

    private static void dfsPreOrder(Node node) {
        if(node==null)
            return;
        System.out.print(node.data + "->");
        dfsInOrder(node.left);
        dfsInOrder(node.right);
    }

    private static void dfsPostOrder(Node node) {
        if(node==null)
            return;
        System.out.print(node.data + "->");
        dfsInOrder(node.left);
        dfsInOrder(node.right);
    }


    private static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node =  queue.poll();
            System.out.println(node.data);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
    }
}


class Node {
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
    }
}