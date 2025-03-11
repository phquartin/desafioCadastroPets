package projeto.service;

import projeto.repository.Repository;

public class CriteriaService {
    public void buscarCriterios(String[][] criterios) {
        if (criterios[0][0] == null) {return;}
        Repository repo = new Repository();
        String[][] pets = repo.lerPets();

        // ME DA VONTADE DE VOMITAR VENDO ISSO, MAS N TIVE OUTRA IDEIA MELHOR :(, vou deixar bem comentado pois pode estar bem confuso
        for (String[] pet : pets) { // Buscando todos os pets que existem

            for (int i = 0; i < pet.length; i++) { // Buscando as descricoes com o index

                if(pet[1].equals(criterios[0][0])){ // Buscando PETS com o TIPO igual o informando em definirCriterios()
                    // Preciso botar o .contains apenas em nome e endereco, o resto deve ser IGUAL, e tambem melhorar a busca por idade, double, eles devem ser numeros
                }
            }
        }

    }
}
