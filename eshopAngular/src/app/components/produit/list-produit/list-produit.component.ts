import { Component, OnInit } from '@angular/core';
import { Produit } from 'src/app/model/produit';
import { ProduitService } from 'src/app/services/produit.service';

@Component({
  selector: 'app-list-produit',
  templateUrl: './list-produit.component.html',
  styleUrls: ['./list-produit.component.css'],
})
export class ListProduitComponent implements OnInit {
  produits: Produit[] = [];

  constructor(private produitSrv: ProduitService) {}
  ngOnInit(): void {
    this.initProduits();
  }

  initProduits() {
    this.produitSrv.allProduit().subscribe((produits: Produit[]) => {
      this.produits = produits;
    });
  }

  delete(id: number) {
    this.produitSrv.delete(id).subscribe(() => {
      this.initProduits();
    });
  }
}
