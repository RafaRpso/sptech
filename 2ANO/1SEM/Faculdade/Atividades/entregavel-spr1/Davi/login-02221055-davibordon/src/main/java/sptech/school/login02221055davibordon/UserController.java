package sptech.school.login02221055davibordon;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private List<User> users;

    public UserController() {
        this.users = new ArrayList<>();
    }


    // Adicionar Usuario
    @PostMapping
    public UserResponse addUser(
            @RequestBody User user
    ){
        user.setAutenticado(false);
        users.add(user);
        return new UserResponse(user);
    }

    // Autenticar Usuario
    @PostMapping("/autenticacao")
    public UserResponse authenticateUser(
            @RequestBody User user
    ){
        for( User user1 : users){
            if(user1.getUsuario().equals(user.getUsuario()) && user1.getSenha().equals(user.getSenha())){
                user1.setAutenticado(true);
                return new UserResponse(user1);
            }
        }
        return null;
    }

    // Listar todos os Usuarios
    @GetMapping
    public List<UserResponse> listUsers(){
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : users){
            userResponses.add(new UserResponse(user));
        }
        return userResponses;
    }

    // LogOff Usuario
    @DeleteMapping("/autenticacao")
    public String logOffUser(
            @RequestBody User user
    ){
        for (User user1 : users){
            if(user1.getUsuario().equals(user.getUsuario())){
                if (user1.getAutenticado().equals(true)){
                    return String.format("Logoff do usuário %s concluído", user1.getNome());
                }else{
                    return String.format("Usuário %s NÃO está autenticado", user1.getNome());
                }
            }
        }
        return String.format("Usuário %s não encontrado", user.getUsuario());
    }

    /*

    Método para alterar o nome do Usuario, recebe um objeto do tipo User como corpo da solicitação
    @RequestBody - O objetivo é alterar o nome do usuário com base no campo "nome" passado no objeto,
    tambem é feita uma validação para autenticar o usuário com base nos campos "usuario" e "senha".
    Caso a validação seja verdadeira o nome do usuário é alterado.

    */
    @PutMapping("/alterarnome")
    public String UpdateNameUser(
            @RequestBody User user
    ){
        for (User user1 : users){
            if (user1.getUsuario().equals(user.getUsuario()) && user1.getSenha().equals(user.getSenha())){
                user1.setNome(user.getNome());
                return String.format("Nome do usuário %s foi alterado para %s", user1.getUsuario(), user1.getNome());
            }
        }
        return String.format("Usuário %s não encontrado", user.getUsuario());
    }

}
