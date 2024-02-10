import java.util.ArrayList;
import java.util.List;

public class Conta {
    private double limite;
    private double saldo;
    private double total;
    private List<Produto> listaDeCompras;

    public Conta(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.listaDeCompras = new ArrayList<>();
    }

    public boolean lancarCompra(Produto produto) {
        if (this.saldo > produto.getValorProduto()) {
            this.saldo -= produto.getValorProduto();
            this.total += produto.getValorProduto();
            this.listaDeCompras.add(produto);
            return true;
        }
        return false;
    }

    public double getTotal() {
        return total;
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Produto> getListaDeCompras() {
        return listaDeCompras;
    }
}
