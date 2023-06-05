package sptech.school.login02221055davibordon;

public class User {

    private String usuario;
    private String senha;
    private String nome;
    private Boolean autenticado;

    public User(String usuario, String senha, String nome, Boolean autenticado) {
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.autenticado = autenticado;
    }

    public User() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAutenticado() {
        return autenticado;
    }

    public void setAutenticado(Boolean autenticado) {
        this.autenticado = autenticado;
    }
}
