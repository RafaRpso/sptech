import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }

    public static int[][] criarMatriz() {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Digite o valor da posição [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }
        return matriz;
    }


    public static void exibirMatriz(int[][] matriz) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] somarMatrizes(int[][] matriz1, int[][] matriz2) {
        int[][] resultado = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                resultado[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        return resultado;
    }

    public static void somaDiagonais(int[][] matriz) {
        int somaDiagonalPrincipal = 0;
        int somaDiagonalSecundaria = 0;

        for (int i = 0; i < matriz.length; i++) {
            somaDiagonalPrincipal += matriz[i][i];
            somaDiagonalSecundaria += matriz[i][matriz.length - i - 1];
        }

        System.out.println("Soma diagonal principal: " + somaDiagonalPrincipal);
        System.out.println("Soma diagonal secundária: " + somaDiagonalSecundaria);
    }

    public static int[] totalPorColuna(int[][] matriz) {
        int[] total = new int[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                total[j] += matriz[i][j];
            }
        }
        return total;
    }

    public static boolean quadradoMagico(int[][] matriz) {
        int soma = 0;

        // Verifica a soma das linhas
        for (int i = 0; i < matriz.length; i++) {
            int somaLinha = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                somaLinha += matriz[i][j];
            }
            if (i == 0) {
                soma = somaLinha;
            } else {
                if (somaLinha != soma) {
                    return false;
                }
            }
        }

        // Verifica a soma das colunas
        for (int j = 0; j < matriz[0].length; j++) {
            int somaColuna = 0;
            for (int i = 0; i < matriz.length; i++) {
                somaColuna += matriz[i][j];
            }
            if (somaColuna != soma) {
                return false;
            }
        }

        // Verifica a soma das diagonais
        int somaDiagonalPrincipal = 0;
        int somaDiagonalSecundaria = 0;
        




    }