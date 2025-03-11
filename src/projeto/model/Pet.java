package projeto.model;

import java.util.Arrays;

public class Pet {
    private String nome;
    private TypeTipo TIPO;
    private TypeSexo SEXO;
    private String[] endereco;
    private double idade;
    private double peso;
    private String raca;

    public Pet(String nome, TypeTipo TIPO, TypeSexo SEXO, String[] endereco, double idade, double peso, String raca) {
        this.nome = nome;
        this.TIPO = TIPO;
        this.SEXO = SEXO;
        this.endereco = endereco;
        this.idade = idade;
        this.peso = peso;
        this.raca = raca;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "nome='" + nome + '\'' +
                ", TIPO=" + TIPO +
                ", SEXO=" + SEXO +
                ", endereco=" + Arrays.toString(endereco) +
                ", idade=" + idade +
                ", peso=" + peso +
                ", raca='" + raca + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public TypeTipo getTipo() {
        return TIPO;
    }

    public TypeSexo getSexo() {
        return SEXO;
    }

    public String[] getEndereco() {
        return endereco;
    }

    public double getIdade() {
        return idade;
    }

    public double getPeso() {
        return peso;
    }

    public String getRaca() {
        return raca;
    }
}
