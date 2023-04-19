import { Injectable } from '@angular/core';
import { Fournisseur } from '../model/fournisseur';
import { Produit } from '../model/produit';

@Injectable({
  providedIn: 'root',
})
export class ObjectToJsonService {
  constructor() {}

  public fournisseurToJson(fournisseur: Fournisseur): any {
    let obj = {
      nom: fournisseur.nom,
      contact: fournisseur.contact,
      adresse: {
        numero: fournisseur.adresse?.numero,
        rue: fournisseur.adresse?.rue,
        codePostal: fournisseur.adresse?.codePostal,
        ville: fournisseur.adresse?.ville,
      },
    };
    if (fournisseur.id) {
      Object.assign(obj, { id: fournisseur.id });
    }
    return obj;
  }

  public produitToJson(produit: Produit): any {
    let obj = {
      libelle: produit.libelle,
      description: produit.description,
      prix: produit.prix,
    };
    if (produit.id) {
      Object.assign(obj, { id: produit.id });
    }
    if (produit.fournisseur) {
      Object.assign(obj, {
        fournisseur: this.fournisseurToJson(produit.fournisseur),
      });
    }
    return obj;
  }
}
