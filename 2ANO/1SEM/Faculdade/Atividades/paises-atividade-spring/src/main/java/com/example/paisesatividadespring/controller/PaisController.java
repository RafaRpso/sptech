package com.example.paisesatividadespring.controller;

import com.example.paisesatividadespring.repository.PaisRepository;
import com.example.paisesatividadespring.service.PaisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paises")
public class PaisController {

    PaisService paisService;

    @GetMapping("/count")
    public ResponseEntity<Integer> countPaises() {
        return ResponseEntity.ok(paisService.countPaises());
    }

    @GetMapping("/populacao")
    public ResponseEntity<Integer> getAllPopulacaoFromEstados() {
        return ResponseEntity.ok(paisService.getAllPopulacaoFromEstados());
    }

    @GetMapping("/tamanho")
    public ResponseEntity<Integer> getTamanhoMundial() {
        return ResponseEntity.ok(paisService.getTamanhoMundial());
    }

    @GetMapping("/tamanho/americaSul")
    public ResponseEntity<Integer> getTamanhoAmericaSul() {
        return ResponseEntity.ok(paisService.getTamanhoAmericaSul());
    }



}
