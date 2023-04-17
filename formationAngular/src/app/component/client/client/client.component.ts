import { Component } from '@angular/core';
import { Client } from 'src/app/model/client';
import { TypeClient } from 'src/app/model/type-client';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css'],
})
export class ClientComponent {
  client!: Client;

  traitementClient(client: Client) {
    this.client = client;
  }
}
