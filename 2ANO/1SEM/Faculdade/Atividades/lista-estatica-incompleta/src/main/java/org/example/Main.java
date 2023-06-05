package org.example;

public class Main {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(5);
        lista.adiciona(10);
        lista.adiciona(20);
        lista.adiciona(30);
        lista.adiciona(40);
        lista.adiciona(50);

        System.out.println(lista.substitui(30, 35)); // true
        System.out.println(lista.substitui(25, 35)); // false

        System.out.println(lista.contaOcorrencias(35)); // 1
        System.out.println(lista.contaOcorrencias(25)); // 0

        lista.adicionaNoInicio(60);

        for (int i = 0; i < lista.getNroElem(); i++) {
            System.out.println(lista.getVetor()[i]);
        }
    }
}