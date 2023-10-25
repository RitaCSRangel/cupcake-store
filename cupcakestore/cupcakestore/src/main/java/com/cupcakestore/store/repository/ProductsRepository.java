package com.cupcakestore.store.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cupcakestore.store.models.Product;

// Interface ProductsRepository
// Lembrete: Interfaces definem métodos básicos que podem ser utilizados. Elas também podem extender de outras classes e pegar seus métodos para si. 
// Nesse caso, a interface abaixo servirá como um repositório de funções extendidas da classe JpaRepository, que permite uma comunicação com o banco de dados
// definido no application.properties. Os métodos do Jpa serão usados no ProductsService.
public interface ProductsRepository extends JpaRepository<Product, Long> {

    // Os métodos abaixo não existiam no JpaRepository e estão sendo definidos aqui,
    // porém seguindo um padrão definido no JpaRepository
    void deleteProductById(Long id);

    Optional<Product> findProductById(Long id);
}
