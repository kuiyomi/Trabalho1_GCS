package app;

import java.util.Scanner;

import data.Funcionario;
import data.Usuario;

public class App {
    
    private static final FUNCIONARIOS = 15;
}

    public void menu() {

        //As opções para o usuario escolher
    }

    private static void inicializaDados() {

        Funcionario[] funcionarios = new Funcionario[FUNCIONARIOS];
        funcionarios[0] = new Funcionario("Paulo Plinio", "Financeiro", departamentos[0]);
        funcionarios[1] = new Funcionario("Betina Hugendobler", "Recursos Humanos", departamentos[1]);
        funcionarios[2] = new Funcionario("Vini VP", "Manutencao", departamentos[2]);
        funcionarios[3] = new Funcionario("Pedro MP", "Engenharia", departamentos[3]);
        funcionarios[4] = new Funcionario("Lucas Meio", "Juridco", departamentos[4]);

        // Para inicializar os pedidos, no caso, começando com nenhum pedido
        pedidos = new Pedido[0];
    }

private static void alteraUsuario(){
    Scanner sc = new Scanner(System.in);
        System.out.println("Sistema de Controle de Aquisições - Alteração de Usuário");
        System.out.print("Insira a matrícula do usuário: ");
        int matricula = sc.nextInt();
}
