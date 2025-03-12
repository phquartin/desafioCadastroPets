package projeto.controller;

import projeto.service.CriteriaService;

import static projeto.controller.PetController.sc;
import static projeto.util.Util.imprimirPets;

public class CriteriaController {
    public String[][] definirCriterios() {
        String[][] criterios = new String[3][2];
        System.out.println("Qual o tipo de animal voce deseja buscar?");
        System.out.print("""
                    1 - Cachorro
                    2 - Gato
                    :\s""");
        try {
            int opc = Integer.parseInt(sc.nextLine()); // Evita problemas com Buffer
            switch (opc) {
                case 1:
                    criterios[0][0] = "Cachorro";
                    criterios[0][1] = "1";
                    break;
                case 2:
                    criterios[0][0] = "Gato";
                    criterios[0][1] = "1";
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
                try {
                    int opcao = Integer.parseInt(sc.nextLine()); // Evita problemas com Buffer
                    switch (opcao) {
                        case 1:
                            System.out.print("Digite o nome e/ou o sobrenome: ");
                            criterios[i][0] = sc.nextLine().toUpperCase();
                            criterios[i][1] = "0";
                            break;
                        case 2:
                            System.out.print("Digite o sexo (M/F): ");
                            String sexo = sc.nextLine().substring(0, 1).toUpperCase();
                            if (sexo.equals("M")) {
                                criterios[i][0] = "Macho";
                            }
                            else if (sexo.equals("F")) {
                                criterios[i][0] = "Femea";
                            }
                            else{
                                System.out.println("Sexo Invalido! Digite M ou F");
                                i--;
                                break;
                            }
                            criterios[i][1] = "2";
                            break;
                        case 3:
                            System.out.print("Digite a idade: ");
                            String idade = String.valueOf(Double.parseDouble(sc.nextLine()));
                            criterios[i][0] = idade;
                            criterios[i][1] = "4";
                            break;
                        case 4:
                            System.out.print("Digite o peso: ");
                            String peso = String.valueOf(Double.parseDouble(sc.nextLine()));
                            criterios[i][0] = peso;
                            criterios[i][1] = "5";
                            break;
                        case 5:
                            System.out.print("Digite a raca: ");
                            criterios[i][0] = sc.nextLine();
                            criterios[i][1] = "6";
                            break;
                        case 6:
                            System.out.print("Digite o endereco: ");
                            criterios[i][0] = sc.nextLine();
                            criterios[i][1] = "3";
                            break;
                        case 7:
                            return criterios;
                        default:
                            System.out.println("Digite um numero valido");
                            i--;
                    }
                }catch (NumberFormatException e) {
                    System.out.println("Digite um numero para selecionar um criterio");
                }catch (Exception e) {
                    System.out.println("Ocorreu um erro inesperado ao tentar escolher um criterio");
                }
            }
            return criterios;
        }catch (NumberFormatException e) {
            System.out.println("Digite um numero!");
        }catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar escolher o tipo de animal!");
        }
        return null;
    }

    public void mostrarPetsComCriterios() {
        String[][] petsComCriterios = new CriteriaService().buscarCriterios(definirCriterios());
        if(petsComCriterios == null) {
            System.out.println("Nenhum resultado encontrado");
            return;
        }
        imprimirPets(petsComCriterios);
    }
}
