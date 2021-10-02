package maicon.dias.myfood.repository;

import java.util.ArrayList;
import java.util.List;

import maicon.dias.myfood.model.Produto;

public class PedidoRepository {

    private static final List<Produto> listaDePedidos  = new ArrayList<>();

    public boolean salvarItem(Produto produto){
        listaDePedidos.add(produto);

        for (Produto p:
             listaDePedidos) {
            System.out.println("Item: " + p.getNome()+ ", preco; " + p.getPreco());
        }
        return true;
    }
}
