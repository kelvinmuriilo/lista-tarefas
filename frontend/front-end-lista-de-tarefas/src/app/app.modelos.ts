export class ListaTarefa{
    id: number;
    titulo: number;
    listaItens: Item[] = [];
}

export class Item{
    id: number;
    descricao: string;
    status: StatusItem;
}

export enum StatusItem{
    PENDENTE,
    CONCLUIDO 
}

export class CriarListaTarefa{
    titulo: string = '';
}

export class CriarItem{
    descricao: string = '';
    idListaTarefa: number;
}

export class AtualizarItem{
    status: StatusItem;
}