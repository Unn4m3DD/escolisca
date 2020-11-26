package Aula10;

import myUtilAula10.BinarySearchTree;

import java.util.Arrays;

public class problema2 {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(1);
        bst.insert(2);
        bst.insert(0);
        bst.insert(7);
        bst.insert(1);
        bst.insert(-3);
        bst.insert(9);
        bst.insert(32);
        bst.insert(-12);
        for (int i = 0; i < bst.numNodes; i++)
            System.out.print((Integer) ((bst.BSTToArray())[i]) + ", ");
        System.out.println();
        bst.remove(1);
        bst.remove(9);
        for (int i = 0; i < bst.numNodes; i++)
            System.out.print((Integer) ((bst.BSTToArray())[i]) + ", ");
        System.out.println();
    }
}
