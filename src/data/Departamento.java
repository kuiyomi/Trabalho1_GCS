package data;

import java.util.ArrayList;

public class Departamento{
    private TipoDepartamento nome;
    private double valorMaximoPedido;
    private ArrayList<Usuario>listaUsuarios;
    public Departamento(TipoDepartamento nome, double valorMaximoPedido, ArrayList<Usuario> listaUsuarios){
        this.nome = nome;
        this.valorMaximoPedido = valorMaximoPedido;
        this.listaUsuarios = new ArrayList<>();
    }
    
    public TipoDepartamento getNome(){
        return nome;
    }

    public double getValorMaximoPedido(){
        return valorMaximoPedido;
    }
    public void setValorMaximoPedido(double valorMaximoPedido){
        this.valorMaximoPedido = valorMaximoPedido;
    }

    public ArrayList<Usuario> getListaUsuarios(){
        return listaUsuarios;
    }
    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios){
        this.listaUsuarios = listaUsuarios;
    }
}