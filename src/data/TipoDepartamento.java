<<<<<<< HEAD
package data;
=======
>>>>>>> 8a375b6cc554abfa086eb9518eb36f47d29049c9
public enum TipoDepartamento{
    
    FINANCEIRO("Financeiro", 10000.00), 
    JURIDICO("Jurídico", 10000.00), 
    RECURSOS_HUMANOS("Recursos Humanos", 10000.00), 
    ENGENHARIA("Engenharia", 10000.00), 
    MANUTENCAO("Manutenção", 10000.00);

    private final String nome;
    private final double valorMaximoPedido;

    TipoDepartamento(String nome, double valorMaximoPedido){
        this.nome = nome;
        this.valorMaximoPedido = valorMaximoPedido;
    }

    public String getNome(){
        return nome;
    }

    public double getValorMaximoPedido(){
        return valorMaximoPedido;
    }
}