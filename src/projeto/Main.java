package projeto;

import projeto.controller.*;
import projeto.controller.PetController;
import projeto.util.Util;

import static projeto.controller.PetController.sc;

public class Main {
    public static void main(String[] args) {
        PetController petController = new PetController();
        CriteriaController criteriaController = new CriteriaController();
        ChangeController changeController = new ChangeController();
        DeleteController deleteController = new DeleteController();

        System.out.println("\t\tBem-vindo ao sistema de cadastros");
        System.out.println("Aperte "+ Util.ConsoleColors.GREEN + " ENTER " + Util.ConsoleColors.RESET + " para entrar");
        sc.nextLine();
        while (true) {
            System.out.print("""
                    1 - Cadastrar um novo pet
                    2 - Alterar dados de um pet
                    3 - Deletar um pet
                    4 - Listar todos os pets
                    5 - Pesquisar pets por algum criterio
                    6 - Sair
                    :\s""");
            try {
                int opcao = Integer.parseInt(sc.nextLine()); // Evita problemas com Buffer
                switch (opcao) {
                    case 1:
                        petController.criarPet();
                        System.out.println("Pressione "+ Util.ConsoleColors.GREEN + " ENTER " + Util.ConsoleColors.RESET + " para continuar");
                        sc.nextLine();
                        break;
                    case 2:
                        changeController.alterarPet();
                        System.out.println("Pressione "+ Util.ConsoleColors.GREEN + " ENTER " + Util.ConsoleColors.RESET + " para continuar");
                        sc.nextLine();
                        break;
                    case 3:
                        deleteController.deletarPet();
                        System.out.println("Pressione "+ Util.ConsoleColors.GREEN + " ENTER " + Util.ConsoleColors.RESET + " para continuar");
                        sc.nextLine();
                        break;
                    case 4:
                        petController.lerPets();
                        System.out.println("Pressione "+ Util.ConsoleColors.GREEN + " ENTER " + Util.ConsoleColors.RESET + " para continuar");
                        sc.nextLine();
                        break;
                    case 5:
                        criteriaController.mostrarPetsComCriterios();
                        System.out.println("Pressione "+ Util.ConsoleColors.GREEN + " ENTER " + Util.ConsoleColors.RESET + " para continuar");
                        sc.nextLine();
                        sc.nextLine();
                        break;
                    case 6:
                        sc.close();
                        return;
                    default:
                        System.out.println(Util.ConsoleColors.RED_BOLD + "Numero Invalido" + Util.ConsoleColors.RESET);
                        break;
                }
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
