package com.example.paisesatividadespring.repository;

import com.example.paisesatividadespring.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaisRepository extends JpaRepository<Pais, Long> {
    @Query("SELECT COUNT(*) FROM Pais")
    int countPaises();

    @Query("")
    int getAllPopulacaoFromEstados();

    @Query("SELECT SUM(tamanhoTerritorio) FROM Pais")
    int getTamanhoMundial();



    @Query("SELECT SUM(tamanhoTerritorio) FROM Pais WHERE continente = 'América do Sul'")
    int getTamanhoAmericaSul();

}
