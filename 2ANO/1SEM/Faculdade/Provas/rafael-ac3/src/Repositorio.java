public class Repositorio {
    private ListaObj<Petshop> lista;
    private Pilha<Operacao> pilha;
    private Fila<Integer> fila;
    private int contadorOperacoes;

    public Repositorio() {
        this.lista = new ListaObj<>(20);
        this.pilha = new Pilha<>(10);
        this.fila = new Fila<>(10);
        this.contadorOperacoes = 0;
    }

    public void salvar(Petshop obj) {
        lista.adicionar(obj);
    }

    public void deletarPeloId(int id) {
        boolean encontrado = false;
        int indice = -1;
        for (int i = 0; i < lista.tamanho(); i++) {
            if (lista.obter(i).getId() == id) {
                encontrado = true;
                indice = i;
                break;
            }
        }
        if (encontrado) {
            lista.remover(indice);
        } else {
            System.out.println("ID inválido.");
        }
    }

    public void aumentarValorPeloId(int id, double valorDeAumento) {
        boolean encontrado = false;
        int indice = -1;
        for (int i = 0; i < lista.tamanho(); i++) {
            if (lista.obter(i).getId() == id) {
                encontrado = true;
                indice = i;
                break;
            }
        }
        if (encontrado) {
            Petshop tema = lista.obter(indice);
            double novoValor = tema.getValor() + valorDeAumento;
            tema.setValor(novoValor);
            Operacao operacao = new Operacao(id, valorDeAumento);
            pilha.empilhar(operacao);
            contadorOperacoes++;
        } else {
            System.out.println("ID inválido.");
        }
    }

    public void diminuirValorPeloId(int id, double valorDeDiminuicao) {
        boolean encontrado = false;
        int indice = -1;
        for (int i = 0; i < lista.tamanho(); i++) {
            if (lista.obter(i).getId() == id) {
                encontrado = true;
                indice = i;
                break;
            }
        }
        if (encontrado) {
            Petshop tema = lista.obter(indice);
            double novoValor = tema.getValor() - valorDeDiminuicao;
            tema.setValor(novoValor);
        } else {
            System.out.println("ID inválido.");
        }
    }

    public void desfazer(int qtdOperacoesADesfazer) {
        if (qtdOperacoesADesfazer < 0 || qtdOperacoesADesfazer > contadorOperacoes) {
            System.out.println("Quantidade de operações inválida.");
            return;
        }
        if (pilha.estaVazia()) {
            System.out.println("Nada a desfazer.");
            return;
        }
        for (int i = 0; i < qtdOperacoesADesfazer; i++) {
            Operacao operacao = pilha.desempilhar();
            diminuirValorPeloId(operacao.getId(), operacao.getValorDeAumento());
        }
        contadorOperacoes -= qtdOperacoesADesfazer;
    }

    public void agendarDeletarPeloId(int id) {
        fila.enfileirar(id);
    }

    public void executarAgendado() {
        if (fila.estaVazia()) {
            System.out.println("Nenhuma operação agendada");
            if (fila.estaVazia()) {
                System.out.println("Nenhuma operação agendada.");
                return;
            }
            int id = fila.desenfileirar();
            deletarPeloId(id);
        }
    }

        public void salvarAposId(Petshop obj, int id) {
            boolean encontrado = false;
            int indice = -1;
            for (int i = 0; i < lista.tamanho(); i++) {
                if (lista.obter(i).getId() == id) {
                    encontrado = true;
                    indice = i;
                    break;
                }
            }
            if (encontrado) {
                lista.adicionarNoIndice(obj, indice + 1);
            } else {
                System.out.println("ID inválido.");
            }
        }
    public boolean desfazer() {
        if (contadorOperacoes == 0) {
            System.out.println("Nada a desfazer.");
            return false ;
        }
        int qtdOperacoesADesfazer = 1;
        if (qtdOperacoesADesfazer > contadorOperacoes) {
            System.out.println("Quantidade de operações inválida.");
            return false ;
        }
        for (int i = 0; i < qtdOperacoesADesfazer; i++) {
            Operacao operacao = pilha.desempilhar();
            diminuirValorPeloId(operacao.getId(), operacao.getValorDeAumento());
        }

        contadorOperacoes -= qtdOperacoesADesfazer;
        return true ;
    }


        public void exibe() {
            for (int i = 0; i < lista.tamanho(); i++) {
                Petshop tema = lista.obter(i);
                System.out.println(tema.toString());
            }
        }

    public Petshop[] getPetshops() {
        Petshop[] petshops = new Petshop[lista.tamanho()];
        for (int i = 0; i < lista.tamanho(); i++) {
            petshops[i] = lista.obter(i);
        }
        return petshops;
    }
}
