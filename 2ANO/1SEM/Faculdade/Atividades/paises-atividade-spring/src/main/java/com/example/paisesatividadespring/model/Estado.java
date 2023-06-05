package com.example.paisesatividadespring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity

public class Estado {
    public String nome ;
    public int populacaoLocal ;

    public int tamanhoTerritorio;
    public String capital ;
    public String governador ;
    public String sigla ;
    public String regiao ;
    @Id
    private Long id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPopulacaoLocal() {
        return populacaoLocal;
    }

    public void setPopulacaoLocal(int populacaoLocal) {
        this.populacaoLocal = populacaoLocal;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getGovernador() {
        return governador;
    }

    public void setGovernador(String governador) {
        this.governador = governador;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
