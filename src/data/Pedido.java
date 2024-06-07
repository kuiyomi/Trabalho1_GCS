package data;

import java.util.ArrayList;

public class Pedido {
    private Usuario user; // Atualização da variável 'u' para 'user' com o objetivo de tornar o 
    private int id;       // código mais compreensível para todos todos desenvolvedores do grupo
    private String data;
    private String dataDeConclusao;
    private Status status;
    private ArrayList<Item> lista;
    private double valorDoPedido;
    private TipoDepartamento departamento;
    

    public Pedido(Usuario user, int id, String data, String dataDeConclusao, Status status, ArrayList<Item> lista) {
        this.user = user;
        this.id = id;
        this.data = data;
        this.dataDeConclusao = dataDeConclusao;
        this.status = status;
        this.lista = lista;
        this.valorDoPedido = 0;
        this.departamento = user.getDepartamento().getNome();
    }

    public Usuario getUser() {
        return this.user;
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

    public boolean setStatus(Status status, Usuario user) {
        if(this.status.equals(Status.CONCLUIDO)){
            return false;
        }
        if(status.equals(Status.APROVADO)||status.equals(Status.REPROVADO)){
            if(user instanceof Administrador){
                this.status = status;
                return true;
            }
        }
       return false;
    }

    public ArrayList<Item> getLista() {
        return this.lista;
    }

    public double getValorDoPedido() {
        return this.valorDoPedido;
    }

    public void setValorDoPedido(double valor){
        this.valorDoPedido = this.valorDoPedido + valor;
    }

    public boolean addItem(Item i){
        if(getStatus().equals(Status.APROVADO)||getStatus().equals(Status.CONCLUIDO)){
            return false;
        }	
        if((getValorDoPedido()+(i.getValorUnitario()))>(user.getDepartamento().getNome().getValorMaximoPedido())){
                return false;
            }
            lista.add(i);
            setValorDoPedido(i.calcularTotal());
            return true;
    }

    public boolean procuraItemDescricao(String d){
        for(Item aux : lista){
            if(aux.getDescricao().equals(d)){
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "{" +
            " user='" + getUser() + "'" +
            ", id='" + getId() + "'" +
            ", data='" + getData() + "'" +
            ", dataDeConclusao='" + getDataDeConclusao() + "'" +
            ", status='" + getStatus() + "'" +
            ", lista='" + getLista() + "'" +
            ", valorDoPedido='" + getValorDoPedido() + "'" +
            ", departamento='" + getDepartamento() + "'" +
            "}";
    }
}