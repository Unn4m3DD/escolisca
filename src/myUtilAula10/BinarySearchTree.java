package myUtilAula10;

import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Comparable;
import java.util.Spliterator;
import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<? super T>> implements Iterable<T> {

    // o elemento do tipo T deve ser comparável para efectuar pesquisas
    // mas como pode herdar a implementação de compareTo() é mais correcto
    // usar <? super T>
    private static class BSTNode<T> {
        T element;
        BSTNode<T> left;
        BSTNode<T> right;

        BSTNode(T theElement) {
            element = theElement;
            left = right = null;
        }
    }

    public BSTNode<T> root;
    public int numNodes;

    public BinarySearchTree() {
        root = null;
        numNodes = 0;
    }

    public void insert(T value) {
        insert(value, root);
    }

    public void reinsert(T value, BSTNode<T> node) {
        if (root == null) {
            root = new BSTNode<>(value);
        } else if (value.compareTo(node.element) <= 0) {
            if (node.left != null)
                reinsert(value, node.left);
            else {
                node.left = new BSTNode<>(value);
            }
        } else {
            if (node.right != null)
                reinsert(value, node.right);
            else {
                node.right = new BSTNode<>(value);
            }
        }

    }
    public void insert(T value, BSTNode<T> node) {
        if (root == null) {
            root = new BSTNode<>(value);
            numNodes++;
        } else if (value.compareTo(node.element) <= 0) {
            if (node.left != null)
                insert(value, node.left);
            else {
                node.left = new BSTNode<>(value);
                numNodes++;
            }
        } else {
            if (node.right != null)
                insert(value, node.right);
            else {
                node.right = new BSTNode<>(value);
                numNodes++;
            }
        }

    }

    public SearchResult search(T value, BSTNode<T> node, BSTNode<T> parent) {
        if (value.compareTo(node.element) == 0) {
            return new SearchResult(node, parent);
        } else if (value.compareTo(node.element) < 0) {
            if (node.left == null)
                return null;
            else
                return search(value, node.left, node);
        } else {
            if (node.right == null)
                return null;
            else
                return search(value, node.right, node);
        }
    }

    public void remove(T value) {
        BSTNode<T> parent = null;
        remove(search(value, root, parent));
    }

    private void remove(SearchResult result) {
        BSTNode<T> node = result.node;
        if (result.parent == null) {
            root = node.left;
            insertRecurs(node.right);
        } else {
            if (result.parent.left == node) {
                result.parent.left = null;
                insertRecurs(node.left);
            } else if (result.parent.right == node){
                result.parent.right = null;
                insertRecurs(node.right);
            }
        }
        numNodes--;
    }

    private void insertRecurs(BSTNode<T> node) {
        if (node == null)
            return;
        reinsert(node.element, root);
        insertRecurs(node.left);
        insertRecurs(node.right);
    }

    public boolean contains(T value) {
        return search(value, root, null) != null;
    }

    public Iterator<T> iterator() {
        return new Iter(this);
    }


    public Object[] BSTToArray() {
        Object[] list = new Object[numNodes];
        append(list, root, new Mutable<Integer>(0));
        return list;
    }

    private void append(Object[] list, BSTNode<T> node, Mutable<Integer> i) {
        if (node.left != null) {
            append(list, node.left, i);
        }
        list[i.get()] = (Object) node.element;
        i.set(i.get() + 1);
        if (node.right != null) {
            append(list, node.right, i);
        }
    }



    class Iter implements Iterator<T> {
        Object[] list;
        int currentIndex = 0;

        Iter(BinarySearchTree bst) {
            list = bst.BSTToArray();
        }

        @Override
        public boolean hasNext() {
            return list.length < currentIndex;
        }

        @Override
        public T next() {
            return (T) list[currentIndex++];
        }
    }

    class SearchResult {
        public SearchResult(BSTNode<T> node, BSTNode<T> parent) {
            this.node = node;
            this.parent = parent;
        }

        BSTNode<T> node, parent;
    }
}