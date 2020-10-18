package Logica;

public class SimplyLinkedList<T> {

    Node<T> first;
    Integer length;

    public SimplyLinkedList() {
        this.length = 0;
        this.first = null;
    }
    
    void insert(T value) {
        if (this.length == 0) {
            this.first = new Node(value);
            this.length++;
            return;
        }
        Node<T> aux = this.first;
        while (aux.next != null) {
            aux = aux.next;
        }
        aux.next = new Node(value);
        this.length++;
    }
    
        public T getK(Integer index) {
        if(index<=0){
            return null;
        }else if (index == 0) {
            return this.first.value;
        } else if (index >= length) {
            System.out.println("El índice es mayor al tamaño de la lista");
            return null;
        } else {
            Node<T> aux = this.first;
            for (int i = 1; i < index; i++) {
                aux = aux.next;
            }
            return aux.value;
        }
    }
        
    void delete(T value) {
        if (this.first == null) { //En caso de una lista vacía
            System.out.println("No puedo eliminar en una lista vacia");

        } else {
            Node<T> aux = this.first;
            while (aux.next.value != value) {
                if (aux.next == null) {
                    System.out.println("El elemento no se encuentra en la lista");
                    return;
                }
                aux = aux.next;
            }
            aux.next = aux.next.next;
            this.length--;
        }
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> aux = this.first;
        while (aux.next != null){
            sb.append(aux.value).append(", ");
            aux = aux.next;
        }
        sb.append(aux.value);
        sb.append("]");
        return sb.toString();
    }
    boolean isEmpty() {
        return this.length == 0;
    }

    Integer length() {
        return this.length;
    }
    
}
