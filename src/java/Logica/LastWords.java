package Logica;

public class LastWords {
    private ArrayQueue<String> queue;

    public LastWords() {
        queue = new ArrayQueue<String>();
    }

    public void addWord(String word) {
        if(queue.full())
            queue.dequeue();

        queue.enqueue(word);
    }

    public ArrayQueue<String> getArrayQueue() {
        return queue;
    }

    public void setArrayQueue(ArrayQueue queue) {
        this.queue = queue;
    }

}