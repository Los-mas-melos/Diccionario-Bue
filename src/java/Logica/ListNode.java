package Logica;

import java.io.Serializable;

public class ListNode implements Serializable {
    public User value;
    public ListNode next;

    public ListNode(User value){
        this.value = value;
        this.next = null;
    }
}
