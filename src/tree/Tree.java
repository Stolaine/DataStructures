package tree;

import java.util.*;

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

    private void recPreOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print("" + node.data + " ");
        recPreOrder(node.leftChild);
        recPreOrder(node.rightChild);
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

    void inOrderNonRecursive() {
        Stack<Node> stack = new Stack<>();
        boolean done = false;
        Node curr = root;
        while (!done) {
            if (curr != null) {
                // if the node exists put it in the stack and go for left child
                stack.push(curr);
                curr = curr.leftChild;
            } else {
                // if the node does not exists i.e. we are at the leaf node
                if (stack.isEmpty()) {
                    // is the stack empty i.e. all nodes are processed
                    done = true;
                } else {
                    // for the current node - all left children are processed so process current node
                    curr = stack.pop();
                    System.out.print("" + curr.data + " ");
                    curr = curr.rightChild;
                }
            }
        }
    }

    void postOrderNonRecursive() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node prev = null;
        while (!stack.isEmpty()) {
            Node curr = stack.peek();
            // either prev is null i.e. curr is root node
            // or curr is left child of prev
            // or curr is right child of prev
            // these conditions mean that the node's children has not been processed yet.
            if (prev == null || prev.leftChild == curr || prev.rightChild == curr) {
                if (curr.leftChild != null) {
                    stack.push(curr.leftChild);
                } else if (curr.rightChild != null) {
                    stack.push(curr.rightChild);
                }
            } else if (curr.leftChild == prev) {
                // the left child of curr has been processed.
                if (curr.rightChild != null) {
                    stack.push(curr.rightChild);
                }
            } else {
                // children are processed time to process parent
                System.out.print(curr);
                stack.pop();
            }
            prev = curr;
        }
    }

    void levelOrderTraversal() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr.leftChild != null) {
                queue.add(curr.leftChild);
            }
            if (curr.rightChild != null) {
                queue.add(curr.rightChild);
            }
            System.out.print(curr);
        }
    }
}
