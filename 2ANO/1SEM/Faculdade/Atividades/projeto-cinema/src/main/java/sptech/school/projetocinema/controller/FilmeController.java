package sptech.school.projetocinema.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.projetocinema.repository.FilmeRepository;
import sptech.school.projetocinema.domain.Filme;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Filmes", description = "Grupo de requisicoes entidade filme")
@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Filme cadastrado."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos.", content = @Content(schema = @Schema(hidden = true)))
    })
    @DeleteMapping("/{nome}")
    public ResponseEntity<Filme> deletar(@PathVariable String nome) {
        this.filmeRepository.deletarByNome(nome);
        return ResponseEntity.status(204).build();
    }

    @PostMapping("/indicados")
    public int countByIndicacaoOscar(){
        return this.filmeRepository.contagemIndicados();
    }
    @PostMapping
    public ResponseEntity<Filme> cadastrar(@RequestBody Filme filme) {
        Filme filmeRegistrado = this.filmeRepository.save(filme);
        return ResponseEntity.status(201).body(filmeRegistrado);
    }

    @ApiResponses({
            @ApiResponse(responseCode = "204", description =
                    "Não há filmes cadastrados.", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "200", description = "Filmes encontradas.")
    })
    @GetMapping
    public ResponseEntity<List<Filme>> listar() {

        List<Filme> filmes = this.filmeRepository.findAll();

        if (filmes.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(filmes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscarPorId(@PathVariable long id) {
        return ResponseEntity.of(this.filmeRepository.findById(id));
    }

    // localhost:8080/filmes/titulo?nome=Lagoa+Azul&diretor=Steven
    @GetMapping("/titulo")
    public ResponseEntity<Filme> buscarPorNome
            (@RequestParam String nome) {
        return ResponseEntity.of(this.filmeRepository.findByNome(nome));
    }

    @GetMapping("/diretor")
    public ResponseEntity<List<Filme>> buscarPorDiretor(
            @RequestParam String nome) {

        List<Filme> filmesFiltrados =
                this.filmeRepository.findByDiretorNomeContainsIgnoreCase(nome);

        if (filmesFiltrados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(filmesFiltrados);
    }

    @GetMapping("/periodo/{data}")
    public ResponseEntity<List<Filme>> buscarPorDiretor(@PathVariable LocalDate data) {

        List<Filme> filmesFiltrados =
                this.filmeRepository.findByDataLancamentoLessThanEqual(data);

        if (filmesFiltrados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(filmesFiltrados);
    }

    @GetMapping("/indicados")
    public ResponseEntity<List<Filme>> buscarSomenteIndicados() {

        List<Filme> filmesFiltrados = this.filmeRepository.findByIndicacaoOscarTrue();

        if (filmesFiltrados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(filmesFiltrados);
    }

    @GetMapping("/nao-indicados/quantidade")
    public ResponseEntity<Integer> contarSomenteNaoIndicados() {
        int contador = this.filmeRepository.countByIndicacaoOscarFalse();
        return ResponseEntity.status(200).body(contador);
    }

    @GetMapping("/custo-producao/{custo}")
    public ResponseEntity<List<Filme>> buscarFilmesComCustoAlto(@PathVariable double custo) {

        List<Filme> filmesFiltrados = this.filmeRepository.findByCustoProducaoGreaterThan(custo);

        if (filmesFiltrados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(filmesFiltrados);
    }
}
