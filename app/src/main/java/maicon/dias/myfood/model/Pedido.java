package maicon.dias.myfood.model;

public class Pedido {

    private String nome;
    private int quantidade;
    private double precoSomado;

    public Pedido() {
    }

    public Pedido(String nome, int quantidade, double precoSomado) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.precoSomado = precoSomado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoSomado() {
        return precoSomado;
    }

    public void setPrecoSomado(double precoSomado) {
        this.precoSomado = precoSomado;
    }
}
