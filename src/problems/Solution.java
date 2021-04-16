package problems;

import tree.Tree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
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
        Problem problem = new Problem();
        System.out.println(problem.getFullNodeCount(tree));
    }
}
