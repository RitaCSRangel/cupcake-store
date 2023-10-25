package com.cupcakestore.store.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cupcakestore.store.models.User;

// Interface UserRepository
// Lembrete: Interfaces definem métodos básicos que podem ser utilizados. Elas também podem extender de outras classes e pegar seus métodos para si. 
// Nesse caso, a interface abaixo servirá como um repositório de funções extendidas da classe JpaRepository, que permite uma comunicação com o banco de dados
// definido no application.properties. Os métodos do Jpa serão usados no ProductsService.
public interface UserRepository extends JpaRepository<User, Long> {

    // Os métodos abaixo não existiam no JpaRepository e estão sendo definidos aqui,
    // porém seguindo um padrão definido no JpaRepository
    void deleteUserById(Long id);

    Optional<User> findUserById(Long id);
    Optional<User> findUserByEmailAndPassword (String email, String password);
    Optional<User> findUserByEmail (String email);
}
