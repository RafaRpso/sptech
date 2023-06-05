package school.sptech.avaliacaocontinuadadois.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.avaliacaocontinuadadois.domain.Produto;

import java.util.List;
import java.time.LocalDate;
/*
    Dev:
        Digite seu RA: 02221022
        Digite seu nome: Rafael Alves Rapsoo

    TODO: Não esqueca de implementar os "dynamics finders" aqui...
*/

//
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    public long count();

    public long countByCategoriaContainingIgnoreCase(String nome);

    public List<Produto> findByCategoriaContainingIgnoreCase(String nome);

    public Produto findFirstByCategoriaContainingIgnoreCaseOrderByPrecoDesc(String nome);

    public Produto findFirstByCategoriaContainingIgnoreCaseOrderByPrecoAsc(String nome);

    public long countByCategoriaContainingIgnoreCaseAndPromocaoTrue(String nome);

    public List<Produto> findByDataCriacaoBetween(LocalDate dataInicio, LocalDate dataFim);
}

