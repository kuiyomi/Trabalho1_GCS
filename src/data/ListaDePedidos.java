package data;

import java.util.ArrayList;

public class ListaDePedidos {
    private ArrayList<Pedido> listaPedidos;

    public ListaDePedidos(){
        listaPedidos = new ArrayList<>();
    }

    public boolean addPedido(Pedido p){
        for(Pedido aux : listaPedidos){
            if(aux.getId()==p.getId()){
                return false;
            }
        }
        listaPedidos.add(p);
        return true;
    }
    public ArrayList<Pedido> pedidoPorFuncionario(Funcionario f){
        ArrayList<Pedido> lAux = new ArrayList<>();
        for(Pedido aux : listaPedidos){
            if(aux.getU().getId()==f.getId()){
                lAux.add(aux);
            }
        }
        if (!lAux.isEmpty()) {
            return lAux;
        }
        return null;
    }

    public ArrayList<Pedido> pedidoPorDescricao(String descricao){
        ArrayList<Pedido> lAux = new ArrayList<>();
        for(Pedido aux : listaPedidos){
            if(aux.procuraItemDescricao(descricao)){
                lAux.add(aux);
            }
        }
        if (!lAux.isEmpty()) {
            return lAux;
        }
        return null;
    }
    // Pode ser alterado para receber um objeto do tipo Pedido
    public Pedido visualizaDetalhesID(int id){
        for(Pedido aux : listaPedidos){
            if (aux.getId()==id) {
                aux.toString();
                return aux;
            }
        }
        return null;
    }

    public boolean excluiPedido(Funcionario f, Pedido p){
        for(Pedido aux : listaPedidos){
            if(p.equals(aux)){
                if(p.getU().equals(f)){
                    if (p.getStatus().equals(Status.ABERTO)) {
                       listaPedidos.remove(aux);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    // Falta implementar
    public ArrayList<Pedido> pesquisaPorData(String data){
        return null;
    }

}