
package Logica;

public class DoubleDataNodeList {


    public DoubleDataNode first;
    protected int length;

    public DoubleDataNodeList() {
        this.length = 0;
        this.first = null;
    }
    
    public void insert(String bue, String esp) {
        if (this.length == 0) {
            this.first = new DoubleDataNode(bue, esp);
            this.length++;
            return;
        }
        DoubleDataNode aux = this.first;
        while (aux.next != null) {
            aux = aux.next;
        }
        aux.next = new DoubleDataNode(bue, esp);
        this.length++;
    }
    
    public void deleteFirst() {
        if (this.length != 0) {
            this.first = this.first.next;
            this.length--;
        } else {
            System.out.println("La lista está vacía.");
        }
    }
        
    public void deleteByBue(String bue) {
        if (this.first == null) {
            System.out.println("La lista está vacía.");
        } else if (this.first.bue.equals(bue)) {
            this.deleteFirst();
        } else {
            DoubleDataNode aux = this.first;
            while (!aux.next.bue.equals(bue)) {
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
    
    public DoubleDataNode getByBue(String bue) {
       DoubleDataNode aux = this.first;
       if (this.length == 0) {
           System.out.println("Lista vacía.");
           return null;
       } else if (this.first.bue.equals(bue)) {
           return this.first;
       } else {
           while (aux.next != null) {
               aux = aux.next;
               if(aux.bue.equals(bue)){
                   return aux;
               }
           }
       }
       return aux;
   }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public int length() {
        return this.length;
    }
    
    
}
