package org.example;

public class ListaEstatica {

    // 01) Declarar vetor de int:
    // É inicializado no construtor
    private int[] vetor;

    // 02) Criar atributo nroElem:
    // Tem dupla função: representa quantos elementos foram adicionados no vetor
    // Também o índice de onde será adicionado o próximo elemento
    private int nroElem;

    // 03) Criar Construtor:
    // Recebe como argumento o tamanho máximo do vetor
    // Cria vetor com tamanho máximo informado
    // Inicializa nroElem
    public ListaEstatica(int capacidade) {
        vetor = new int[capacidade];
        nroElem = 0;
    }

    // 04) Método adiciona:
    // Recebe o elemento a ser adicionado na lista
    // Se a lista estiver cheia usar IllegalStateException();
    public void adiciona (int elemento) {
        if (nroElem >= vetor.length) {    // Lista está cheia
            throw new IllegalStateException();
        }
        else {
            vetor[nroElem++] = elemento;
        }
    }

    // 05) Método busca:
    // Recebe o elemento a ser procurado na lista
    // Retorna o índice do elemento, se for encontrado
    // Retorna -1 se não encontrou
    public int busca(int elemento) {
        for(int i = 0; i < nroElem; i++) {
            if (vetor[i] == elemento) {
                return i;
            }
        }
        return -1;
    }

    // 06) Método removePeloIndice:
    // Recebe o índice do elemento a ser removido
    // Se o índice for inválido, retorna false
    // Se removeu, retorna true
    public boolean removePeloIndice(int indice) {
        if (indice < 0 || indice >= nroElem) {
            return false;
        }
        else {
            for (int i = indice; i < nroElem-1; i++) {
                vetor[i] = vetor[i+1];
            }
            // o for abaixo equivale ao de cima
//            for (int i = indice+1; i < nroElem; i++) {
//                vetor[i-1] = vetor[i];
//            }
            nroElem--;
            return true;
        }
    }

    // 07) Método removeElemento
    // Recebe um elemento a ser removido
    // Utiliza os métodos busca e removePeloIndice
    // Retorna false, se não encontrou o elemento
    // Retorna true, se encontrou e removeu o elemento
    public boolean removeElemento(int elemento) {
        return removePeloIndice(busca(elemento));
    }

    // 08 Método exibe:
    // Exibe os elementos da lista
    public void exibe() {
        if (nroElem == 0) {
            System.out.println("Lista vazia!");
        }
        else {
            for (int i = 0; i < nroElem; i++) {
                System.out.println(vetor[i]);
            }
        }
    }


    //Métodos getVetor e getNroElem
    //São usados nos testes
    public int getNroElem() {
        return nroElem;
    }

    public int[] getVetor() {
        return vetor;
    }

    /* Método adicionaNoMeio - recebe o novo elemento a ser inserido
       Se a lista estiver cheia ou vazia, lança uma exceção IllegalStateException.
       O meio da lista é o indice corrrespondente a nroElem / 2
       Para inserir o elemento novo, deve-se deslocar os elementos
       para "abrir o espaço" para inserir o novo elemento.
       Incrementa o nroElem
       Ex: se a lista tiver 10, 20, 30, 40
       Entao nroElem = 4 e o meio é nroElem / 2 = 2
       Se chamar adicionaNoMeio(500), após a execução desse método, a lista
       ficará 10, 20, 500, 30, 40
     */

    public void adicionaNoMeio(int num) throws IllegalStateException {
        if (nroElem == 0 || nroElem == vetor.length) {
            throw new IllegalStateException("Lista cheia ou vazia");
        }
        int meio = nroElem / 2;
        for (int i = nroElem; i > meio; i--) {
            vetor[i] = vetor[i - 1];
        }
        vetor[meio] = num;
        nroElem++;
    }

    /* Método listaParaMatriz - recebe uma matriz regular de inteiros
       Obs: matriz regular é uma matriz que tem a mesma qtd de colunas em cada linha
       Copia os valores do lista (vetor) para a matriz
       Se a quantidade de valores da lista for menor ou maior do que
       a quantidade de valores que cabe na matriz, lança exceção de IllegalArgumentException
       Os valores devem ser copiados preenchendo as linhas.
       Por exemplo, se a lista tiver os valores 10, 20, 30, 40
       E for chamado listaParaMatriz(matriz), sendo matriz 2 x 2
       A matriz terá os valores
       10  20
       30  40
     */

    public void listaParaMatriz(int[][] m) throws  IllegalStateException {
        if (vetor.length > m.length ) {
            throw new IllegalStateException("Lista cheia ou vazia");
        }


        for(int i =0 ; i < vetor.length/2 ; i++) {
            for(int j =0 ;j<vetor.length/2 ; j++) {
                m[i][j] = vetor[j];
            }
        }

    }

}
