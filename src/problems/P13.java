package problems;

import tree.Node;
import tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class P13 {
    static int getMininumHeight(Tree tree) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(tree.root);
        queue.add(null);
        int count = 0;
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr!=null) {
                if (curr.leftChild == null && curr.rightChild == null) {
                    return count;
                }
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
