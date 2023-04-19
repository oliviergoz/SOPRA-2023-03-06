import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Compte } from 'src/app/model/compte';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  login: string = '';
  password: string = '';
  showError = false;

  constructor(private loginSrv: LoginService, private router: Router) {}

  check() {
    this.loginSrv.login(this.login, this.password).subscribe({
      next: (infos: Compte) => {
        this.showError = false;
        sessionStorage.setItem(
          'token',
          'Basic ' + window.btoa(this.login + ':' + this.password)
        );
        sessionStorage.setItem('compte', JSON.stringify(infos));
        this.router.navigateByUrl('/home');
      },
      error: (error: any) => {
        console.debug(error);
        this.showError = true;
      },
    });
  }
}
