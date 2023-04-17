import { Component, EventEmitter, Output } from '@angular/core';
import { Client } from 'src/app/model/client';

@Component({
  selector: 'app-form-client',
  templateUrl: './form-client.component.html',
  styleUrls: ['./form-client.component.css'],
})
export class FormClientComponent {
  client: Client = new Client();

  @Output()
  clientReady: EventEmitter<any> = new EventEmitter();

  sendClient() {
    if (this.client.prenom && this.client.nom) {
      // this.clientReady.emit(this.client);
      this.clientReady.emit({
        prenom: this.client.prenom,
        nom: this.client.nom,
        type: this.client.type,
      });
      this.client = new Client();
    }
  }

  prenom(data: any) {
    this.client.prenom = data as string;
  }
}
