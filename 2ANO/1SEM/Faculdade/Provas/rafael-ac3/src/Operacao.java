public class Operacao {
    private int id;
    private Double valorDeAumento;

    public Operacao(int id, Double valorDeAumento) {
        this.id = id;
        this.valorDeAumento = valorDeAumento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getValorDeAumento() {
        return valorDeAumento;
    }

    public void setValorDeAumento(Double valorDeAumento) {
        this.valorDeAumento = valorDeAumento;
    }
}
