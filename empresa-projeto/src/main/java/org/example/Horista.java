package org.example;

public class Horista extends Funcionario{
    private Integer qtdHora ;
    private Double valorHora;

    public Horista(String nome, String cpf, Integer qtdHora) {
        super(nome, cpf);
        this.qtdHora = qtdHora;
    }

    @Override
    public Double calcSalario() {
        return valorHora * qtdHora;
    }

    @Override
    public String toString() {
        return "Horista{" +
                "qtdHora=" + qtdHora +
                ", valorHora=" + valorHora +
                '}';
    }
}
