import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Order, OrderAndProducts, OrderProduct } from 'src/app/services/orders/order-model';
import { OrdersService } from 'src/app/services/orders/orders.service';
import { User } from 'src/app/services/users/user-model';
import { UsersService } from 'src/app/services/users/users.service';
import { getUser } from 'src/app/utils/utils';

@Component({
  selector: 'app-last-orders',
  templateUrl: './last-orders.component.html',
  styleUrls: ['./last-orders.component.scss']
})

export class LastOrdersComponent implements OnInit {

  // -------- Atributos --------

  // Armazenadores
  user!: User;
  orders: OrderAndProducts[] = [];

  // Inputs
  score = 5;

  // -------- Método Construtor --------
  constructor(
    private ordersService: OrdersService
  ) { }

  ngOnInit(): void {
    this.loadUser();
    if (this.user.admin === false) {
      console.log('era false')
      this.loadCommonUserOrders();
    } else {
      console.log('era tru')
      this.loadAdminUserOrders();
    }
    console.log(this.orders)
  }

  // -------- Métodos da Classe --------

  // Método loadUserData
  // Este método é responsável por colocar as informações do usuário atual no formulário de perfil
  loadUser() {
    this.user = getUser();
  }

  // Método loadCommonUserOrders
  // Este método é responsável por obter todos os pedidos por usuário (no caso, o usuário logado), 
  // em seguida buscar por todos os produtos daquele pedido e, por fim, montar um array com as informações de
  // pedidos e seus respectivos produtos.
  loadCommonUserOrders() {
    if (this.user.id != null) {
      this.ordersService.getAllOrdersFromUser(this.user.id).subscribe(
        (responseOrder: Order[]) => {
          responseOrder.forEach((order) => {
            if (order.id != null) {
              this.ordersService.getAllOrderProductsFromOrder(order.id).subscribe(
                (responseOrderProducts: OrderProduct[]) => {
                  const orderAndProduct: OrderAndProducts = {
                    id: order.id,
                    userId: order.userId,
                    value: order.value,
                    status: order.status,
                    products: responseOrderProducts
                  }
                  this.orders.push(orderAndProduct);
                },
                (error: HttpErrorResponse) => {
                  alert(error.message);
                }
              );
            }
          })
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    } else {
      alert('Não foi possível obter os pedidos desse usuário.');
    }
  }

  // Método loadAdminUserOrders
  // Este método é responsável por obter todos os pedidos da loja, 
  // em seguida buscar por todos os produtos daquele pedido e, por fim, montar um array com as informações de
  // pedidos e seus respectivos produtos.
  loadAdminUserOrders() {
    console.log('load adm')
    if (this.user.id != null) {
      this.ordersService.getAllOrders().subscribe(
        (responseOrder: Order[]) => {
          responseOrder.forEach((order) => {
            if (order.id != null) {
              this.ordersService.getAllOrderProductsFromOrder(order.id).subscribe(
                (responseOrderProducts: OrderProduct[]) => {
                  const orderAndProduct: OrderAndProducts = {
                    id: order.id,
                    userId: order.userId,
                    value: order.value,
                    status: order.status,
                    products: responseOrderProducts
                  }
                  this.orders.push(orderAndProduct);
                },
                (error: HttpErrorResponse) => {
                  alert(error.message);
                }
              );
            }
          })
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    } else {
      alert('Não foi possível obter os pedidos desse usuário.');
    }
  }

  // Método loadUserData
  // Este método é responsável por colocar as informações do usuário atual no formulário de perfil
  openCloseInfos(id: number) {
    if (document.getElementById('expanded-' + id.toString())?.classList.contains('hidden')) {
      document.getElementById('expanded-' + id.toString())?.classList.remove('hidden');
      document.getElementById('expanded-' + id.toString())?.classList.add('visible');
    } else {
      document.getElementById('expanded-' + id.toString())?.classList.remove('visible');
      document.getElementById('expanded-' + id.toString())?.classList.add('hidden');
    }
  }

    // Método loadUserData
  // Este método é responsável por colocar as informações do usuário atual no formulário de perfil
  changeOrderStatus(status: string, value: number, userId: number, orderId?: number) {
    const order: Order = {
      id: orderId,
      userId: userId,
      value: value,
      status: status,
    }
    this.ordersService.updateOrder(order).subscribe(
      (response: Order) => {
        alert('Status atualizado com sucesso!');
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
