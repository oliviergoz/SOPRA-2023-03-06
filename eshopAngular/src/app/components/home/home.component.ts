import { Component } from '@angular/core';
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
}
