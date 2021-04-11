package tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Tree {
    Node root;
    public Map<Integer,Node> map;

    public Tree() {
        root = null;
        map = new HashMap<>();
    }
    void insert(int p,int c){
        if (map.isEmpty()) {
            root = new Node(p);
            root.leftChild = new Node(c);
            map.put(p, root);
            map.put(c, root.leftChild);
        } else if (map.containsKey(p)) {
            Node curr = map.get(p);
            if (curr.leftChild == null) {
                curr.leftChild=new Node(c);
                map.put(c, curr.leftChild);
            } else {
                curr.rightChild = new Node(c);
                map.put(c, curr.rightChild);
            }
        }
    }

    void addNode(Node parent, Node child) {
        if (root == null) {
            root = parent;
            root.leftChild = child;
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node curr = null;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            if (curr.data == parent.data) {
                break;
            } else {
                if(curr.leftChild != null) {
                    stack.push(curr.leftChild);
                }
                if(curr.rightChild != null) {
                    stack.push(curr.rightChild);
                }
            }
        }
        if (curr != null) {
            if (curr.leftChild==null) {
                curr.leftChild = child;
            } else if (curr.rightChild == null) {
                curr.rightChild = child;
            }
        }
    }

    void preOrderRecursive() {
        recPreOrder(root);
        System.out.println();
    }

    void preOrderNonRecursive() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            if (curr.rightChild != null) {
                stack.push(curr.rightChild);
            }
            if (curr.leftChild != null) {
                stack.push(curr.leftChild);
            }
            System.out.print("" + curr.data + " ");
        }
        System.out.println();
    }

    private void recPreOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print("" + node.data + " ");
        recPreOrder(node.leftChild);
        recPreOrder(node.rightChild);
    }
}
