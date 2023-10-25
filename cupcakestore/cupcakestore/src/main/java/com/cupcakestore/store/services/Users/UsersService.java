package com.cupcakestore.store.services.Users;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cupcakestore.store.exceptions.ProductNotFoundException;
import com.cupcakestore.store.exceptions.UserNotFoundException;
import com.cupcakestore.store.models.Product;
import com.cupcakestore.store.models.User;
import com.cupcakestore.store.repository.UserRepository;

import jakarta.persistence.Id;
import jakarta.transaction.Transactional;

// Classe UserRepository
// Como comentado no UserRepository, o Users Service fará uso dos métodos da classe Jpa que foi extendida na interface do UserRepository. Assim, será possível performar
// várias funções características de consulta e armazenamento de dados em banco com facilidade.
@Service
// Essa anotação diz que a classe abaixo é um service. Ela não provém nenhuma
// funcionalidade específica, mas categoriza a classe como uma classe que contém
// lógicas de negócio (chamadas de API).
@Transactional
// Essa anotação define algumas características básicas de comunicação entre a
// classe e o banco de dados.
public class UsersService {

    // -------- Atributos --------
    private final UserRepository usersRepo;

    // -------- Método Construtor --------
    // Lembrete: O método construtor define o estado/ação de um objeto dessa classe
    // assim que ele for instanciado. Mas é importante
    // lembrar que os construtores também podem receber injeções de dados de outras
    // classes, como no caso abaixo no qual define que
    // instâncias da classe UsersService poderão usar os artigos da classe
    // UserRepository por padrão por conta da injection/injeção
    // feita via construtor.
    @Autowired
    public UsersService(UserRepository usersRepo) {
        this.usersRepo = usersRepo;
    }

    // -------- Métodos da Classe --------

    // Método addUser
    // Responsável por chamar o método .save proveniente do Jpa e extendido pela
    // interface do usersRepo. Ele salva o objeto
    // passado via parâmetro no banco de dados.
    public User addUser(User user) {
        return usersRepo.save(user);
    }

    // Método listAllUsers
    // Responsável por chamar o método .findAll proveniente do Jpa e extendido pela
    // interface do usersRepo. Ele obtém todos
    // os registros do banco de dados.
    public List<User> listAllUsers() {
        return usersRepo.findAll();
    }

    // Método updateUser
    // Responsável por chamar o método .save proveniente do Jpa e extendido pela
    // interface do usersRepo. Ele salva o objeto
    // passado via parâmetro no banco de dados e, caso exista, ele o atualiza.
    public User updateUser(User user) {
        return usersRepo.save(user);
    }

    // Método findUser
    // Responsável por chamar o método .findUserById definido na interface
    // utilizando uma nomenclatura interpretada pelo do Jpa
    // que foi extendido pela interface do usersRepo. Ele procura pelo registro com
    // o id passado via parâmetro e, caso não encontre,
    // chama uma instância da classe UserNotFoundException
    public User findUser(Long id) {
        return usersRepo.findUserById(id).orElseThrow(() -> new ProductNotFoundException("User not found"));
    }

    
    // Método findUser (Email e Senha)
    // Responsável por chamar o método .findUserByEmailAndPassword definido na interface
    // utilizando uma nomenclatura interpretada pelo do Jpa
    // que foi extendido pela interface do usersRepo. Ele procura pelo registro com
    // o id passado via parâmetro e, caso não encontre,
    // chama uma instância da classe UserNotFoundException
    public User findUserByEmailAndPassword(String email, String password) {
        return usersRepo.findUserByEmailAndPassword(email, password).orElseThrow(() -> new ProductNotFoundException("User not found"));
    }

    // Método findUser (Email)
    // Responsável por chamar o método .findUserByEmail definido na interface
    // utilizando uma nomenclatura interpretada pelo do Jpa
    // que foi extendido pela interface do usersRepo. Ele procura pelo registro com
    // o id passado via parâmetro e, caso não encontre,
    // chama uma instância da classe UserNotFoundException
    public User findUserByEmail(String email) {
        return usersRepo.findUserByEmail(email).orElseThrow(() -> new ProductNotFoundException("User not found"));
    }

    // Método findUser
    // Responsável por chamar o método .deleteUserById definido na interface
    // utilizando uma nomenclatura interpretada pelo do Jpa
    // que foi extendido pela interface do usersRepo. Ele procura pelo registro com
    // o id passado via parâmetro e o remove do banco
    public void deleteUser(Long id) {
        usersRepo.deleteUserById(id);
    }
}
