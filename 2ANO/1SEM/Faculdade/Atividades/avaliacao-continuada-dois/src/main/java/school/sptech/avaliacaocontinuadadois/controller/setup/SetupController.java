package school.sptech.avaliacaocontinuadadois.controller.setup;

/*
    CONTROLLER CRIADA APENAS PARA VALIDAR SE TODOS ESTÃO COM O PROJETO
    DEVIDAMENTE CARREGADO.

    NÃO CODIFICAR ITENS NESSA CLASSE.

    BOA SORTE!!!
*/

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provas")
public class SetupController {

    @GetMapping
    public ResponseEntity<String> verificarProjeto(){
        return ResponseEntity.status(200).body("ESTAMOS PRONTOS, ALEGRIAAAA!");
    }
}
