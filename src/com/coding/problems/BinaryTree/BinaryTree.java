package com.coding.problems.BinaryTree;

class Node {
    int value;
    Node leftNode;
    Node rightNode;

    Node(int value) {
        this.value = value;
        leftNode = null;
        rightNode = null;
    }
}

public class BinaryTree {
    Node root;

    private static BinaryTree createBinaryTree() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(5);
        binaryTree.add(6);

        return binaryTree;
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.leftNode = addRecursive(current.leftNode, value);
        } else if (value > current.value) {
            current.rightNode = addRecursive(current.rightNode, value);
        } else {
            return current;
        }

        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    public static void printBinaryTree(BinaryTree binaryTree) {
        System.out.println("Binary Tree: " + binaryTree.root);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = createBinaryTree();
        printBinaryTree(binaryTree);
    }
}
