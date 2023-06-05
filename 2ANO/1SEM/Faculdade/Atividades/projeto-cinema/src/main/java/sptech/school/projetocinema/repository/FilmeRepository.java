package sptech.school.projetocinema.repository;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import sptech.school.projetocinema.domain.Filme;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

    @Query("SELECT COUNT(f) FROM Filme f WHERE f.indicacaoOscar")
    int contagemIndicados();

    @Query("Select AVG(f.custoProducao) FROM Filme f")
    int custoMedioProducao() ;

    @Query("Select Count(f) FROM Filme f Where f.indicacaoOscar and F.diretor.nome like %:nome%")
    int getContagemIndicadosPorDiretor(String nome);
    Optional<Filme> findByNome(String nome);

    @Modifying
    @Transactional
    @Query("delete from Filme f where f.nome = :nome")
    void deletarByNome(String nome);
    List<Filme> findByDiretorNomeContainsIgnoreCase(String nome);

    List<Filme> findByDataLancamentoLessThanEqual(LocalDate data);

    List<Filme> findByIndicacaoOscarTrue();

    int countByIndicacaoOscarFalse();

    List<Filme> findByCustoProducaoGreaterThan(double custo);

    List<Filme> findTop5ByOrderByIdDesc();
}
