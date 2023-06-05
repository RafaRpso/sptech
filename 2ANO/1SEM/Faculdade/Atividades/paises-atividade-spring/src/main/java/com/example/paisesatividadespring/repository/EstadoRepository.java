package com.example.paisesatividadespring.repository;

import com.example.paisesatividadespring.model.Estado;
import com.example.paisesatividadespring.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    @Query("SELECT COUNT(*) FROM Estado")
    int countEstados();

    @Query("SELECT SUM(populacaoLocal) FROM Estado")
    int getPopulacaoEstado();

    @Query("SELECT SUM(tamanhoTerritorio) FROM Estado")
    int getTamanhoEstado();



}
