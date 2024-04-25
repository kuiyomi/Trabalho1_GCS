package app;
import java.util.Scanner;

import data.Funcionario;

public class App {
   
}

public void menu(){
    Scanner sc = new Scanner(System.in);
    int opcao;
    System.out.println("Menu:");
    do{
        System.out.println("1: Consulta lista de funcionários");
        System.out.println("2: Logar");
        opcao = sc.nextInt();
    }while(!(opcao == 1 || opcao ==2));

    switch(opcao){
        case 1: //MÉTODO DE LISTA DE FUNCIONARIOS
            break;

        case 2: //METODO LOGIN
            break;
    }




    System.out.println("Digite a matrícula para se logar...");
    do{
        System.out.print("Digite uma matrícula válida: ");
        /*int matricula = sc.nextInt(); Insere matrícula 
    }while(!Usuario.NomeMetodoConsultaPorMatricula(matricula))*/ 


}

