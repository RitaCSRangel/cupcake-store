import { Component, Input, OnInit } from '@angular/core';
import { Product } from 'src/app/services/product-model';
import { checkLogin, getCart, setCart } from 'src/app/utils/utils';

@Component({
  selector: 'app-products-menu',
  templateUrl: './products-menu.component.html',
  styleUrls: ['./products-menu.component.scss']
})

export class ProductsMenuComponent implements OnInit {

  @Input() cart: Product[] = [];
  cupcakeTab = false;
  coffeeTab = true;

  // Controlers
  logged = false;

  constructor() { }

  ngOnInit(): void {
    this.loadCart();
    this.loadLoginFeatures();
  }

  loadLoginFeatures() {

    this.logged = checkLogin();
    if (this.logged) {
      document.getElementById('acessar')?.classList.add('hidden');
      this.logged = true;
    } else {
      document.getElementById('acessar')?.classList.remove('hidden');
      this.logged = false;
    }
  }

  loadCart() {
    // Obter o cart do session storage
    let sessionCart = getCart();
    if (sessionCart != null) {
      this.cart = sessionCart;
    }
  }

  addRemoveToCart(id: number, action: string) {

    //Procurar pelo item clicado nos produtos
    for (let i = 0; i < this.cart.length; i++) {

      //Ao encontrar, atualizar a quantidade do produto, atualizar o cart no session storage e encerrar
      if (this.cart[i].id === id) {
        if (action === 'add') {
          this.cart[i].quantity = this.cart[i].quantity + 1;
        } else if (action === 'rem') {
          if (this.cart[i].quantity > 0) {
            this.cart[i].quantity = this.cart[i].quantity - 1;
          } else {
            return;
          }
        } else {
          return;
        }
        setCart(this.cart);
        break;
      }
    }
  }

  changeTab(id: string){
    if (id === 'coffee-tab'){
      document.getElementById('coffee-tab')?.classList.add('active');
      document.getElementById('cupcake-tab')?.classList.remove('active');
      this.coffeeTab = true;
      this.cupcakeTab = false;
    }

    if (id === 'cupcake-tab'){
      document.getElementById('coffee-tab')?.classList.remove('active');
      document.getElementById('cupcake-tab')?.classList.add('active');
      this.coffeeTab = false;
      this.cupcakeTab = true;
    }
  }
}