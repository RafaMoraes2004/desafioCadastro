package Main.Services;

import Main.Entities.Pet;
import Main.Utils.Sexo;
import Main.Utils.Tipo;
import Main.Utils.UtilReadPrint;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ServiceCadastro {

    LocalDateTime agora = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
    String timestamp = agora.format(formatter);

    public static final String VAZIO = "Não informado";

    public void cadastro() throws Exception {

        Scanner sc = new Scanner(System.in);
        UtilReadPrint rp = new UtilReadPrint();
        Double peso = 0.0;
        Double idade = 0.0;
        Tipo tipo = null;
        String nome = "";
        String sobrenome = "";
        String raca = "";
        Integer numero;
        String cidade;
        String rua;
        Sexo sexo = null;

        String path = "/home/rafael/Área de trabalho/UDEMY-JAVA/desafioCadastro/data/formulario.txt";
        rp.printFile(path);

        sc.nextLine();

        try {
            System.out.println("Digite o nome: ");
            nome = sc.nextLine();
            System.out.println("Digite o sobrenome: ");
            sobrenome = sc.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Nome invalido. Digite apenas letras.");
        }
        if (sobrenome == "") {
            sobrenome = VAZIO;
        }
        if (nome == "") {
            throw new Exception("Nome não pode ficar vazio. Erro");
        }

        while (tipo == null) {
            System.out.println("Digite o tipo de animal(Gato ou cachorro): ");
            String entrada = sc.nextLine().trim().toUpperCase();

            try {
                tipo = Tipo.valueOf(entrada);

            } catch (IllegalArgumentException e) {
                System.out.println("Invalido, digite apenas Gato ou cachorro" + e.getMessage());
            }
        }

        // EXCEPTION PERSONALIZADA
        while (sexo == null) {
            System.out.print("Digite o sexo do pet (M/F): ");
            String entrada2 = sc.nextLine().trim().toUpperCase();

            try {
                sexo = Sexo.valueOf(entrada2);
            } catch (IllegalArgumentException e) {
                System.out.println("Sexo inválido. Digite apenas M ou F.");
            }
        }

        System.out.println("Digite o endereço (Numero, cidade e Rua respectivamente): ");
        System.out.println("Digite o numero da casa: ");
        numero = sc.nextInt();
        System.out.println("Digite a cidade ");
        cidade = sc.next();
        System.out.println("Digite a rua: ");
        sc.nextLine();
        rua = sc.next();

        try {

            System.out.println("Digite a idade: ");
            idade = sc.nextDouble();

        } catch (InputMismatchException e) {
            System.out.println("Idade invalida.");

        }
        if (idade > 20) {
            throw new Exception("Idade inválido! Deve ser menor que 20.");
        }

        try {
            System.out.println("Digite o peso: ");
            peso = sc.nextDouble();

        } catch (InputMismatchException e) {
            System.out.println("Peso invalida.");
        }
        if (peso > 60 || peso < 0.5) {
            throw new Exception("Peso inválido! Deve estar entre 0.5kg e 60kg.");
        }

        try {
            System.out.println("Digite a raça: ");
            raca = sc.next();
            if (raca == null) {
                raca = VAZIO;
            }
        } catch (InputMismatchException e) {
            System.out.println("Digite somente letras");
        }

        Pet pet = new Pet(nome, sobrenome, tipo, sexo, numero, cidade, rua, idade, peso, raca);

        String path2 = "/home/rafael/Área de trabalho/UDEMY-JAVA/desafioCadastro/data/petsCadastrados/";

        String nomeFormatado = pet.getNome().replaceAll("\\s+", "").toUpperCase();

        String arquivoNome = timestamp + "-" + nomeFormatado + ".TXT";
        String caminhoCompleto = path2 + "/" + arquivoNome;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoCompleto))) {

            bw.write(pet.toString());
            bw.newLine();

            System.out.println("Arquivo salvo em: " + caminhoCompleto);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
