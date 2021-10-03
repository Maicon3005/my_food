package maicon.dias.myfood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import maicon.dias.myfood.R;
import maicon.dias.myfood.model.Pedido;
import maicon.dias.myfood.model.Produto;

public class AdapterListView extends BaseAdapter {

    private LayoutInflater inflater;
    private List<Pedido> itens;

    public AdapterListView(Context context, List<Pedido> itens) {
        this.itens = itens;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Object getItem(int posicao) {
        return itens.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return posicao;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {
        ItemSuporte itemSuporte;

        if(view == null){
            view = inflater.inflate(R.layout.pedido_item, null);
            itemSuporte = new ItemSuporte();
            itemSuporte.nomeProduto = ((TextView) view.findViewById(R.id.txtDescricaoPedido));
            itemSuporte.quantidadeProduto = ((TextView) view.findViewById(R.id.txtQuantidadePedido));
            itemSuporte.precoProduto = ((TextView) view.findViewById(R.id.txtPrecoUnidadePedido));

            view.setTag(itemSuporte);
        } else {
            itemSuporte = (ItemSuporte) view.getTag();
        }
        Pedido item = itens.get(posicao);
        itemSuporte.nomeProduto.setText(item.getNome());
        itemSuporte.precoProduto.setText(String.valueOf(item.getPrecoSomado()));
        itemSuporte.quantidadeProduto.setText(String.valueOf(item.getQuantidade()));

        return view;
    }
}
