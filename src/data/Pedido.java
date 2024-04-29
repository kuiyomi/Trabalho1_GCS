package data;

import java.util.ArrayList;

public class Pedido {
    private Usuario u;
    //private Departamento d; Adicionar depois da implementação da classe Departamento
    private String data;
    private String dataDeConclusao;
    private Status status;
    private ArrayList<Item> lista;
    private double valorDoPedido;
    

    public Pedido(Usuario u, String data, String dataDeConclusao, Status status, ArrayList<Item> lista, double valorDoPedido) {
        this.u = u;
        this.data = data;
        this.dataDeConclusao = dataDeConclusao;
        this.status = status;
        this.lista = lista;
        this.valorDoPedido = valorDoPedido;
    }

    public Usuario getU() {
        return this.u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDataDeConclusao() {
        return this.dataDeConclusao;
    }

    public void setDataDeConclusao(String dataDeConclusao) {
        this.dataDeConclusao = dataDeConclusao;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status, Usuario u) {
        // adicionar verificaçao para alterar status
        this.status = status;
    }

    public ArrayList<Item> getLista() {
        return this.lista;
    }

    public void setLista(ArrayList<Item> lista) {
        this.lista = lista;
    }

    public double getValorDoPedido() {
        return this.valorDoPedido;
    }

    
}
