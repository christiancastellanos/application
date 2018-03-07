import { Injectable } from '@angular/core';
import { Usuario } from '../model/usuario';
import { UsuarioProfile } from '../model/usuarioprofile';
import { UsuariosConfig } from '../usuarios.config';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { ResultMessage } from '../../model/result-message';

const httpOptions = {
  headers: new HttpHeaders({'Content-type': 'application/json'})
};


@Injectable()
export class UsuariosService {

  private resourceUrl: string;

  constructor( private http: HttpClient ) {
    this.resourceUrl = UsuariosConfig.httpResource.usuarios;
  }

  getAll(): Observable<Usuario[]> {
    return this.http.get<ResultMessage>(`${this.resourceUrl}`, httpOptions).map(response => response['data']);
  }

  getTypes(): Observable<UsuarioProfile[]> {
    return this.http.get<ResultMessage>(`${this.resourceUrl}/types`, httpOptions).map(response => response['data']);
  }

  get(id: number): Observable<Usuario> {
    return this.http.get<ResultMessage>(`${this.resourceUrl}/${id}`, httpOptions).map(response => response['data']);
  }

  create(usuario: Usuario): Observable<Usuario> {
    return this.http.post<ResultMessage>(`${this.resourceUrl}`, usuario, httpOptions)
    .map(response => {
      this.showMessage(response);
      return response['data'];
    });
  }

  update(usuario: Usuario): Observable<Usuario> {
    return this.http.put<ResultMessage>(`${this.resourceUrl}/${usuario.id}`, usuario, httpOptions)
    .map(response => {
      this.showMessage(response);
      return response['data'];
    });
  }

  delete(ssoid: string): Observable<Usuario> {
    return this.http.delete<ResultMessage>(`${this.resourceUrl}/${ssoid}`, httpOptions)
    .map(response => {
      this.showMessage(response);
      return response['data'];
    });
  }

  private showMessage(response) {
    alert(response.message);
  }

}
