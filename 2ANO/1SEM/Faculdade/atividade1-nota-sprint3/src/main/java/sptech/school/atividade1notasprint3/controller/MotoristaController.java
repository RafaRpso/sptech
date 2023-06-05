package sptech.school.atividade1notasprint3.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.atividade1notasprint3.dto.PerfilMotoristaDTO;
import sptech.school.atividade1notasprint3.model.Motorista;
import sptech.school.atividade1notasprint3.service.MotoristaService;

import java.util.List;


@RestController
@RequestMapping("/motorista")
public class MotoristaController {
    @Autowired
    private MotoristaService motoristaService;

    @PostMapping("/cadastrar")
    public void cadastrarMotorista(@RequestBody Motorista motorista) {
        motoristaService.cadastrarMotorista(motorista);
    }

    @GetMapping("/listar")
    public List<PerfilMotoristaDTO> listarMotoristas() {
        return motoristaService.listarMotoristas();
    }

    @PutMapping("/atualizar")
    public void atualizarMotorista(@RequestParam long id, @RequestBody Motorista motorista) {
        motoristaService.atualizarMotorista(id, motorista);
    }

    @DeleteMapping("/deletar")
    public void deletarMotorista(@RequestParam long id) {
        motoristaService.deletarMotorista(id);
    }

    @GetMapping("/buscarPorCpf")
    public ResponseEntity<Motorista> buscarPorCpf(@RequestParam String cpf) {
        return motoristaService.buscarPorCpf(cpf);
    }

    @GetMapping("/buscarPorEmail")
    public ResponseEntity<Motorista> buscarPorEmail(@RequestParam String email) {
        return motoristaService.buscarPorEmail(email);
    }

    @GetMapping("/buscarPorNome")
    public ResponseEntity<List<Motorista>> buscarPorNome(@RequestParam String nome) {
        return motoristaService.buscarPorNome(nome);

    }

    @GetMapping("/buscarPorDataNascimento")
    public ResponseEntity<List<Motorista>> buscarPorDataNascimento(@RequestParam String dataNascimento) {
        return motoristaService.buscarPorDataNascimento(dataNascimento);
    }

    @GetMapping("/buscarPorInativo")
    public ResponseEntity<List<Motorista>> buscarPorInativo(@RequestParam boolean inativo) {
        return motoristaService.buscarPorInativo(inativo);
    }


}
