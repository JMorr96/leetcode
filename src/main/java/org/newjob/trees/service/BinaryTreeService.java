package org.newjob.trees.service;

import org.newjob.trees.model.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeService {
    public void printBinaryBFS(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            BinaryTreeNode printNode = queue.poll();
            System.out.println(printNode.val + " ");

            if (printNode.left != null)
                queue.add(printNode.left);
            if (printNode.right != null)
                queue.add(printNode.right);
        }
    }

    public BinaryTreeNode invertTree(BinaryTreeNode root) {
        if(root == null)
            return root;

        BinaryTreeNode left = invertTree(root.left);
        BinaryTreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public void executeBinaryTree() {
        BinaryTreeNode testRootNode = new BinaryTreeNode();
        testRootNode.val = 4;
        testRootNode.left = new BinaryTreeNode(2);

        testRootNode.left.left = new BinaryTreeNode(1);
        testRootNode.left.right = new BinaryTreeNode(3);

        testRootNode.right = new BinaryTreeNode(7);
        testRootNode.right.left = new BinaryTreeNode(6);
        testRootNode.right.right = new BinaryTreeNode(9);

        invertTree(testRootNode);

        printBinaryBFS(testRootNode);
    }
}
