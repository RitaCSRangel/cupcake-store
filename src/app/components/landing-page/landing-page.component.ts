import { Component, Input, OnInit } from '@angular/core';
import { CartItem } from 'src/app/services/cart-item';
import { checkLogin } from 'src/app/utils/utils';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.scss']
})

export class LandingPageComponent implements OnInit {

  // Controlers
  logged = false;
  @Input() currentPage = '';

  // Page data
  popularItems: CartItem[] = [];

  constructor() { }

  ngOnInit(): void {
    sessionStorage.setItem('user', 'Rita');
    this.loadLoginFeatures();
    this.loadPopularItems();
  }

  loadLoginFeatures(){

    this.logged = checkLogin();
    if (this.logged){
      document.getElementById('acessar')?.classList.add('hidden');
      this.logged = true;
    }else{
      document.getElementById('acessar')?.classList.remove('hidden');
      this.logged = false;
    }
  }

  loadPopularItems(){
    var item: CartItem = {
      name: 'Vanilla Latte',
      value: 20,
      quantity: 10,
      score: 5,
      image: '../../../assets/landing-page/product-image-example.png'
    }

    this.popularItems.push(item);
    this.popularItems.push(item);
    this.popularItems.push(item);
    this.popularItems.push(item);
  }

  addToCart(index: number){
    if (this.logged === false){
      if (document.getElementById(`cardalert-${index}`)?.classList.contains('invisible')){
        document.getElementById(`cardalert-${index}`)?.classList.remove('invisible');
        document.getElementById(`cardalert-${index}`)?.classList.add('visible');
      }else{
        document.getElementById(`cardalert-${index}`)?.classList.add('invisible');
        document.getElementById(`cardalert-${index}`)?.classList.remove('visible');
      }
    }
  }
}