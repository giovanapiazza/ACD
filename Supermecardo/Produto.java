package supermercado;

public class Produto {
    String nome;
    double preco;
    int quantidadeEstoque;

    public Produto(String nome, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void reduzirEstoque(int qtd) {
        if (qtd <= quantidadeEstoque) {
            quantidadeEstoque -= qtd;
        } else {
            System.out.println("⚠ Estoque insuficiente para " + nome);
        }
    }
}
