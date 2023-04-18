import { Fournisseur } from './../../../model/fournisseur';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Adresse } from 'src/app/model/adresse';
import { FournisseurService } from 'src/app/services/fournisseur.service';

@Component({
  selector: 'app-edit-fournisseur',
  templateUrl: './edit-fournisseur.component.html',
  styleUrls: ['./edit-fournisseur.component.css'],
})
export class EditFournisseurComponent implements OnInit {
  constructor(
    private fournisseurSrv: FournisseurService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.fournisseur = new Fournisseur();
    this.fournisseur.adresse = new Adresse();
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.fournisseurSrv
          .getById(params['id'])
          .subscribe((data: Fournisseur) => {
            this.fournisseur = data;
          });
      }
    });
  }
  fournisseur!: Fournisseur;

  save() {
    if (this.fournisseur.id) {
      //update
      this.fournisseurSrv.update(this.fournisseur).subscribe(() => {
        this.router.navigateByUrl('/fournisseur');
      });
    } else {
      //create
      this.fournisseurSrv.create(this.fournisseur).subscribe(() => {
        this.router.navigateByUrl('/fournisseur');
      });
    }
  }
}
