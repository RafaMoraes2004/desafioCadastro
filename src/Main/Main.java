package Main;

import Main.Services.ServiceBuscar;
import Main.Services.ServiceCadastro;
import Main.Utils.UtilReadPrint;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        UtilReadPrint rp = new UtilReadPrint();
        

        String path = "/home/rafael/Área de trabalho/UDEMY-JAVA/desafioCadastro/data/formulario.txt";
        rp.printFile(path);

        menu(sc);

        System.out.println("Fechando programa....");
    }

    public static void menu(Scanner sc) throws Exception {
        int in;
        ServiceCadastro se = new ServiceCadastro();
        ServiceBuscar sb = new ServiceBuscar();
        
        do {
            System.out.println("---------------------- MENU --------------------------");
            System.out.println();
            System.out.println("1. Cadastrar um novo pet");
            System.out.println("2.  Buscar os dados do Pet Cadastrado");
            System.out.println("3. Deletar um pet cadastrado");
            System.out.println("4. Alterar os dados do pet cadastrado");
            System.out.println("5. Sair");
            System.out.println();
            System.out.println("Digite a opção que deseja: ");

            try {
                in = sc.nextInt();

                switch (in) {
                    case 1 -> se.cadastro();
                    case 2 -> sb.buscar();
                    case 3 -> System.out.println("3 deletar");
                    case 4 -> System.out.println("4 alterar pets");
                    case 5 -> System.out.println("5 sair");

                    default -> {
                        System.out.println("Opção invalida");
                        sc.nextLine();
                        in = 0;

                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Digite um valor valido");
                sc.nextLine();
                in = 0;
            }


        } while (in != 5);

    }
}