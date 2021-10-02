package maicon.dias.myfood.repository;

import java.util.ArrayList;
import java.util.List;

import maicon.dias.myfood.R;
import maicon.dias.myfood.model.Produto;

public class ProdutoRepository {

    private static final List<Produto> estoqueDeProdutos = new ArrayList<>();

    public ProdutoRepository() {
        popularListaDeProdutos();
    }

    public void popularListaDeProdutos(){
        Produto produto = new Produto(R.drawable.feijao, "Feijão", "1 Kg", "R$ 2,69");
        Produto produto1 = new Produto(R.drawable.leite, "Leite", "1 l", "R$ 2,70");
        Produto produto2 = new Produto(R.drawable.macarrao, "Macarrão", "500 g", "R$ 16,70");
        Produto produto3 = new Produto(R.drawable.farofa, "Farofa", "800 g","R$ 3,38");
        Produto produto4 = new Produto(R.drawable.refrigerante, "Refrigerante", "250 ml", "R$ 3,00");
        Produto produto5 = new Produto(R.drawable.batata_frita, "Batata-frita", "350 g", "R$ 5,00");

        estoqueDeProdutos.add(produto);
        estoqueDeProdutos.add(produto1);
        estoqueDeProdutos.add(produto2);
        estoqueDeProdutos.add(produto3);
        estoqueDeProdutos.add(produto4);
        estoqueDeProdutos.add(produto5);
    }

    public List<Produto> listarTodosOsProdutos(){
        return this.estoqueDeProdutos;
    }

}
