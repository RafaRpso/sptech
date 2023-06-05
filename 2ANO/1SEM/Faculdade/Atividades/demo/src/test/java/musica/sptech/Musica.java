package musica.sptech;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.constraints.br.TituloEleitoral;

import java.time.LocalDate;


@Entity
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min=3)

    private String nome;

    private String album;

    @PastOrPresent
    private LocalDate dataLancamento;

    @DecimalMin("0.5")
    @DecimalMax("8.0")
    private Double duracao;

    @Positive
    @PositiveOrZero
    @Negative
    @NegativeOrZero
    private Integer ranking;

    @Email
    private String contato;

    @NotNull
    private String telefoneContato;

    @CPF
    private String cpfContato;

    @TituloEleitoral
    private String tituloEleitorContato;

    @CNPJ
    private String gravadoraCnpj;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Double getDuracao() {
        return duracao;
    }

    public void setDuracao(Double duracao) {
        this.duracao = duracao;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public String getCpfContato() {
        return cpfContato;
    }

    public void setCpfContato(String cpfContato) {
        this.cpfContato = cpfContato;
    }

    public String getTituloEleitorContato() {
        return tituloEleitorContato;
    }

    public void setTituloEleitorContato(String tituloEleitorContato) {
        this.tituloEleitorContato = tituloEleitorContato;
    }

    public String getGravadoraCnpj() {
        return gravadoraCnpj;
    }

    public void setGravadoraCnpj(String gravadoraCnpj) {
        this.gravadoraCnpj = gravadoraCnpj;
    }
}
