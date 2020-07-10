import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CriarItem, AtualizarItem } from '../app.modelos';
import { URL_API } from '../app.constantes';
import { Observable } from 'rxjs';

const END_POINT = '/item';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor(
    private httpClient: HttpClient
  ) { }

  criarItem(item: CriarItem): Observable<string>{
    return this.httpClient.post(URL_API + END_POINT, item, { responseType: 'text' });
  }

  atualizarStatusItem(idItem: number, item: AtualizarItem): Observable<string>{
    return this.httpClient.put(`${URL_API}${END_POINT}/${idItem}`, item, { responseType: 'text' });
  }

  removerItem(idItem: number): Observable<string>{
    return this.httpClient.delete(`${URL_API}${END_POINT}/${idItem}`, { responseType: 'text'});
  }
}
