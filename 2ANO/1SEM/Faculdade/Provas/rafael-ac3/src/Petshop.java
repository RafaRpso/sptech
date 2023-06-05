public class Petshop {
    private int id;
    private double valor;
    private String nome;
    private String endereco;
    private double avaliacao;
    private int capacidade;

    public Petshop(int id, double valor, String nome, String endereco, double avaliacao, int capacidade) {
        this.id = id;
        this.valor = valor;
        this.nome = nome;
        this.endereco = endereco;
        this.avaliacao = avaliacao;
        this.capacidade = capacidade;
    }

    // Getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    // toString

    @Override
    public String toString() {
        return "Tema{" +
                "id=" + id +
                ", valor=" + valor +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", avaliacao=" + avaliacao +
                ", capacidade=" + capacidade +
                '}';
    }
}
