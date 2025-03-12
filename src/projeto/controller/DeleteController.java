package projeto.controller;

import projeto.service.CriteriaService;
import projeto.repository.Repository;

import static projeto.controller.PetController.sc;
import static projeto.util.Util.imprimirPets;

public class DeleteController {

    public void deletarPet(){
        CriteriaController criteriaController = new CriteriaController();
        String[][] petsComCriterios = new CriteriaService().buscarCriterios(criteriaController.definirCriterios());
        if (petsComCriterios == null) {return;}
        Repository repository = new Repository();

        imprimirPets(petsComCriterios);
        System.out.print("Digite o numero do pet que voce deseja deletar ");
        int indexPet = Integer.parseInt(sc.nextLine()) - 1;
        System.out.println("Tem certeza que voce que deletar o/a " + petsComCriterios[indexPet][0]);
        System.out.print("SIM / NAO");
        char opcao = sc.nextLine().toUpperCase().charAt(0);
        if (opcao == 'N') {
            System.out.println("OPERACAO CANCELADA");
            return;
        }
        if (opcao != 'S') {
            System.out.println("Numero INVALIDO, voltando para a tela inicial");
            return;
        }
        repository.deletarPet(petsComCriterios[indexPet]);
    }
}
