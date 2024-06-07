package app;

import java.util.Scanner;
import data.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class App {

    private Usuario u;
    private  ListaDePedidos listaDePedidos;
    Scanner sc = new Scanner(System.in);

    public App() {
        u = null;
        listaDePedidos = new ListaDePedidos();
    };

    public void executa() {
        inicializaDados();
        
        int id;
        while (u == null) {
            System.out.println("Digite o ID do usuário que está utilizando o sistema:");
            id = sc.nextInt();
            sc.nextLine();
            u = Usuario.consultaUsuario(id);
            if (u == null) {
                System.out.println("usuário não encontrado, digite novamente!");
         }
        }
       
        menuPrincipal();
    }

    private void inicializaDados() {

       
        

        Departamento financeiro = new Departamento(TipoDepartamento.FINANCEIRO, 10000.00, new ArrayList<>());
        Departamento rh = new Departamento(TipoDepartamento.RECURSOS_HUMANOS, 10000.00, new ArrayList<>());
        Departamento manutencao = new Departamento(TipoDepartamento.MANUTENCAO, 10000.00, new ArrayList<>());
        Departamento engenharia = new Departamento(TipoDepartamento.ENGENHARIA, 10000.00, new ArrayList<>());
        Departamento juridico = new Departamento(TipoDepartamento.JURIDICO, 10000.00, new ArrayList<>());

        Administrador adm0 = new Administrador("Betina Hugendobler", rh, 0);
        Usuario.adicionaUsuario(adm0);
        Administrador adm1 = new Administrador("Paulo Plinio", financeiro, 1);
        Usuario.adicionaUsuario(adm1);
        Administrador adm2 = new Administrador("Betina Hugendobler", rh, 2);
        Usuario.adicionaUsuario(adm2);
        Administrador adm3 = new Administrador("Vini VP", manutencao, 3);
        Usuario.adicionaUsuario(adm3);
        Administrador adm4 = new Administrador("Pedro MP", engenharia, 4);
        Usuario.adicionaUsuario(adm4);
        Administrador adm5 = new Administrador("Lucas Meio", juridico, 5);
        Usuario.adicionaUsuario(adm5);

        Funcionario func6 = new Funcionario("Joana Silva", financeiro, 6);
        Usuario.adicionaUsuario(func6);
        Funcionario func7 = new Funcionario("Mário Souza", financeiro, 7);
        Usuario.adicionaUsuario(func7);
        Funcionario func8 = new Funcionario("Carla Santos", rh, 8);
        Usuario.adicionaUsuario(func8);
        Funcionario func9 = new Funcionario("Gabriel Almeida", rh, 9);
        Usuario.adicionaUsuario(func9);
        Funcionario func10 = new Funcionario("Fernanda Oliveira", manutencao, 10);
        Usuario.adicionaUsuario(func10);
        Funcionario func11 = new Funcionario("Rafaela Pereira", manutencao, 11);
        Usuario.adicionaUsuario(func11);
        Funcionario func12 = new Funcionario("Gustavo Costa", engenharia, 12);
        Usuario.adicionaUsuario(func12);
        Funcionario func13 = new Funcionario("André Rodrigues", engenharia, 13);
        Usuario.adicionaUsuario(func13);
        Funcionario func14 = new Funcionario("Marcela Nunes", juridico, 14);
        Usuario.adicionaUsuario(func14);
        Funcionario func15 = new Funcionario("Juliana Machado", juridico, 15);
        Usuario.adicionaUsuario(func15);
        System.out.println("funcionarios adicionados");


    }

    private void menuPrincipal() {
        int opcao;
        do {
            System.out.println("-----------------------------------------------\n"
                    + "[1] Usuários\n"
                    + "[2] Pedidos\n"
                    + "[3] Itens\n"
                    + "[4] Departamentos\n"
                    + "[5] Estatísticas gerais\n"
                    + "[0] Sair\n"
                    + "-----------------------------------------------");
            System.out.print("Selecione a opção desejada:");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    menuUsuario();
                    break;
                case 2:
                    menuPedidos();
                    break;
                case 3:
                    menuItens();
                    break;
                case 4:
                    menuDepartamentos();
                    break;
                case 5:
                    mostrarEstatisticasGerais(); 
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void menuPedidos() {
        int opcao;
        do {
            System.out.println("-----------------------------------------------\n"
                    + "[1] Registrar pedido\n"
                    + "[2] Listar todos pedidos\n"
                    + "[3] Aprovar pedido\n"
                    + "[4] Procurar pedidos\n"
                    + "[5] Excluir pedido\n"
                    + "[0] Voltar\n"
                    + "-----------------------------------------------");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    registrarPedido();
                    break;
                case 2:
                    menuItens();
                    break;
                case 3:
                    aprovarPedido();
                    break;
                case 4:
                    menuProcuraPedidos();
                    break;
                case 5:
                    excluirPedido();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void menuProcuraPedidos() {
        int opcao;
        do {
            System.out.println("-----------------------------------------------\n"
                    + "[1] Procurar pedidos entre duas datas\n"
                    + "[2] Procurar pedidos por funcionário\n"
                    + "[3] Procurar pedidos por item\n"
                    + "[0] Voltar\n"
                    + "-----------------------------------------------");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    procurarPedidosPorData();
                    break;
                case 2:
                    procurarPedidosPorFuncionario();
                    break;
                case 3:
                    procurarPedidosPorFuncionario();
                    break;
                case 0:
                    System.out.println("Voltando ao menu de pedidos...");
                    menuPedidos();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void menuUsuario() {
        int opcao;
        do {
            System.out.println("-----------------------------------------------\n"
                    + "[1] Listar usuários\n"
                    + "[2] Trocar usuário\n"
                    + "[0] Voltar\n"
                    + "-----------------------------------------------");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Lista de Usuários:");
                    for (Usuario usuario : Usuario.getUsuarios()) {
                        System.out.println(usuario);
                    }
                    break;
                case 2:
                    trocarUsuario();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void menuItens() {
        int opcao;
        do {
            System.out.println("-----------------------------------------------\n"
                    + "[1] Listar todos os itens\n"
                    + "[0] Voltar\n"
                    + "-----------------------------------------------");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    // loista todos os itens
                    for (Pedido pedido : listaDePedidos.getListaPedidos()) {
                        for (Item item : pedido.getLista()) {
                            System.out.println("Descrição: " + item.getDescricao());
                            System.out.println("Valor unitário: " + item.getValorUnitario());
                            System.out.println("Quantidade: " + item.getQuantidade());
                            System.out.println("-----------------------");
                        }
                    }
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    menuPrincipal(); //confirmar se essas chamadas estão corretas
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void menuDepartamentos() {
        int opcao;
        do {
            System.out.println("-----------------------------------------------\n"
                    + "[1] Listar todos os departamentos\n"
                    + "[0] Voltar\n"
                    + "-----------------------------------------------");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    listarDepartamentos();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void mostrarEstatisticasGerais() {
        ListaDePedidos listaDePedidos = new ListaDePedidos();

        // a varivel criada, recebe o numero total de pedidos
        int totalPedidos = listaDePedidos.getListaPedidos().size();

        // aqui recebbe o numero de pedidos aprovados e o de pedidos reprovados.
        int aprovados = 0;
        int reprovados = 0;
        for (Pedido pedido : listaDePedidos.getListaPedidos()) {
            if (pedido.getStatus() == Status.APROVADO) {
                aprovados++;
            } else if (pedido.getStatus() == Status.REPROVADO) {
                reprovados++;
            }
        }

        // percentuais dos aprovados e reprovados
        double percentAprovados = (double) aprovados / totalPedidos * 100;
        double percentReprovados = (double) reprovados / totalPedidos * 100;

        // numero de pedidos nos últimos 30 dias e valor médio
        int pedidosUltimos30Dias = 0;
        double valorTotalUltimos30Dias = 0;
        for (Pedido pedido : listaDePedidos.getListaPedidos()) {
            LocalDate dataPedido = LocalDate.parse(pedido.getData());
            if (dataPedido.isAfter(LocalDate.now().minusDays(30))) {
                pedidosUltimos30Dias++;
                valorTotalUltimos30Dias += pedido.getValorDoPedido();
            }
        }
        double valorMedioUltimos30Dias = pedidosUltimos30Dias > 0 ? valorTotalUltimos30Dias / pedidosUltimos30Dias : 0;

        // valor total de cada categoria nos últimos 30 dias
        double valorTotalFinanceiro = 0;
        double valorTotalRH = 0;
        double valorTotalManutencao = 0;
        double valorTotalEngenharia = 0;
        double valorTotalJuridico = 0;
        for (Pedido pedido : listaDePedidos.getListaPedidos()) {
            LocalDate dataPedido = LocalDate.parse(pedido.getData());
            if (dataPedido.isAfter(LocalDate.now().minusDays(30))) {
                switch (pedido.getDepartamento()) {
                    case FINANCEIRO:
                        valorTotalFinanceiro += pedido.getValorDoPedido();
                        break;
                    case RECURSOS_HUMANOS:
                        valorTotalRH += pedido.getValorDoPedido();
                        break;
                    case MANUTENCAO:
                        valorTotalManutencao += pedido.getValorDoPedido();
                        break;
                    case ENGENHARIA:
                        valorTotalEngenharia += pedido.getValorDoPedido();
                        break;
                    case JURIDICO:
                        valorTotalJuridico += pedido.getValorDoPedido();
                        break;
                }
            }
        }

        // detalhes do pedido de aquisição de maior valor ainda aberto
        Pedido pedidoMaiorValorAberto = null;
        double maiorValorAberto = 0;
        for (Pedido pedido : listaDePedidos.getListaPedidos()) {
            if (pedido.getStatus() == Status.ABERTO && pedido.getValorDoPedido() > maiorValorAberto) {
                maiorValorAberto = pedido.getValorDoPedido();
                pedidoMaiorValorAberto = pedido;
            }
        }

        // exibe tudo
        System.out.println("-----------------------------------------------");
        System.out.println("Estatísticas Gerais do Sistema:");
        System.out.println("Número total de pedidos: " + totalPedidos);
        System.out.println("Pedidos aprovados: " + aprovados + " (" + String.format("%.2f", percentAprovados) + "%)");
        System.out
                .println("Pedidos reprovados: " + reprovados + " (" + String.format("%.2f", percentReprovados) + "%)");
        System.out.println("Número de pedidos nos últimos 30 dias: " + pedidosUltimos30Dias);
        System.out.println(
                "Valor médio dos pedidos nos últimos 30 dias: " + String.format("%.2f", valorMedioUltimos30Dias));
        System.out.println("Valor total de cada categoria nos últimos 30 dias:");
        System.out.println(" - Financeiro: " + String.format("%.2f", valorTotalFinanceiro));
        System.out.println(" - Recursos Humanos: " + String.format("%.2f", valorTotalRH));
        System.out.println(" - Manutenção: " + String.format("%.2f", valorTotalManutencao));
        System.out.println(" - Engenharia: " + String.format("%.2f", valorTotalEngenharia));
        System.out.println(" - Jurídico: " + String.format("%.2f", valorTotalJuridico));
        if (pedidoMaiorValorAberto != null) {
            System.out.println("Detalhes do pedido de aquisição de maior valor ainda aberto:");
            System.out.println(pedidoMaiorValorAberto.toString());
        } else {
            System.out.println("Não há pedidos abertos.");
        }
        System.out.println("-----------------------------------------------");
    }

    private void listarDepartamentos() {
        System.out.println("-----------------------------------------------");
        System.out.println("Lista de Departamentos:");

        // anda pela lista de Usuarios para achar os admins
        for (Usuario usuario : Usuario.getUsuarios()) {
            if (usuario instanceof Administrador) {
                Administrador administrador = (Administrador) usuario;
                Departamento departamento = administrador.getDepartamento();
                TipoDepartamento tipo = departamento.getNome();
                double orcamento = departamento.getValorMaximoPedido();
                System.out.println(tipo.getNome() + ": R$" + String.format("%.2f", orcamento));
            }
        }

        System.out.println("-----------------------------------------------");
    }

    private void trocarUsuario() {
        System.out.print("Digite o nome do novo usuário: ");
        String nomeNovoUsuario = sc.nextLine();
        
        if(Usuario.consultaUsuarioNome(nomeNovoUsuario)!=null){
            u = Usuario.consultaUsuarioNome(nomeNovoUsuario);
        }

        

        else {
            System.out.println("Usuário não encontrado!");
        }
    }

    private void procurarPedidosPorData() {
        System.out.println("Digite as datas no formato (YYYY-MM-DD)");
        System.out.print("Digite a data inicial: ");
        String dataInicialStr = sc.next();
        LocalDate dataInicial = LocalDate.parse(dataInicialStr);

        System.out.print("Digite a data final: ");
        String dataFinalStr = sc.next();
        LocalDate dataFinal = LocalDate.parse(dataFinalStr);

        System.out.println("Pedidos entre " + dataInicial + " e " + dataFinal + ":");
        for (Pedido pedido : listaDePedidos.getListaPedidos()) {
            LocalDate dataPedido = LocalDate.parse(pedido.getData());
            if (dataPedido.isAfter(dataInicial) && dataPedido.isBefore(dataFinal)) {
                System.out.println(pedido);
            }
        }
    }

    private void procurarPedidosPorFuncionario() {
        System.out.print("Digite o nome do funcionário: ");
        String nomeFuncionario = sc.next();

        System.out.println("Pedidos do funcionário " + nomeFuncionario + ":");
        for (Pedido pedido : listaDePedidos.getListaPedidos()) {
            if (pedido.getUser().getNome().equalsIgnoreCase(nomeFuncionario)) {
                System.out.println(pedido);
            }
        }
    }

    private void procurarPedidosPorItem() {
        System.out.print("Digite a descrição do item: ");
        String descricaoItem = sc.next();

        System.out.println("Pedidos com o item '" + descricaoItem + "':");
        for (Pedido pedido : listaDePedidos.getListaPedidos()) {
            if (pedido.procuraItemDescricao(descricaoItem)) {
                System.out.println(pedido);
            }
        }
    }

    private void registrarPedido() {
        System.out.println("Registro de novo pedido...");

        // solicita informações do usuário para criar o pedido
        System.out.print("Digite o ID do usuário solicitante: ");
        int idUsuario = sc.nextInt();
        sc.nextLine();
        Usuario usuarioSolicitante = Usuario.consultaUsuario(idUsuario);

        if (usuarioSolicitante == null) {
            System.out.println("Usuário não encontrado. Registro de pedido cancelado.");
            return;
        }

        System.out.print("Digite a data do pedido (formato: AAAA-MM-DD): ");
        String dataPedido = sc.next();

        ArrayList<Item> itensPedido = new ArrayList<>();

        boolean continuarAdicionandoItens = true;
        while (continuarAdicionandoItens) {
            System.out.print("Digite a descrição do item: ");
            String descricaoItem = sc.next();

            System.out.print("Digite o valor unitário do item: ");
            double valorItem = sc.nextDouble();

            System.out.print("Digite a quantidade do item: ");
            int quantidadeItem = sc.nextInt();

            Item novoItem = new Item(descricaoItem, valorItem, quantidadeItem);
            itensPedido.add(novoItem);

            System.out.print("Deseja adicionar mais itens? (S/N): ");
            String continuar = sc.next().toUpperCase();
            continuarAdicionandoItens = continuar.equals("S");
        }

        // cria o pedido
        Pedido novoPedido = new Pedido(usuarioSolicitante, listaDePedidos.getListaPedidos().size() + 1, dataPedido,
                null, Status.ABERTO, itensPedido);
        listaDePedidos.addPedido(novoPedido);

        System.out.println("Pedido registrado com sucesso!");
    }

    private void aprovarPedido() {
        // lista todos os pedidos abertos para aprovação
        ArrayList<Pedido> pedidosAbertos = listaDePedidos.buscarPedidosPorStatus(Status.ABERTO);

        if (pedidosAbertos.isEmpty()) {
            System.out.println("Não há pedidos abertos para aprovação.");
            return;
        }

        // mostra os pedidos abertos para aprovação
        System.out.println("Pedidos abertos para aprovação:");
        for (Pedido pedido : pedidosAbertos) {
            System.out.println("ID: " + pedido.getId() + " - Data: " + pedido.getData() + " - Solicitante: "
                    + pedido.getUser().getNome());
        }

        // solicita ao administrador que selecione um pedido para aprovação
        System.out.print("Digite o ID do pedido que deseja aprovar: ");
        int idPedido = sc.nextInt();

        // busca o pedido selecionado
        Pedido pedidoSelecionado = listaDePedidos.visualizaDetalhesID(idPedido);

        if (pedidoSelecionado == null) {
            System.out.println("Pedido não encontrado.");
            return;
        }

        // confere se o usuário logado é um administrador
        if (!(u instanceof Administrador)) {
            System.out.println("Você não tem permissão para aprovar pedidos.");
            return;
        }

        // aprova  o pedido
        boolean aprovado = pedidoSelecionado.setStatus(Status.APROVADO, u);

        if (aprovado) {
            System.out.println("Pedido aprovado com sucesso!");
        } else {
            System.out.println("Não foi possível aprovar o pedido.");
        }
    }

    private void excluirPedido(){
        System.out.print("Digite o ID do pedido a ser excluído: ");
                    int idPedido = sc.nextInt();

                    // Busca o pedido na lista de pedidos
                    Pedido pedidoExcluir = null;
                    for (Pedido pedido : listaDePedidos.getListaPedidos()) {
                        if (pedido.getId() == idPedido) {
                            pedidoExcluir = pedido;
                            break;
                        }
                    }

                    // Verifica se o pedido foi encontrado
                    if (pedidoExcluir != null) {
                        // pega o funcionário atual
                        Funcionario funcionarioAtual = u instanceof Funcionario ? (Funcionario) u
                                : null;

                        // confere se o funcionário atual é válido e se o pedido pode ser excluído
                        if (funcionarioAtual != null && listaDePedidos.excluiPedido(funcionarioAtual, pedidoExcluir)) {
                            System.out.println("Pedido excluído com sucesso.");
                        } else {
                            System.out.println(
                                    "Não foi possível excluir o pedido. Verifique se o pedido está aberto e se você tem permissão para excluí-lo.");
                        }
                    } else {
                        System.out.println("Pedido não encontrado.");
                    }
    }

}