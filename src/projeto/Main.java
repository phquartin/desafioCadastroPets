package projeto;

import projeto.controller.PetController;
import projeto.service.PetService;

import static projeto.controller.PetController.sc;

public class Main {
    public static void main(String[] args) {
        PetController petController = new PetController();
        System.out.println("\t\tBem-vindo ao sistema de cadastros");
        System.out.println("Aperte ENTER para entrar");
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
            int opcao = Integer.parseInt(sc.nextLine()); // Evita problemas com Buffer
            switch (opcao) {
                case 1:
                    petController.criarPet();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    petController.lerPets();
                    System.out.println("Pressione ENTER para continuar");
                    sc.nextLine();
                    break;
                case 5:

                    break;
                case 6:
                    sc.close();
                    return;
                default:
                    System.out.println("Numero Invalido");
                    break;
            }
        }
    }
}
