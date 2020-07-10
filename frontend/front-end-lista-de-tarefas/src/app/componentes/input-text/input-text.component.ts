import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'input-text',
  templateUrl: './input-text.component.html',
  styleUrls: ['./input-text.component.scss']
})
export class InputTextComponent implements OnInit {
  @Input('nome') nome: string = '';
  @Input('tipo') tipo: string = 'text';
  @Input('placeholder') placeholder: string = '';
  @Input('valorInicial') valorInicial: any;

  @Output('valorRetorno') valorRetorno: EventEmitter<any> = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  retornarValor(){
    this.valorRetorno.emit(this.valorInicial);
  }

}
