package com.example.paisesatividadespring.service;

import com.example.paisesatividadespring.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisService {
    @Autowired
    PaisRepository paisRepository;

    public int countPaises() {
        return paisRepository.countPaises();
    }

    public int getAllPopulacaoFromEstados() {
        return paisRepository.getAllPopulacaoFromEstados();
    }

    public int getTamanhoMundial() {
        return paisRepository.getTamanhoMundial();
    }

    public int getTamanhoAmericaSul() {
        return paisRepository.getTamanhoAmericaSul();
    }

}
