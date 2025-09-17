package supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SupermercadoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Criando alguns produtos no estoque
        List<Produto> estoque = new ArrayList<>();
        estoque.add(new Produto("Arroz", 10.0, 50));
        estoque.add(new Produto("Feijão", 8.0, 30));
        estoque.add(new Produto("Farinha", 5.0, 20));
        estoque.add(new Produto("Leite", 4.5, 40));

        Pedido pedido = null;

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1) Novo Pedido");
            System.out.println("2) Realizar Pagamento");
            System.out.println("0) Sair");
            System.out.print("Escolha: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 0) {
                System.out.println("Encerrando aplicação...");
                break;

            } else if (opcao == 1) {
            	
                // Novo pedido
                System.out.print("Nome do cliente: ");
                String nome = sc.nextLine();
                System.out.print("CPF do cliente: ");
                String cpf = sc.nextLine();
                Cliente cliente = new Cliente(nome, cpf);
                pedido = new Pedido(cliente);

                while (true) {
                    System.out.println("\n--- Produtos disponíveis ---");
                    for (int i = 0; i < estoque.size(); i++) {
                        Produto p = estoque.get(i);
                        System.out.println((i+1) + ") " + p.nome +
                                           " - R$" + p.preco +
                                           " (Estoque: " + p.quantidadeEstoque + ")");
                    }
                    System.out.print("Escolha produto (0 para parar): ");
                    int prodIndex = sc.nextInt();
                    if (prodIndex == 0) break;

                    System.out.print("Quantidade: ");
                    int qtd = sc.nextInt();
                    sc.nextLine(); // limpar buffer
                    pedido.adicionarItem(estoque.get(prodIndex - 1), qtd);
                }

            } else if (opcao == 2) {
                if (pedido == null) {
                    System.out.println("Nenhum pedido foi criado.");
                } else {
                	System.out.println("Formas de pagamento:");
                	System.out.println("1) Dinheiro");
                	System.out.println("2) Cheque");
                	System.out.println("3) Pix");
                	System.out.println("4) Débito");
                	System.out.println("5) Crédito");
                	int tipo = sc.nextInt();

                	TipoPagamento pagamento = TipoPagamento.DINHEIRO;
                	if (tipo == 2) pagamento = TipoPagamento.CHEQUE;
                	else if (tipo == 3) pagamento = TipoPagamento.PIX;
                	else if (tipo == 4) pagamento = TipoPagamento.DEBITO;
                	else if (tipo == 5) pagamento = TipoPagamento.CREDITO;

                	pedido.realizarPagamento(pagamento);
                }
            }
        }

        sc.close();
    }
}
