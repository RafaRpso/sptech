package org.example;

public class Main {
    public static void main(String[] args) {
        contagemRegressiva(5);
    }


    public static void contagemRegressiva(int n) {
        for (int i = n; i >= 0; i--) {
            System.out.println(i);
        }
    }

    public static void contagemRegressivaRecursiva(int n) {
        if (n == 0) {
            System.out.println(n);
        } else {
            System.out.println(n);
            contagemRegressivaRecursiva(n--);
        }
    }

    public static int fatorialRecursivo(int n) {
        if (n == 0) {
            return 1;
        }

        return n * fatorialRecursivo(n--);
    }

    public static void exibeVetor(int v[], int i) {
        if (i < v.length) {
            System.out.println(v[i]);

        }
        else {
            System.out.println(v[i]);
            exibeVetor(v, i++);

        }
    }

    public static void exibeVetorInvertido(int v[], int i ){
        if ( i >= 0 ) {
            System.out.println(v[i]);
            exibeVetorInvertido(v,i-- );
        }
        else{
            System.out.println(v[i]);

        }
    }
}