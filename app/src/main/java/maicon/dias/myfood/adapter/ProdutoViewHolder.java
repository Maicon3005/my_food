package maicon.dias.myfood.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import maicon.dias.myfood.R;

public class ProdutoViewHolder extends RecyclerView.ViewHolder {
    final ImageView foto;
    final TextView nome;
    final TextView descricao;
    final TextView preco;

    public ProdutoViewHolder(View view) {
        super(view);
        foto = (ImageView) view.findViewById(R.id.imgProduto);
        nome = (TextView) view.findViewById(R.id.txtNomeProduto);
        descricao = (TextView) view.findViewById(R.id.txtDescricaoProduto);
        preco = (TextView) view.findViewById(R.id.txtPreco);
    }
}
