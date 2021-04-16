package problems;

import tree.Node;
import tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Problem {
    int getLeafNodeCount(Tree tree) {
        int count = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(tree.root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr.leftChild == null && curr.rightChild == null) {
                count++;
            }
            if (curr.leftChild != null) {
                queue.add(curr.leftChild);
            }
            if (curr.rightChild != null) {
                queue.add(curr.rightChild);
            }
        }
        return count;
    }
}
