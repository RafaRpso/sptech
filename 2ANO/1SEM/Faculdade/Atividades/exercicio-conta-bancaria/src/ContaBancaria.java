public class ContaBancaria {
    private Integer numero;
    private Double saldo;

    public ContaBancaria(Integer numero, Double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public boolean debitar(Double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Débito realizado. Saldo atual: " + saldo);
            return true;
        } else {
            System.out.println("Saldo insuficiente");
            return false;
        }
    }

    public void creditar(Double valor) {
        saldo += valor;
        System.out.println("Crédito realizado. Saldo atual: " + saldo);
    }

    @Override
    public String toString() {
        return "ContaBancaria [numero=" + numero + ", saldo=" + saldo + "]";
    }
}
