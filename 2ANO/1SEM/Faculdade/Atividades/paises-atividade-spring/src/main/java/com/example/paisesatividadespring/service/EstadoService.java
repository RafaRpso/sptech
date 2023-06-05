package com.example.paisesatividadespring.service;

import com.example.paisesatividadespring.repository.EstadoRepository;

public class EstadoService {
    EstadoRepository estadoRepository;

    public int countEstados() {
        return estadoRepository.countEstados();
    }

    public int getPopulacaoEstado() {
        return estadoRepository.getPopulacaoEstado();
    }

    public int getTamanhoEstado() {
        return estadoRepository.getTamanhoEstado();
    }


}
