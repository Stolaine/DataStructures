package problems;

import javafx.util.Pair;
import nonLinear.tree.Node;
import nonLinear.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class P15 {
    void deleteNode(Tree tree, int data) {
        Node toBeDeleted = null;
        Node deepest = null;
        Node parent = null;
        Queue<Pair<Node, Node>> queue = new LinkedList<>();
        queue.add(new Pair(null, tree.root));
        while (!queue.isEmpty()) {
            Pair<Node, Node> currentPair = queue.poll();
            Node curr = currentPair.getValue();
            if (curr.data == data) {
                toBeDeleted = curr;
            }
            if (curr.leftChild != null) {
                queue.add(new Pair(curr, curr.leftChild));
            }
            if (curr.rightChild != null) {
                queue.add(new Pair(curr, curr.rightChild));
            }
            if (curr.leftChild == null && curr.rightChild == null && queue.isEmpty()) {
                parent = currentPair.getKey();
                deepest = curr;
            }
        }
        if (deepest != null && toBeDeleted != null) {
            toBeDeleted.data = deepest.data;
        }
        if (parent == null && deepest != null) {
            tree.root = null;
        } else if (parent != null && deepest != null) {
            if (parent.leftChild == deepest) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }

    }
}
