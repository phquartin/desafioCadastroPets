package projeto.util;

public class Util {
    public static void imprimirPets(String[][] pets) {
        int id = 0;
        for (String[] pet : pets) {
            System.out.print(++id + ".    ");
            for (String descricao : pet) {
                System.out.print(descricao + " - ");
            }
            System.out.println();
        }
    }
}
