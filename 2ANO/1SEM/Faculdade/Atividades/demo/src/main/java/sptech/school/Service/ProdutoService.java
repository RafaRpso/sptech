package sptech.school.Service;

import org.springframework.stereotype.Service;
import sptech.school.DTO.ProdutoDTO;
import sptech.school.Model.Categoria;
import sptech.school.Model.Produto;
import sptech.school.Repository.CategoriaRepository;
import sptech.school.Repository.ProdutoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public ProdutoDTO criarProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setNome(produtoDTO.getNome());
        Categoria categoria =  categoriaRepository.findById(produtoDTO.getCategoriaId ()).orElse(null);
        produto.setCategoria(categoria);
        Produto produtoSalvo = produtoRepository.save(produto);
        return produtoDTO;
    }

    public ProdutoDTO atualizarProduto(Long id, ProdutoDTO produtoDTO) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if (optionalProduto.isPresent()) {
            Produto produto = optionalProduto.get();
            produto.setNome(produtoDTO.getNome());
            Categoria categoria = categoriaRepository.findById(produtoDTO.getCategoriaId()).orElse(null);
            produto.setCategoria(categoria);
            Produto produtoAtualizado = produtoRepository.save(produto);
            return produtoDTO;
        }
        return null;
    }

    public ProdutoDTO obterProduto(Long id) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if (optionalProduto.isPresent()) {
            Produto produto = optionalProduto.get();
            ProdutoDTO produtoDTO = new ProdutoDTO();
            produtoDTO.setId(produto.getId());
            produtoDTO.setNome(produto.getNome());
            produtoDTO.setCategoriaId(produto.getCategoria().getId());
            return produtoDTO;
        }
        return null;
    }

    public void excluirProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public List<ProdutoDTO> listarProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return converterParaDTO(produtos);
    }

    public List<ProdutoDTO> listarProdutosPorCategoria(Long categoriaId) {
        List<Produto> produtos = produtoRepository.findByCategoriaId(categoriaId);
        return converterParaDTO(produtos);
    }

    public List<ProdutoDTO> listarProdutosAtivos() {
        List<Produto> produtos = produtoRepository.findAtivos();
        return converterParaDTO(produtos);
    }

    private List<ProdutoDTO> converterParaDTO(List<Produto> produtos) {
        List<ProdutoDTO> produtoDTOs = new ArrayList<>();
        for (Produto produto : produtos) {
            ProdutoDTO produtoDTO = new ProdutoDTO();
            produtoDTO.setId(produto.getId());
            produtoDTO.setNome(produto.getNome());
            produtoDTO.setCategoriaId(produto.getCategoria().getId());
            produtoDTOs.add(produtoDTO);
        }
        return produtoDTOs;
    }
}

