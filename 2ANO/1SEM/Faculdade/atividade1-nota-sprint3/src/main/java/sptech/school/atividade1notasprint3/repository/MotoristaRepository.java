package sptech.school.atividade1notasprint3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.school.atividade1notasprint3.model.Motorista;

import java.util.List;
import java.util.Optional;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

    Optional<Motorista> findByCpf(String cpf);

    Optional<Motorista> findByEmailContainingIgnoreCase(String email);

    Optional<List<Motorista>> findByNomeContainingIgnoreCase(String nome);

    Optional<List<Motorista>> findByDataNascimento(String dataNascimento);

    Optional<List<Motorista>> findByInativo(boolean inativo);

    Optional<List<Motorista>> findByNota(int nota);

    Optional<List<Motorista>> findByDataNascimentoBetween(String dataNascimento1, String dataNascimento2);

    Optional<List<Motorista>> findByNotaBetween(int nota1, int nota2);


}
