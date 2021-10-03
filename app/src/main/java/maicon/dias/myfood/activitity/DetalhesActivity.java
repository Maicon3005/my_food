package maicon.dias.myfood.activitity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import maicon.dias.myfood.R;
import maicon.dias.myfood.model.Pedido;
import maicon.dias.myfood.model.Produto;
import maicon.dias.myfood.repository.PedidoRepository;

public class DetalhesActivity extends AppCompatActivity {

    private int quantidadeDeItems;
    private TextView txtContador;
    private int foto;
    private String nome;
    private String descricao;
    private double preco;
    private final int ACRESCIMO_ITEM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhes_item);

        foto = getIntent().getExtras().getInt("fotoProduto");
        nome = getIntent().getExtras().getString("nomeProduto");
        descricao = getIntent().getExtras().getString("descricaoProduto");
        preco = Double.parseDouble(getIntent().getExtras().getString("preco"));

        ImageView imgProduto = (ImageView) findViewById(R.id.imgDetalhe);
        TextView  txtNomeProduto = (TextView) findViewById(R.id.txtTitleDetalhe);
        TextView txtDescricaoProduto = (TextView) findViewById(R.id.txtDescricaoDetalhe);

        imgProduto.setImageResource(foto);
        txtNomeProduto.setText(nome);
        txtDescricaoProduto.setText(descricao);

        this.quantidadeDeItems = 0;

        txtContador = (TextView) findViewById(R.id.txtContador);

        Button btnAdicionar = (Button) findViewById(R.id.btnAdicionar);
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicionarItemAoPedido(view);
            }
        });
    }

    public void acrescentarItem(View view) {
        quantidadeDeItems += ACRESCIMO_ITEM;
        txtContador.setText(String.valueOf(quantidadeDeItems));
    }

    public void removerItem(View view) {
        if(quantidadeDeItems > 0) {
            quantidadeDeItems -= ACRESCIMO_ITEM;
            txtContador.setText(String.valueOf(quantidadeDeItems));
        }else{
            mostrarToast("Quantidade de itens inválida!");
        }
    }

    public void mostrarToast(String texto){
        Context contexto = getApplicationContext();
        int tempoDuracao = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(contexto, texto, tempoDuracao);
        toast.show();
    }

    public void adicionarItemAoPedido(View view) {
        PedidoRepository pedidoRepository = new PedidoRepository();
        Pedido pedido = new Pedido(nome, quantidadeDeItems, preco * quantidadeDeItems);

        boolean resultado = pedidoRepository.salvarItem(pedido);

        if (resultado) {
            mostrarToast(quantidadeDeItems + " " + nome + " adicionado(s) ao pedido");
        } else {
            mostrarToast("Falha ao adicionar o pedido ao carrinho");
        }

        Intent intent = new Intent(getApplicationContext(), TelaDeOpcoesActivity.class);
        startActivity(intent);
    }

}
