import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})

export class CartComponent implements OnInit {

  @Input() cart: any[] = [];
  itemQuantity = '';
  totalValue = 0;

  constructor() { }

  ngOnInit(): void {
    if (this.cart.length > 0){
      this.cart.forEach((item) => {
        this.totalValue = this.totalValue + item.value;
      })
    }
  }

}