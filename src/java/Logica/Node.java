package Logica;

public class Node <T>
{
    private T data;
    private int height;
    private Node<T> left;
    private Node<T> right;

    public Node(T data)
    {
        this.data = data;
        left = right = null;
        height = 0;
    }

    public Node(T data, Node<T> left, Node<T> right) {
        super();
        this.data = data;
        this.left = left;
        this.right = right;
        if (left == null && right == null)
            setHeight(1);
        else if (left == null)
            setHeight(right.getHeight() + 1);
        else if (right == null)
            setHeight(left.getHeight() + 1);
        else
            setHeight(Math.max(left.getHeight(), right.getHeight()) + 1);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }
}