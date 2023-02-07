package org.example;

public class Vendedor extends Funcionario{
    private Integer  vendas ;
    private Double taxas ;

    public Vendedor(String nome, String cpf, Integer vendas, Double taxas) {
        super(nome, cpf);
        this.vendas = vendas;
        this.taxas = taxas;
    }

    @Override
    public Double calcSalario() {
        return vendas * taxas;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "vendas=" + vendas +
                ", taxas=" + taxas +
                '}';
    }

}
