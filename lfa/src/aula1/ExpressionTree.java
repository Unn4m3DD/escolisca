package aula1;

import java.util.Scanner;

public class ExpressionTree {
    static class Node<T> {
        T content;
        Node left, right;

    }

    Node root;

    ExpressionTree(Node root) {
        this.root = root;
    }

    public String stringInfix() {
        return infixStringOf(root);
    }

    private String infixStringOf(Node n) {
        if (n.left == null) return "" + n.content;
        return infixStringOf(n.left) + " " + n.content + " " + infixStringOf(n.right);
    }

    public String stringPrefix() {
        return prefixStringOf(root);
    }

    private String prefixStringOf(Node n) {
        if (n.left == null) return "" + n.content;
        return n.content + " " + prefixStringOf(n.left) + " " + prefixStringOf(n.right);
    }

    public String stringPostfix() {
        return postfixStringOf(root);
    }

    private String postfixStringOf(Node n) {
        if (n.left == null) return "" + n.content;
        return postfixStringOf(n.left) + " " + infixStringOf(n.right) + " " + n.content;
    }

    public static ExpressionTree fromPrefixNotation(String source) {
        Scanner k = new Scanner(source);
        ExpressionTree result = new ExpressionTree(populate(k));
        return result;
    }

    static Node populate(Scanner k) {
        Node result = new Node();
        if (k.hasNextDouble()) {
            result.content = k.nextDouble();
            return result;
        }
        result.content = k.next();
        result.left = populate(k);
        result.right = populate(k);
        return result;
    }

    public double eval() {
        return eval(root);
    }

    double eval(Node n) {
        if (n.left == null) return (double) n.content;
        if (n.content.equals("+"))
            return eval(n.left) + eval(n.right);
        if (n.content.equals("-"))
            return eval(n.left) - eval(n.right);
        if (n.content.equals("*"))
            return eval(n.left) * eval(n.right);
        if (n.content.equals("/"))
            return eval(n.left) / eval(n.right);
        return 0;
    }
}
