public class ListaObj<T> {
    private int nroElem;
    private int max;
    private T[] lista;

    public ListaObj(int max) {
        this.max = max;
        lista = (T[]) new Object[max];
        nroElem = 0;
    }

    public void adicionar(T valor) {
        if (nroElem == max) {
            throw new IllegalStateException("Lista cheia");
        }

        lista[nroElem] = valor;
        nroElem++;
    }

    public void adicionarNoIndice(T valor, int indice) {
        if (indice < 0 || indice > nroElem) {
            System.out.println("Índice inválido");
            return;
        }

        if (nroElem == max) {
            throw new IllegalStateException("Lista cheia");
        }

        for (int i = nroElem; i > indice; i--) {
            lista[i] = lista[i - 1];
        }

        lista[indice] = valor;
        nroElem++;
    }

    public T remover(int indice) {
        if (indice < 0 || indice >= nroElem) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        T valorRemovido = lista[indice];

        for (int i = indice; i < nroElem - 1; i++) {
            lista[i] = lista[i + 1];
        }

        lista[nroElem - 1] = null;
        nroElem--;

        return valorRemovido;
    }

    public int tamanho() {
        return nroElem;
    }

    public T obter(int indice) {
        if (indice < 0 || indice >= nroElem) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }
        return lista[indice];
    }
}
