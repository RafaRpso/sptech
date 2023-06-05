public class Operacao {
    private ContaBancaria objConta;
    private String tipoOperacao;
    private Double valor;

    public Operacao(ContaBancaria objConta, String tipoOperacao, Double valor) {
        this.objConta = objConta;
        this.tipoOperacao = tipoOperacao;
        this.valor = valor;
    }

    public Operacao() {

    }

    public ContaBancaria getObjConta() {
        return objConta;
    }

    public void setObjConta(ContaBancaria objConta) {
        this.objConta = objConta;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Operacao [objConta=" + objConta + ", tipoOperacao=" + tipoOperacao + ", valor=" + valor + "]";
    }
}
