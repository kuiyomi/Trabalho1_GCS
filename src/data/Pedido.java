package data;

import java.util.ArrayList;

public class Pedido {
    private Usuario u;
    private int id;
    private String data;
    private String dataDeConclusao;
    private Status status;
    private ArrayList<Item> lista;
    private double valorDoPedido;
    private TipoDepartamento departamento;
    

    public Pedido(Usuario u, int id, String data, String dataDeConclusao, Status status, ArrayList<Item> lista) {
        this.u = u;
        this.id = id;
        this.data = data;
        this.dataDeConclusao = dataDeConclusao;
        this.status = status;
        this.lista = lista;
        this.valorDoPedido = 0;
        this.departamento = u.getDepartamento().getNome();
    }

    public Usuario getU() {
        return this.u;
    }
    public int getId(){
        return id;
    }

    public TipoDepartamento getDepartamento(){
        return departamento;
    }

    public String getData() {
        return this.data;
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

    public boolean setStatus(Status status, Usuario u) {
        if(this.status.equals(Status.CONCLUIDO)){
            return false;
        }
        if(status.equals(Status.APROVADO)||status.equals(Status.REPROVADO)){
            if(u instanceof Administrador){
                this.status = status;
                return true;
            }
        }
       return false;
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

    public void setValorDoPedido(double valor){
        this.valorDoPedido = this.valorDoPedido + valor;
    }

    public boolean addItem(Item i){
        	if((getValorDoPedido()+(i.getValorUnitario()))>(u.getDepartamento().getNome().getValorMaximoPedido())){
                return false;
            }
            lista.add(i);
            setValorDoPedido(i.getValorUnitario());
            return true;
    }
    
}
