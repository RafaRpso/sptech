package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListaEstaticaTest {

    @Test
    public void adicionaNoIndiceAlteraNroElem() {
        ListaEstatica listaEstatica = new ListaEstatica(3);

        listaEstatica.adiciona(1);
        listaEstatica.adiciona(2);
        listaEstatica.adicionaNoMeio(3);

        assertEquals(3, listaEstatica.getNroElem());
    }

    @Test
    public void adicionaNoMeio1() {
        ListaEstatica listaEstatica = new ListaEstatica(3);

        listaEstatica.adiciona(10);
        listaEstatica.adicionaNoMeio(300);

        assertEquals(300, listaEstatica.getVetor()[0]);
        assertEquals(10, listaEstatica.getVetor()[1]);
    }

    @Test
    public void adicionaNoMeio2() {
        ListaEstatica listaEstatica = new ListaEstatica(5);

        listaEstatica.adiciona(1);
        listaEstatica.adiciona(2);
        listaEstatica.adiciona(3);
        listaEstatica.adiciona(4);

        listaEstatica.adicionaNoMeio(500);

        assertEquals(1, listaEstatica.getVetor()[0]);
        assertEquals(2, listaEstatica.getVetor()[1]);
        assertEquals(500, listaEstatica.getVetor()[2]);
        assertEquals(3, listaEstatica.getVetor()[3]);
        assertEquals(4, listaEstatica.getVetor()[4]);
    }

    @Test
    public void adicionaNoMeio3() {
        ListaEstatica listaEstatica = new ListaEstatica(4);

        listaEstatica.adiciona(1);
        listaEstatica.adiciona(2);
        listaEstatica.adiciona(3);

        listaEstatica.adicionaNoMeio(100);

        assertEquals(1, listaEstatica.getVetor()[0]);
        assertEquals(100, listaEstatica.getVetor()[1]);
        assertEquals(2, listaEstatica.getVetor()[2]);
        assertEquals(3, listaEstatica.getVetor()[3]);
    }

    @Test
    public void adicionaNoMeioListaCheia() {
        ListaEstatica listaEstatica = new ListaEstatica(3);
        listaEstatica.adiciona(1);
        listaEstatica.adiciona(2);
        listaEstatica.adiciona(3);
        assertThrows(IllegalStateException.class, () -> listaEstatica.adicionaNoMeio(4));
    }

    @Test
    public void adicionaNoMeioListaVazia() {
        ListaEstatica listaEstatica = new ListaEstatica(4);
        assertThrows(IllegalStateException.class, () -> listaEstatica.adicionaNoMeio(10));
    }

    @Test
    public void listaParaMatrizQtdadeMenor() {
        ListaEstatica listaEstatica = new ListaEstatica(4);
        int[][] matriz = new int[2][2];
        listaEstatica.adiciona(1);
        listaEstatica.adiciona(2);
        listaEstatica.adiciona(3);
        assertThrows(IllegalArgumentException.class, () -> listaEstatica.listaParaMatriz(matriz));
    }

    public void listaParaMatrizQtdadeMaior() {
        ListaEstatica listaEstatica = new ListaEstatica(6);
        int[][] matriz = new int[2][2];
        listaEstatica.adiciona(1);
        listaEstatica.adiciona(2);
        listaEstatica.adiciona(3);
        listaEstatica.adiciona(4);
        listaEstatica.adiciona(5);

        assertThrows(IllegalArgumentException.class, () -> listaEstatica.listaParaMatriz(matriz));
    }

    public void listaParaMatrizVerificaValor() {
        ListaEstatica listaEstatica = new ListaEstatica(4);
        int[][] matriz = new int[2][2];

        listaEstatica.adiciona(1);
        listaEstatica.adiciona(2);
        listaEstatica.adiciona(3);
        listaEstatica.adiciona(4);

        assertEquals(1, matriz[0][0]);
        assertEquals(2, matriz[0][1]);
        assertEquals(3, matriz[1][0]);
        assertEquals(4, matriz[1][1]);

    }

}
