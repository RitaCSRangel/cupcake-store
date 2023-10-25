package com.cupcakestore.store.services.Users;

import java.util.List;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cupcakestore.store.models.User;

// Classe UsersController
// Constroladores são classes intermediárias responsáveis por estabelecer a conex]ao entre a aplicação front e a aplicação back. É o controlador que 
// conectará uma chamada de um service front ao service back via API, definindo métodos, endpoints, requisições e retornos.
@RestController
// Essa anotação marca essa classe como uma classe que define métodos de API
// Rest.
@RequestMapping("/users")
// Essa anotação define qual é o endpoint principal definido por essa classe
public class UsersController {

    // -------- Atributos --------
    private final UsersService usersService;

    // -------- Método Construtor --------
    // Lembrete: O método construtor define o estado/ação de um objeto dessa classe
    // assim que ele for instanciado. Mas é importante
    // lembrar que os construtores também podem receber injeções de dados de outras
    // classes, como no caso abaixo no qual define que
    // instâncias da classe UsersService poderão usar os artigos da classe
    // UsersRepository por padrão por conta da injection/injeção
    // feita via construtor.
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    // -------- Métodos da Classe --------

    // Método GET /all
    // Através do endpoint /all a aplicação chamará este método que, por sua vez,
    // fará uso do usersService para trazer
    // todos os registros do banco.
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = usersService.listAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Método GET /find/{id}
    // Através do endpoint /find/{id} a aplicação chamará este método que, por sua
    // vez, irá procurar pelo item
    // com o id correspondente ao passado no {id}. Exemplo: /find/1
    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        User users = usersService.findUser(id);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Método Post /login
    // Através do endpoint /login o email e senha do usuário serão procurados no
    // banco
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        User User = usersService.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
        return new ResponseEntity<>(User, HttpStatus.CREATED);
    }

    // Método Post /recoverpassword
    // Através do endpoint /recoverpassword o email usuário é procurado no
    // banco
    @PostMapping("/recoverpassword")
    public ResponseEntity<User> recoverPasswordUser(@RequestBody User user) {
        User User = usersService.findUserByEmail(user.getEmail());
        return new ResponseEntity<>(User, HttpStatus.CREATED);
    }

    // Método Post /add
    // Através do endpoint /add a aplicação chamará este método que, por sua vez,
    // criará um registro com as
    // características passadas via request body no banco de dados.
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = usersService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    // Método Post /update
    // Através do endpoint /update a aplicação chamará este método que, por sua vez,
    // atualizará o registro com as
    // características passadas via request body no banco de dados.
    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updateUser = usersService.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    // Método Delete /delete/{id}
    // Através do endpoint /delete/{id} a aplicação chamará este método que, por sua
    // vez, irá procurar pelo item
    // com o id correspondente ao passado no {id} e o removerá do banco. Exemplo:
    // /delete/1
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        usersService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
