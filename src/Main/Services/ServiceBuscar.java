package Main.Services;

import Main.Entities.Pet;
import Main.Utils.Sexo;
import Main.Utils.Tipo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceBuscar {

    @SuppressWarnings("ConvertToTryWithResources")
    public static List<Pet> listFile(File path) {
        List<Pet> listaDePets = new ArrayList<>();

        if (!path.exists() || !path.isDirectory()) {
            System.out.println("O diretório não existe ou não é uma pasta.");
            return listaDePets;
        }

        File[] arquivos = path.listFiles();
        if (arquivos == null || arquivos.length == 0) {
            System.out.println("Nenhum arquivo encontrado no diretório.");
            return listaDePets;
        }

        for (File arquivo : arquivos) {
            if (arquivo.isFile() && arquivo.getName().toLowerCase().endsWith(".txt")) {
                System.out.println("Lendo arquivo: " + arquivo.getName());

                try {
                    BufferedReader br = new BufferedReader(new FileReader(arquivo));

                    String nome = br.readLine();
                    String tipoStr = br.readLine();
                    String sexoStr = br.readLine();
                    String endereco = br.readLine();
                    String idadeStr = br.readLine();
                    String pesoStr = br.readLine();
                    String raca = br.readLine();

                    br.close();

                    if (nome != null && tipoStr != null) {
                        // converter tipo para enum
                        Tipo tipo = Tipo.valueOf(tipoStr.trim().toUpperCase());

                        // converter sexo
                        Sexo sexo = Sexo.M;
                        if (sexoStr != null && sexoStr.trim().equalsIgnoreCase("F")) {
                            sexo = Sexo.F;
                        }

                        // endereço
                        Integer numero = 0;
                        String cidade = "";
                        String rua = "";
                        if (endereco != null) {
                            String[] parts = endereco.split(",");
                            if (parts.length >= 3) {
                                try {
                                    numero = Integer.valueOf(parts[0].trim());
                                } catch (NumberFormatException e) {
                                    numero = 0;
                                }
                                cidade = parts[1].trim();
                                rua = parts[2].trim();
                            }
                        }

                        // idade
                        Double idade = 0.0;
                        if (idadeStr != null) {
                            try {
                                idade = Double.valueOf(idadeStr.replace("anos", "").trim());
                            } catch (NumberFormatException e) {
                                idade = 0.0;
                            }
                        }

                        // peso
                        Double peso = 0.0;
                        if (pesoStr != null) {
                            try {
                                peso = Double.valueOf(pesoStr.replace("kgs", "").trim());
                            } catch (NumberFormatException e) {
                                peso = 0.0;
                            }
                        }

                        // criar Pet
                        Pet pet = new Pet(nome, "", tipo, sexo, numero, cidade, rua, idade, peso, raca);
                        listaDePets.add(pet);
                    }

                } catch (IOException e) {
                    System.out.println("Erro ao ler arquivo: " + arquivo.getName());
                }
            }
        }

        return listaDePets;
    }

    public void buscar() {

        File path = new File("/home/rafael/Área de trabalho/UDEMY-JAVA/desafioCadastro/data/petsCadastrados");
        List<Pet> todosOsPets = listFile(path);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- SELECIONE O TIPO DE PET ---");
            System.out.println("1. Cachorro");
            System.out.println("2. Gato");
            System.out.println("0. Sair do programa");
            System.out.print("Digite sua opção: ");

            int tipoEscolha = scanner.nextInt();

            if (tipoEscolha == 0) {
                break;
            }

            // NO TXT ELE PERDDE O VALOR DE TIPO --- VIRA UM TEXTO QUALQUER POR ISSO NUNCA
            // VAI ACHAR, MUDAR PAR TXT
            String tipoSelecionado;
            switch (tipoEscolha) {
                case 1 -> tipoSelecionado = "CACHORRO";
                case 2 -> tipoSelecionado = "GATO";
                default -> {
                    System.out.println("Opção de tipo inválida. Tente novamente.");
                    continue;
                }      
            }

        System.out.println("\nEscolha os critérios de busca (1 ou 2):");
        System.out.println("1. Nome ou Sobrenome");
        System.out.println("2. Sexo");
        System.out.println("3. Idade");
        System.out.println("4. Peso");
        System.out.println("5. Raça");
        System.out.println("6. Endereço");

        System.out.print("Digite o número do primeiro critério: ");
        int crit1 = scanner.nextInt();
        scanner.nextLine(); // limpar buffer

        System.out.print("Digite o número do segundo critério (0 para nenhum): ");
        int crit2 = scanner.nextInt();
        scanner.nextLine(); // limpar buffer

        String valorCrit1 = "";
        String valorCrit2 = "";

        if (crit1 == 1) {
            System.out.print("Digite o nome ou sobrenome: ");
            valorCrit1 = scanner.nextLine();
        } else if (crit1 == 2) {
            System.out.print("Digite o sexo (M/F): ");
            valorCrit1 = scanner.nextLine();
        } else if (crit1 == 3) {
            System.out.print("Digite a idade: ");
            valorCrit1 = scanner.nextLine();
        } else if (crit1 == 4) {
            System.out.print("Digite o peso: ");
            valorCrit1 = scanner.nextLine();
        } else if (crit1 == 5) {
            System.out.print("Digite a raça: ");
            valorCrit1 = scanner.nextLine();
        } else if (crit1 == 6) {
            System.out.print("Digite a cidade ou rua: ");
            valorCrit1 = scanner.nextLine();
        }

        if (crit2 != 0) {
            if (crit2 == 1) {
                System.out.print("Digite o nome ou sobrenome: ");
                valorCrit2 = scanner.nextLine();
            } else if (crit2 == 2) {
                System.out.print("Digite o sexo (M/F): ");
                valorCrit2 = scanner.nextLine();
            } else if (crit2 == 3) {
                System.out.print("Digite a idade: ");
                valorCrit2 = scanner.nextLine();
            } else if (crit2 == 4) {
                System.out.print("Digite o peso: ");
                valorCrit2 = scanner.nextLine();
            } else if (crit2 == 5) {
                System.out.print("Digite a raça: ");
                valorCrit2 = scanner.nextLine();
            } else if (crit2 == 6) {
                System.out.print("Digite a cidade ou rua: ");
                valorCrit2 = scanner.nextLine();
            }
        }

            List<Pet> petsFiltradosPorTipo = new ArrayList<>();
            for (Pet pet : todosOsPets) {
                if (pet.getTipo().name().equalsIgnoreCase(tipoSelecionado)) {
                    continue;
            }

            boolean atendeCrit1 = false;
            boolean atendeCrit2 = (crit2 == 0); // se não escolheu segundo critério, já é true

            // avaliar crit1
            switch (crit1) {
                case 1:
                    if (pet.getNome().equalsIgnoreCase(valorCrit1) || pet.getSobrenome().equalsIgnoreCase(valorCrit1)) {
                        atendeCrit1 = true;
                    }
                    break;
                case 2:
                    if ((valorCrit1.equalsIgnoreCase("M") && pet.getSexo() == Sexo.M) ||
                        (valorCrit1.equalsIgnoreCase("F") && pet.getSexo() == Sexo.F)) {
                        atendeCrit1 = true;
                    }
                    break;
                case 3:
                    if (pet.getIdade() == Double.parseDouble(valorCrit1)) {
                        atendeCrit1 = true;
                    }
                    break;
                case 4:
                    if (pet.getPeso() == Double.parseDouble(valorCrit1)) {
                        atendeCrit1 = true;
                    }
                    break;
                case 5:
                    if (pet.getRaca().equalsIgnoreCase(valorCrit1)) {
                        atendeCrit1 = true;
                    }
                    break;
                case 6:
                    if (pet.getCidade().equalsIgnoreCase(valorCrit1) || pet.getRua().equalsIgnoreCase(valorCrit1)) {
                        atendeCrit1 = true;
                    }
                    break;
            }

            // avaliar crit2 se existir
            if (crit2 != 0) {
                switch (crit2) {
                    case 1:
                        if (pet.getNome().equalsIgnoreCase(valorCrit2) || pet.getSobrenome().equalsIgnoreCase(valorCrit2)) {
                            atendeCrit2 = true;
                        }
                        break;
                    case 2:
                        if ((valorCrit2.equalsIgnoreCase("M") && pet.getSexo() == Sexo.M) ||
                            (valorCrit2.equalsIgnoreCase("F") && pet.getSexo() == Sexo.F)) {
                            atendeCrit2 = true;
                        }
                        break;
                    case 3:
                        if (pet.getIdade() == Double.parseDouble(valorCrit2)) {
                            atendeCrit2 = true;
                        }
                        break;
                    case 4:
                        if (pet.getPeso() == Double.parseDouble(valorCrit2)) {
                            atendeCrit2 = true;
                        }
                        break;
                    case 5:
                        if (pet.getRaca().equalsIgnoreCase(valorCrit2)) {
                            atendeCrit2 = true;
                        }
                        break;
                    case 6:
                        if (pet.getCidade().equalsIgnoreCase(valorCrit2) || pet.getRua().equalsIgnoreCase(valorCrit2)) {
                            atendeCrit2 = true;
                        }
                        break;
                }
            }

            if (atendeCrit1 && atendeCrit2) {
                petsFiltradosPorTipo.add(pet);
            }
        }

            if (petsFiltradosPorTipo.isEmpty()) {
                System.out.println("Nenhum pet do tipo '" + tipoSelecionado + "' encontrado nos arquivos.");
            } else {
                System.out.println("\nPets encontrados do tipo '" + tipoSelecionado + "':");
                for (Pet p : petsFiltradosPorTipo) {
                    System.out.println("Nome: " + p.getNome() +
                            " | Tipo: " + p.getTipo() +
                            " | Idade: " + p.getIdade() +
                            " | Peso: " + p.getPeso() +
                            " | Cidade: " + p.getCidade() +
                            " | Rua: " + p.getRua() +
                            " | Raça: " + p.getRaca());
                }
            }
        }
    }
}