import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ObjectToJsonService } from './object-to-json.service';
import { achatRest } from '../env';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AchatService {
  constructor(private http: HttpClient, private convert: ObjectToJsonService) {}

  public create(): Observable<any> {
    let map = this.convert.panierJsonToMap(sessionStorage.getItem('panier'));
    let achats: any[] = [];
    map.forEach((v, k) => {
      achats.push({ idProduit: k, quantite: v });
    });
    return this.http.post(achatRest, achats);
  }
}
