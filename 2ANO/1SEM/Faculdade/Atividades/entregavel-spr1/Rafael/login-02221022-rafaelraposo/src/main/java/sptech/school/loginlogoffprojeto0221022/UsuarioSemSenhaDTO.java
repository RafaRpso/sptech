package sptech.school.loginlogoffprojeto0221022;

public class UsuarioSemSenhaDTO {
    private String usuario;
    private String nome;

    private Boolean autenticado ;
    public UsuarioSemSenhaDTO(String usuario, String nome, Boolean autenticado) {
        this.usuario = usuario;
        this.nome = nome;
        this.autenticado = autenticado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Boolean getAutenticado() {
        return autenticado;
    }

    public void setAutenticado(Boolean autenticado) {
        this.autenticado = autenticado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "{" +
                "usuario='" + usuario + '\'' +
                ", nome='" + nome + '\'' +
                ", autenticado=" + autenticado +
                '}';
    }
}
