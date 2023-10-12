import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/services/users/user-model';
import { UsersService } from 'src/app/services/users/users.service';
import { setUser } from 'src/app/utils/utils';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})

export class LoginComponent implements OnInit {

  // -------- Atributos --------

  // Controladores
  login = true;
  cadastro = false;
  esqueciSenha = false;

  // Inputs
  emailLogin = "";
  passwordLogin = "";

  nameRegister = "";
  emailRegister = "";
  phoneRegister = "";
  ruaRegister = "";
  numeroRegister = ""
  bairroRegister = "";
  cidadeRegister = "";
  estadoRegister = "";
  cepRegister = "";
  passwordRegister = "";

  emailRecovery = "";
  passwordRecovery = "";
  passwordRecoveryConfirmation = "";

  // -------- Método Construtor --------
  constructor(
    private router: Router,
    private usersService: UsersService
  ) { }

  // -------- Métodos do ciclo de vida do componente --------
  ngOnInit(): void {
  }

  // -------- Métodos da Classe --------

  // Método logIn
  // Este método é chamado quando o usuário clica no botão de login. Ele faz o envio das informações via API para o banco, valida se
  // obtém um retorno positivo e permite ou nega o login.
  logIn() {
    const user: User = {
      name: "",
      email: this.emailLogin,
      phone: "",
      rua: "",
      numero: "",
      bairro: "",
      cidade: "",
      estado: "",
      cep: "",
      password: this.passwordLogin
    }
    this.usersService.loginUser(user).subscribe(
      (response: any) => {
        setUser(response);
        this.router.navigate(['']);
      },
      (error: HttpErrorResponse) => {
        alert("Nenhum usuário com essas informações foi encontrado, tente novamente ou cadastre-se.");
      }
    );
  }

  // Método register
  // Este método é chamado quando o usuário clica no botão de Cadastrar. Ele faz o envio das informações via API para o banco, 
  // e adiciona os dados do usuário na base.
  register() {
    const user: User = {
      name: this.nameRegister,
      email: this.emailRegister,
      phone: this.phoneRegister,
      rua: this.ruaRegister,
      numero: this.numeroRegister,
      bairro: this.bairroRegister,
      cidade: this.cidadeRegister,
      estado: this.estadoRegister,
      cep: this.cepRegister,
      password: this.passwordRegister
    }
    this.usersService.addUser(user).subscribe(
      (response: any) => {
        setUser(response);
        this.router.navigate(['']);
      },
      (error: HttpErrorResponse) => {
        alert("Nâo foi possível realizar seu cadastro, tente novamente mais tarde.");
      }
    );
  }

  // Método resetPassword
  // Este método é chamado quando o usuário clica no botão de Login após inserir os dados de recuperação de senha. Ele faz o envio das informações via API para o banco,
  // e se encontrar uma correspondência faz a atualização dos dados para por fim permitir o login.
  resetPassword() {
    const user: User = {
      name: "",
      email: this.emailRecovery,
      phone: "",
      rua: "",
      numero: "",
      bairro: "",
      cidade: "",
      estado: "",
      cep: "",
      password: ""
    }
    this.usersService.recoverPasswordUser(user).subscribe(
      (responseSearch: any) => {

        const newUser: User = {
          name: responseSearch.name,
          email: this.emailLogin,
          phone: responseSearch.phone,
          rua: responseSearch.rua,
          numero: responseSearch.numero,
          bairro: responseSearch.bairro,
          cidade: responseSearch.cidade,
          estado: responseSearch.estado,
          cep: responseSearch.cep,
          password: this.passwordRecovery
        }

        this.usersService.updateUser(newUser).subscribe((responseUpdate: any) => {
          setUser(responseUpdate);
          this.router.navigate(['']);
        },
          (error: HttpErrorResponse) => {
            alert("Não foi possível alterar a senha do usuário.");
          }
        )

      },
      (error: HttpErrorResponse) => {
        alert("Nenhum usuário com essas informações foi encontrado, tente novamente ou cadastre-se.");
      }
    );
  }

  // Método changeToCadastro
  // Este método habilita o componente de cadastro em tela
  changeToCadastro() {
    this.login = false;
    this.cadastro = true;
    this.esqueciSenha = false;
  }

  // Método changeToEsqueciSenha
  // Este método habilita o componente de recuperação de senha em tela
  changeToEsqueciSenha() {
    this.login = false;
    this.cadastro = false;
    this.esqueciSenha = true;
  }

  // Método   changeToLogin() {
  // Este método habilita o componente de login em tela
  changeToLogin() {
    this.login = true;
    this.cadastro = false;
    this.esqueciSenha = false;
  }

}