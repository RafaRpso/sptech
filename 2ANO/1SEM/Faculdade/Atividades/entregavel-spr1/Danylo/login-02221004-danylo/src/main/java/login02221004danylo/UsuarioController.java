package login02221004danylo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

    private List<Usuario> usuarios;

    public UsuarioController(){
        usuarios = new ArrayList<>();
    }

    // Listando os usuários na lista
    @GetMapping
    public List <Usuario> listar(){
        return usuarios;
    }

    // Cadastrando um novo usuário
    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario novoUsuario){
        usuarios.add(novoUsuario);
        return novoUsuario;
    }

    // Autenticando um usuário
    @PostMapping("/autenticacao/{usuario}/{senha}")
    public Usuario autenticar(@PathVariable String usuario, @PathVariable String senha){
        for(Usuario user : usuarios){
            if(user.getUsuario().equals(usuario) && user.getSenha().equals(senha)){
                user.setAutenticado(true);
                return user;
            }
        }
        return null;
    }

    // Logoff do usuário
    @DeleteMapping("/autenticacao/{usuario}")
    public String logoff(@PathVariable String usuario){
        for(Usuario user : usuarios){
            if(user.getUsuario().equals(usuario)){
                if(user.isAutenticado()){
                    user.setAutenticado(false);
                    return String.format("Logoff do usuário %s concluído", user.getNome());
                }else{
                    return String.format("Usuário %s NÃO está autenticado", user.getNome());
                }
            }
        }
        return String.format("Usuário %s não encontrado", usuario);
    }

    // Atualizando a senha de um usuário

    /*
        Pensei nessa função sendo utilizada no momento que o usário realiza o primeiro
        login em uma aplicação, e por motivos de segurança ele é obrigado a atualizar
        a sua senha para garantir sua segurança
    */
    @PatchMapping("/atualizarSenha/{usuario}/{senhaAtual}/{novaSenha}/{confirmarSenha}")
    public String atualizarSenha(
            @PathVariable String usuario,
            @PathVariable String senhaAtual,
            @PathVariable String novaSenha,
            @PathVariable String confirmarSenha
    ){
        for(Usuario user : usuarios){
            if(user.getUsuario().equals(usuario)){
                if(user.getSenha().equals(senhaAtual)){
                    if(novaSenha.equals(confirmarSenha)){
                        user.setSenha(novaSenha);
                        return String.format("Senha do usuário %s alterada com sucesso!", usuario);
                    }else{
                        return "As senhas informadas não coincidem!";
                    }
                }else {
                    return String.format("Senha atual do usuário %s está incorreta!", user.getNome());
                }
            }
        }
        return String.format("Usuário %s não encontrado", usuario);
    }

}
