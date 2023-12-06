// Menu.java
package primeira;

import java.util.Scanner;

public class Menu {
    public static void processamento() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Escolha sua opção:");
            System.out.println("1- Gerenciar Clientes");
            System.out.println("2- Gerenciar Quartos");
            System.out.println("3- Gerenciar Camas");
            System.out.println("4- Gerenciar Reservas");
            System.out.println("5- Sair");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    gerenciarClientes();
                    break;
                case 2:
                    gerenciarQuartos();
                    break;
                case 3:
                    gerenciarCamas();
                    break;
                case 4:
                    gerenciarReservas();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
            }
        } while (opcao != 5);
    }

    private static void gerenciarClientes() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Escolha sua opção para Clientes:");
            System.out.println("1- Incluir Cliente");
            System.out.println("2- Alterar Cliente");
            System.out.println("3- Excluir Cliente");
            System.out.println("4- Listar Clientes");
            System.out.println("5- Voltar");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    Cliente.incluirCliente();
                    break;
                case 2:
                    Cliente.alterarCliente();
                    break;
                case 3:
                    Cliente.excluirCliente();
                    break;
                case 4:
                    Cliente.listarClientes();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
            }
        } while (opcao != 5);
    }

    private static void gerenciarQuartos() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Escolha sua opção para Quartos:");
            System.out.println("1- Incluir Quarto");
            System.out.println("2- Alterar Quarto");
            System.out.println("3- Excluir Quarto");
            System.out.println("4- Listar Quartos");
            System.out.println("5- Voltar");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    Quarto.incluirQuarto();
                    break;
                case 2:
                    Quarto.alterarQuarto();
                    break;
                case 3:
                    Quarto.excluirQuarto();
                    break;
                case 4:
                    Quarto.listarQuartos();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
            }
        } while (opcao != 5);
    }

    private static void gerenciarCamas() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Escolha sua opção para Camas:");
            System.out.println("1- Incluir Cama");
            System.out.println("2- Alterar Cama");
            System.out.println("3- Excluir Cama");
            System.out.println("4- Listar Camas");
            System.out.println("5- Voltar");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    Cama.incluirCama();
                    break;
                case 2:
                    Cama.alterarCama();
                    break;
                case 3:
                    Cama.excluirCama();
                    break;
                case 4:
                    Cama.listarCamas();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
            }
        } while (opcao != 5);
    }

    private static void gerenciarReservas() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Escolha sua opção para Reservas:");
            System.out.println("1- Incluir Reserva");
            System.out.println("2- Alterar Reserva");
            System.out.println("3- Excluir Reserva");
            System.out.println("4- Listar Reservas");
            System.out.println("5- Voltar");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    Reserva.incluirReserva();
                    break;
                case 2:
                    Reserva.alterarReserva();
                    break;
                case 3:
                    Reserva.excluirReserva();
                    break;
                case 4:
                    Reserva.listarReservas();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
            }
        } while (opcao != 5);
    }
}
