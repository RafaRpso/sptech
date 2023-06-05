package sptech.school.login02221055davibordon;

public class UserResponse {
    private String usuario;
    private String nome;
    private Boolean autenticado;

    public UserResponse(User user) {
        this.usuario = user.getUsuario();
        this.nome = user.getNome();
        this.autenticado = user.getAutenticado();
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

    public Boolean getAutenticado() {
        return autenticado;
    }

    public void setAutenticado(Boolean autenticado) {
        this.autenticado = autenticado;
    }
}
