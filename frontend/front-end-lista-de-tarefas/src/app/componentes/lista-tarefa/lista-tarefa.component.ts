import { Component, OnInit, Input } from '@angular/core';
import { ListaTarefaService } from 'src/app/servicos/lista-tarefa.service';
import { ListaTarefa } from 'src/app/app.modelos';

@Component({
  selector: 'lista-tarefa',
  templateUrl: './lista-tarefa.component.html',
  styleUrls: ['./lista-tarefa.component.scss']
})
export class ListaTarefaComponent implements OnInit {
  @Input('listaTarefa') listaTarefa: ListaTarefa;

  constructor() { }

  ngOnInit(): void {
  }

}
