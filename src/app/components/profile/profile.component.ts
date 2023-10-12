import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/services/users/user-model';
import { getUser, setUser } from 'src/app/utils/utils';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})

export class ProfileComponent implements OnInit {

  // Controllers
  loading = false;

  // HTML Data
  user!: User;

  // User Input
  nome = '';
  email = '';
  telefone = '';
  rua = '';
  numero = '';
  bairro = '';
  cep = '';
  senha = '';

  constructor() { }

  ngOnInit(): void {
    this.loadUserData();
  }

  loadUserData() {
    this.user = getUser();
    this.nome = this.user.name;
    this.email = this.user.email;
    this.telefone = this.user.phone;
    this.senha = this.user.password;
  }

  async submitNewUser() {
    this.loading = true;
    this.user.name = this.nome;
    this.user.email = this.email;
    this.user.phone = this.telefone;
    this.user.password = this.senha;
    this.rua = this.user.rua;
    this.bairro = this.user.bairro;
    this.cep = this.user.cep;
    setUser(this.user)
    setTimeout(() => {
      this.loading = false;
    }, 1000);
  }
}