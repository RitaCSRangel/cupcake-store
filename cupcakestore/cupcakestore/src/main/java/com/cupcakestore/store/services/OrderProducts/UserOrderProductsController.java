package com.cupcakestore.store.services.OrderProducts;

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

import com.cupcakestore.store.models.UserOrder;
import com.cupcakestore.store.models.UserOrderProduct;

// Classe UserOrderProductsController
// Constroladores são classes intermediárias responsáveis por estabelecer a conex]ao entre a aplicação front e a aplicação back. É o controlador que 
// conectará uma chamada de um service front ao service back via API, definindo métodos, endpoints, requisições e retornos.
@RestController
// Essa anotação marca essa classe como uma classe que define métodos de API
// Rest.
@RequestMapping("/orderproducts")
// Essa anotação define qual é o endpoint principal definido por essa classe
public class UserOrderProductsController {

    // -------- Atributos --------
    private final UserOrderProductsService ordersProductsService;

    // -------- Método Construtor --------
    // Lembrete: O método construtor define o estado/ação de um objeto dessa classe
    // assim que ele for instanciado. Mas é importante
    // lembrar que os construtores também podem receber injeções de dados de outras
    // classes, como no caso abaixo no qual define que
    // instâncias da classe OrdersService poderão usar os artigos da classe
    // UserOrderProductsRepository por padrão por conta da injection/injeção
    // feita via construtor.
    public UserOrderProductsController(UserOrderProductsService ordersProductsService) {
        this.ordersProductsService = ordersProductsService;
    }

    // -------- Métodos da Classe --------

    // Método GET /all
    // Através do endpoint /all a aplicação chamará este método que, por sua vez,
    // fará uso do ordersService para trazer
    // todos os registros do banco.
    @GetMapping("/all")
    public ResponseEntity<List<UserOrderProduct>> getAllUserOrderProducts() {
        List<UserOrderProduct> ordersProducts = ordersProductsService.listAllUserOrderProducts();
        return new ResponseEntity<>(ordersProducts, HttpStatus.OK);
    }

    // Método Post /add
    // Através do endpoint /add a aplicação chamará este método que, por sua vez,
    // criará um registro com as
    // características passadas via request body no banco de dados.
    @PostMapping("/add")
    public ResponseEntity<UserOrderProduct> addUserOrderProduct(@RequestBody UserOrderProduct ordersProducts) {
        UserOrderProduct newOrderProduct = ordersProductsService.addUserOrderProduct(ordersProducts);
        return new ResponseEntity<>(newOrderProduct, HttpStatus.CREATED);
    }

    // Método Post /update
    // Através do endpoint /update a aplicação chamará este método que, por sua vez,
    // atualizará o registro com as
    // características passadas via request body no banco de dados.
    @PutMapping("/update")
    public ResponseEntity<UserOrderProduct> updateUserOrderProduct(@RequestBody UserOrderProduct ordersProducts) {
        UserOrderProduct updateOrderProduct = ordersProductsService.updateUserOrderProduct(ordersProducts);
        return new ResponseEntity<>(updateOrderProduct, HttpStatus.OK);
    }

    // Método GET /find/{id}
    // Através do endpoint /find/{id} a aplicação chamará este método que, por sua
    // vez, irá procurar pelo item
    // com o id correspondente ao passado no {id}. Exemplo: /find/1
    @GetMapping("/findbyorderid/{id}")
    public ResponseEntity<List<UserOrderProduct>> getUserOrderProductByOrderId(@PathVariable("id") Long id) {
        List<UserOrderProduct> orderProducts = ordersProductsService.findUserOrderProductByOrderId(id);
        return new ResponseEntity<>(orderProducts, HttpStatus.OK);
    }

    // Método Delete /delete/{id}
    // Através do endpoint /delete/{id} a aplicação chamará este método que, por sua
    // vez, irá procurar pelo item
    // com o id correspondente ao passado no {id} e o removerá do banco. Exemplo:
    // /delete/1
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        ordersProductsService.deleteUserOrderProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
