package Logica;

import java.io.Serializable;

public class SimplyLinkedList implements Serializable {

    public ListNode first;
    protected int length;

    public SimplyLinkedList() {
        this.length = 0;
        this.first = null;
    }
    
    public void insert(User value) {
        if (this.length == 0) {
            this.first = new ListNode(value);
            this.length++;
            return;
        }
        ListNode aux = this.first;
        while (aux.next != null) {
            aux = aux.next;
        }
        aux.next = new ListNode(value);
        this.length++;
    }
    
        public User getK(Integer index) {
        if(index<=0){
            return null;
        }else if (index == 0) {
            return this.first.value;
        } else if (index >= length) {
            System.out.println("El índice es mayor al tamaño de la lista");
            return null;
        } else {
            ListNode aux = this.first;
            for (int i = 1; i < index; i++) {
                aux = aux.next;
            }
            return aux.value;
        }
    }
    
    public void deleteFirst() {
        if (this.length != 0) {
            this.first = this.first.next;
            this.length--;
        } else {
            System.out.println("La lista está vacía.");
        }
    }
        
    public void deleteByMail(String mail) {
        if (this.first == null) {
            System.out.println("La lista está vacía.");
        } else if (this.first.value.getMail().equals(mail)) {
            this.deleteFirst();
        } else {
            ListNode aux = this.first;
            while (!aux.next.value.getMail().equals(mail)) {
                if (aux.next == null) {
                    System.out.println("El elemento no existe dentro de la lista.");
                    return;
                }
                aux = aux.next;
            }
            aux.next = aux.next.next;
            this.length--;
        }
    }
    
    public ListNode getByMail(String mail) {
       ListNode aux = this.first;
       if (this.length == 0) {
           System.out.println("Lista vacía.");
           return null;
       } else if (this.first.value.getMail().equals(mail)) {
           return this.first;
       } else {
           while (aux.next != null) {
               aux = aux.next;
               if(aux.value.getMail().equals(mail)){
                   return aux;
               }
           }
       }
       return aux;
   }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode aux = this.first;
        while (aux.next != null){
            sb.append(aux.value).append(", ");
            aux = aux.next;
        }
        sb.append(aux.value);
        sb.append("]");
        return sb.toString();
    }
    public boolean isEmpty() {
        return this.length == 0;
    }

    public int length() {
        return this.length;
    }
    
}
