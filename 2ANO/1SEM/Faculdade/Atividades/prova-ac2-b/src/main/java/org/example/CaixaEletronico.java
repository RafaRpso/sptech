package org.example;

public class CaixaEletronico {

    private int quantidadeNotasQuinhentos;
    private int quantidadeNotasDuzentos;
    private int quantidadeNotasCem;
    private int quantidadeNotasCinquenta;
    private int quantidadeNotasVinte;
    private int quantidadeNotasDez;
    private int quantidadeNotasCinco;
    private int quantidadeNotasUm;

    private Double[] mediaLinha = new Double[8];
    private Double[] mediaColuna = new Double[3];

    public int getQuantidadeNotasQuinhentos() {
        return quantidadeNotasQuinhentos;
    }

    public int getQuantidadeNotasDuzentos() {
        return quantidadeNotasDuzentos;
    }

    public int getQuantidadeNotasCem() {
        return quantidadeNotasCem;
    }

    public int getQuantidadeNotasCinquenta() {
        return quantidadeNotasCinquenta;
    }

    public int getQuantidadeNotasVinte() {
        return quantidadeNotasVinte;
    }

    public int getQuantidadeNotasDez() {
        return quantidadeNotasDez;
    }

    public int getQuantidadeNotasCinco() {
        return quantidadeNotasCinco;
    }

    public int getQuantidadeNotasUm() {
        return quantidadeNotasUm;
    }

    public void incrementaValor(int nota) {
        switch (nota) {
            case 500 -> setQuantidadeNotasQuinhentos(getQuantidadeNotasQuinhentos() + 1);
            case 200 -> setQuantidadeNotasDuzentos(getQuantidadeNotasDuzentos() + 1);
            case 100 -> setQuantidadeNotasCem(getQuantidadeNotasCem() + 1);
            case 50 -> setQuantidadeNotasCinquenta(getQuantidadeNotasCinquenta() + 1);
            case 20 -> setQuantidadeNotasVinte(getQuantidadeNotasVinte() + 1);
            case 10 -> setQuantidadeNotasDez(getQuantidadeNotasDez() + 1);
            case 5 -> setQuantidadeNotasCinco(getQuantidadeNotasCinco() + 1);
            case 1 -> setQuantidadeNotasUm(getQuantidadeNotasUm() + 1);
        }
    }

    public int getValorNota(int nota) {
        int valor = 0;
        switch (nota) {
            case 500 -> valor = getQuantidadeNotasQuinhentos();
            case 200 -> valor = getQuantidadeNotasDuzentos();
            case 100 -> valor = getQuantidadeNotasCem();
            case 50 -> valor = getQuantidadeNotasCinquenta();
            case 20 -> valor = getQuantidadeNotasVinte();
            case 10 -> valor = getQuantidadeNotasDez();
            case 5 -> valor = getQuantidadeNotasCinco();
            case 1 -> valor = getQuantidadeNotasUm();
            default -> {
                System.out.println("Valor de nota não existe");
                valor = -1;
            }
        }
        return valor;
    }

    public boolean validacoesSaque(int valor) {
        if (valor > 5000) {
            System.out.println("Não é possível sacar valores acima de 5000");
            return false;
        }

        return true;
    }

    public int[] getNotas() {
        return new int[]{500,200,100,50,20,10,5};
    }

    public void sacar(int valor) throws IllegalStateException  {
        int[] notas = getNotas();
        if (valor > 5000 || valor < 0 ) {
            throw new IllegalStateException("Valor maior que 5000 ou menor que 0 ");
        }
        sacarAux(valor, notas, 0);
    }

    private void sacarAux(int valor, int[] notas, int nota) {
        if (valor != 0 && nota < notas.length) {
            if (valor >= notas[nota]) {
                incrementaValor(notas[nota]);
                sacarAux(valor - notas[nota], notas, nota);
            } else {
                sacarAux(valor, notas, nota + 1);
            }
        }
    }


    /* Calcula a media das linhas e coloca as medias no vetor mediaLinha
       Calcula a media das colunas e coloca as medias no vetor mediaColuna
       Não esqueca de exibir na console o relatorio formatado conforme enunciado
    */
    public void exibeRelatorio(int[][] m) {
        int[] notas = getNotas();
        System.out.printf("%5s%5s%5s%5s%5s\\n", "CÉDULA", "ABRIL", "MAIO", "JUNHO", "MÉDIA");

        for (int i = 0; i < 3; i++) {
            mediaLinha[i] = calcMedia(m[i]);
        }
        for (int i = 0; i < notas.length; i++) {
            System.out.printf("%5s%5s%5s%5s%5s\\n", notas[i], m[i][0], m[i][1], m[i][2], mediaLinha[i]);

        }
        System.out.printf("%5s", "MÉDIA:");
        for (int i = 0; i < 3; i++) {
            mediaColuna[i] = calcMedia(m, i);
        }
        for (int i = 0; i < 3; i++) {
            System.out.printf("%5s", mediaColuna[i]);
        }
        ;

    }

    public double calcMedia(int[] m) {
        int sum = 0;
        for (int i : m) {
            sum += i;
        }
        return sum / m.length;

    }

    public double calcMedia(int[][] m, int index) {
        int sum = 0;
        for (int[] i : m) {
            sum += i[index];

        }
        return sum / getNotas().length;

    }

    public Double[] getMediaLinha() {
        return mediaLinha;
    }

    public Double[] getMediaColuna() {
        return mediaColuna;
    }

    public void setQuantidadeNotasQuinhentos(int quantidadeNotasQuinhentos) {
        this.quantidadeNotasQuinhentos = quantidadeNotasQuinhentos;
    }

    public void setQuantidadeNotasDuzentos(int quantidadeNotasDuzentos) {
        this.quantidadeNotasDuzentos = quantidadeNotasDuzentos;
    }

    public void setQuantidadeNotasCem(int quantidadeNotasCem) {
        this.quantidadeNotasCem = quantidadeNotasCem;
    }

    public void setQuantidadeNotasCinquenta(int quantidadeNotasCinquenta) {
        this.quantidadeNotasCinquenta = quantidadeNotasCinquenta;
    }

    public void setQuantidadeNotasVinte(int quantidadeNotasVinte) {
        this.quantidadeNotasVinte = quantidadeNotasVinte;
    }

    public void setQuantidadeNotasDez(int quantidadeNotasDez) {
        this.quantidadeNotasDez = quantidadeNotasDez;
    }

    public void setQuantidadeNotasCinco(int quantidadeNotasCinco) {
        this.quantidadeNotasCinco = quantidadeNotasCinco;
    }

    public void setQuantidadeNotasUm(int quantidadeNotasUm) {
        this.quantidadeNotasUm = quantidadeNotasUm;
    }
}
