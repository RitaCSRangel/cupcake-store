import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Product } from 'src/app/services/products/product-model';
import { getCart } from 'src/app/utils/utils';

@Component({
  selector: 'app-payment-method',
  templateUrl: './payment-method.component.html',
  styleUrls: ['./payment-method.component.scss'],
  encapsulation: ViewEncapsulation.None
})

export class PaymentMethodComponent implements OnInit {

  // HTML Data
  cart: Product[] = [];
  isPix = false;
  isCard = false;
  totalValue = 0;

  cardNumber = '';
  cvv = '';
  name = '';
  expireDate = '';
  cpf = '';

  constructor(
    public activeModal: NgbActiveModal
  ) { }

  ngOnInit(): void {
    this.loadCart()
    this.calculateTotalValue();
  }

  loadCart() {
    // Obter o cart do session storage
    let sessionCart = getCart();
    if (sessionCart != null) {
      for (let i = 0; i < sessionCart.length; i++) {
        if (sessionCart[i].quantity > 0) {
          this.cart.push(sessionCart[i]);
        }
      }
    }
  }

  payWithPix() {
    this.isPix = true;
    this.isCard = false;
  }

  payWithCard() {
    this.isCard = true;
    this.isPix = false;
  }


  calculateTotalValue(){
    if (this.cart.length > 0){
      for(let i = 0; i<this.cart.length; i++){
        this.totalValue = this.totalValue + (this.cart[i].value * this.cart[i].quantity);
      }
    }
  }
}