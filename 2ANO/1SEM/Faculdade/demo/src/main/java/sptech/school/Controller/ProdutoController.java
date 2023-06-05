package sptech.school.Controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.DTO.ProdutoDTO;
import sptech.school.Service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(@Valid @RequestBody ProdutoDTO produtoDTO) {
        ProdutoDTO produtoCriado = produtoService.criarProduto(produtoDTO);
        return ResponseEntity.ok().body(produtoCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizarProduto(@PathVariable Long id, @Valid @RequestBody ProdutoDTO produtoDTO) {
        ProdutoDTO produtoAtualizado = produtoService.atualizarProduto(id, produtoDTO);
        if (produtoAtualizado != null) {
            return ResponseEntity.ok(produtoAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> obterProduto(@PathVariable Long id) {
        ProdutoDTO produtoDTO = produtoService.obterProduto(id);
        if (produtoDTO != null) {
            return ResponseEntity.ok(produtoDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable Long id) {
        produtoService.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarProdutos() {
        List<ProdutoDTO> produtos = produtoService.listarProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<ProdutoDTO>> listarProdutosPorCategoria(@PathVariable Long categoriaId) {
        List<ProdutoDTO> produtos = produtoService.listarProdutosPorCategoria(categoriaId);
        if (!produtos.isEmpty()) {
            return ResponseEntity.ok(produtos);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<ProdutoDTO>> listarProdutosAtivos() {
        List<ProdutoDTO> produtos = produtoService.listarProdutosAtivos();
        return ResponseEntity.ok(produtos);
    }
}
