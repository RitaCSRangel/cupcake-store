package com.cupcakestore.store.services.OrderProducts;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cupcakestore.store.exceptions.UserOrderNotFoundException;
import com.cupcakestore.store.exceptions.UserOrderProductNotFoundException;
import com.cupcakestore.store.models.UserOrder;
import com.cupcakestore.store.models.UserOrderProduct;
import com.cupcakestore.store.repository.UserOrderProductsRepository;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;

// Classe UserOrderProductsService
// Como comentado no OrderProductRepository, o OrderProducts Service fará uso dos métodos da classe Jpa que foi extendida na interface do OrderProductRepository. Assim, será possível performar
// várias funções características de consulta e armazenamento de dados em banco com facilidade.
@Service
// Essa anotação diz que a classe abaixo é um service. Ela não provém nenhuma
// funcionalidade específica, mas categoriza a classe como uma classe que contém
// lógicas de negócio (chamadas de API).
@Transactional
// Essa anotação define algumas características básicas de comunicação entre a
// classe e o banco de dados.
public class UserOrderProductsService {

    // -------- Atributos --------
    private final UserOrderProductsRepository orderProductsRepo;

    // -------- Método Construtor --------
    // Lembrete: O método construtor define o estado/ação de um objeto dessa classe
    // assim que ele for instanciado. Mas é importante
    // lembrar que os construtores também podem receber injeções de dados de outras
    // classes, como no caso abaixo no qual define que
    // instâncias da classe UserOrderProductsService poderão usar os artigos da classe
    // OrderProductRepository por padrão por conta da injection/injeção
    // feita via construtor.
    @Autowired
    public UserOrderProductsService(UserOrderProductsRepository orderProductsRepo) {
        this.orderProductsRepo = orderProductsRepo;
    }

    // -------- Métodos da Classe --------

    // Método addOrderProduct
    // Responsável por chamar o método .save proveniente do Jpa e extendido pela
    // interface do orderProductsRepo. Ele salva o objeto
    // passado via parâmetro no banco de dados.
    public UserOrderProduct addUserOrderProduct(UserOrderProduct orderProduct) {
        return orderProductsRepo.save(orderProduct);
    }

    // Método listAllOrderProducts
    // Responsável por chamar o método .findAll proveniente do Jpa e extendido pela
    // interface do orderProductsRepo. Ele obtém todos
    // os registros do banco de dados.
    public List<UserOrderProduct> listAllUserOrderProducts() {
        return orderProductsRepo.findAll();
    }

    // Método updateOrderProduct
    // Responsável por chamar o método .save proveniente do Jpa e extendido pela
    // interface do orderProductsRepo. Ele salva o objeto
    // passado via parâmetro no banco de dados e, caso exista, ele o atualiza.
    public UserOrderProduct updateUserOrderProduct(UserOrderProduct orderProduct) {
        return orderProductsRepo.save(orderProduct);
    }

    // Método findUserOrderProduct
    // Responsável por chamar o método .findUserOrderProductById definido na interface
    // utilizando uma nomenclatura interpretada pelo do Jpa
    // que foi extendido pela interface do epo. Ele procura pelo registro
    // com o id passado via parâmetro e, caso não encontre,
    // chama uma instância da classe ProductNotFoundException
    public List<UserOrderProduct> findUserOrderProductByOrderId(Long orderid) {
        return orderProductsRepo.findUserOrderProductByOrderId(orderid).orElseThrow(() -> new UserOrderProductNotFoundException("Product not found"));
    }

    // Método deleteUserOrderProduct
    // Responsável por chamar o método .deleteUserOrderProduct definido na interface
    // utilizando uma nomenclatura interpretada pelo do Jpa
    // que foi extendido pela interface do epo. Ele procura pelo registro
    // com o id passado via parâmetro e o remove do banco
    public void deleteUserOrderProduct(Long id) {
        orderProductsRepo.deleteUserOrderProductById(id);
    }
}
