package maicon.dias.myfood;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import maicon.dias.myfood.adapter.ProdutoAdapter;
import maicon.dias.myfood.model.Produto;

public class TelaDeOpcoesActivity extends AppCompatActivity implements OnProdutoListener{

    private List<Produto> produtos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_opcoes);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcvProdutos);

        //Teste
        Produto produto = new Produto(R.drawable.feijao, "Feijão", "1 Kg", "R$ 2,69");
        Produto produto1 = new Produto(R.drawable.leite, "Leite", "1 l", "R$ 2,70");
        Produto produto2 = new Produto(R.drawable.macarrao, "Macarrão", "500 g", "R$ 16,70");
        Produto produto3 = new Produto(R.drawable.farofa, "Farofa", "800 g","R$ 3,38");
        Produto produto4 = new Produto(R.drawable.refrigerante, "Refrigerante", "250 ml", "R$ 3,00");
        Produto produto5 = new Produto(R.drawable.batata_frita, "Batata-frita", "350 g", "R$ 5,00");

        produtos.add(produto);
        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);
        produtos.add(produto5);

        recyclerView.setAdapter(new ProdutoAdapter(produtos, this));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layout);
    }

    @Override
    public void onProdutoClick(int posicao) {
        System.out.println("Foi clicado na posição: " + posicao);
        /*produtos.get(posicao);
        Intent intent = new Intent(this, DetalhesProdutoActivity.class);
        startActivity(intent);*/
    }
}
