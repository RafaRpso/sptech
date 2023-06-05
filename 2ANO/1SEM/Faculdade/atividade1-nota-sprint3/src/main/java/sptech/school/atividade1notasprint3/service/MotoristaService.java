package sptech.school.atividade1notasprint3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sptech.school.atividade1notasprint3.dto.PerfilMotoristaDTO;
import sptech.school.atividade1notasprint3.mapper.MotoristaMapper;
import sptech.school.atividade1notasprint3.model.Motorista;
import sptech.school.atividade1notasprint3.repository.MotoristaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;
    private MotoristaMapper mapper = new MotoristaMapper();

    public void cadastrarMotorista(Motorista motorista) {
        motoristaRepository.save(motorista);
    }

    public List<PerfilMotoristaDTO> listarMotoristas() {
        List<Motorista> motoristas = motoristaRepository.findAll();
        List<PerfilMotoristaDTO> motoristasDTO = new ArrayList<>();

        for (Motorista motorista : motoristas) {
            PerfilMotoristaDTO dto = mapper.toPerfilMotoristaDTO(motorista);
            motoristasDTO.add(dto);
        }

        return motoristasDTO;


    }

    public ResponseEntity<Motorista> buscarPorCpf(String cpf) {
        Motorista query = motoristaRepository.findByCpf(cpf).get();
        return ResponseEntity.ok(query);
    }

    public ResponseEntity<Motorista> buscarPorEmail(String email) {
        Motorista query = motoristaRepository.findByEmailContainingIgnoreCase(email).get();
        return ResponseEntity.ok(query);
    }

    public ResponseEntity<List<Motorista>> buscarPorNome(String nome) {
        List<Motorista> query = motoristaRepository.findByNomeContainingIgnoreCase(nome).get();
        return ResponseEntity.ok(query);
    }

    public ResponseEntity<List<Motorista>> buscarPorDataNascimento(String dataNascimento) {
        List<Motorista> query = motoristaRepository.findByDataNascimento(dataNascimento).get();
        return ResponseEntity.ok(query);
    }

    public ResponseEntity<List<Motorista>> buscarPorInativo(boolean inativo) {
        List<Motorista> query = motoristaRepository.findByInativo(inativo).get();
        return ResponseEntity.ok(query);
    }

    public ResponseEntity<List<Motorista>> buscarPorNota(int nota) {
        List<Motorista> query = motoristaRepository.findByNota(nota).get();
        return ResponseEntity.ok(query);
    }

    public ResponseEntity<List<Motorista>> buscarPorDataNascimentoBetween(String dataNascimento1, String dataNascimento2) {
        List<Motorista> query = motoristaRepository.findByDataNascimentoBetween(dataNascimento1, dataNascimento2).get();
        return ResponseEntity.ok(query);
    }

    public ResponseEntity<List<Motorista>> buscarPorNotaBetween(int nota1, int nota2) {
        List<Motorista> query = motoristaRepository.findByNotaBetween(nota1, nota2).get();
        return ResponseEntity.ok(query);
    }


    public void atualizarMotorista(long id, Motorista motorista) {
        Optional<Motorista> motoristaAtualizar = motoristaRepository.findById(id);

    }

    public void deletarMotorista(long id) {
        Optional<Motorista> motoristaDeletar = motoristaRepository.findById(id);
        motoristaRepository.delete(motoristaDeletar.get());
    }
}



