package zad2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    // Tworze liste tablic wynikowych
    public static List<int[][]> listaC = new ArrayList<>();
    public static List<int[][]> listaD = new ArrayList<>();

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        int[] rozmiary = {500, 1000, 1500,2000,3000};
        int procesory = Runtime.getRuntime().availableProcessors();
        BufferedWriter zapis = new BufferedWriter(new FileWriter("wyniki.txt", true));

        for (int indeks = 0; indeks < rozmiary.length; indeks++) {
            int SIZE = rozmiary[indeks];
            int[][] A = new int[SIZE][SIZE];
            int[][] B = new int[SIZE][SIZE];
            // Tworze tablice tymczasowe
            int[][] C = new int[SIZE][SIZE];
            int[][] D = new int[SIZE][SIZE];

            fill_matrix_A(A);
            fill_matrix_B(B);


            Mnozenie_jeden mnz = new Mnozenie_jeden(A, B, C, SIZE);
        //----------------------------------------------------------
            double start_pomiar_1 = System.nanoTime();
            try {
                mnz.start();
                mnz.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            double end_pomiar_1 = System.nanoTime();
            double czas1 = (end_pomiar_1 - start_pomiar_1) / 100_000_000_0;

        //----------------------------------------------------------
            Thread[] watki = new Thread[procesory];

            // Obliczamy liczbe wierszy Size/procesory zaokraglamy funkcja math ceil
            // castujemy na int bo math.ceil zwraca double
            int wiersze = (int) Math.ceil((double) SIZE / procesory);

            long start_pomiar_2 = System.nanoTime();

            for (int i = 0; i < procesory; i++) {
                int start = i * wiersze;
                int end = Math.min(start + wiersze, SIZE);
                watki[i] = new Mnozenie_wiele(A, B, D, start, end, SIZE);
                watki[i].start();
            }
            for (Thread w : watki) {
                try {
                    w.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            double end_pomiar_2 = System.nanoTime();
        /*-------------------------------------------------------------------------------------*/
            double czas2 = (end_pomiar_2 - start_pomiar_2) / 100_000_000_0;
            double roznica = czas1/czas2;
            listaC.add(C);
            listaD.add(D);
            String sumaC = sumakontrolna(listaC.get(indeks));
            String sumaD = sumakontrolna(listaD.get(indeks));
            boolean checksum = sumaC.equals(sumaD);

            System.out.println("Macierz Wynikowa C" + (indeks+1));
            System.out.println("Czas 1 watek: " + czas1 + " s");
            System.out.println("Macierz Wynikowa D" + (indeks+1));
            System.out.printf("Czas dla %d watkow: %.2f s%n", procesory, czas2);
            System.out.printf("Mnozenie %d-wątkowe było %.2f razy szybsze%n",procesory,roznica);





            String wynik = String.format(
                            "\nRozmiar macierzy: %dx%d\n" +
                            "Czas (1 watek): %.2f s\n" +
                            "Czas (%d watkow): %.2f s\n" +
                            "Przyspieszenie: %.2fx\n" +
                            "Suma kontrolna C%s: %s\n" +
                            "Suma kontrolna D%s: %s\n" +
                            "Zgodnosc sum kontrolnych?: %s\n",
                            SIZE, SIZE,
                            czas1,
                            procesory,czas2,
                            roznica,
                            (indeks+1), sumaC,
                            (indeks+1), sumaD,
                            checksum ? "TAK" : "NIE");

            System.out.println(wynik);
            zapis.write(wynik);
            zapis.flush();
        }
        zapis.close();

// Pętla ktora iteruje po liscie elementow C i zwraca indeksy tej listy aby wyswietlac C1 D1 itp oraz wyświetlic sume kontrolna dla tych elementow
        for(int i = 0; i < listaC.size(); i++){
            System.out.println("Suma kontrolna elementu C"+(listaC.indexOf(listaC.get(i))+1)+": "+sumakontrolna(listaC.get(i)));
            System.out.println("Suma kontrolna elementu D"+(listaD.indexOf(listaD.get(i))+1)+": "+sumakontrolna(listaD.get(i)));

        }
    }
/*-------------------------------------------------------------------------------------------------*/

    // Metoda do obliczania sumy kontrolnej
    //Tworzy obiekt klasy MessageDigest skonfigurowany do uzycia algorytmu MD5
    // w petli iterujemy po wierszach i elementach wierszy konwertujac inty na byte bo
    // klasa MessageDigest dziala tylko na bajtach konwersja z int na byte ucina wartosci z
    // przedzialy -128 do 128 ale tutaj jest spoko bo dzialamy na intach z zakresu 0 do 10
    //md.update dodaje bajt do obliczen haszujacych
    //nastepnie tworzy tablice bajtow i zmienia wszystko na postac szesnastkowa i skleja jako string

    public static String sumakontrolna(int[][] macierz) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        for (int[] row : macierz)
            for (int val : row)
                md.update((byte) val);
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest)
            sb.append(String.format("%02x", b));
        return sb.toString();
    }

    public static void fill_matrix_A(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Math.abs((int) Math.round(Math.sin(i+j)*10));
            }
        }
    }

    public static void fill_matrix_B(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Math.abs((int) Math.round(Math.cos(i+j)*10));
            }
        }
    }

    public static void show_array(int[][] matrix) {
        System.out.println("\nMatrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+", ");
            }
        }
    }
}
