package com.example.paisesatividadespring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Pais {
    @Id
    private long id ;
    private String nome;
    private String capital;
    private String continente;

    private double tamanhoTerritorio;

    @OneToMany
    private List<Estado> estados;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public double getTamanhoTerritorio() {
        return tamanhoTerritorio;
    }

    public void setTamanhoTerritorio(double tamanhoTerritorio) {
        this.tamanhoTerritorio = tamanhoTerritorio;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

}
