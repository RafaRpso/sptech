package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Soma numeros: " + somaNumerosN(4));
        int[] vetor = {1, 2, 3, 4, 5};
        int numero = 1234;
        int x = 0;

        System.out.println("Soma dos números de 1 a 5: " + somaNumerosN(5));
        System.out.println("Soma dos elementos do vetor: " + somarElementosVetor(vetor, 0));
        System.out.println("Soma dos elementos pares do vetor: " + somarElementosParesVetor(vetor, 0));
        System.out.println("Soma dos elementos ímpares do vetor: " + somarElementosImparesVetor(vetor, 0));
        ocorrenciaVetor(vetor, x, 0);
        System.out.println("MDC de 12 e 8: " + mdcRecursivo(12, 8));
        System.out.println("Maior elemento do vetor: " + maiorElementoRecursivo(vetor, vetor.length - 1));
        System.out.println("Soma dos dígitos de 1234: " + somaDigitosRecursivo(numero));
        System.out.println("Representação binária de 12: " + binarioRecursivo(12));
    }

    //4  +3 = 7
    // 7 + 2 = 9
    // 9 + 1 = 10
    public static int somaNumerosN(int n) {
        if (n == 0) {
            return 0;
        }
        return n + somaNumerosN(n - 1);

    }

    public static int somarElementosVetor(int[] v, int i) {
        if (i >= v.length - 1) {
            return 0;
        } else {
            return v[i] + somarElementosVetor(v, ++i);
        }
    }

    public static int somarElementosParesVetor(int[] v, int i) {
        if (i >= v.length - 1) {
            return 0;
        }
        if (verificaPar(v[i])) {

            return v[i] + somarElementosParesVetor(v, ++i);
        }

        return somarElementosParesVetor(v, ++i);

    }

    public static int somarElementosImparesVetor(int[] v, int i) {
        if (i >= v.length - 1) {
            return 0;
        }
        if (!verificaPar(v[i])) {

            return v[i] + somarElementosParesVetor(v, ++i);
        }

        return somarElementosParesVetor(v, ++i);

    }

    public static int ocorrenciaVetor(int[] v, int x, int i) {

        if (i >= v.length) {
            return 0;
        }
        else{
            if(i == v.length-1  ) {
                return ocorrenciaVetor(v, ++x, ++i );
            }
            if( v[i] == v[++i]  ){

                return ocorrenciaVetor(v, ++x, ++i );
            }
            else{
                System.out.println("O número " + v[i] + " apareceu " +x );
                return ocorrenciaVetor(v, ++x, ++i );
            }
        }


    }
    public static int mdcRecursivo(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return mdcRecursivo(b, a % b);
        }
    }

    public static int maiorElementoRecursivo(int[] vetor, int indice) {
        if (indice == 0) {
            return vetor[0];
        } else {
            int maiorAnterior = maiorElementoRecursivo(vetor, indice - 1);
            if (vetor[indice] > maiorAnterior) {
                return vetor[indice];
            } else {
                return maiorAnterior;
            }
        }
    }


    public static int somaDigitosRecursivo(int numero) {
        if (numero == 0) {
            return 0;
        } else {
            int digito = numero % 10;
            return digito + somaDigitosRecursivo(numero / 10);
        }
    }


    public static String binarioRecursivo(int numero) {
        if (numero == 0) {
            return "";
        } else {
            int resto = numero % 2;
            return binarioRecursivo(numero / 2) + resto;
        }
    }



    public static Boolean verificaPar(int i) {
        return i % 2 == 0;
    }
}