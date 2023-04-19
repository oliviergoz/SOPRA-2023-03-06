import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Fournisseur } from '../model/fournisseur';
import { ObjectToJsonService } from './object-to-json.service';

@Injectable({
  providedIn: 'root',
})
export class FournisseurService {
  private url: string = 'http://localhost:8080/eshop/api/fournisseur';
  constructor(
    private httpClient: HttpClient,
    private convert: ObjectToJsonService
  ) {}

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
      this.convert.fournisseurToJson(fournisseur)
    );
  }

  public update(fournisseur: Fournisseur): Observable<Fournisseur> {
    return this.httpClient.put<Fournisseur>(
      `${this.url}/${fournisseur.id}`,
      this.convert.fournisseurToJson(fournisseur)
    );
  }

  public getById(id: number): Observable<Fournisseur> {
    return this.httpClient.get<Fournisseur>(`${this.url}/${id}`);
  }
}
