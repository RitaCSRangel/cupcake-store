package com.cupcakestore.store.services.Orders;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cupcakestore.store.exceptions.ProductNotFoundException;
import com.cupcakestore.store.exceptions.UserOrderNotFoundException;
import com.cupcakestore.store.models.Product;
import com.cupcakestore.store.models.UserOrder;
import com.cupcakestore.store.repository.UserOrderRepository;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;

// Classe UserOrdersService
// Como comentado no OrderRepository, o Orders Service fará uso dos métodos da classe Jpa que foi extendida na interface do OrderRepository. Assim, será possível performar
// várias funções características de consulta e armazenamento de dados em banco com facilidade.
@Service
// Essa anotação diz que a classe abaixo é um service. Ela não provém nenhuma
// funcionalidade específica, mas categoriza a classe como uma classe que contém
// lógicas de negócio (chamadas de API).
@Transactional
// Essa anotação define algumas características básicas de comunicação entre a
// classe e o banco de dados.
public class UserOrdersService {

    // -------- Atributos --------
    private final UserOrderRepository ordersRepo;

    // -------- Método Construtor --------
    // Lembrete: O método construtor define o estado/ação de um objeto dessa classe
    // assim que ele for instanciado. Mas é importante
    // lembrar que os construtores também podem receber injeções de dados de outras
    // classes, como no caso abaixo no qual define que
    // instâncias da classe UserOrdersService poderão usar os artigos da classe
    // OrderRepository por padrão por conta da injection/injeção
    // feita via construtor.
    @Autowired
    public UserOrdersService(UserOrderRepository ordersRepo) {
        this.ordersRepo = ordersRepo;
    }

    // -------- Métodos da Classe --------

    // Método addOrder
    // Responsável por chamar o método .save proveniente do Jpa e extendido pela
    // interface do ordersRepo. Ele salva o objeto
    // passado via parâmetro no banco de dados.
    public UserOrder addUserOrder(UserOrder order) {
        return ordersRepo.save(order);
    }

    // Método listAllOrders
    // Responsável por chamar o método .findAll proveniente do Jpa e extendido pela
    // interface do ordersRepo. Ele obtém todos
    // os registros do banco de dados.
    public List<UserOrder> listAllUserOrders() {
        return ordersRepo.findAll();
    }

    // Método updateOrder
    // Responsável por chamar o método .save proveniente do Jpa e extendido pela
    // interface do ordersRepo. Ele salva o objeto
    // passado via parâmetro no banco de dados e, caso exista, ele o atualiza.
    public UserOrder updateUserOrder(UserOrder order) {
        return ordersRepo.save(order);
    }

    // Método findUserOrder
    // Responsável por chamar o método .findUserOrderById definido na interface
    // utilizando uma nomenclatura interpretada pelo do Jpa
    // que foi extendido pela interface do repo. Ele procura pelo registro
    // com o id passado via parâmetro e, caso não encontre,
    // chama uma instância da classe ProductNotFoundException
    public List<UserOrder> findUserOrderByUserId(Long id) {
        return ordersRepo.findUserOrderByUserId(id).orElseThrow(() -> new UserOrderNotFoundException("Product not found"));
    }

    // Método deleteUserOrder
    // Responsável por chamar o método .deleteProductById definido na interface
    // utilizando uma nomenclatura interpretada pelo do Jpa
    // que foi extendido pela interface do epo. Ele procura pelo registro
    // com o id passado via parâmetro e o remove do banco
    public void deleteUserOrder(Long id) {
        ordersRepo.deleteUserOrderById(id);
    }
}
