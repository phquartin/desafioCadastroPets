package projeto.repository;

import projeto.model.Pet;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Repository {
    Path pathPets = Paths.get("/Caminho/Para/A-Pasta/Pets");
    Path pathFormulario = Paths.get("Caminho/Para/A-Pasta/desafioCadastroPets/src/projeto/repository/formulario.txt");

    public String[] lerFormulario() {
        String[] perguntas;
        try(BufferedReader br = Files.newBufferedReader(pathFormulario)) {
            perguntas = br.lines().toArray(String[]::new);
        }catch (IOException e) {
            System.out.println("Erro ao ler o arquivo do formulario.");
            throw new RuntimeException(e);
        }
        return perguntas;
    }

    public void cadastrarPet(Pet pet) {
        // Criando o nome do arquivo
        String nome = pet.getNome().toUpperCase().replaceAll("\\s+", "");
        String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm"));
        Path pathPet = Paths.get(pathPets.toString(), data+"-"+nome+".txt");
        // Criar o arquivo do Usuario
        try {
            Files.createFile(pathPet);
        } catch (IOException e) {
            System.out.println("Erro ao criar um arquivo");
            throw new RuntimeException(e);
        }

        // Adicionar as respostas no arquivo
        try (BufferedWriter bw = Files.newBufferedWriter(pathPet)) {
            bw.write("1 - " + pet.getNome());
            bw.newLine();
            bw.write("2 - " + pet.getTipo().nome);
            bw.newLine();
            bw.write("3 - " + pet.getSexo().sexo);
            bw.newLine();
            bw.write("4 - " + pet.getEndereco()[0] +", "+ pet.getEndereco()[1] +", "+ pet.getEndereco()[2]);
            bw.newLine();
            String resultadoIdade = (pet.getIdade() == 0) ? "5 - NAO INFORMADO" : "5 - " + pet.getIdade() + " anos";
            bw.write(resultadoIdade);
            bw.newLine();
            String resultadoPeso = (pet.getPeso() == 0) ? "6 - NAO INFORMADO" : "6 - " + pet.getPeso() + "kg";
            bw.write(resultadoPeso);
            bw.newLine();
            bw.write("7 - " + pet.getRaca());
            bw.newLine();

            String[] perguntas = lerFormulario();
            if(perguntas.length > 7) {
                for(int i = 7; i < perguntas.length; i++) {
                    bw.write(perguntas[i]);
                    bw.newLine();
                }
            }

            bw.flush();

        } catch (IOException e) {
            System.out.println("Erro em escrever o usuario em um arquivo");
            throw new RuntimeException(e);
        }
    }

    public void alterarPet(String[] pet, String[] petSemAlterar) {
        Path pathPet = buscarPastaPet(petSemAlterar);

        try (BufferedWriter bw = Files.newBufferedWriter(pathPet)) {
            int id = -1;
            for(String desc : pet) {
                id++;
                bw.write((id + 1) + " - " + desc);
                bw.newLine();
            }

            String[] perguntas = lerFormulario();
            if(perguntas.length > 7) {
                for(int i = 7; i < perguntas.length; i++) {
                    bw.write(perguntas[i]);
                    bw.newLine();
                }
            }

            bw.flush();

        } catch (IOException e) {
            System.out.println("Erro em escrever o usuario em um arquivo");
            throw new RuntimeException(e);
        }
    }

    public String[][] lerPets() {
        String[] perguntas = lerFormulario();
        File name = new File(String.valueOf(pathPets));
        File[] files = name.listFiles();
        assert files != null;

        String[][] pets = new String[files.length][perguntas.length];

        int count = -1;
        for(File file:files){
            ++count;
                try(BufferedReader br = Files.newBufferedReader(file.toPath())) {
                    for(int i = 0; i < perguntas.length; i++) {
                        pets[count][i] = br.readLine().substring(4);
                    }
                } catch (IOException e) {
                    System.out.println("Erro ao ler o arquivo" + e.getMessage());
                }
            }

        return pets;
    }

    public Path buscarPastaPet(String[] petBuscando) {
        String[] perguntas = lerFormulario();
        File fileName = new File(String.valueOf(pathPets));
        File[] files = fileName.listFiles();
        assert files != null;

        String[][] pets = new String[files.length][perguntas.length];

        int count = -1;
        for(File file:files){
            ++count;
            try(BufferedReader br = Files.newBufferedReader(file.toPath())) {
                for(int i = 0; i < perguntas.length; i++) {
                    pets[count][i] = br.readLine().substring(4);
                }
                if(Arrays.equals(pets[count], petBuscando)) {
                    return file.toPath();
                }
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo" + e.getMessage());
            }
        }
        return null;
    }

    public void deletarPet(String[] pet) {
        Path pathPet = buscarPastaPet(pet);
        try {
            Files.delete(pathPet);
        }catch (IOException e) {
            System.out.println("Erro ao deletar o arquivo");
        }catch (Exception e) {
            System.out.println("Problema inesperado");
        }
    }
}
