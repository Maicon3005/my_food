package maicon.dias.myfood.repository;

import java.util.ArrayList;
import java.util.List;

import maicon.dias.myfood.model.Pedido;
import maicon.dias.myfood.model.Produto;

public class PedidoRepository {

    private static final List<Pedido> listaDePedidos  = new ArrayList<>();

    public boolean salvarItem(Pedido pedido){

        if(listaDePedidos.size() == 0){
            Pedido novoPedido = new Pedido(pedido.getNome(), pedido.getQuantidade(), pedido.getPrecoSomado());
            listaDePedidos.add(novoPedido);
            return true;
        }else{
            for (int i = 0; i < listaDePedidos.size(); i++) {
                if(pedido.getNome().equals(listaDePedidos.get(i).getNome())){
                    listaDePedidos.get(i).setQuantidade(listaDePedidos.get(i).getQuantidade() + pedido.getQuantidade());
                    listaDePedidos.get(i).setPrecoSomado(listaDePedidos.get(i).getPrecoSomado() + pedido.getPrecoSomado());
                    return true;
                }else{
                    listaDePedidos.add(pedido);
                    return true;
                }
            }
        }
        return false;
    }

    public List<Pedido> pegarTodosOsItensDoPedido(){
        return listaDePedidos;
    }

    public double pegarValorTotalPedido(){
        double valorTotal = 0;

        for (Pedido pedido: listaDePedidos) {
            valorTotal += pedido.getPrecoSomado();
        }
        return valorTotal;
    }
}
