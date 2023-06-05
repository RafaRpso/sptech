package org.example;

public class FilaCircular {
    int tamanho, inicio, fim;
    String[] fila;

    // Construtor - Recebe a capacidade da fila (tamanho total do vetor)
    public FilaCircular(int capacidade) {
        fila = new String[capacidade] ;
        tamanho = 0 ;
        inicio = 0 ;
        fim = 0 ;

    }

    // Método isEmpty() - Retorna true se a fila está vazia e false caso contrário
    public boolean isEmpty() {
        return tamanho==0;
    }

    // Método isFull() - Retorna true se a fila está cheia e false caso contrário
    public boolean isFull() {
        return tamanho == fila.length;
    }

    // Método insert - Recebe informação a ser inserida na fila
    public void insert(String info) {
        if(!isFull()) {
            fila[fim] = info ;
            fim = (fim + 1) % fila.length;
            tamanho++;

        }

    }

    // Método peek() - Retorna o primeiro da fila, sem remover
    public String peek() {
        if(isFull()) {
            return fila[inicio] ;
        }
        return null;
    }

    // Método poll() - Retorna o primeiro da fila, removendo-o
    public String poll() {
        if(isFull()) {
            String aux = fila[inicio];
            fila[inicio] = null;
            inicio = (inicio + 1) % fila.length;
            tamanho--;
            return aux;

        }
        return null;
    }

    // Método exibe() - exibe os elementos da fila
    public void exibe() {
        for(int i=0; i<tamanho; i++) {
            System.out.println(fila[i]);
        }
    }

    public int getTamanho() {
        return 0;
    }

    public int getInicio() {
        return 0;
    }

    public int getFim() {
        return 0;
    }

    public String[] getFila(){
        String[] arr = new String[tamanho];
        for(int i=0; i<tamanho; i++) {
            arr[i] = fila[(inicio + i) % fila.length];
        }
        return null;
    }
}

