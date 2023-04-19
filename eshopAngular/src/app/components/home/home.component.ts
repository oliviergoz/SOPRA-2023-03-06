import { Component } from '@angular/core';
import { Compte } from 'src/app/model/compte';
import { ServiceExempleService } from 'src/app/services/service-exemple.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent {
  constructor(private monService: ServiceExempleService) {}

  get message() {
    return this.monService.sayHello();
  }

  get welcome() {
    let _welcome = 'bonjour ';
    if (sessionStorage.getItem('compte')) {
      let compte = JSON.parse(sessionStorage.getItem('compte')!) as Compte;
      _welcome = _welcome + compte.login;
    }
    return _welcome;
  }
}
