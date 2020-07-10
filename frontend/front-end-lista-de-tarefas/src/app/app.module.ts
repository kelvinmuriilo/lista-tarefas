import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { LayoutComponent } from './layout/layout.component';
import { ListaTarefaComponent } from './componentes/lista-tarefa/lista-tarefa.component';
import { ItemComponent } from './componentes/item/item.component';
import { BotaoComponent } from './componentes/botao/botao.component';
import { CriadorListaTarefaComponent } from './componentes/criador-lista-tarefa/criador-lista-tarefa.component';
import { InputTextComponent } from './componentes/input-text/input-text.component';
import { BotaoAdicionarComponent } from './componentes/botao-adicionar/botao-adicionar.component';
import { NavbarComponent } from './componentes/navbar/navbar.component';
import { CriadorItemComponent } from './componentes/criador-item/criador-item.component';

import { NgxSpinnerModule } from "ngx-spinner";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';



@NgModule({
  declarations: [
    AppComponent,
    LayoutComponent,
    ListaTarefaComponent,
    ItemComponent,
    CriadorListaTarefaComponent,
    InputTextComponent,
    BotaoComponent,
    BotaoAdicionarComponent,
    NavbarComponent,
    CriadorItemComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    NgxSpinnerModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
