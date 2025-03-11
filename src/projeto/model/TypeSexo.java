package projeto.model;

public enum TypeSexo {
    MACHO('M', "Macho"),
    FEMEA('F', "Femea");

    public final char codigo;
    public final String sexo;

    TypeSexo(char codigo, String sexo) {
        this.codigo = codigo;
        this.sexo = sexo;
    }
}