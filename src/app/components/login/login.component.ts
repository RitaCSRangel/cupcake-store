import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/services/user-model';
import { setUser } from 'src/app/utils/utils';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})

export class LoginComponent implements OnInit {

  login = true;
  cadastro = false;
  esqueciSenha = false;

  constructor(
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  logIn() {
    let user: User = {
      id: 1,
      name: 'Rita',
      email: 'rita@email.com',
      phone: '19996812648',
      address: {
        rua: 'Rua gatinhos',
        numero: '1',
        bairro: 'felino',
        cep: '13330640'
      },
      password: '122'
    }
    setUser(user);
    this.router.navigate(['']);
  }
}