import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IProduto } from '../produto';
import { PedidoService } from '../pedido/pedido.service';

@Component({
  selector: 'app-cardapio',
  templateUrl: './cardapio.component.html',
  styleUrls: ['./cardapio.component.css']
})
export class CardapioComponent implements OnInit {

  produtos: IProduto[] = [];

  constructor(private httpClient: HttpClient, private pedidoService: PedidoService) { }

  ngOnInit(): void {
    this.httpClient.get<IProduto[]>('http://localhost:3000/cardapio')
      .subscribe(produtos => {
        this.produtos = produtos;
      });
  }

  adicionaItem(produto: IProduto) {
    this.pedidoService.adicionaItem(produto);
  }

  getQuantidadeTotal(): number {
    return this.pedidoService.getQuantidadeTotal();
  }

  getValorTotal(): number {
    return this.pedidoService.getValorTotal();
  }

}
