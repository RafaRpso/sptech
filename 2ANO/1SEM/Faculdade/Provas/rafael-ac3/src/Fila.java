public class Fila<T> {
    private Object[] elements;
    private int size;
    private int capacity;
    private int front;
    private int rear;

    public Fila(int capacity) {
        this.elements = new Object[capacity];
        this.size = 0;
        this.capacity = capacity;
        this.front = 0;
        this.rear = -1;
    }

    public void enfileirar(T elemento) {
        if (size == capacity) {
            throw new IllegalStateException("A fila está cheia.");
        }
        rear = (rear + 1) % capacity;
        elements[rear] = elemento;
        size++;
    }

    public T desenfileirar() {
        if (size == 0) {
            throw new IllegalStateException("A fila está vazia.");
        }
        T elemento = (T) elements[front];
        elements[front] = null;
        front = (front + 1) % capacity;
        size--;
        return elemento;
    }

    public T frente() {
        if (size == 0) {
            throw new IllegalStateException("A fila está vazia.");
        }
        return (T) elements[front];
    }

    public boolean estaVazia() {
        return size == 0;
    }

    public int tamanho() {
        return size;
    }
}
