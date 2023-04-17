import { Component, EventEmitter, Output } from '@angular/core';
import { Produit } from '../model/produit';

@Component({
  selector: 'app-form-produit',
  templateUrl: './form-produit.component.html',
  styleUrls: ['./form-produit.component.css'],
})
export class FormProduitComponent {
  produit: Produit = new Produit();

  @Output()
  produitEvent: EventEmitter<Produit> = new EventEmitter();

  add() {
    this.produitEvent.emit(this.produit);
    this.produit = new Produit();
  }
}
