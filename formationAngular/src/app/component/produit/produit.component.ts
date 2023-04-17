import { Component } from '@angular/core';
import { Produit } from 'src/app/model/produit';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css'],
})
export class ProduitComponent {
  produits: Produit[] = [new Produit('pc', 700), new Produit('velo', 4000)];

  filtre: string = '';

  filter() {
    return this.produits.filter((p) => p.nom?.indexOf(this.filtre) != -1);
  }

  addProduit(produit: Produit) {
    this.produits.push(produit);
  }
}
