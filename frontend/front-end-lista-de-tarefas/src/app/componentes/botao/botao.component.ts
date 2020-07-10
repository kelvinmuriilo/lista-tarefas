import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'botao',
  templateUrl: './botao.component.html',
  styleUrls: ['./botao.component.scss']
})
export class BotaoComponent implements OnInit {
  @Input('classeHabilitado') classeHabilitado: string;
  @Input('classeDesabilitado') classeDesabilitado: string = 'btn-secondary btn-block';
  @Input('nome') nome: string;
  @Input('liberado') liberado: boolean = true;
  @Input('classeIcone') classeIcone: string;

  @Output() eventoClick: EventEmitter<any> = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  bindClick(){
    this.eventoClick.emit();
  }

  isBloqueado(): boolean{
    return this.liberado === false;
  }

  alterarEstilo(): string{
    if(this.liberado){
      return this.classeHabilitado;
    }

   return this.classeDesabilitado;
  }

}
