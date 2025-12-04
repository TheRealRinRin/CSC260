/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csc260project;
/**
 *
 * @author hlib
 */
public class BinarySearchTree {
// We will use other tree
    private class Node {
        int votes;
        ElectionRecord record;
        Node left;
        Node right;

        Node(int votes, ElectionRecord record) {
            this.votes = votes;
            this.record = record;
        }
    }

    private Node root;

    public void insert(ElectionRecord record) {
        if (record == null) {
            throw new IllegalArgumentException("ElectionRecord cannot be null");
        }
        root = insertRecursive(root, record);
    }

    private Node insertRecursive(Node current, ElectionRecord record) {
        if (current == null) {
            return new Node(record.getVotes(), record);
        }

        if (record.getVotes() < current.votes) {
            current.left = insertRecursive(current.left, record);
        } else {
            current.right = insertRecursive(current.right, record);
        }

        return current;
    }

    public ElectionRecord search(int votes) {
        Node result = searchRecursive(root, votes);
        return result == null ? null : result.record;
    }

    private Node searchRecursive(Node current, int votes) {
        if (current == null || current.votes == votes) {
            return current;
        }

        if (votes < current.votes) {
            return searchRecursive(current.left, votes);
        } else {
            return searchRecursive(current.right, votes);
        }
    }

    public void delete(int votes) {
        root = deleteRecursive(root, votes);
    }

    private Node deleteRecursive(Node current, int votes) {
        if (current == null) {
            return null;
        }

        if (votes < current.votes) {
            current.left = deleteRecursive(current.left, votes);
        } else if (votes > current.votes) {
            current.right = deleteRecursive(current.right, votes);
        } else {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }

            Node smallest = findMin(current.right);
            current.votes = smallest.votes;
            current.record = smallest.record;
            current.right = deleteRecursive(current.right, smallest.votes);
        }
        return current;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void inOrderTraversal() {
        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.println(node.record);
            inOrderRecursive(node.right);
        }
    }
}


