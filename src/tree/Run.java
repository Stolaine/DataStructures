package tree;

import java.io.*;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\shesh\\IdeaProjects\\DataStructures\\src\\interaction\\input.txt"));
        System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\shesh\\IdeaProjects\\DataStructures\\src\\interaction\\output.txt")));
        Tree tree = new Tree();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i=0; i<N-1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree.addNode(new Node(u), new Node(v));
        }
        tree.preOrderRecursive();
    }
}
