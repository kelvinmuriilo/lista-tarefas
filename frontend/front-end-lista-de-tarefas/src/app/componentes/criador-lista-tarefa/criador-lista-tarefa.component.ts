import { Component, OnInit, Output, EventEmitter } from '@angular/core';
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

  constructor(
    private listaTarefaService: ListaTarefaService
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
      data => {
        alert(data.toString());
        this.carregarListaEvent.emit();
      }
    );
  }

  liberarBotaoSalvar(): boolean{
    return this.listaTarefa.titulo != '';
  }
}
