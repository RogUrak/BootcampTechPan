import { Injectable } from '@angular/core';
import { IProduto } from '../produto';

interface IItemPedido {
  quantidade: number;
  produto: IProduto;
}

@Injectable({
  providedIn: 'root'
})
export class PedidoService {

  itens: IItemPedido[] = [];

  constructor() { }

  adicionaItem(produto: IProduto) {
    const item = this.itens.find(item => item.produto.descricao === produto.descricao);
    if (item) {
      item.quantidade++;
    } else {
      this.itens.push({
        quantidade: 1,
        produto
      })
    }
  }

  getQuantidadeTotal(): number {
    let total = 0;
    for (let item of this.itens) {
      total += item.quantidade;
    }
    return total;
  }

  getValorTotal(): number {
    let total = 0;
    for (let item of this.itens) {
      total += item.quantidade * item.produto.preco;
    }
    return total;
  }

  getItens() {
    return this.itens;
  }

  limpaPedido() {
    this.itens = [];
  }
}
