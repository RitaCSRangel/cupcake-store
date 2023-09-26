import { Component, Input, OnInit } from '@angular/core';
import { Product } from 'src/app/services/product-model';
import { checkLogin, getCart, setCart, setUser } from 'src/app/utils/utils';
import { HeaderComponent } from '../header/header.component';
import { User } from 'src/app/services/user-model';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.scss']
})

export class LandingPageComponent implements OnInit {

  // Controlers
  logged = false;
  @Input() currentPage = '';
  cartManipulationInProgress = false;

  // Page data
  products: Product[] = [];

  constructor(
  ) { }

  ngOnInit(): void {
    this.loadProducts();
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

  loadProducts() {
    // Veridicar se já existe um carrinho
    let sessionCart = getCart();
    if (sessionCart != null) {
      this.products = sessionCart;
    }else{
      var item1: Product = {
        id: 1,
        name: 'Vanilla Latte',
        value: 20,
        type: 'cafe',
        quantity: 0,
        stock: 20,
        score: 5,
        image: '../../../assets/landing-page/product-image-example.png'
      }

      var item2: Product = {
        id: 2,
        name: 'Espresso',
        value: 20,
        type: 'cafe',
        quantity: 0,
        stock: 20,
        score: 4.8,
        image: '../../../assets/landing-page/product-image-example.png'
      }

      var item3: Product = {
        id: 3,
        name: 'Chocolate Cupcake',
        value: 20,
        type: 'cupcake',
        quantity: 0,
        stock: 20,
        score: 3.3,
        image: '../../../assets/landing-page/product-image-example.png'
      }

      var item4: Product = {
        id: 4,
        name: 'Vanilla Cupcake',
        value: 20,
        type: 'cupcake',
        quantity: 0,
        stock: 20,
        score: 4,
        image: '../../../assets/landing-page/product-image-example.png'
      }

      this.products.push(item1);
      this.products.push(item2);
      this.products.push(item3);
      this.products.push(item4);
    }

    // Arrumar do maior pro menor score
    this.products.sort((itemA, itemB) => (itemA.score < itemB.score) ? 1 : (itemA.score > itemB.score) ? -1 : 0);
    setCart(this.products);
  }

  addRemoveToCart(id: number, action: string) {

    //Procurar pelo item clicado nos produtos
    for (let i = 0; i < this.products.length; i++) {

      //Ao encontrar, atualizar a quantidade do produto, atualizar o cart no session storage e encerrar
      if (this.products[i].id === id) {
        if (action === 'add') {
          this.products[i].quantity = this.products[i].quantity + 1;
        } else if (action === 'rem') {
          if (this.products[i].quantity > 0) {
            this.products[i].quantity = this.products[i].quantity - 1;
          } else {
            return;
          }
        } else {
          return;
        }
        setCart(this.products);
        break;
      }
    }
  }

  showAlert(id: string) {
    if (this.logged === false) {
      if (document.getElementById(`cardalert-${id}`)?.classList.contains('invisible')) {
        document.getElementById(`cardalert-${id}`)?.classList.remove('invisible');
        document.getElementById(`cardalert-${id}`)?.classList.add('visible');
      } else {
        document.getElementById(`cardalert-${id}`)?.classList.add('invisible');
        document.getElementById(`cardalert-${id}`)?.classList.remove('visible');
      }
    }
  }

}