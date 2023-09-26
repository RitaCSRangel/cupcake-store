import { Component, Input, OnInit } from '@angular/core';
import { CartItem } from 'src/app/services/cart-item';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})

export class CartComponent implements OnInit {

  // HTML Data
  @Input() cart: CartItem[] = [];
  itemQuantity = '';
  totalValue = 0;

  constructor() { }

  ngOnInit(): void {
    this.cart = JSON.parse(sessionStorage.getItem('cart') || '{}')
    if (this.cart.length > 0){
      this.cart.forEach((item) => {
        this.totalValue = this.totalValue + item.value;
      })
    }
    if (this.cart.length > 1){
      this.itemQuantity = `${this.cart.length} itens adicionados ao carrinho`;
    }else if (this.cart.length === 1){
      this.itemQuantity = `${this.cart.length} item adicionado ao carrinho`;
    }else{
      this.itemQuantity = `Nenhum item foi adicionado ao carrinho`;
    }
  }

}