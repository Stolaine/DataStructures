package problems;

import tree.Node;
import tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class P14 {
    Node findDeepestNode(Tree tree) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(tree.root);
        Node deepestNode = null;
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr.leftChild != null) {
                queue.add(curr.leftChild);
            }
            if (curr.rightChild != null) {
                queue.add(curr.rightChild);
            }
            if (curr.leftChild == null && curr.rightChild == null && queue.isEmpty()) {
                deepestNode = curr;
            }
        }
        return deepestNode;
    }
}
