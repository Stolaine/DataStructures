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

    void insert(int parent, int child){
        Node p;
        Node c = new Node(child);
        if (map.isEmpty()) {
            p = new Node(parent);
            root = p;
        } else {
            p = map.get(parent);
        }
        if (p.leftChild == null) {
            p.leftChild = c;
        } else {
            p.rightChild = c;
        }
        map.put(parent, p);
        map.put(child, c);
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
