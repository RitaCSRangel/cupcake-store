import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})

export class LoginComponent implements OnInit {

  login = false;
  cadastro = true;
  esqueciSenha = false;

  constructor() { }

  ngOnInit(): void {
  }

}