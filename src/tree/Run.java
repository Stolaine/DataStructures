package tree;

import java.io.*;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\shesh\\IdeaProjects\\DataStructures\\src\\interaction\\input.txt"));
        System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\shesh\\IdeaProjects\\DataStructures\\src\\interaction\\output.txt")));
        Scanner sc = new Scanner(System.in);
        Tree tree = new Tree();
        int N = sc.nextInt();
        for (int i=0; i<N-1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree.insert(u,v);
        }
        tree.preOrderRecursive();
        System.out.println(tree.root.rightChild);
    }
}
