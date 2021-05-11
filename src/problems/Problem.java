package problems;

import nonLinear.tree.Node;
import nonLinear.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Problem {
    boolean isIdentical(Tree a, Tree b) {
        boolean identical = true;
        Queue<Node> queueA = new LinkedList<>();
        Queue<Node> queueB = new LinkedList<>();
        queueA.add(a.root);
        queueB.add(a.root);
        while (!queueA.isEmpty() || !queueB.isEmpty()) {
            Node currA = queueA.poll();
            Node currB = queueB.poll();
            if ((currA.leftChild == null && currB.leftChild != null) ||
                    (currA.leftChild != null && currB.leftChild == null) ||
                    (currA.rightChild == null && currB.rightChild != null) ||
                    (currA.rightChild != null && currB.rightChild == null)) {
                identical = false;
                break;
            }
        }
        return identical;
    }
}
