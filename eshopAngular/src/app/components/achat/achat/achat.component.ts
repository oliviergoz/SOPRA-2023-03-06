import { Router } from '@angular/router';
import { ObjectToJsonService } from './../../../services/object-to-json.service';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Produit } from 'src/app/model/produit';
import { AchatService } from 'src/app/services/achat.service';
import { ProduitService } from 'src/app/services/produit.service';

@Component({
  selector: 'app-achat',
  templateUrl: './achat.component.html',
  styleUrls: ['./achat.component.css'],
})
export class AchatComponent implements OnInit {
  obsProduit!: Observable<Produit[]>;
  panier!: Map<number, number>;

  constructor(
    private produitSrv: ProduitService,
    private convert: ObjectToJsonService,
    private achatSrv: AchatService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.obsProduit = this.produitSrv.allProduit();
    if (sessionStorage.getItem('panier') == null) {
      this.panier = new Map<number, number>();
      sessionStorage.setItem('panier', this.convert.panierToJson(this.panier));
    }
  }

  addPanier(id: number) {
    if (this.panier.get(id)) {
      this.panier.set(id, this.panier.get(id)! + 1);
    } else {
      this.panier.set(id, 1);
    }
    sessionStorage.setItem('panier', this.convert.panierToJson(this.panier));
  }

  quantite(id: number): number | undefined {
    return this.panier.get(id);
  }

  remove(id: number) {
    if (this.panier.get(id) == 1) {
      this.panier.delete(id);
    } else {
      this.panier.set(id, this.panier.get(id)! - 1);
      sessionStorage.setItem('panier', this.convert.panierToJson(this.panier));
    }
  }

  valider() {
    this.achatSrv.create().subscribe((commande) => {
      sessionStorage.removeItem('panier');
      this.router.navigateByUrl('/home');
    });
  }
}
