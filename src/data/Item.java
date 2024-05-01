package data;
public class Item {
    private String descricao;
    private double valorUnitario;
    private int quantidade;

    public Item (String descricao, double valorUnitario, int quantidade) {
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public double getValorUnitario() {
        return this.valorUnitario;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public double calcularTotal() {
        return quantidade * valorUnitario;
    }
}