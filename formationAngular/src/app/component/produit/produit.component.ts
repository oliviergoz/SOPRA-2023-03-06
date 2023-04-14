import { Component } from '@angular/core';
import { Produit } from 'src/app/model/produit';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css'],
})
export class ProduitComponent {
  produit: Produit = new Produit();
  message: string = this.produit.hello;
}
