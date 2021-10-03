package maicon.dias.myfood.activitity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import maicon.dias.myfood.R;
import maicon.dias.myfood.adapter.AdapterListView;
import maicon.dias.myfood.model.Pedido;
import maicon.dias.myfood.model.Produto;
import maicon.dias.myfood.model.ResumoItemListView;
import maicon.dias.myfood.repository.PedidoRepository;

public class ResumoPedido extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resumo_pedido);

        PedidoRepository pedidoRepository = new PedidoRepository();

        ListView listaDePedido = (ListView) findViewById(R.id.lstPedido);

        List<Pedido> listaDeProdutos = pedidoRepository.pegarTodosOsItensDoPedido();

        AdapterListView adapter = new AdapterListView(getApplicationContext(), listaDeProdutos);

        listaDePedido.setAdapter(adapter);

        TextView txtValorTotal = (TextView) findViewById(R.id.txtValorTotal);
        txtValorTotal.setText(String.valueOf(pedidoRepository.pegarValorTotalPedido()));
    }

}
