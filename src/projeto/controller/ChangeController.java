package projeto.controller;

import projeto.repository.Repository;
import projeto.service.CriteriaService;
import projeto.service.PetService;

import static projeto.util.Util.imprimirPets;
import static projeto.controller.PetController.sc;

public class ChangeController {
    public void alterarPet() {
        CriteriaController criteriaController = new CriteriaController();
        try {
            String[][] petsComCriterios = new CriteriaService().buscarCriterios(criteriaController.definirCriterios());

            if (petsComCriterios == null) {
                return;
            }

            int tamanhoAlterar = petsComCriterios[0].length;
            String[] petAlterar = new String[tamanhoAlterar];
            PetService tratamento = new PetService();
            Repository repository = new Repository();

            imprimirPets(petsComCriterios);
            System.out.print("Digite o numero do pet que voce deseja alterar: ");
            try {
                int indexPet = Integer.parseInt(sc.nextLine()) - 1;
                imprimirPets(petsComCriterios[indexPet]);
                System.out.println("Oque voce deseja alterar:");
                System.out.print("""
                        1 - Nome/Sobrenome
                        2 - Idade
                        3 - Peso
                        4 - Raca
                        5 - Endereco
                        0 - Cancelar
                        :\s""");
                int opcao = Integer.parseInt(sc.nextLine());
                String alterar = "";
                int indexAlterar = -1;
                switch (opcao) {
                    case 0:
                        return;
                    case 1:
                        System.out.print("Digite o novo nome e sobrenome: ");
                        String nome = sc.nextLine();
                        alterar = tratamento.tratarNome(nome);
                        indexAlterar = 0;
                        break;
                    case 2:
                        System.out.print("Digite a nova idade: ");
                        String stringIdade = sc.nextLine();
                        double idade = tratamento.tratarIdade(stringIdade);
                        alterar = idade + " anos";
                        indexAlterar = 4;
                        break;
                    case 3:
                        System.out.print("Digite o novo peso: ");
                        String stringPeso = sc.nextLine();
                        double peso = tratamento.tratarPeso(stringPeso);
                        alterar = peso + "kg";
                        indexAlterar = 5;
                        break;
                    case 4:
                        System.out.print("Digite a nova raca: ");
                        String raca = sc.nextLine();
                        alterar = tratamento.tratarRaca(raca);
                        indexAlterar = 6;
                        break;
                    case 5:
                        System.out.print("Digite o endereco: ");
                        System.out.print("Qual a cidade?: ");
                        String cidade = sc.nextLine();
                        System.out.print("Qual a rua?: ");
                        String rua = sc.nextLine();
                        System.out.print("Qual numero da casa/apartamento?: ");
                        String numeroCasa = sc.nextLine();
                        String[] enderecoArray = tratamento.tratarEndereco(cidade, rua, numeroCasa);
                        alterar = enderecoArray[0] + ", " + enderecoArray[1] + ", " + enderecoArray[2];
                        indexAlterar = 3;
                        break;
                    default:
                        System.out.println("Numero invalido!");
                        break;
                }
                for (int i = 0; i < petsComCriterios[indexPet].length; i++) {
                    petAlterar[i] = petsComCriterios[indexPet][i];
                    if (indexAlterar == i) {
                        petAlterar[indexAlterar] = alterar;
                    }
                }
                repository.alterarPet(petAlterar, petsComCriterios[indexPet]);
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Erro ao tentar alterar um pet!");
            }
        } catch (NullPointerException e){
            System.out.println("O pet nao existe!");
        }
    }
}
