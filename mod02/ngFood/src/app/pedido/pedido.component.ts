import { Component } from '@angular/core';
import { PedidoService } from '../pedido/pedido.service';

@Component({
  selector: 'app-pedido',
  templateUrl: './pedido.component.html',
  styleUrls: ['./pedido.component.css']
})
export class PedidoComponent {

  constructor(private pedidoService: PedidoService) { }

  getItens() {
    return this.pedidoService.getItens();
  }

  limpaPedido() {
    this.pedidoService.limpaPedido();
  }

  getValorTotal(): number {
    return this.pedidoService.getValorTotal();
  }
}
