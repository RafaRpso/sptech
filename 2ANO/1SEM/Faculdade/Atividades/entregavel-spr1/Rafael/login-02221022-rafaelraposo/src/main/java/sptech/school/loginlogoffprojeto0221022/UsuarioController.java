package sptech.school.loginlogoffprojeto0221022;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.ArrayList;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    List<Usuario> usuarios;

    public UsuarioController() {
        usuarios = new ArrayList<>();
    }


    //ok
    @GetMapping
    public List<UsuarioSemSenhaDTO> requisicaoUsuariosSemSenha() {
        List<UsuarioSemSenhaDTO> noPassUsuario = new ArrayList<UsuarioSemSenhaDTO>();
        usuarios.forEach(i -> {
            noPassUsuario.add(new UsuarioSemSenhaDTO(i.getUsuario(), i.getNome(), i.getAutenticado()));
        });
        return noPassUsuario;
    }


    //ok
    @PostMapping
    public UsuarioSemSenhaDTO novoUsuario(@RequestBody Usuario usuario) {
        UsuarioSemSenhaDTO novoUsuarioSemSenha = new UsuarioSemSenhaDTO(
                usuario.getUsuario(),
                usuario.getNome(),
                false
        );
        usuarios.add(usuario);
        return novoUsuarioSemSenha;
    }


    //escreva as letras e ele pesquisará o usuário por nome
    @GetMapping("/consultas/{pesquisa}")
    public List<UsuarioSemSenhaDTO>  retornarPesqusiaUsuario(@PathVariable String pesquisa) {
        List<UsuarioSemSenhaDTO> usuariosConsultados = new ArrayList<>();
       for(Usuario u : usuarios) {
            if(u.getUsuario().contains(pesquisa) || u.getNome().contains(pesquisa)){
                usuariosConsultados.add(
                        new UsuarioSemSenhaDTO(u.getUsuario(),u.getNome(),u.getAutenticado()
                        ));
            }
       }
       return usuariosConsultados;
    }

    //ok
    @PostMapping("autenticacao/{usuario}/{senha}")
    public String autenticarUsuario(@PathVariable String usuario, @PathVariable String senha) {

        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario) && u.getSenha().equals(senha)) {
                u.setAutenticado(true);
                return "Autenticado o usuário nome: " + usuario;
            }
        }

        return "Não foi possível autenticar o usuário " + usuario;
    }

    @DeleteMapping("autenticacao/{usuario}")
    public String sairContaUsuario(@PathVariable String usuario) {


        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario) && u.getAutenticado()) {
                u.setAutenticado(false);
                return "Logoff do usuário " + u.getNome() + " efetuado com sucesso";
            }
        }
        return "O usuário " + usuario + " não está autenticado";

    }
}
