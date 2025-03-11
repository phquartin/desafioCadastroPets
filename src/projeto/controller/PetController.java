package projeto.controller;

import projeto.model.Pet;
import projeto.model.TypeSexo;
import projeto.model.TypeTipo;
import projeto.repository.Repository;
import projeto.service.PetService;

import java.util.Scanner;

public class PetController {
    public static final Scanner sc = new Scanner(System.in).useDelimiter("\\n");
    private final PetService tratamento = new PetService();
    private final Repository repository = new Repository();

    public void criarPet(){
        String[] perguntas = repository.lerFormulario();

        // Nome
        System.out.println(perguntas[0]);
        String nome = sc.nextLine();
        nome = tratamento.tratarNome(nome);

        // Tipo
        System.out.println(perguntas[1]);
        String stringTipo = sc.nextLine().toUpperCase().trim();
        TypeTipo tipo = tratamento.tratarTipo(stringTipo);

        // Sexo
        System.out.println(perguntas[2]);
        char charSexo = sc.nextLine().toUpperCase().trim().charAt(0);
        TypeSexo sexo = tratamento.tratarSexo(charSexo);

        // Endereco
        System.out.println(perguntas[3]);
        System.out.print("Qual a cidade?: ");
        String cidade = sc.nextLine();
        System.out.print("Qual a rua?: ");
        String rua = sc.nextLine();
        System.out.print("Qual numero da casa/apartamento?: ");
        String numeroCasa = sc.nextLine();
        String[] endereco = tratamento.tratarEndereco(cidade, rua, numeroCasa);

        // Idade
        System.out.println(perguntas[4]);
        String stringIdade = sc.nextLine();
        double idade = tratamento.tratarIdade(stringIdade);

        // Peso
        System.out.println(perguntas[5]);
        String stringPeso = sc.nextLine();
        double peso = tratamento.tratarPeso(stringPeso);


        // Raca
        System.out.println(perguntas[6]);
        String raca = sc.nextLine();
        raca = tratamento.tratarRaca(raca);

        if (perguntas.length > 7) {
            String[] respostas = new String[perguntas.length];
            for (int i = 7; i < perguntas.length; i++) {
                System.out.println(perguntas[i]);
                respostas[i] = sc.nextLine();
            }
        }

        Pet pet = new Pet(nome, tipo, sexo, endereco, idade, peso, raca);
        repository.cadastrarPet(pet);
    }

    public void lerPets(){
        Repository repository = new Repository();
        String[][] pets = repository.lerPets();
        int id = 0;
        for (String[] pet : pets) {
            System.out.print(++id + ".    ");
            for(String descricao : pet){
                System.out.print(" - "+ descricao.substring(4));
            }
            System.out.println();
        }
    }
    public void lerPetsCriterio(int[] criterios){}
}
