import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Item, StatusItem } from 'src/app/app.modelos';

@Component({
  selector: 'item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.scss']
})
export class ItemComponent implements OnInit {

  @Input('item') item: Item;

  @Output('marcarCheckbox') marcarCheckbox: EventEmitter<any> = new EventEmitter;

  constructor() { }

  ngOnInit(): void {
  }

  marcado(){
    this.marcarCheckbox.emit();
  }

  returnStatus(): boolean{
    let statusItemAtual = StatusItem[this.item.status].toString();
    console.log(statusItemAtual)
    if(statusItemAtual == '1'){
      return true;
    }
    return false;
  }

}
