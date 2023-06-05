public class FilaObj<T> {
    private int tamanho;
    private int frente;
    private int tras;
    private T[] fila;

    public FilaObj(int capacidade) {
        fila = (T[]) new Object[capacidade];
        tamanho = 0;
        frente = 0;
        tras = -1;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public boolean isFull() {
        return tamanho == fila.length;
    }

    public void enqueue(T item) {
        if (isFull()) {
            throw new IllegalStateException("A fila está cheia");
        }
        fila[++tras] = item;
        tamanho++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }
        T elemento = fila[frente];
        fila[frente++] = null;
        frente = frente % fila.length;
        tamanho--;
        return elemento;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getFrente() {
        return frente;
    }

    public void setFrente(int frente) {
        this.frente = frente;
    }

    public int getTras() {
        return tras;
    }

    public void setTras(int tras) {
        this.tras = tras;
    }

    public T[] getFila() {
        return fila;
    }

    public void setFila(T[] fila) {
        this.fila = fila;
    }
}
