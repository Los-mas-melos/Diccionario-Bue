package Logica;

public class SimplyLinkedList<T> extends List<T> {

    Node<T> first;
    Integer length;

    public SimplyLinkedList() {
        this.length = 0;
        this.first = null;
    }
    @Override
    void insert(T value) {
        if (this.length == 0) {
            this.first = new Node<T>(value);
            this.length++;
            return;
        }
        Node<T> aux = this.first;
        while (aux.next != null) {
            aux = aux.next;
        }
        aux.next = new Node<T>(value);
        this.length++;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> aux = this.first;
        while (aux.next != null){
            sb.append(aux.value + ", ");
            aux = aux.next;
        }
        sb.append(aux.value);
        sb.append("]");
        return sb.toString();
    }
    
}
