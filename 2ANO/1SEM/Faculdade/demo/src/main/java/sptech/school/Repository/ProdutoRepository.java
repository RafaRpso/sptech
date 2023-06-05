package sptech.school.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sptech.school.Model.Produto;

import java.util.List;

@Repository
    public interface ProdutoRepository extends JpaRepository<Produto, Long> {
        @Query("SELECT p FROM Produto p WHERE p.categoria.id = :categoriaId")
        List<Produto> findByCategoriaId(@Param("categoriaId") Long categoriaId);


        @Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
        List<Produto> findByNome(@Param("nome") String nome);

        @Query("SELECT p FROM Produto p WHERE p.ativo = true")
        List<Produto> findAtivos();

    }

