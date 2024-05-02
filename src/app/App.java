package app;

import java.util.Locale;
import java.util.Scanner;
import data.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class App {

    private static ArrayList<Usuario> usuarios;
    private static ListaDePedidos listaDePedidos;
    private static Usuario usuarioAtual;

    public App(){};


    public static void executa(){
        inicializaDados();
    }

    private static void inicializaDados() {

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

    private void menuPrincipal() {
        System.out.println("-----------------------------------------------\n"
                            + "[1] Usuários\n"
                            + "[2] Pedidos\n"
                            + "[3] Itens\n"
                            + "[4] Departamentos\n"
                            + "[5] Estatísticas gerais\n"
                            + "[0] Sair\n"
                            + "-----------------------------------------------");
    }

    private void menuPedidos() {
        System.out.println("-----------------------------------------------\n"
                            + "[1] Registrar pedido\n"
                            + "[2] Listar todos pedidos\n"
                            + "[3] Aprovar pedido\n"
                            + "[4] Procurar pedidos\n"
                            + "[5] Exclui pedido\n"
                            + "[0] Voltar\n"
                            + "-----------------------------------------------");
    }

    private void menuProcuraPedidos() {
        System.out.println("-----------------------------------------------\n"
                            + "[1] Procurar pedidos entre duas datas\n"
                            + "[2] Procurar pedidos por funcionário\n"
                            + "[3] Procurar pedidos por item\n"
                            + "[0] Voltar\n"
                            + "-----------------------------------------------");
    }

    private void menuUsuário() {
        System.out.println("-----------------------------------------------\n"
                            + "[1] Listar usuários\n"
                            + "[2] Trocar usuário\n"
                            + "[0] Voltar\n"
                            + "-----------------------------------------------");
    }

    private void menuItens() {
        System.out.println("-----------------------------------------------\n"
                            + "[1] Listar itens\n"
                            + "[0] Voltar\n"
                            + "-----------------------------------------------");
    }

    private void menuDepartamentos() {
        System.out.println("===========================================\n"
                            + "[1] Listar departamentos\n"
                            + "[0] Voltar\n"
                            + "-----------------------------------------------");
    }
}