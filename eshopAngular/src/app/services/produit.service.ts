import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Produit } from '../model/produit';
import { produitRest } from '../env';
import { ObjectToJsonService } from './object-to-json.service';

@Injectable({
  providedIn: 'root',
})
export class ProduitService {
  constructor(private http: HttpClient, private convert: ObjectToJsonService) {}

  public allProduit(): Observable<Produit[]> {
    return this.http.get<Produit[]>(produitRest);
  }

  public getById(id: number): Observable<Produit> {
    return this.http.get<Produit>(`${produitRest}/${id}`);
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(`${produitRest}/${id}`);
  }

  public update(produit: Produit): Observable<Produit> {
    return this.http.put<Produit>(
      `${produitRest}/${produit.id}`,
      this.convert.produitToJson(produit)
    );
  }

  public create(produit: Produit): Observable<Produit> {
    return this.http.post<Produit>(
      produitRest,
      this.convert.produitToJson(produit)
    );
  }
}
