package org.example;

public abstract class Funcionario {
    private String cpf;
    private String nome;


    public Funcionario(String nome ,String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }



    public abstract Double calcSalario();
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
