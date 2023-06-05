package com.example.paisesatividadespring.controller;

import com.example.paisesatividadespring.service.EstadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class EstadoController {
    EstadoService estadoService;

    @GetMapping("/populacao")
    public ResponseEntity<Integer> countEstados() {
        return ResponseEntity.ok(estadoService.countEstados());
    }

    @GetMapping("/populacao")
    public ResponseEntity<Integer> getPopulacaoEstado() {
        return ResponseEntity.ok(estadoService.getPopulacaoEstado());
    }

    @GetMapping("/tamanho")
    public ResponseEntity<Integer> getTamanhoEstado() {
        return ResponseEntity.ok(estadoService.getTamanhoEstado());
    }






}
