package musica.sptech;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/musicas")
@RestController
public class MusicaController {

    private MusicaRepository musicaRepository;

    public MusicaController(MusicaRepository musicaRepository) {
        this.musicaRepository = musicaRepository;
    }

    @GetMapping
    public ResponseEntity<List<Musica>> getMusica() {
        List<Musica> musicas = this.musicaRepository.findAll();

        if (musicas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(musicas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musica> getMusicaById(@PathVariable Integer id) {
        Musica musica = this.musicaRepository.findById(id).orElse(null);

        if (musica == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(musica);
    }

    @PostMapping
    public ResponseEntity<Musica> postMusica(@RequestBody Musica musica) {
        Musica savedMusica = this.musicaRepository.save(musica);
        return ResponseEntity.status(201).body(savedMusica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Musica> putMusica(@PathVariable Integer id, @RequestBody Musica musica) {
        Musica musicaToUpdate = this.musicaRepository.findById(id).orElse(null);

        if (musicaToUpdate == null) {
            return ResponseEntity.notFound().build();
        }

        musicaToUpdate.setId(musica.getId());
        musicaToUpdate.setNome(musica.getNome());
        musicaToUpdate.setAlbum(musica.getAlbum());
        musicaToUpdate.setContato(musica.getContato());
        musicaToUpdate.setCpfContato(musica.getCpfContato());
        musicaToUpdate.setGravadoraCnpj(musica.getGravadoraCnpj());
        musicaToUpdate.setTelefoneContato(musica.getTelefoneContato());
        musicaToUpdate.setTituloEleitorContato(musica.getTituloEleitorContato());


        Musica updatedMusica = this.musicaRepository.save(musicaToUpdate);
        return ResponseEntity.ok(updatedMusica);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Musica> deleteMusica(@PathVariable Integer id) {
        Musica musica = this.musicaRepository.findById(id).orElse(null);

        if (musica == null) {
            return ResponseEntity.notFound().build();
        }

        this.musicaRepository.delete(musica);

        return ResponseEntity.noContent().build();
    }


}