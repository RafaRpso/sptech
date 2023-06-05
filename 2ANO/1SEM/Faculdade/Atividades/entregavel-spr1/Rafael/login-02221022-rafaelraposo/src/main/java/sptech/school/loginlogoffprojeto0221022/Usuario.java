package sptech.school.loginlogoffprojeto0221022;

public class Usuario {
    private String usuario;
    private String nome;
    private String senha;

    private Boolean autenticado ;

    public Usuario(String usuario, String nome, String senha) {
        this.usuario = usuario;
        this.nome = nome;
        this.senha = senha;
        this.autenticado = false;
    }



    public Boolean getAutenticado() {
        return autenticado;
    }

    public void setAutenticado(Boolean autenticado) {
        this.autenticado = autenticado;
    }
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "{" +
                "" + usuario + '\'' +
                "," + nome + '\'' +
                "," + senha + '\'' +
                "," + autenticado +
                '}';
    }
}
