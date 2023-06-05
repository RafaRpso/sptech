package org.example;

import java.util.Arrays;
public class ListaEstatica {
    private int[] vetor;
    private int nroElem;

    public ListaEstatica(int tamanho) {
        vetor = new int[tamanho];
        nroElem = 0;
    }

    public void adiciona(int elemento) {
        if (nroElem == vetor.length) {
            throw new IllegalStateException("Lista cheia");

        }
        vetor[nroElem] = elemento;
        nroElem++;
    }

    public void exibe() {
        for(int i = 0; i < nroElem; i++) {
            System.out.println(vetor[i]);
        }
    }

    public int busca(int elemento) {
        for(int i = 0; i < nroElem; i++) {
            if(vetor[i] == elemento) {
                return i;
            }
        }
        return -1;
    }

    public boolean removePeloIndice(int indice) {
        if(indice < 0 || indice >= nroElem) {
            return false;
        }
        for(int i = indice; i < nroElem - 1; i++) {
            vetor[i] = vetor[i+1];
        }
        nroElem--;
        return true;
    }

    public boolean removeElemento(int elemento) {
        int indice = busca(elemento);
        if(indice != -1) {
            return removePeloIndice(indice);
        }
        return false;
    }
    public boolean substitui(int antigo, int novo) {
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i] == antigo) {
                vetor[i] = novo;
                return true;
            }
        }
        System.out.println("Valor não encontrado");
        return false;
    }

    public int contaOcorrencias(int valor) {
        int ocorrencias = 0;
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i] == valor) {
                ocorrencias++;
            }
        }
        return ocorrencias;
    }

    public boolean adicionaNoInicio(int valor) {
        if (nroElem >= vetor.length) {
            System.out.println("Lista cheia");
            return false;
        }
        for (int i = nroElem - 1; i >= 0; i--) {
            vetor[i + 1] = vetor[i];
        }
        vetor[0] = valor;
        nroElem++;
        return true;
    }

    public int[] getVetor() {
        return vetor;
    }

    public void setVetor(int[] vetor) {
        this.vetor = vetor;
    }

    public int getNroElem() {
        return nroElem;
    }

    public void setNroElem(int nroElem) {
        this.nroElem = nroElem;
    }
}
