package com.cupcakestore.store.services.Products;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cupcakestore.store.exceptions.ProductNotFoundException;
import com.cupcakestore.store.models.Product;
import com.cupcakestore.store.repository.ProductsRepository;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;

// Classe ProductsService
// Como comentado no ProductsRepository, o Products Service fará uso dos métodos da classe Jpa que foi extendida na interface do ProductsRepository. Assim, será possível performar
// várias funções características de consulta e armazenamento de dados em banco com facilidade.
@Service
// Essa anotação diz que a classe abaixo é um service. Ela não provém nenhuma
// funcionalidade específica, mas categoriza a classe como uma classe que contém
// lógicas de negócio (chamadas de API).
@Transactional
// Essa anotação define algumas características básicas de comunicação entre a
// classe e o banco de dados.
public class ProductsService {

    // -------- Atributos --------
    private final ProductsRepository productsRepo;

    // -------- Método Construtor --------
    // Lembrete: O método construtor define o estado/ação de um objeto dessa classe
    // assim que ele for instanciado. Mas é importante
    // lembrar que os construtores também podem receber injeções de dados de outras
    // classes, como no caso abaixo no qual define que
    // instâncias da classe ProductsService poderão usar os artigos da classe
    // ProductsRepository por padrão por conta da injection/injeção
    // feita via construtor.
    @Autowired
    public ProductsService(ProductsRepository productsRepo) {
        this.productsRepo = productsRepo;
    }

    // -------- Métodos da Classe --------

    // Método addProduct
    // Responsável por chamar o método .save proveniente do Jpa e extendido pela
    // interface do productsRepo. Ele salva o objeto
    // passado via parâmetro no banco de dados.
    public Product addProduct(Product product) {
        return productsRepo.save(product);
    }

    // Método listAllProducts
    // Responsável por chamar o método .findAll proveniente do Jpa e extendido pela
    // interface do productsRepo. Ele obtém todos
    // os registros do banco de dados.
    public List<Product> listAllProducts() {
        return productsRepo.findAll();
    }

    // Método updateProduct
    // Responsável por chamar o método .save proveniente do Jpa e extendido pela
    // interface do productsRepo. Ele salva o objeto
    // passado via parâmetro no banco de dados e, caso exista, ele o atualiza.
    public Product updateProduct(Product product) {
        return productsRepo.save(product);
    }

    // Método findProduct
    // Responsável por chamar o método .findProductById definido na interface
    // utilizando uma nomenclatura interpretada pelo do Jpa
    // que foi extendido pela interface do productsRepo. Ele procura pelo registro
    // com o id passado via parâmetro e, caso não encontre,
    // chama uma instância da classe ProductNotFoundException
    public Product findProduct(Long id) {
        return productsRepo.findProductById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    // Método deleteProduct
    // Responsável por chamar o método .deleteProductById definido na interface
    // utilizando uma nomenclatura interpretada pelo do Jpa
    // que foi extendido pela interface do productsRepo. Ele procura pelo registro
    // com o id passado via parâmetro e o remove do banco
    public void deleteProduct(Long id) {
        productsRepo.deleteProductById(id);
    }
}
