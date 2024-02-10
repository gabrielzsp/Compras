import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite seu limite: ");
        double limite = leitor.nextDouble();
        Conta conta = new Conta(limite);
        int sair = 1;

        while (sair != 0) {
            System.out.println("Digite o nome do produto que deseja comprar: ");
            String nomeProduto = leitor.next();

            System.out.println("Digite o valor do produto: ");
            double valorProduto = leitor.nextDouble();

            Produto produto = new Produto(nomeProduto, valorProduto);

            boolean compraRealizada = conta.lancarCompra(produto);

            if (compraRealizada) {
                System.out.println("COMPRA REALIZADA!");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                sair = leitor.nextInt();
            } else {
                System.out.println("Saldo insuficiente!\n");
                sair = 0;
            }
        }

        System.out.println("*******************");
        System.out.println("COMPRAS REALIZADAS: \n");

        Collections.sort(conta.getListaDeCompras());
        for (Produto c : conta.getListaDeCompras()) {
            System.out.println(c.getNomeProduto() + " - " + c.getValorProduto());
        }
        System.out.println("\nValor total da compra: " + conta.getTotal());

        System.out.println("*******************\n");
        System.out.println("Saldo restante do cartão: " + conta.getSaldo());

    }
}
