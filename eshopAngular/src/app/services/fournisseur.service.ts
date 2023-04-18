import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Fournisseur } from '../model/fournisseur';

@Injectable({
  providedIn: 'root',
})
export class FournisseurService {
  private url: string = 'http://localhost:8080/eshop/api/fournisseur';
  constructor(private httpClient: HttpClient) {}

  public allFournisseur(): Observable<Fournisseur[]> {
    return this.httpClient.get<Fournisseur[]>(
      'http://localhost:8080/eshop/api/fournisseur'
    );
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      `http://localhost:8080/eshop/api/fournisseur/${id}`
    );
  }

  public create(fournisseur: Fournisseur): Observable<Fournisseur> {
    console.debug(fournisseur);
    return this.httpClient.post<Fournisseur>(
      this.url,
      this.fournisseurToJson(fournisseur)
    );
  }

  public update(fournisseur: Fournisseur): Observable<Fournisseur> {
    return this.httpClient.put<Fournisseur>(
      `${this.url}/${fournisseur.id}`,
      fournisseur
    );
  }

  public getById(id: number): Observable<Fournisseur> {
    return this.httpClient.get<Fournisseur>(`${this.url}/${id}`);
  }

  private fournisseurToJson(fournisseur: Fournisseur): any {
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
    return obj;
  }
}
