package tree;

import java.util.ArrayList;
import java.util.Stack;

public class DynamicTree {
    private int count;
    private Node[] nodes;
    private Node root;

    public DynamicTree(int count, ArrayList<Node> nodes) {
        this.count = count;
        this.nodes = new Node[count+1];
        for (int i=0; i<count; i++) {
            this.nodes[i+1] = nodes.get(i);
        }
        root = this.nodes[1];
    }

    public void insert(int parentIndex, int childIndex) {
        Node parent = nodes[parentIndex];
        Node child = nodes[childIndex];
        if (parent.leftChild == null) {
            parent.leftChild = child;
        } else {
            parent.rightChild = child;
        }
    }

    public ArrayList<Node> preOrderTraversal() {
        Stack<Node> stack = new Stack<>();
        ArrayList<Node> elements = new ArrayList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            if (curr.rightChild != null) {
                stack.push(curr.rightChild);
            }
            if (curr.leftChild != null) {
                stack.push(curr.leftChild);
            }
            elements.add(curr);
        }
        return elements;
    }
}
