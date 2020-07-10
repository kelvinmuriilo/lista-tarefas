import { Component, OnInit, Output, EventEmitter, ViewChild, ElementRef } from '@angular/core';

import { CriarListaTarefa } from 'src/app/app.modelos';
import { ListaTarefaService } from 'src/app/servicos/lista-tarefa.service';

@Component({
  selector: 'criador-lista-tarefa',
  templateUrl: './criador-lista-tarefa.component.html',
  styleUrls: ['./criador-lista-tarefa.component.scss']
})
export class CriadorListaTarefaComponent implements OnInit {
  listaTarefa: CriarListaTarefa;

  @Output('clickBotaoCancelar') clickBotaoCancelar: EventEmitter<any> = new EventEmitter;
  @Output('carregarListaEvent') carregarListaEvent: EventEmitter<any> = new EventEmitter;
  @ViewChild('tituloInput') tituloInput: ElementRef<HTMLInputElement>;


  constructor(
    private listaTarefaService: ListaTarefaService,
  ) { }

  ngOnInit(): void {
    this.listaTarefa = new CriarListaTarefa();
  }

  clickCancelar(){
    this.listaTarefa.titulo = '';
    this.clickBotaoCancelar.emit();
  }

  criarLista(){
    console.log(this.listaTarefa)
    this.listaTarefaService.criarListaTarefa(this.listaTarefa).subscribe(
      () => {
        this.carregarListaEvent.emit();
      },
      error => {
        console.log(error)
        alert("Erro ao criar lista de tarefas. " + error.message);
      }
    );
  }

  liberarBotaoSalvar(): boolean{
    return this.listaTarefa.titulo != '';
  }
}
