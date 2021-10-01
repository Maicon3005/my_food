package maicon.dias.myfood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import maicon.dias.myfood.R;
import maicon.dias.myfood.model.Produto;

public class ProdutoAdapter extends RecyclerView.Adapter {

    private List<Produto> produtos;
    private Context context;

    public ProdutoAdapter(List<Produto> produtos, Context context) {
        this.produtos = produtos;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.alimento_item, parent, false);
        ProdutoViewHolder produtoViewHolder = new ProdutoViewHolder(view);
        return produtoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProdutoViewHolder viewHolder = (ProdutoViewHolder) holder;

        Produto produto = produtos.get(position);
        viewHolder.foto.setImageResource(produto.getFoto());
        viewHolder.nome.setText(produto.getNome());
        viewHolder.descricao.setText(produto.getDescricao());
        viewHolder.preco.setText(produto.getPreco());
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }
}
