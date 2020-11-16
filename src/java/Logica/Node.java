package Logica;

import java.io.Serializable;

public class Node<T> implements Serializable {
    public T value;
    public Node next;

    public Node(T value){
        this.value = value;
        this.next = null;
    }
}
