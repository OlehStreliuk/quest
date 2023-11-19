package com.example.quest_streliuk.model;

public class Node {
    String value;
    Node left;
    Node right;

    String result;

    public Node(String value, Node left, Node right) {
        this.value = value;
        this.left  = left;
        this.right = right;
    }

    public Node(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public String getResult() {
        return result;
    }

    public Node nextText(String text, Node node) {

        if (node != null && node.getValue().equals(text))
            return node;

        if (node.left != null && node.left.getValue() != text)
            return nextText(text, node.left);

        if (node.left != null && node.left.getValue() == text)
            return node.left;

        if (node.right != null && node.right.getValue() != text)
            return nextText(text, node.right);

        if (node.right != null && node.right.getValue() == text)
            return node.right;

        return node;
    }
}

