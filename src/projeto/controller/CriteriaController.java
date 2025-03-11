package projeto.controller;

import static projeto.controller.PetController.sc;

public class CriteriaController {
    public String[][] definirCriterios() {
        String[][] criterios = new String[3][1];
        System.out.println("Qual o tipo de animal voce deseja buscar?");
        System.out.print("""
                    1 - Cachorro
                    2 - Gato
                    :\s""");
        int opc = Integer.parseInt(sc.nextLine()); // Evita problemas com Buffer
        switch (opc) {
            case 1:
                criterios[0][0] = "Cachorro";
                break;
            case 2:
                criterios[0][0] = "Gato";
                break;
            default:
                System.out.println("Criterio INVALIDO");
                return null;
        }
        for(int i = 1 ; i < 3 ; i++) {
            System.out.println("Qual outro tipo de criterio voce deseja acresentar?");
            System.out.print("""
                    1 - Nome/Sobrenome
                    2 - Sexo
                    3 - Idade
                    4 - Peso
                    5 - Raca
                    6 - Endereco
                    7 - Concluir
                    :\s""");
            Integer opcao = Integer.parseInt(sc.nextLine()); // Evita problemas com Buffer
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome e/ou o sobrenome: ");
                    criterios[i][0] = sc.nextLine();
                    criterios[i][1] = String.valueOf(opcao);
                    break;
                case 2:
                    System.out.print("Digite o sexo (M/F): ");
                    criterios[i][0] = sc.nextLine();
                    criterios[i][1] = String.valueOf(opcao);
                    break;
                case 3:
                    System.out.print("Digite a idade: ");
                    criterios[i][0] = sc.nextLine();
                    criterios[i][1] = String.valueOf(opcao);
                    break;
                case 4:
                    System.out.print("Digite o peso: ");
                    criterios[i][0] = sc.nextLine();
                    criterios[i][1] = String.valueOf(opcao);
                    break;
                case 5:
                    System.out.print("Digite a raca: ");
                    criterios[i][0] = sc.nextLine();
                    criterios[i][1] = String.valueOf(opcao);
                    break;
                case 6:
                    System.out.print("Digite o endereco: ");
                    criterios[i][0] = sc.nextLine();
                    criterios[i][1] = String.valueOf(opcao);
                    break;
                case 7:
                    return criterios;
                default:
                    System.out.println("Digite um numero valido");
                    i--;
                    continue;
            }
        }
        return criterios;
    }
}
