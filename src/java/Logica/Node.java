package Logica;

import java.io.Serializable;

public class Node implements Serializable {
    public User value;
    public Node next;

    public Node(User value){
        this.value = value;
        this.next = null;
    }
}
