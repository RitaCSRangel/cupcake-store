package com.cupcakestore.store.services.Products;

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
import com.cupcakestore.store.models.Product;

// Classe ProductsController
// Constroladores são classes intermediárias responsáveis por estabelecer a conex]ao entre a aplicação front e a aplicação back. É o controlador que 
// conectará uma chamada de um service front ao service back via API, definindo métodos, endpoints, requisições e retornos.
@RestController
// Essa anotação marca essa classe como uma classe que define métodos de API
// Rest.
@RequestMapping("/products")
// Essa anotação define qual é o endpoint principal definido por essa classe
public class ProductsController {

    // -------- Atributos --------
    private final ProductsService productsService;

    // -------- Método Construtor --------
    // Lembrete: O método construtor define o estado/ação de um objeto dessa classe
    // assim que ele for instanciado. Mas é importante
    // lembrar que os construtores também podem receber injeções de dados de outras
    // classes, como no caso abaixo no qual define que
    // instâncias da classe ProductsService poderão usar os artigos da classe
    // ProductsRepository por padrão por conta da injection/injeção
    // feita via construtor.
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    // -------- Métodos da Classe --------

    // Método GET /all
    // Através do endpoint /all a aplicação chamará este método que, por sua vez,
    // fará uso do productsService para trazer
    // todos os registros do banco.
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productsService.listAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Método GET /find/{id}
    // Através do endpoint /find/{id} a aplicação chamará este método que, por sua
    // vez, irá procurar pelo item
    // com o id correspondente ao passado no {id}. Exemplo: /find/1
    @GetMapping("/find/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        Product products = productsService.findProduct(id);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Método Post /add
    // Através do endpoint /add a aplicação chamará este método que, por sua vez,
    // criará um registro com as
    // características passadas via request body no banco de dados.
    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product newProduct = productsService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    // Método Post /update
    // Através do endpoint /update a aplicação chamará este método que, por sua vez,
    // atualizará o registro com as
    // características passadas via request body no banco de dados.
    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updateProduct = productsService.updateProduct(product);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    // Método Delete /delete/{id}
    // Através do endpoint /delete/{id} a aplicação chamará este método que, por sua
    // vez, irá procurar pelo item
    // com o id correspondente ao passado no {id} e o removerá do banco. Exemplo:
    // /delete/1
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        productsService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
