package Logica;

public class ArrayQueue <T> {
    public final int N = 10;
    public int front;
    public int rear;
    public int count;
    public T[] qarray;

    public ArrayQueue() {
        front = rear = count = 0;
        qarray = (T[]) new Object[N];
    }

    public T dequeue() {
        T item = null;
        if(empty())
            throw new RuntimeException("Cola vacia: item no desencolado");

        item = qarray[front];
        front = (front + 1) % N;
        count--;

        return item;
    }

    public void enqueue(T item) {
        if(full())
            throw new RuntimeException("Cola llena: item no encolado");

        qarray[rear] = item;
        rear = (rear + 1) % N;
        count++;

    }

    public boolean full() {
        return count >= N;
    }

    public boolean empty() {
        return count <= 0;
    }

    public T peek() {
        return qarray[front];
    }

    @Override
    public String toString() {
        if(empty())
            return("Frente -> []");

        StringBuilder string = new StringBuilder();

        string.append("Frente -> [" + qarray[front]);
        int j = (front + 1) % N;
        for(int i = 0; i < count - 1; i++, j = (j + 1) % N){
            string.append(", " + qarray[j]);
        }

        string.append("]");

        return string.toString();
    }
}