import java.util.Random;

public class zad5 {
    public static void main(String[] args) {

        watekdo5 macierz1 = new watekdo5();
        watekdo5 macierz2 = new watekdo5();
        macierz1.start();
        macierz2.start();
try{
    macierz1.join();
    macierz2.join();
} catch (Exception e) {
    throw new RuntimeException(e);
}

    System.out.println("--------------");
    int[][] wynik = macierz1.mnozenie(macierz1.matrix, macierz2.matrix);
        for (int i = 0; i < wynik.length; i++) {
            System.out.println();
            for (int j = 0; j < wynik[0].length; j++) {
                    System.out.print(wynik[i][j]+" | ");
            }

        }
    }}

