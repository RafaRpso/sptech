package school.sptech.marketplaceresumido.service.produto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import school.sptech.marketplaceresumido.domain.Produto;
import school.sptech.marketplaceresumido.domain.data.ProdutoRepository;
import school.sptech.marketplaceresumido.domain.exception.EntidadeNaoEncontradaException;
import school.sptech.marketplaceresumido.service.produto.builder.ProdutoBuilder;
import school.sptech.marketplaceresumido.service.produto.dto.ProdutoConsultaDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {

    @Mock
    private ProdutoRepository repository;

    @InjectMocks
    private ProdutoService service;

    @Test
    @DisplayName("Listar quando acionado deve retornar lista vazia")
    void quandoAcionadoDeveRetornarListaVazia() {
        //given
        int tamanhoEsperado = 0 ;

        //when
        Mockito.when(repository.findAll()).thenReturn(List.of());

        //then
        List<ProdutoConsultaDto> resultado = service.listar();

        //assert
        assertEquals(tamanhoEsperado, resultado.size());
    }

    @Test
    void listaQuandoAcionadoDeveRetornarItens() {
        int tamanhoEsperado = 3;
        //given
        List<Produto> produtos = ProdutoBuilder.criarListaProduto();

        //when
        Mockito.when(repository.findAll()).thenReturn(produtos);

        //then
        List<ProdutoConsultaDto> resultado = service.listar();

        //assert
        assertEquals(tamanhoEsperado, resultado.size());
        assertFalse(resultado.isEmpty());
    }

    @Test
    void criarProdutoQuandoDadosValidos() {

        //given
        Produto produto = ProdutoBuilder.criarProduto();
        //when
        Mockito.when(repository.save(Mockito.any(Produto.class))).thenReturn(produto);
        //then
        ProdutoConsultaDto resultado = service.criar(ProdutoBuilder.criarProdutoCriacaoDto());
        //assert
        assertEquals(produto.getId(), resultado.getId());
    }

    @Test
    void atualizarProdutoQuandoDadosValidos() {
        //given
        Produto produto = ProdutoBuilder.criarProduto();
        //when
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(java.util.Optional.of(produto));
        Mockito.when(repository.save(Mockito.any(Produto.class))).thenReturn(produto);
        //then
        ProdutoConsultaDto resultado = service.atualizar(1L, ProdutoBuilder.criarProdutoAtualizacaoDto());
        //assert
        assertEquals(produto.getId(), resultado.getId());
    }

    @Test
    void atualizarProdutoQuandoDadosInvalidos() {
        //given
        Produto produto = ProdutoBuilder.criarProduto();
        //when
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(java.util.Optional.empty());
        //then
        assertThrows(EntidadeNaoEncontradaException.class, () -> service.atualizar(1L, ProdutoBuilder.criarProdutoAtualizacaoDto()));
    }
    @Test
    void buscarPorIdQuandoAcionadoDeveLancarExcecao(){
        //given
        String mensagemEsperada = "produto nao encontrado";

         //when
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(java.util.Optional.empty());

        //then / assert
        assertThrows(EntidadeNaoEncontradaException.class, () -> service.buscarPorId(1L));

        assertEquals(mensagemEsperada, assertThrows(EntidadeNaoEncontradaException.class, () -> service.buscarPorId(1L)).getMessage());
    }
}