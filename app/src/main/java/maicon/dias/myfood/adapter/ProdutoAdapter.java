package maicon.dias.myfood.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import maicon.dias.myfood.OnProdutoListener;
import maicon.dias.myfood.R;
import maicon.dias.myfood.model.Produto;

public class ProdutoAdapter extends RecyclerView.Adapter {

    private List<Produto> produtos;
    private OnProdutoListener onProdutoListener;

    public ProdutoAdapter(List<Produto> produtos, OnProdutoListener onProdutoListener) {
        this.produtos = produtos;
        this.onProdutoListener = onProdutoListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.alimento_item, parent, false);
        ProdutoViewHolder produtoViewHolder = new ProdutoViewHolder(view, onProdutoListener);
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
