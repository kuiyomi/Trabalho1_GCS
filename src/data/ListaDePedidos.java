package data;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public ArrayList<Pedido> pesquisaPorData(String dataInicio, String dataFim){
        ArrayList<Pedido> lista = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data1 = LocalDate.parse(dataInicio, formatter);
        LocalDate data2 = LocalDate.parse(dataFim, formatter);
        for(Pedido aux : listaPedidos){
            LocalDate dataAux = LocalDate.parse(aux.getData(), formatter);
            if(dataAux.isEqual(data1)||dataAux.isAfter(data1)){
                if (dataAux.isEqual(data2)||dataAux.isBefore(data2)) {
                   lista.add(aux); 
                }
            }
        }
        if (!lista.isEmpty()) {
            return lista;
        }
        return null;
    }

    //Métodos novos adicionados
    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public ArrayList<Pedido> buscarPedidosPorStatus(Status status) {
        ArrayList<Pedido> pedidosPorStatus = new ArrayList<>();
        for (Pedido pedido : listaPedidos) {
            if (pedido.getStatus().equals(status)) {
                pedidosPorStatus.add(pedido);
            }
        }
        
        if (pedidosPorStatus.isEmpty()) {
            return null;
        } else {
            return pedidosPorStatus;
        }
    }

}