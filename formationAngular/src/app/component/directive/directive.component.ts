import { Component } from '@angular/core';
import { Produit } from 'src/app/model/produit';

@Component({
  selector: 'app-directive',
  templateUrl: './directive.component.html',
  styleUrls: ['./directive.component.css'],
})
export class DirectiveComponent {
  variableIf = true;
  styleVert = false;
  noms = ['olivier', 'fiona', 'alix', 'jeanne'];
  produits = [new Produit('tele', 1000), new Produit('telephone', 500)];
  texte = '';

  nomsFiltre(): string[] {
    return this.noms.filter((n) => n.indexOf(this.texte) != -1);
  }
}
