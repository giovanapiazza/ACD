package supermercado;

public class Item {
    Produto produto;
    int quantidade;

    public Item(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        produto.reduzirEstoque(quantidade);
    }

    public double getSubtotal() {
        return produto.preco * quantidade;
    }

    public String toString() {
        return produto.nome + " x " + quantidade + " = R$ " + getSubtotal();
    }
}
