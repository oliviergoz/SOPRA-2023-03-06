import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Fournisseur } from 'src/app/model/fournisseur';
import { Produit } from 'src/app/model/produit';
import { FournisseurService } from 'src/app/services/fournisseur.service';
import { ProduitService } from 'src/app/services/produit.service';

@Component({
  selector: 'app-edit-produit',
  templateUrl: './edit-produit.component.html',
  styleUrls: ['./edit-produit.component.css'],
})
export class EditProduitComponent implements OnInit {
  produit!: Produit;
  //fournisseurs: Fournisseur[] = [];
  obsFournisseurs!: Observable<Fournisseur[]>;

  constructor(
    private aR: ActivatedRoute,
    private produitSrv: ProduitService,
    private fournisseurSrv: FournisseurService,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.produit = new Produit();
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.produitSrv.getById(params['id']).subscribe((produit: Produit) => {
          this.produit = produit;
        });
      }
    });

    // this.fournisseurSrv
    //   .allFournisseur()
    //   .subscribe((fournisseurs: Fournisseur[]) => {
    //     this.fournisseurs = fournisseurs;
    //   });

    this.obsFournisseurs = this.fournisseurSrv.allFournisseur();
  }

  save() {
    let obvResult: Observable<Produit>;
    if (this.produit.id) {
      obvResult = this.produitSrv.update(this.produit);
    } else {
      obvResult = this.produitSrv.create(this.produit);
    }
    obvResult.subscribe(() => {
      this.router.navigateByUrl('/produit');
    });
  }

  compareById(obj1: Produit, obj2: Produit) {
    return obj1 && obj2 && obj1.id == obj2.id;
  }
}
