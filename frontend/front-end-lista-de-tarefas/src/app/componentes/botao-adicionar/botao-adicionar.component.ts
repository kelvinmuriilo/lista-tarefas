import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'botao-adicionar',
  templateUrl: './botao-adicionar.component.html',
  styleUrls: ['./botao-adicionar.component.scss']
})
export class BotaoAdicionarComponent implements OnInit {

  @Input('nome') nome: string = '';
  @Input('telaInicial') telaInicial: boolean;

  @Output('eventoClick') eventoClick: EventEmitter<any> = new EventEmitter;
  constructor() { }

  ngOnInit(): void {
  }

  bindClick(){
    this.eventoClick.emit();
  }

}
