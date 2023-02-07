package org.example;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Funcionario> funcionario;
    // Construtor
    public Empresa() {
        funcionario = new ArrayList();
    }
    public void adicionaFunc(Funcionario f) {
        funcionario.add(f);
    }

    public void exibeTodos() {
        for (Funcionario i : funcionario) {
            System.out.println(i);
        }
    }

    public void exibeTotalSalario() {
        Double totalSalario=0.0;
        for (Funcionario i : funcionario) {
            if (i instanceof Engenheiro) {
                totalSalario += i.calcSalario();
            }
        }
        System.out.println("Total Salário: " + totalSalario);
    }

    public void exibeHoristas(){
        for(Funcionario i : funcionario) {
            if( i instanceof Horista){
                System.out.println(i.getNome());
            }
        }
    }


}