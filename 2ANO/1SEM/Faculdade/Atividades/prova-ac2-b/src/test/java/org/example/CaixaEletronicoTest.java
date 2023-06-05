package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CaixaEletronicoTest {

    @Test
    public void sacarQuandoValorMenorIgualZeroLancaIllegalArgumentException() {
        CaixaEletronico exercicio = new CaixaEletronico();
        assertThrows(IllegalArgumentException.class, () -> exercicio.sacar(-1));
        assertThrows(IllegalArgumentException.class, () -> exercicio.sacar(-10));
        assertThrows(IllegalArgumentException.class, () -> exercicio.sacar(-1000));
        assertThrows(IllegalArgumentException.class, () -> exercicio.sacar(0));
    }

    @Test
    public void sacarQuandoValorMaiorIgualCincoMilLancaIllegalArgumentException() {
        CaixaEletronico exercicio = new CaixaEletronico();
        assertThrows(IllegalArgumentException.class, () -> exercicio.sacar(5_000));
        assertThrows(IllegalArgumentException.class, () -> exercicio.sacar(5_001));
        assertThrows(IllegalArgumentException.class, () -> exercicio.sacar(10_000));
        assertThrows(IllegalArgumentException.class, () -> exercicio.sacar(100_000));
    }

    @Test
    public void sacarQuandoValorIgualUmRetornaUmaNotaUm() {
        CaixaEletronico exercicio = new CaixaEletronico();
        exercicio.sacar(1);
        assertEquals(exercicio.getQuantidadeNotasUm(), 1);
        assertEquals(exercicio.getQuantidadeNotasCinco(), 0);
        assertEquals(exercicio.getQuantidadeNotasDez(), 0);
        assertEquals(exercicio.getQuantidadeNotasVinte(), 0);
        assertEquals(exercicio.getQuantidadeNotasCinquenta(), 0);
        assertEquals(exercicio.getQuantidadeNotasCem(), 0);
        assertEquals(exercicio.getQuantidadeNotasDuzentos(), 0);
        assertEquals(exercicio.getQuantidadeNotasQuinhentos(), 0);
    }


    @Test
    public void sacarQuandoValorIgualCincoRetornaUmaNotaCinco() {
        CaixaEletronico exercicio = new CaixaEletronico();
        exercicio.sacar(5);
        assertEquals(exercicio.getQuantidadeNotasUm(), 0);
        assertEquals(exercicio.getQuantidadeNotasCinco(), 1);
        assertEquals(exercicio.getQuantidadeNotasDez(), 0);
        assertEquals(exercicio.getQuantidadeNotasVinte(), 0);
        assertEquals(exercicio.getQuantidadeNotasCinquenta(), 0);
        assertEquals(exercicio.getQuantidadeNotasCem(), 0);
        assertEquals(exercicio.getQuantidadeNotasDuzentos(), 0);
        assertEquals(exercicio.getQuantidadeNotasQuinhentos(), 0);
    }

    @Test
    public void sacarQuandoValorIgualDezRetornaUmaNotaDez() {
        CaixaEletronico exercicio = new CaixaEletronico();
        exercicio.sacar(10);
        assertEquals(exercicio.getQuantidadeNotasUm(), 0);
        assertEquals(exercicio.getQuantidadeNotasCinco(), 0);
        assertEquals(exercicio.getQuantidadeNotasDez(), 1);
        assertEquals(exercicio.getQuantidadeNotasVinte(), 0);
        assertEquals(exercicio.getQuantidadeNotasCinquenta(), 0);
        assertEquals(exercicio.getQuantidadeNotasCem(), 0);
        assertEquals(exercicio.getQuantidadeNotasDuzentos(), 0);
        assertEquals(exercicio.getQuantidadeNotasQuinhentos(), 0);
    }

    @Test
    public void sacarQuandoValorIgualVinteRetornaUmaNotaVinte() {
        CaixaEletronico exercicio = new CaixaEletronico();
        exercicio.sacar(20);
        assertEquals(exercicio.getQuantidadeNotasUm(), 0);
        assertEquals(exercicio.getQuantidadeNotasCinco(), 0);
        assertEquals(exercicio.getQuantidadeNotasDez(), 0);
        assertEquals(exercicio.getQuantidadeNotasVinte(), 1);
        assertEquals(exercicio.getQuantidadeNotasCinquenta(), 0);
        assertEquals(exercicio.getQuantidadeNotasCem(), 0);
        assertEquals(exercicio.getQuantidadeNotasDuzentos(), 0);
        assertEquals(exercicio.getQuantidadeNotasQuinhentos(), 0);
    }

    @Test
    public void sacarQuandoValorIgualCinquentaRetornaUmaNotaCinquenta() {
        CaixaEletronico exercicio = new CaixaEletronico();
        exercicio.sacar(50);
        assertEquals(exercicio.getQuantidadeNotasUm(), 0);
        assertEquals(exercicio.getQuantidadeNotasCinco(), 0);
        assertEquals(exercicio.getQuantidadeNotasDez(), 0);
        assertEquals(exercicio.getQuantidadeNotasVinte(), 0);
        assertEquals(exercicio.getQuantidadeNotasCinquenta(), 1);
        assertEquals(exercicio.getQuantidadeNotasCem(), 0);
        assertEquals(exercicio.getQuantidadeNotasDuzentos(), 0);
        assertEquals(exercicio.getQuantidadeNotasQuinhentos(), 0);
    }

    @Test
    public void sacarQuandoValorIgualCemRetornaUmaNotaCem() {
        CaixaEletronico exercicio = new CaixaEletronico();
        exercicio.sacar(100);
        assertEquals(exercicio.getQuantidadeNotasUm(), 0);
        assertEquals(exercicio.getQuantidadeNotasCinco(), 0);
        assertEquals(exercicio.getQuantidadeNotasDez(), 0);
        assertEquals(exercicio.getQuantidadeNotasVinte(), 0);
        assertEquals(exercicio.getQuantidadeNotasCinquenta(), 0);
        assertEquals(exercicio.getQuantidadeNotasCem(), 1);
        assertEquals(exercicio.getQuantidadeNotasDuzentos(), 0);
        assertEquals(exercicio.getQuantidadeNotasQuinhentos(), 0);
    }

    @Test
    public void sacarQuandoValorIgualDuzentosRetornaUmaNotaDuzentos() {
        CaixaEletronico exercicio = new CaixaEletronico();
        exercicio.sacar(200);
        assertEquals(exercicio.getQuantidadeNotasUm(), 0);
        assertEquals(exercicio.getQuantidadeNotasCinco(), 0);
        assertEquals(exercicio.getQuantidadeNotasDez(), 0);
        assertEquals(exercicio.getQuantidadeNotasVinte(), 0);
        assertEquals(exercicio.getQuantidadeNotasCinquenta(), 0);
        assertEquals(exercicio.getQuantidadeNotasCem(), 0);
        assertEquals(exercicio.getQuantidadeNotasDuzentos(), 1);
        assertEquals(exercicio.getQuantidadeNotasQuinhentos(), 0);
    }

    @Test
    public void sacarQuandoValorIgualQuinhetosRetornaUmaNotaDuzentos() {
        CaixaEletronico exercicio = new CaixaEletronico();
        exercicio.sacar(500);
        assertEquals(exercicio.getQuantidadeNotasUm(), 0);
        assertEquals(exercicio.getQuantidadeNotasCinco(), 0);
        assertEquals(exercicio.getQuantidadeNotasDez(), 0);
        assertEquals(exercicio.getQuantidadeNotasVinte(), 0);
        assertEquals(exercicio.getQuantidadeNotasCinquenta(), 0);
        assertEquals(exercicio.getQuantidadeNotasCem(), 0);
        assertEquals(exercicio.getQuantidadeNotasDuzentos(), 0);
        assertEquals(exercicio.getQuantidadeNotasQuinhentos(), 1);
    }

    @Test
    public void sacarQuandoValorIgualCentoDezRetornaUmaNotaCemEUmaNotaDez() {
        CaixaEletronico exercicio = new CaixaEletronico();
        exercicio.sacar(110);
        assertEquals(exercicio.getQuantidadeNotasUm(), 0);
        assertEquals(exercicio.getQuantidadeNotasCinco(), 0);
        assertEquals(exercicio.getQuantidadeNotasDez(), 1);
        assertEquals(exercicio.getQuantidadeNotasVinte(), 0);
        assertEquals(exercicio.getQuantidadeNotasCinquenta(), 0);
        assertEquals(exercicio.getQuantidadeNotasCem(), 1);
        assertEquals(exercicio.getQuantidadeNotasDuzentos(), 0);
        assertEquals(exercicio.getQuantidadeNotasQuinhentos(), 0);
    }

    @Test
    public void sacarQuandoValorIgualMilTrezentosQuarentaDoisRetornaDuasNotaQuinhentosUmaNotaDuzentosUmaNotaCemDuasNotaVinte() {
        CaixaEletronico exercicio = new CaixaEletronico();
        exercicio.sacar(1340);
        assertEquals(exercicio.getQuantidadeNotasUm(), 0);
        assertEquals(exercicio.getQuantidadeNotasCinco(), 0);
        assertEquals(exercicio.getQuantidadeNotasDez(), 0);
        assertEquals(exercicio.getQuantidadeNotasVinte(), 2);
        assertEquals(exercicio.getQuantidadeNotasCinquenta(), 0);
        assertEquals(exercicio.getQuantidadeNotasCem(), 1);
        assertEquals(exercicio.getQuantidadeNotasDuzentos(), 1);
        assertEquals(exercicio.getQuantidadeNotasQuinhentos(), 2);
    }

    @Test
    public void sacarQuandoValorIgualQuatroMilSeissentosSessentaSeteRetornaNoveNotaQuinhentosUmaNotaCemUmaNotaCinquentaUmaNotaDezUmaNotaCincoDuasNotaDois() {
        CaixaEletronico exercicio = new CaixaEletronico();
        exercicio.sacar(4667);
        assertEquals(exercicio.getQuantidadeNotasUm(), 2);
        assertEquals(exercicio.getQuantidadeNotasCinco(), 1);
        assertEquals(exercicio.getQuantidadeNotasDez(), 1);
        assertEquals(exercicio.getQuantidadeNotasVinte(), 0);
        assertEquals(exercicio.getQuantidadeNotasCinquenta(), 1);
        assertEquals(exercicio.getQuantidadeNotasCem(), 1);
        assertEquals(exercicio.getQuantidadeNotasDuzentos(), 0);
        assertEquals(exercicio.getQuantidadeNotasQuinhentos(), 9);
    }

    @Test
    public void sacarQuandoValorIgualSetentaNoveRetornaUmaNotaCinquentaUmaNotaVinteUmaNotaCincoQuatroNotasUm() {
        CaixaEletronico exercicio = new CaixaEletronico();
        exercicio.sacar(79);
        assertEquals(exercicio.getQuantidadeNotasUm(), 4);
        assertEquals(exercicio.getQuantidadeNotasCinco(), 1);
        assertEquals(exercicio.getQuantidadeNotasDez(), 0);
        assertEquals(exercicio.getQuantidadeNotasVinte(), 1);
        assertEquals(exercicio.getQuantidadeNotasCinquenta(), 1);
        assertEquals(exercicio.getQuantidadeNotasCem(), 0);
        assertEquals(exercicio.getQuantidadeNotasDuzentos(), 0);
        assertEquals(exercicio.getQuantidadeNotasQuinhentos(), 0);
    }

    @Test
    public void sacarQuandoValorIgualTresRetornaTresNotaUm() {
        CaixaEletronico exercicio = new CaixaEletronico();
        exercicio.sacar(3);
        assertEquals(exercicio.getQuantidadeNotasUm(), 3);
        assertEquals(exercicio.getQuantidadeNotasCinco(), 0);
        assertEquals(exercicio.getQuantidadeNotasDez(), 0);
        assertEquals(exercicio.getQuantidadeNotasVinte(), 0);
        assertEquals(exercicio.getQuantidadeNotasCinquenta(), 0);
        assertEquals(exercicio.getQuantidadeNotasCem(), 0);
        assertEquals(exercicio.getQuantidadeNotasDuzentos(), 0);
        assertEquals(exercicio.getQuantidadeNotasQuinhentos(), 0);
    }

    @Test
    public void exibeRelatorio() {
        CaixaEletronico exercicio = new CaixaEletronico();
        int[][] m = new int[8][3];
        ListaEstatica lista = new ListaEstatica(24);
        lista.adiciona(11);
        lista.adiciona(12);
        lista.adiciona(13);
        lista.adiciona(14);
        lista.adiciona(15);
        lista.adiciona(16);
        lista.adiciona(17);
        lista.adiciona(18);
        lista.adiciona(19);
        lista.adiciona(20);
        lista.adiciona(21);
        lista.adiciona(22);
        lista.adiciona(23);
        lista.adiciona(24);
        lista.adiciona(25);
        lista.adiciona(26);
        lista.adiciona(27);
        lista.adiciona(28);
        lista.adiciona(29);
        lista.adiciona(30);
        lista.adiciona(31);
        lista.adiciona(32);
        lista.adiciona(33);
        lista.adiciona(34);
        lista.listaParaMatriz(m);
        exercicio.exibeRelatorio(m);
        assertEquals(12, exercicio.getMediaLinha()[0]);
        assertEquals(21.5, exercicio.getMediaColuna()[0]);
    }


}

