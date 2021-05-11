package nonLinear.tree;

import java.util.*;

public class Tree {
    public Node root;
    public Map<Integer,Node> map;

    public Tree() {
        root = null;
        map = new HashMap<>();
    }

    public void insert(int parent, int child){
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

    public void preOrderRecursive() {
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

    int findMax() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        int max = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            if (max < curr.data) {
                max = curr.data;
            }
            if (curr.leftChild != null) {
                stack.push(curr.leftChild);
            }
            if (curr.rightChild != null) {
                stack.push(curr.rightChild);
            }
        }
        return max;
    }

    int findMaxRec(Node parent) {
        int max = parent.data;
        if (parent.leftChild != null) {
            int temp = findMaxRec(parent.leftChild);
            if (temp>max) {
                max = temp;
            }
        }
        if (parent.rightChild != null) {
            int temp = findMaxRec(parent.rightChild);
            if (temp>max) {
                max = temp;
            }
        }
        return max;
    }

    boolean search(int data) {
        boolean found = false;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr.data == data) {
                found = true;
                break;
            }
            if (curr.leftChild != null) {
                queue.add(curr.leftChild);
            }
            if (curr.rightChild != null) {
                queue.add(curr.rightChild);
            }
        }
        return found;
    }

    void levelOrderInsertion(int data) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr.leftChild != null) {
                queue.add(curr.leftChild);
            } else {
                curr.leftChild = new Node(data);
                break;
            }
            if (curr.rightChild != null) {
                queue.add(curr.rightChild);
            } else {
                curr.rightChild = new Node(data);
            }
        }
    }

    int getSize() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int size = 0;
        while (!queue.isEmpty()) {
            size++;
            Node curr = queue.poll();
            if (curr.leftChild != null) {
                queue.add(curr.leftChild);
            }
            if (curr.rightChild != null) {
                queue.add(curr.rightChild);
            }
        }
        return size;
    }

    void reverseLevelOrder() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Stack<Node> reverseStack = new Stack<>();
        reverseStack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            if (curr.rightChild != null) {
                reverseStack.push(curr.rightChild);
            }
            if (curr.leftChild != null) {
                reverseStack.push(curr.leftChild);
            }
            if (curr.leftChild != null) {
                stack.push(curr.leftChild);
            }
            if (curr.rightChild != null) {
                stack.push(curr.rightChild);
            }
        }
        while (!reverseStack.isEmpty()) {
            Node curr = reverseStack.pop();
            System.out.print(curr);
        }
    }

    int getHeightRecursively(Node parent) {
        int height = 1;
        int leftHeight = 0;
        int rightHeight = 0;
        if (parent.leftChild != null) {
            leftHeight = getHeightRecursively(parent.leftChild);
        }
        if (parent.rightChild != null) {
            rightHeight += getHeightRecursively(parent.rightChild);
        }
        if (leftHeight == rightHeight || leftHeight > rightHeight) {
            height += leftHeight;
        } else if (leftHeight < rightHeight) {
            height += rightHeight;
        }
        return height;
    }

    int getHeightNonRecursively() {
        // count the number of nodes in the longest path from root to leaf nodes.
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node prev = null;
        int maxDepth = 0;
        while (!stack.isEmpty()) {
            Node curr = stack.peek();
            if (prev == null || prev.leftChild == curr || prev.rightChild == curr) {
                if (curr.leftChild != null) {
                    stack.push(curr.leftChild);
                } else if (curr.rightChild != null) {
                    stack.push(curr.rightChild);
                }
            } else if (curr.leftChild == prev) {
                if (curr.rightChild != null) {
                    stack.push(curr.rightChild);
                }
            } else {
                stack.pop();
            }
            prev = curr;
            if (stack.size() > maxDepth) {
                maxDepth = stack.size();
            }
        }
        return maxDepth;
    }

    int getHeightLevelOrder() {
        // count the number of edges in longest path from root to leaf nodes.
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int count = 0;
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr != null) {
                if (curr.leftChild != null) {
                    queue.add(curr.leftChild);
                }
                if (curr.rightChild != null) {
                    queue.add(curr.rightChild);
                }
            } else {
                if (!queue.isEmpty()) {
                    count++;
                    queue.add(null);
                }
            }
        }
        return count;
    }
}
