import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.scss']
})

export class LandingPageComponent implements OnInit {

  logged = false;
  @Input() currentPage = '';

  constructor() { }

  ngOnInit(): void {
    this.checkLogin();
  }

  checkLogin(){
    if (this.logged === false){
      document.getElementById('acessar')?.classList.remove('hidden');
    }else if(this.logged === true){
      document.getElementById('acessar')?.classList.add('hidden');
    }
  }
}