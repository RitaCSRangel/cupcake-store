import { Component, Input, OnInit } from '@angular/core';
import { checkLogin } from 'src/app/utils/utils';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})

export class HeaderComponent implements OnInit {

  // Controlers
  logged = false;
  showCart = false;
  @Input() currentPage = '';

  constructor() { }

  ngOnInit(): void {
    this.checkCurrentPage();
    this.loadLoginFeatures();
  }

  loadLoginFeatures(){

    this.logged = checkLogin();
    if (this.logged === false) {
      let collection = document.getElementsByClassName('filled-button-iconBG');
      Array.from(collection).forEach(element => {
        element.classList.add('inactive');
      });
    } else if (this.logged === true) {
      let collection = document.getElementsByClassName('filled-button-iconBG');
      Array.from(collection).forEach(element => {
        element.classList.add('active');
      });
    }
  }

  checkCurrentPage() {
    if (this.currentPage === 'landing-page') {
      document.getElementById('inicio')?.classList.add('active');
      document.getElementById('cardapio')?.classList.remove('active');
      document.getElementById('acessar')?.classList.remove('active');
    } else if (this.currentPage === 'cardapio') {
      document.getElementById('inicio')?.classList.remove('active');
      document.getElementById('cardapio')?.classList.add('active');
      document.getElementById('acessar')?.classList.remove('active');
    } else if (this.currentPage === 'acessar') {
      document.getElementById('inicio')?.classList.remove('active');
      document.getElementById('cardapio')?.classList.remove('active');
      document.getElementById('acessar')?.classList.add('active');
    }
  }

  openCart(){
    this.showCart = !this.showCart;
  }
}