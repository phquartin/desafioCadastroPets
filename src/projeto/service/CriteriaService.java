package projeto.service;

import projeto.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class CriteriaService {

    public String[][] buscarCriterios(String[][] criterios) {
        if (criterios[0][0] == null) {return null;}
        int indexCriterioTipo = Integer.parseInt(criterios[0][1]);
        String[][] pets = new Repository().lerPets();
        List<String> petsDescricao = new ArrayList<>();
        List<String[]> listaPetsComCriterio = new ArrayList<>();

        for (String[] pet : pets) { // Buscando todos os pets que existem
            for (String desc : pet) { // Buscando as descricoes com o index
                if (pet[indexCriterioTipo].equals(criterios[0][0])) { // Buscando PETS com o TIPO do animal igual o informando em definirCriterios()
                    if(criterios[1][0] != null && criterios[2][0] != null) {
                        if(pet[Integer.parseInt(criterios[1][1])].toUpperCase().contains(criterios[2][0].toUpperCase()) && pet[Integer.parseInt(criterios[2][1])].toUpperCase().contains(criterios[2][0].toUpperCase())){
                            petsDescricao.add(desc);
                        }
                        continue;
                    }
                    if(criterios[1][0] != null){
                        if(pet[Integer.parseInt(criterios[1][1])].toUpperCase().contains(criterios[1][0].toUpperCase())){
                            petsDescricao.add(desc);
                        }
                        continue;
                    }
                    petsDescricao.add(desc);
                }
            }
            if (!petsDescricao.isEmpty()) {
                String[] descTemp = petsDescricao.toArray(new String[0]);
                petsDescricao.clear();

                listaPetsComCriterio.add(descTemp);
            }
        }
        if (listaPetsComCriterio.isEmpty()) {return null;}
        return listaPetsComCriterio.toArray(new String[0][0]);
    }
}
