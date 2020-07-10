import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';

import { ItemService } from 'src/app/servicos/item.service';
import { NgxSpinnerService } from "ngx-spinner";
import { CriarItem } from 'src/app/app.modelos';

@Component({
  selector: 'criador-item',
  templateUrl: './criador-item.component.html',
  styleUrls: ['./criador-item.component.scss']
})
export class CriadorItemComponent implements OnInit {
  item: CriarItem = new CriarItem();

  @Input('idListaTarefa') idListaTarefa: number;

  @Output('clickBotaoCancelar') clickBotaoCancelar: EventEmitter<any> = new EventEmitter;
  @Output('carregarListaTarefa') carregarListaTarefa: EventEmitter<any> = new EventEmitter;
  @Output('fecharJanela') fecharJanela: EventEmitter<any> = new EventEmitter;
  constructor(
    private itemService: ItemService,
    private ngxSpinnerService: NgxSpinnerService
  ) { }

  ngOnInit(): void {
  }

  criarItem(){
    this.ngxSpinnerService.show();
    this.item.idListaTarefa = this.idListaTarefa;
    this.itemService.criarItem(this.item).subscribe(
      data => {
        this.carregarListaTarefa.emit();
        this.fecharJanela.emit();
      },
      error => {
        alert('Erro! Não foi possível adicionar o item.' + error);
      },
      ()=>{
        this.ngxSpinnerService.hide();
      }
    );
  }

  clickCancelar(){
    this.item.descricao = '';
    this.clickBotaoCancelar.emit();
  }

  liberarBotaoSalvar(): boolean{
    return this.item.descricao != '';
  }

}
