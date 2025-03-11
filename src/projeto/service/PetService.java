package projeto.service;

import projeto.model.TypeSexo;
import projeto.model.TypeTipo;
import projeto.model.exceptions.*;

public class PetService {

    public String tratarNome(String nome) throws NameException {
        if (nome.isEmpty()) {
            return "NAO INFORMADO";
        }
        if (!nome.contains(" ")) {
            throw new NameException("Nome deve conter Sobrenme!");
        }
        if (!nome.matches("^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$")) {
            throw new NameException("Nome deve conter apenas letras!");
        }
        return nome;
    }

    public TypeSexo tratarSexo(char sexo) throws SexException {
        if (sexo == 'M') {
            return TypeSexo.MACHO;
        }
        if (sexo == 'F') {
            return TypeSexo.FEMEA;
        }
        throw new SexException("Sexo deve ser M ou F");
    }

    public TypeTipo tratarTipo(String tipo) throws TipoException {
        if (tipo.equals("CACHORRO")) {
            return TypeTipo.CACHORRO;
        }
        if (tipo.equals("GATO")) {
            return TypeTipo.GATO;
        }
        throw new TipoException("Tipo deve ser Cachorro ou Gato");
    }

    public double tratarIdade(String stringIdade) throws RuntimeException, AgeException {
        if (stringIdade.isEmpty()) {
            return 0;
        }
        if (stringIdade.contains(",")) {
            stringIdade = stringIdade.replace(",", ".");
        }
        try {
            double idade = Double.parseDouble(stringIdade);
            if (idade > 20) {
                throw new AgeException("Idade deve ser maior que 20");
            }
            return idade;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Idade deve ser um numero!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public double tratarPeso(String stringPeso) throws RuntimeException {
        if (stringPeso.isEmpty()) {
            return 0;
        }
        if (stringPeso.contains(",")) {
            stringPeso = stringPeso.replace(",", ".");
        }
        try {
            double peso = Double.parseDouble(stringPeso);
            if (peso > 60 || peso < 0.5) {
                throw new WeightException("Peso deve ser maior que 0.5kg ou menor que 60kg");
            }
            return peso;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Peso deve ser um numero!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public String tratarRaca(String raca) throws RaceException {
        if (raca.isEmpty()) {
            return "NAO INFORMADO";
        }
        if (raca.matches("^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$")) {
            return raca;
        }
        throw new RaceException("Raca deve conter apenas letras!");
    }

    public String[] tratarEndereco(String cidade, String rua, String numeroCasa) throws AdressException {
        if (numeroCasa.isEmpty()) {
            numeroCasa = "NAO INFORMADO";
        }
        if (!rua.isEmpty() && !cidade.isEmpty()) {
            return new String[]{rua, numeroCasa, cidade};
        }
        throw new AdressException("Voce deve preencher a cidade e a rua");
    }
}
