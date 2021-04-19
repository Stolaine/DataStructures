package problems;

import tree.DynamicTree;
import tree.Node;
import tree.Tree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\shesh\\IdeaProjects\\DataStructures\\src\\interaction\\input.txt"));
        System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\shesh\\IdeaProjects\\DataStructures\\src\\interaction\\output.txt")));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i=0; i<n; i++) {
            nodes.add(new Node(sc.nextInt()));
        }
        DynamicTree tree = new DynamicTree(n, nodes);
        for (int i=0; i<n-1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree.insert(u, v);
        }
        ArrayList<Node> elements = tree.preOrderTraversal();
        for (Node element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
