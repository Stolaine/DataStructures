package nonLinear.tree;

public class BST extends Tree {

    public BST() {
        root = null;
    }

    public void insert(int data) {
        Node temp = new Node(data);
        if (root == null) {
            root = temp;
            return;
        }
        Node curr = root;
        while (true) {
            if (curr == null) {
                break;
            }
            if (curr.data < data) {
                if (curr.rightChild == null) {
                    curr.rightChild = temp;
                    return;
                } else if (curr.rightChild != null) {
                    curr = curr.rightChild;
                }
            } else if (curr.data > data) {
                if (curr.leftChild == null) {
                    curr.leftChild = temp;
                    return;
                } else if (curr.leftChild != null) {
                    curr = curr.leftChild;
                }
            }
        }
    }
}
