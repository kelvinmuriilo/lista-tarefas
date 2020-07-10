import { Component, OnInit } from '@angular/core';
import { ListaTarefa, AtualizarItem, StatusItem } from '../app.modelos';
import { ListaTarefaService } from '../servicos/lista-tarefa.service';
import { ItemService } from '../servicos/item.service';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.scss']
})
export class LayoutComponent implements OnInit {
  listaTarefa: ListaTarefa;
  exibirBotaoCadastrar: boolean = true;
  exibirCriarItem: boolean;

  constructor(
    private listaTarefaService: ListaTarefaService,
    private itemService: ItemService,
    private spinnerService: NgxSpinnerService
  ) { }

  ngOnInit(): void {
    this.carregarListaTarefa();
  }

  carregarListaTarefa(){
    this.listaTarefaService.carregarListaTarefa().subscribe(
      data => {
        this.listaTarefa = data[0];
      },
      error => {
        alert('Não foi possível carregar a lista de tarefas. ' + error);
      }
    );
  }

  exibirAreaCriarLista(){
    return this.listaTarefa == undefined;
  }

  alterarExibirCriarItem(){
    this.exibirCriarItem = !this.exibirCriarItem;
  }

  alterarExibirBotaoCadastrar(){
    this.exibirBotaoCadastrar = !this.exibirBotaoCadastrar;
  }

  atualizarStatusItem(idItem: number){
    let atualizarItem = {
      status: StatusItem.CONCLUIDO
    }

    this.itemService.atualizarStatusItem(idItem, atualizarItem).subscribe(
      data => {
        this.carregarListaTarefa();
      },
      error => {
        alert('Erro ao atualizar status do item. ' + error);
      }
    );
  }

  removerItem(idItem: number){
    this.spinnerService.show();
    this.itemService.removerItem(idItem).subscribe(
      data => {
        this.carregarListaTarefa();
      },
      error => {
        alert("Erro ao remover item. " + error);
      },
      () => {
        this.spinnerService.hide();
      }
    )
  }
}
