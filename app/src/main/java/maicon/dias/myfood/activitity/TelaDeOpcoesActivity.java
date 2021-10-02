package maicon.dias.myfood.activitity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import maicon.dias.myfood.OnProdutoListener;
import maicon.dias.myfood.R;
import maicon.dias.myfood.activitity.DetalhesActivity;
import maicon.dias.myfood.adapter.ProdutoAdapter;
import maicon.dias.myfood.model.Produto;
import maicon.dias.myfood.repository.ProdutoRepository;

public class TelaDeOpcoesActivity extends AppCompatActivity implements OnProdutoListener {

    private List<Produto> produtos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_opcoes);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcvProdutos);

        ProdutoRepository produtoRepository = new ProdutoRepository();

        List<Produto> listaDeProdutos = produtoRepository.listarTodosOsProdutos();
        this.produtos = listaDeProdutos;

        recyclerView.setAdapter(new ProdutoAdapter(listaDeProdutos, this));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layout);
    }

    @Override
    public void onProdutoClick(int posicao) {

        int foto = produtos.get(posicao).getFoto();
        String nome = produtos.get(posicao).getNome();
        String descricao = produtos.get(posicao).getDescricao();
        String preco = produtos.get(posicao).getPreco();

        Bundle bundle = new Bundle();
        bundle.putInt("fotoProduto", foto);
        bundle.putString("nomeProduto", nome);
        bundle.putString("descricaoProduto", descricao);
        bundle.putString("preco", preco);

        Intent intent = new Intent(getApplicationContext(), DetalhesActivity.class);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}
