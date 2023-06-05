public class Pilha<T> {
    private Object[] elements;
    private int size;
    private int capacity;

    public Pilha(int capacity) {
        this.elements = new Object[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public void empilhar(T elemento) {
        if (size == capacity) {
            throw new IllegalStateException("A pilha está cheia.");
        }
        elements[size] = elemento;
        size++;
    }

    public T desempilhar() {
        if (size == 0) {
            throw new IllegalStateException("A pilha está vazia.");
        }
        size--;
        T elemento = (T) elements[size];
        elements[size] = null;
        return elemento;
    }

    public T topo() {
        if (size == 0) {
            throw new IllegalStateException("A pilha está vazia.");
        }
        return (T) elements[size - 1];
    }

    public boolean estaVazia() {
        return size == 0;
    }

    public int tamanho() {
        return size;
    }
}
