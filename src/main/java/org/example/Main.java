package org.example;

import java.util.Scanner;

public class Main {

    public static FilaComPrioridade<Paciente> fila = new FilaComPrioridade<>();
    public static  Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        menu();

    }

    public static void menu () {
        System.out.println("====================================");
        System.out.println("F I L A  D E  A T E N D I M E N T O               ");
        System.out.println("====================================");

        System.out.println("[1] cadastrar paciente.");
        System.out.println("[2] ver fila  de paciente.");
        System.out.println("[3] atender  paciente.");
        System.out.println("[4] proximo da fila.");
        System.out.println("[0] sair.");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1:
                cadastrar();

                menu();
                break;
            case 2:

                verFila();

                menu();
                break;
            case 3:
                fila.desenfileirar();
                menu();
            case 4:
                proximoDaFila();

                menu();
                break;
            case 0:
                sc.close();
                return;
            default:
                System.out.println("INVALIDO");
                menu();
                break;
        }
    }
    public static void cadastrar () {
        sc.nextLine();
        System.out.print("Digite o nome do paciente: ");
        String nome = sc.nextLine();

        System.out.print("Digite a idade do paciente: ");
        int idade = sc.nextInt();
        sc.nextLine();
        System.out.print("O pacientes possui alguma prioridade ?[Y/N]");
        String prioridade = sc.nextLine();
        boolean condicao = false;
        if (prioridade.equalsIgnoreCase("y")) {
            condicao = true;
        }
        fila.enfileira(new Paciente(nome,condicao, idade ));
    }

    public static void verFila () {
        System.out.println(fila);
    }
    public static void proximoDaFila () {

        System.out.println("PROXIMO DA FILA:" + fila.espiar().getSenha());
        System.out.println(fila.espiar());
    }

}


