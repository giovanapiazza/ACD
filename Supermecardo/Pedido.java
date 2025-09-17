package supermercado;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    Cliente cliente;
    List<Item> itens = new ArrayList<>();
    TipoPagamento formaPagamento;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        itens.add(new Item(produto, quantidade));
    }

    public double calcularTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void realizarPagamento(TipoPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
        System.out.println("\n--- Recibo ---");
        System.out.println("Cliente: " + cliente.nome );
        System.out.println("CPF: " + cliente.cpf );
        for (Item item : itens) {
            System.out.println(item);
        }
        System.out.println("Total: R$ " + calcularTotal());
        System.out.println("Pagamento em: " + formaPagamento);
    }
}
