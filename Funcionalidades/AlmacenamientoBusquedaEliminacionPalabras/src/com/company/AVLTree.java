package com.company;

import Prototipo2.Exceptions.FoundWordException;
import Prototipo2.Exceptions.NotFoundWordException;
import Prototipo2.StorageWords;

public class AVLTree <T extends Comparable<T>> implements StorageWords<T>
{
    private Node<T> root;

    public AVLTree()
    {
        root = null;
    }

    public void insert(T item) throws FoundWordException {
        root = insertAVL(item,root);
    }

    private Node<T> insertAVL(T item, Node<T> p) throws FoundWordException {
        if(p == null)
            p = new Node<T>(item);
        else
        if(item.compareTo(p.getData()) <= -1)
            p.setLeft(insertAVL(item,p.getLeft()));
        else
        if(item.compareTo(p.getData()) >= 1)
            p.setRight(insertAVL(item,p.getRight()));
        else
            throw new FoundWordException();
        return balance(p);
    }

    public void remove(T item) throws NotFoundWordException {
        root = removeAVL(item,root);
    }

    private Node<T> removeAVL(T item, Node<T> p) throws NotFoundWordException {
        if(p != null)
            if(item.compareTo(p.getData()) <= -1)
                p.setLeft(removeAVL(item,p.getLeft()));
            else
            if(item.compareTo(p.getData()) >= 1)
                p.setRight(removeAVL(item,p.getRight()));
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
                p.setRight(removeAVL(p.getData(),p.getRight()));
            }
        else
            throw new NotFoundWordException();
        return balance(p);
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

    public void removeAll()
    {
        root = null;
    }

//***********************************************************************************************************************

    public int height(Node<T> node)
    {
        return node == null? -1: node.getHeight();
    }

    public void reHeight(Node<T> node)
    {
        node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
    }

    public int getHeight(Node<T> node)
    {
        return node == null? 0: node.getHeight() + 1;
    }

    public int getFactorBalance(Node<T> node)
    {
        return getHeight(node.getRight()) - getHeight(node.getLeft());
    }

    public Node<T> balance(Node<T> node)
    {
        if(node == null) return null;
        reHeight(node);
        int factorBalance = getFactorBalance(node);
        if(factorBalance >= 2)
            if(getFactorBalance(node.getRight()) >= 0)
                node = rotateL(node);
            else
            {
                node.setRight(rotateR(node.getRight()));
                node = rotateL(node);
            }
        if(factorBalance <= -2)
            if(getFactorBalance(node.getLeft()) <= 0)
                node = rotateR(node);
            else
            {
                node.setLeft(rotateL(node.getLeft()));
                node = rotateR(node);
            }
        return node;
    }

    public Node<T> rotateL(Node<T> node)
    {
        Node<T> nodeRL = (node.getRight()).getLeft();
        Node<T> nodeR = node.getRight();
        nodeR.setLeft(node);
        node.setRight(nodeRL);
        reHeight(node);
        reHeight(nodeR);
        return nodeR;
    }

    public Node<T> rotateR(Node<T> node)
    {
        Node<T> nodeLR = (node.getLeft()).getRight();
        Node<T> nodeL = node.getLeft();
        nodeL.setRight(node);
        node.setLeft(nodeLR);
        reHeight(node);
        reHeight(nodeL);
        return nodeL;
    }

    //***********************************************************************************************************************

    public void traverseAVL() {
        System.out.print("Inorder:");
        if(root != null)
            traverse(root);
        else
            throw new RuntimeException("Tree is Empty");
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
        System.out.print("Prefix:");
        if(root != null)
            traversePreFix(root);
        else
            throw new RuntimeException("Tree is Empty");
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

    public void traversePosFixAVL()
    {
        System.out.print("Posfix:");
        if(root != null)
            traversePosFix(root);
        else
            throw new RuntimeException("Tree is Empty");
        System.out.println();
    }

    private void traversePosFix(Node<T> p)
    {
        if(p.getLeft() != null)
            traversePosFix(p.getLeft());

        if(p.getRight() != null)
            traversePosFix(p.getRight());

        System.out.print(" " + p.getData());
    }

    private Node<T> findMin(Node<T> p) {
        if(p != null)
            while(p.getLeft() != null)
                p = p.getLeft();
        return p;
    }

    public void findMaxBST()
    {
        System.out.println("Max: " + findMax(root).getData());
    }

    private Node<T> findMax(Node<T> ptr)
    {
        if(ptr.getRight() == null)
            return ptr;
        return findMax(ptr.getRight());
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

}
