import { Component, Input, OnInit } from '@angular/core';
import { Client } from 'src/app/model/client';

@Component({
  selector: 'app-show-client',
  templateUrl: './show-client.component.html',
  styleUrls: ['./show-client.component.css'],
})
export class ShowClientComponent {
  @Input('customer')
  client!: Client;

  visible(): boolean {
    return this.client?.prenom && this.client?.nom ? true : false;
  }
}
