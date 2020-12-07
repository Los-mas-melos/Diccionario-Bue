package Logica;

import Logica.Exceptions.*;
import java.io.Serializable;

public class BinarySearchTree <T extends Comparable<T>> implements StorageWords<T>, Serializable {

    private Node<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(T item) throws FoundWordException {
        root = insertBST(item,root);
    }

    private Node<T> insertBST(T item, Node<T> p) throws FoundWordException {
        if(p == null)
            p = new Node<T>(item);
        else
        if(item.compareTo(p.getData()) <= -1)
            p.setLeft(insertBST(item,p.getLeft()));
        else
        if(item.compareTo(p.getData()) >= 1)
            p.setRight(insertBST(item,p.getRight()));
        else
            throw new FoundWordException();
        return p;
    }
    public void remove(T item) throws NotFoundWordException {
        root = removeBST(item,root);
    }
    private Node<T> removeBST(T item, Node<T> p) throws NotFoundWordException {
        if(p != null)
            if(item.compareTo(p.getData()) <= -1)
                p.setLeft(removeBST(item,p.getLeft()));
            else
            if(item.compareTo(p.getData()) >= 1)
                p.setRight(removeBST(item,p.getRight()));
            else
            if(p.getLeft() == null && p.getRight() == null)
                p = null;
            else
            if(p.getLeft() == null)
                p = p.getRight();
            else
            if(p.getRight() == null)
                p = p.getLeft();
            else {
                Node<T> t = findMin(p.getRight());
                p.setData(t.getData());
                p.setRight(removeBST(p.getData(),p.getRight()));
            }
        else
            throw new NotFoundWordException();
        return p;
    }

    public Node<T> search(T value) throws NotFoundWordException {
        return searchAVL(value, root);
    }

    private Node<T> searchAVL(T value, Node<T> node) throws NotFoundWordException {
        if(node != null)
            if(node.getData().compareTo(value) <= -1)
                return searchAVL(value, node.getRight());
            else if(node.getData().compareTo(value) >= 1)
                return searchAVL(value, node.getLeft());
            else return node;
        else throw new NotFoundWordException();
    }

    public void removeAll() {
        root = null;
    }

    private Node findMin(Node p) {
        if(p != null)
            while(p.getLeft() != null)
                p = p.getLeft();
        return p;
    }

    public void traverseBST() {
        System.out.print("The tree is in inorder:");
        if(root != null)
            traverse(root);
        else
            System.out.print(" " + "Empty");
        System.out.println();
    }
    private void traverse(Node<T> ptr) {
        if(ptr.getLeft() != null)
            traverse(ptr.getLeft());
        System.out.print(" " + ptr.getData());
        if(ptr.getRight() != null)
            traverse(ptr.getRight());
    }

    public void traversePreFixAVL()
    {
        System.out.print("The tree is in prefix:");
        if(root != null)
            traversePreFix(root);
        else
            System.out.print("Tree is Empty");
        System.out.println();
    }

    private void traversePreFix(Node<T> p)
    {
        System.out.print(" " + p.getData());
        if(p.getLeft() != null)
            traversePreFix(p.getLeft());

        if(p.getRight() != null)
            traversePreFix(p.getRight());
    }

    public void traversePosFixBST()
    {
        System.out.print("The tree is in posfix:");
        if(root != null)
            traversePosFix(root);
        else
            System.out.print("Tree is Empty");
    }

    private void traversePosFix(Node<T> p)
    {
        if(p.getLeft() != null)
            traversePosFix(p.getLeft());

        if(p.getRight() != null)
            traversePosFix(p.getRight());

        System.out.print(" " + p.getData());
    }

    public void findMaxBST()
    {
        System.out.println("Max: " + findMax(root).getData());
    }

    private Node findMax(Node<T> ptr)
    {
        if(ptr.getRight() == null)
            return ptr;
        return findMax(ptr.getRight());
    }
}


