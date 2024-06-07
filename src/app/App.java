package app;

import java.util.ArrayList;
import java.util.Scanner;

import data.Administrador;
import data.Departamento;
import data.Funcionario;
import data.Item;
import data.ListaDePedidos;
import data.Pedido;
import data.Status;
import data.TipoDepartamento;
import data.Usuario;

public class App {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ListaDePedidos listaDePedidos = new ListaDePedidos();
    private Usuario usuarioAtual;

    private void inicializaDados() {
        usuarios = new ArrayList<>();
        listaDePedidos = new ListaDePedidos();

        Departamento financeiro = new Departamento(TipoDepartamento.FINANCEIRO, 10000.00, new ArrayList<>());
        Departamento rh = new Departamento(TipoDepartamento.RECURSOS_HUMANOS, 10000.00, new ArrayList<>());
        Departamento manutencao = new Departamento(TipoDepartamento.MANUTENCAO, 10000.00, new ArrayList<>());
        Departamento engenharia = new Departamento(TipoDepartamento.ENGENHARIA, 10000.00, new ArrayList<>());
        Departamento juridico = new Departamento(TipoDepartamento.JURIDICO, 10000.00, new ArrayList<>());

        Administrador adm0 = new Administrador("Betina Hugendobler", rh, 2);
        usuarios.add(adm0);
        Administrador adm1 = new Administrador("Paulo Plinio", financeiro, 1);
        usuarios.add(adm1);
        Administrador adm2 = new Administrador("Betina Hugendobler", rh, 2);
        usuarios.add(adm2);
        Administrador adm3 = new Administrador("Vini VP", manutencao, 3);
        usuarios.add(adm3);
        Administrador adm4 = new Administrador("Pedro MP", engenharia, 4);
        usuarios.add(adm4);
        Administrador adm5 = new Administrador("Lucas Meio", juridico, 5);
        usuarios.add(adm5);

        Funcionario func6 = new Funcionario("Joana Silva", financeiro, 6);
        usuarios.add(func6);
        Funcionario func7 = new Funcionario("Mário Souza", financeiro, 7);
        usuarios.add(func7);
        Funcionario func8 = new Funcionario("Carla Santos", rh, 8);
        usuarios.add(func8);
        Funcionario func9 = new Funcionario("Gabriel Almeida", rh, 9);
        usuarios.add(func9);
        Funcionario func10 = new Funcionario("Fernanda Oliveira", manutencao, 10);
        usuarios.add(func10);
        Funcionario func11 = new Funcionario("Rafaela Pereira", manutencao, 11);
        usuarios.add(func11);
        Funcionario func12 = new Funcionario("Gustavo Costa", engenharia, 12);
        usuarios.add(func12);
        Funcionario func13 = new Funcionario("André Rodrigues", engenharia, 13);
        usuarios.add(func13);
        Funcionario func14 = new Funcionario("Marcela Nunes", juridico, 14);
        usuarios.add(func14);
        Funcionario func15 = new Funcionario("Juliana Machado", juridico, 15);
        usuarios.add(func15);
    }

    public void menuPrincipal() {
        inicializaDados();
        Scanner sc = new Scanner(System.in);
        int idUsuario;

        do {
            System.out.print("Por favor, insira seu ID de usuário: ");
            idUsuario = sc.nextInt();
            sc.nextLine();

            usuarioAtual = encontrarUsuarioPorID(idUsuario);
            if (usuarioAtual == null) {
                System.out.println("Usuário não encontrado. Por favor, insira um ID válido.");
            }
        } while (usuarioAtual == null);

        if (usuarioAtual instanceof Administrador) {
            System.out.println("Usuário identificado como Administrador.");
            menuAdministrador();
        } else if (usuarioAtual instanceof Funcionario) {
            System.out.println("Usuário identificado como Funcionário.");
            menuFuncionario();
        }

        sc.close();
    }

