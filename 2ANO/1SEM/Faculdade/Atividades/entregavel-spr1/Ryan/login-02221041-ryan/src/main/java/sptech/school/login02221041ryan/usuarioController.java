package sptech.school.login02221041ryan;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class usuarioController {
    private List<Usuario> usuarios;

    public usuarioController(){
        this.usuarios = new ArrayList<>();
    }
    public usuarioController(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @PostMapping
    public Usuario cadastro(@RequestBody Usuario novoUsuario){
        if(novoUsuario != null){
            for(Usuario usuario : this.usuarios){
                if(usuario.getUsuario().equals(novoUsuario.getUsuario())){
                    System.out.println("Cadastro de usuário já existe");
                    return null;
                }
            }
            usuarios.add(novoUsuario);
            System.out.println("Novo usuário cadastrado com sucesso");
            return novoUsuario;
        } else {
            System.out.println("Cadastro de usuário inválido");
            return null;
        }
    }

    @PostMapping("/autenticacao/{usuario}/{senha}")
    public Usuario authLogin(@PathVariable String usuario, @PathVariable String senha){
        for(Usuario login : this.usuarios){
            if(login.getSenha().equals(senha) && login.getUsuario().equals(usuario)){
                login.setAutenticado(true);
                System.out.println("Usuário autenticado");
                return login;
            }
        }
        System.out.println("Autenticação inválida");
        return null;
    }

    @GetMapping
    public List<Usuario> listaUsuario(){
        return usuarios;
    }

    @DeleteMapping("/autenticacao/{usuario}")
    public String authLogoff(@PathVariable String usuario){
        for(Usuario login : this.usuarios){
            if(login.getUsuario().equals(usuario)){
                if(login.isAutenticado()){
                    login.setAutenticado(false);
                    return "Logoff do usuário " + login.getNome() + " concluído";
                }else{
                    return "Usuário " + login.getNome() + " NÃO está autenticado";
                }
            }
        }
        return "Usuário " + usuario + " não encontrado";
    }

    // O método pesquisa na lista de usuários cadastrados quais deles
    // possuem um "usuario" (e-mail) que contenha a String passada como argumento,
    // seja no começo, no meio ou no final do "usuario".
    @GetMapping("/consulta/email/{usuario}")
    public List<Usuario> consultaUsuarioPorUsuario(@PathVariable String usuario){
        return this.usuarios.stream().filter(login -> login.getUsuario().toLowerCase().contains(usuario.toLowerCase())).collect(Collectors.toList());
    }

    // O método pesquisa na lista de usuários cadastrados quais deles
    // possuem um "nome" que contenha a String passada como argumento,
    // seja no começo, no meio ou no final do "nome".
    @GetMapping("/consulta/nome/{nome}")
    public List<Usuario> consultaUsuarioPorNome(@PathVariable String nome){
        return this.usuarios.stream().filter(login -> login.getNome().toLowerCase().contains(nome.toLowerCase())).collect(Collectors.toList());
    }
}
