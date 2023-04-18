import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Produit } from 'src/app/model/produit';

@Component({
  selector: '[tr-produit]',
  templateUrl: './tr-produit.component.html',
  styleUrls: ['./tr-produit.component.css'],
})
export class TrProduitComponent {
  @Input()
  produit!: Produit;
  @Input()
  index!: number;
  display = true;
  @Output()
  produitChange: EventEmitter<any> = new EventEmitter();

  edit() {
    this.display = false;
  }

  save() {
    this.display = true;
    this.produitChange.emit({
      produit: this.produit,
      index: this.index,
    });
  }
}