    private Usuario encontrarUsuarioPorID(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public void menuAdministrador() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu do Administrador:");
            System.out.println("1. Aprovar/Reprovar Pedido");
            System.out.println("2. Concluir Pedido");
            System.out.println("3. Criar Pedido");
            System.out.println("4. Pesquisar Pedidos por Data");
            System.out.println("5. Listar Pedidos por Status");
            System.out.println("6. Listar Itens de Pedido");
            System.out.println("0. Sair");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    aprovarReprovarPedido();
                    break;
                case 2:
                    alterarStatusParaConcluido();
                    break;
                case 3:
                    criarPedido();
                    break;
                case 4:
                    pesquisarPedidosPorData();
                    break;
                case 5:
                    listarPedidosPorStatus();
                    break;
                case 6:
                    listarItens();
                    break;
                case 0:
                    System.out.println("Saindo do menu...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);
        sc.close();
    }

    public void menuFuncionario() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu do Funcionário:");
            System.out.println("1. Criar Pedido");
            System.out.println("2. Listar Itens de Pedido");
            System.out.println("0. Sair");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    criarPedido();
                    break;
                case 2:
                    listarItens();
                    break;
                case 0:
                    System.out.println("Saindo do menu...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);
        sc.close();
    }

    private void criarPedido() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Item> itens = new ArrayList<>();

        System.out.println("Menu de Criação de Pedido");

        System.out.print("ID do Pedido: ");
        int idPedido = sc.nextInt();
        sc.nextLine();

        System.out.print("Data (dd/MM/yyyy): ");
        String data = sc.nextLine();

        String dataConclusao = null;

        boolean adicionarMaisItens = true;
        while (adicionarMaisItens) {
            System.out.print("Descrição do Item: ");
            String descricao = sc.nextLine();

            System.out.print("Valor Unitário: ");
            double valorUnitario = sc.nextDouble();
            sc.nextLine();

            System.out.print("Quantidade: ");
            int quantidade = sc.nextInt();
            sc.nextLine();

            Item item = new Item(descricao, valorUnitario, quantidade);
            itens.add(item);

            System.out.print("Deseja adicionar mais itens? (sim/não): ");
            String resposta = sc.nextLine();
            adicionarMaisItens = resposta.equalsIgnoreCase("sim");
        }

        Pedido pedido = new Pedido(usuarioAtual, idPedido, data, dataConclusao, Status.ABERTO, itens);
        listaDePedidos.addPedido(pedido);
        System.out.println("Pedido criado com sucesso!");
        sc.close();
    }

    private void listarItens() {
        for (Pedido pedido : listaDePedidos.getListaPedidos()) {
            for (Item item : pedido.getLista()) {
                System.out.println("Descrição: " + item.getDescricao());
                System.out.println("Valor unitário: " + item.getValorUnitario());
                System.out.println("Quantidade: " + item.getQuantidade());
                System.out.println("-----------------------");
            }
        }
    }

    private void aprovarReprovarPedido() {
        Scanner sc = new Scanner(System.in);
    
        System.out.print("ID do Pedido: ");
        int idPedido = sc.nextInt();
        sc.nextLine();
    
        Pedido pedido = listaDePedidos.visualizaDetalhesID(idPedido);
        if (pedido != null) {
            System.out.println("Pedido encontrado:");
            System.out.println(pedido);
    
            System.out.print("Deseja aprovar ou reprovar o pedido? (aprovar/reprovar): ");
            String decisao = sc.nextLine();
            Status novoStatus = decisao.equalsIgnoreCase("aprovar") ? Status.APROVADO : Status.REPROVADO;
            if (pedido.setStatus(novoStatus, usuarioAtual)) {
                if (novoStatus == Status.APROVADO) {
                    System.out.println("Pedido aprovado com sucesso!");
                } else {
                    System.out.println("Pedido reprovado com sucesso!");
                }
            } else {
                System.out.println("Não foi possível " + decisao + "ar o pedido.");
            }
        } else {
            System.out.println("Pedido não encontrado.");
        }
        sc.close();
    }

    private void alterarStatusParaConcluido() {
        Scanner sc = new Scanner(System.in);

        System.out.print("ID do Pedido: ");
        int idPedido = sc.nextInt();
        sc.nextLine();

        Pedido pedido = listaDePedidos.visualizaDetalhesID(idPedido);
        if (pedido != null) {
            System.out.println("Pedido encontrado:");
            System.out.println(pedido);

            if (pedido.getStatus() == Status.CONCLUIDO) {
                System.out.println("O pedido já está concluído.");
            } else {
                System.out.print("Data de Conclusão (dd/MM/yyyy): ");
                String dataConclusao = sc.nextLine();
                pedido.setDataDeConclusao(dataConclusao);
                pedido.setStatus(Status.CONCLUIDO, usuarioAtual);
                System.out.println("Pedido concluído com sucesso!");
            }
        } else {
            System.out.println("Pedido não encontrado.");
        }
        sc.close();
    }

    private void listarPedidosPorStatus() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Status (ABERTO, APROVADO, REPROVADO, CONCLUIDO): ");
        String statusStr = sc.nextLine();
        Status status = Status.valueOf(statusStr.toUpperCase());

        ArrayList<Pedido> pedidos = listaDePedidos.buscarPedidosPorStatus(status);
        if (pedidos != null) {
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
        } else {
            System.out.println("Nenhum pedido encontrado com o status " + statusStr);
        }
        sc.close();
    }

    private void pesquisarPedidosPorData() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Data de abertura (dd/MM/yyyy): ");
        String dataInicio = sc.nextLine();

        System.out.print("Data de conclusão (dd/MM/yyyy): ");
        String dataFim = sc.nextLine();

        ArrayList<Pedido> pedidos = listaDePedidos.pesquisaPorData(dataInicio, dataFim);
        if (pedidos != null) {
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
        } else {
            System.out.println("Nenhum pedido encontrado no intervalo de datas informado.");
        }
        sc.close();
    }
}