package org.example;

public class Engenheiro extends Funcionario {
    private Double salario;

    public Engenheiro(String nome, String cpf, Double salario) {
        super(nome, cpf);
        this.salario = salario;
    }


    public Double calcSalario(){
        return salario;
    };

    @Override
    public String toString() {
        return "Engenheiro{" +
                "salario=" + salario +
                '}';
    }
}
