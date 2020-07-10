import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CriarListaTarefa, ListaTarefa } from '../app.modelos';
import { URL_API } from '../app.constantes';

const END_POINT = `/lista-tarefa`;

@Injectable({
  providedIn: 'root'
})
export class ListaTarefaService {

  constructor(
    private httpClient: HttpClient
  ) { }

  criarListaTarefa(listaTarefa: CriarListaTarefa): Observable<string>{
    return this.httpClient.post(URL_API + END_POINT, listaTarefa, {responseType: 'text'});
  }

  carregarListaTarefa(): Observable<ListaTarefa>{
    return this.httpClient.get<ListaTarefa>(URL_API + END_POINT);
  }
}
