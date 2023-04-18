import { Component, OnInit } from '@angular/core';
import { Fournisseur } from 'src/app/model/fournisseur';
import { FournisseurService } from 'src/app/services/fournisseur.service';

@Component({
  selector: 'app-list-fournisseur',
  templateUrl: './list-fournisseur.component.html',
  styleUrls: ['./list-fournisseur.component.css'],
})
export class ListFournisseurComponent implements OnInit {
  fournisseurs: Fournisseur[] = [];

  constructor(private fournisseurSrv: FournisseurService) {}
  ngOnInit(): void {
    this.initFournisseurs();
  }

  initFournisseurs() {
    this.fournisseurSrv.allFournisseur().subscribe((datas: Fournisseur[]) => {
      this.fournisseurs = datas;
    });
  }

  delete(id: number) {
    this.fournisseurSrv.delete(id).subscribe(() => {
      this.initFournisseurs();
    });
  }
}
