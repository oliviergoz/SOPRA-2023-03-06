import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { clientRest } from '../env';

@Injectable({
  providedIn: 'root',
})
export class UtilisateurService {
  constructor(private http: HttpClient) {}

  public inscription(client: any): Observable<any> {
    return this.http.post(clientRest + '/inscription', client);
  }

  public checkLogin(login: string): Observable<boolean> {
    return this.http.get<boolean>(
      'http://localhost:8080/eshop/api/compte/login/check/' + login
    );
  }
}
