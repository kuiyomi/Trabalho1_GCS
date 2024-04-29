package data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ListaDePedidos {
    private ArrayList<Pedido> listaPedidos;

    public ListaDePedidos() {
        listaPedidos = new ArrayList<>();
    }

    public boolean addPedido(Pedido p) {
        if (!listaPedidos.contains(p)) { // Adicionado a verificação de existência
            listaPedidos.add(p);         // do pedido para evitar possíveis erros
            return true;
        }
        return false;
    }

    public ArrayList<Pedido> pedidoPorDepartamento(TipoDepartamento departamento) {
        ArrayList<Pedido> pedidosPorDepartamento = new ArrayList<>();
        for (Pedido pedido : listaPedidos) {
            if (pedido.getDepartamento() == departamento) {
                pedidosPorDepartamento.add(pedido);
            }
        }
        return pedidosPorDepartamento;
    }

    public int numeroTotalPedidos() {
        return listaPedidos.size();
    }

    public ArrayList<Pedido> pedidoPorFuncionario(Funcionario f){
        ArrayList<Pedido> lAux = new ArrayList<>();
        for(Pedido aux : listaPedidos){
            if(aux.getUser().getId()==f.getId()){
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
                if(p.getUser().equals(f)){
                    if (p.getStatus().equals(Status.ABERTO)) {
                       listaPedidos.remove(aux);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //  Método que calcula valor total dos pedidos efetuados para fins 
    //  de analise financeira e relatórios de desempenho da empresa
    public double calculaValorTotalPedidos() {
        double valorTotal = 0;
        for (Pedido pedido : listaPedidos) {
            valorTotal += pedido.getValorDoPedido();
        }
        return valorTotal;
    }

    public ArrayList<Pedido> pesquisaPedidosPorData(String dataInicio, String dataFim) {
        ArrayList<Pedido> lista = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataInicial = LocalDate.parse(dataInicio, formatter);
        LocalDate dataFinal = LocalDate.parse(dataFim, formatter);
    
        if (dataInicial.isAfter(dataFinal)) {   // Adição da verificação de coerência entre datas de inicio e fim
            throw new IllegalArgumentException("A data de início deve ser anterior à data de fim");
        }
    
        for (Pedido pedido : listaPedidos) {
            LocalDate dataPedido = LocalDate.parse(pedido.getData(), formatter);
            if ((dataPedido.isEqual(dataInicial) || dataPedido.isAfter(dataInicial)) &&
                (dataPedido.isEqual(dataFinal) || dataPedido.isBefore(dataFinal))) {
                lista.add(pedido);
            }
        }
        return lista;
    }
}