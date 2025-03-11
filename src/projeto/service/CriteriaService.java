package projeto.service;

import projeto.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class CriteriaService {

    public String[][] buscarCriterios(String[][] criterios) {
        if (criterios[0][0] == null) {return null;}
        int indexCriterioTipo = Integer.parseInt(criterios[0][1]);
        String[][] pets = new Repository().lerPets();
        List<String[]> listaPetsComCriterio = new ArrayList<>();

        for (String[] pet : pets) { // Buscando todos os pets que existem
            for (String ignored : pet) { // Buscando as descricoes com o index
                if (pet[indexCriterioTipo].equals(criterios[0][0])) { // Buscando PETS com o TIPO do animal igual o informando em definirCriterios()
                    if(criterios[1][0] != null && criterios[2][0] != null) {
                        if(pet[Integer.parseInt(criterios[1][1])].contains(criterios[2][0]) && pet[Integer.parseInt(criterios[2][1])].contains(criterios[2][0])){
                            listaPetsComCriterio.add(pet);
                        }
                        continue;
                    }
                    if(criterios[1][0] != null){
                        if(pet[Integer.parseInt(criterios[1][1])].contains(criterios[1][0])){
                            listaPetsComCriterio.add(pet);
                        }
                        continue;
                    }
                    listaPetsComCriterio.add(pet);
                }
            }
        }
        if (listaPetsComCriterio.isEmpty()) {return null;}
        return listaPetsComCriterio.toArray(new String[0][0]);
    }
}
