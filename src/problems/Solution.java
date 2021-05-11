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
        BST bst = new BST();
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            int data = sc.nextInt();
            bst.insert(data);
        }
        bst.preOrderRecursive();
    }
}
