package problems;

import linear.linkedList.LinkedList;
import nonLinear.tree.BST;
import nonLinear.tree.Tree;

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
        int n = sc.nextInt();
        for (int i=0; i<n-1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree.insert(u, v);
        }
        tree.preOrderRecursive();
        System.out.println(tree.findMax(tree.root));
        System.out.println(tree.findMin(tree.root));
        System.out.println(tree.isBST(tree.root));
        // 10 3 2 1 4 14 11
    }
}
