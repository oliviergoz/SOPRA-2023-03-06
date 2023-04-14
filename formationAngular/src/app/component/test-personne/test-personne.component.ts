import { Fournisseur } from './../../model/fournisseur';
import { Component } from '@angular/core';
import { Client } from 'src/app/model/client';
import { TypeClient } from 'src/app/model/type-client';

@Component({
  selector: 'app-test-personne',
  templateUrl: './test-personne.component.html',
  styleUrls: ['./test-personne.component.css'],
})
export class TestPersonneComponent {
  client: Client = new Client('olivier', 'gozlan', TypeClient.Particulier);
  fournisseur: Fournisseur = new Fournisseur('ajc');
}
