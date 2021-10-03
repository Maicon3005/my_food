package maicon.dias.myfood.activitity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import maicon.dias.myfood.OnProdutoListener;
import maicon.dias.myfood.R;
import maicon.dias.myfood.adapter.ProdutoAdapter;
import maicon.dias.myfood.model.Produto;
import maicon.dias.myfood.repository.PedidoRepository;
import maicon.dias.myfood.repository.ProdutoRepository;

public class TelaDeOpcoesActivity extends AppCompatActivity implements OnProdutoListener {

    private List<Produto> produtos = new ArrayList<>();
    private TextView notificacaoPedido;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_opcoes);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcvProdutos);
        notificacaoPedido = (TextView) findViewById(R.id.txtNotificacao);

        ProdutoRepository produtoRepository = new ProdutoRepository();

        List<Produto> listaDeProdutos = produtoRepository.listarTodosOsProdutos();
        this.produtos = listaDeProdutos;

        recyclerView.setAdapter(new ProdutoAdapter(listaDeProdutos, this));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layout);

        ImageButton btnInicio = (ImageButton) findViewById(R.id.btnInicio);
        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        ImageButton btnPedido = (ImageButton) findViewById(R.id.btnMostrarPedido);
        btnPedido.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                @SuppressLint("ClickableViewAccessibility") Intent intent = new Intent(getApplicationContext(), ResumoPedido.class);
                startActivity(intent);
                return true;
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();

        PedidoRepository pedidoRepository = new PedidoRepository();
        int quantidadeDePedidos = pedidoRepository.pegarTodosOsItensDoPedido().size();

        if(quantidadeDePedidos > 0){
            notificacaoPedido.setText("1");
        }else{
            notificacaoPedido.setVisibility(View.INVISIBLE);
        }
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
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }
}
