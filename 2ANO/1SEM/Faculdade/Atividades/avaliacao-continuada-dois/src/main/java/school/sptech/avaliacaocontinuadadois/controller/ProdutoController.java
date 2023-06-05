package school.sptech.avaliacaocontinuadadois.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.avaliacaocontinuadadois.domain.Produto;
import school.sptech.avaliacaocontinuadadois.repository.ProdutoRepository;
import java.time.LocalDate;
import java.util.List;

/*
    Revisor: Diego
    Report:
        - Evite fazer alterações no arquivo data.sql, já que ele está correto e qualquer modificação pode resultar em respostas imprecisas.
        - Recomenda-se não criar novos produtos, uma vez que isso pode impactar as respostas e levá-las a serem imprecisas.

    TODO:
     - A equipe relatou ter dificuldades em realizar buscas dinâmicas. Você poderia ajudá-los?
     - Além de auxiliar a equipe, não se esqueça de responder a algumas perguntas relacionadas ao estoque para o time comercial.

    Dev:
        Digite seu RA:
        Digite seu nome:

    Ps.Eu estimei que a conclusão desses itens levará cerca de duas horas. Deixei mapeado os endpoints para facilitar.
    Você pode liberar para revisão dentro desse prazo? Estou aguardando sua resposta.

    Boa sorte!
*/

@RequestMapping("/produtos")
@RestController
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    // Deve ser resolvido apenas com dynamic finder
    @GetMapping("/contagem")
    public ResponseEntity<Long> contagemGeral() {
        return ResponseEntity.status(200).body(produtoRepository.count());
    }

    // Deve ser resolvido apenas com dynamic finder
    @GetMapping("/categorias/contagem")
    public ResponseEntity<Long> contagemPorCategoria(@RequestParam String nome) {
        return produtoRepository.countByCategoriaContainingIgnoreCase(nome) > 0 ?
                ResponseEntity.status(200).body(produtoRepository.countByCategoriaContainingIgnoreCase(nome))
                : ResponseEntity.status(204).body(null);
    }

    // Deve ser resolvido apenas com dynamic finder e checagem de lista vazia
    @GetMapping("/categorias")
    public ResponseEntity<List<Produto>> buscarPorCategoria(@RequestParam String nome) {
        return !produtoRepository.findByCategoriaContainingIgnoreCase(nome).isEmpty() ?
                ResponseEntity.status(200).body(produtoRepository.findByCategoriaContainingIgnoreCase(nome))
                : ResponseEntity.status(204).body(null);
    }

    // Deve ser resolvido apenas com dynamic finder
    @GetMapping("/categorias/maior-preco")
    public ResponseEntity<Produto> buscarPorCategoriaMaiorPreco(@RequestParam String nome) {
        return produtoRepository.findFirstByCategoriaContainingIgnoreCaseOrderByPrecoDesc(nome).getPreco() > 0 ?
                ResponseEntity.status(200).body(produtoRepository.findFirstByCategoriaContainingIgnoreCaseOrderByPrecoDesc(nome))
                : ResponseEntity.status(204).body(null);
    }

    // Deve ser resolvido apenas com dynamic finder
    @GetMapping("/categorias/menor-preco")
    public ResponseEntity<Produto> buscarPorCategoriaMenorPreco(@RequestParam String nome) {
        return produtoRepository.findFirstByCategoriaContainingIgnoreCaseOrderByPrecoAsc(nome).getPreco() > 0
                ? ResponseEntity.status(200).body(produtoRepository.findFirstByCategoriaContainingIgnoreCaseOrderByPrecoAsc(nome))
                : ResponseEntity.status(204).body(null);

    }

    // Deve ser resolvido apenas com dynamic finder
    @GetMapping("/categorias/contagem/promocoes")
    public ResponseEntity<Long> contarPorCategoriaPromocao(@RequestParam String nome) {
        return produtoRepository.countByCategoriaContainingIgnoreCaseAndPromocaoTrue(nome) > 0
                ? ResponseEntity.status(200).body(produtoRepository.countByCategoriaContainingIgnoreCaseAndPromocaoTrue(nome))
                : ResponseEntity.status(204).body(null);
    }

    // Esse endpoint exige dynamic finder + uso de laco de repeticao ou uso de stream para cálculo
    @GetMapping("/total-estoque/data")
    public ResponseEntity<Double> buscarTotalEstoquePorPeriodo(
            @RequestParam LocalDate inicio,
            @RequestParam LocalDate fim
    ) {
        double total = 0 ;
        for (Produto prod : produtoRepository.findByDataCriacaoBetween(inicio, fim) )  {
            total += prod.getPreco() * prod.getQuantidade();
        }
        return total > 0.0 ? ResponseEntity.status(200).body(total) : ResponseEntity.status(204).body(null);
    }
}
