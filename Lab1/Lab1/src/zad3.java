import java.util.Random;
public class zad3 {
    public static int[] zapelnij(int[] tablica) {
        for (int i = 0; i < tablica.length; i++) {
            Random rand = new Random();
            int liczba = rand.nextInt(100);
            tablica[i] = liczba;
        }
        return tablica;
    }

    public static void wypisz(int[] tablica) {
        for (int i = 0; i < tablica.length; i++) {
            System.out.print(tablica[i] + " ");
        }
        System.out.println();
    }

    public static int max(int[] tablica) {
        int maks = tablica[0];
        for (int i = 0; i < tablica.length; i++) {
            if (tablica[i] > maks) {
                maks = tablica[i];
            }
        }
        return maks;
    }

    public static void trzymaks(int[] tablica) {

        int max = max(tablica);
        int max2 = tablica[0];
        int max3 = tablica[0];
        for (int i = 0; i < tablica.length; i++) {
            if (tablica[i] > max2 && tablica[i] != max) {
                max2 = tablica[i];
            }
        }
        for (int i = 0; i < tablica.length; i++) {
            if (tablica[i] > max3 && tablica[i] != max2 && tablica[i] != max) {
                max3 = tablica[i];
            }
        }

        System.out.println("Max:1-" + max + "Max:2-" + max2 + "Max:3-" + max3);


    }

    public static int aryt(int[] tablica) {
        int e = 0;
        for (int i = 0; i < tablica.length; i++) {
            e += tablica[i];
        }
        int wynik = e / tablica.length;
            return wynik;
    }

    public static int min(int[] tablica) {
        int min = tablica[0];
        for (int i = 0; i < tablica.length; i++) {
            if (tablica[i] < min) {
                min = tablica[i];
            }
        }
        return min;
    }

    public static void wypiszodtylu(int[] tablica){
        for (int i = tablica.length-1; i >= 0 ; i--) {
            System.out.print(tablica[i]+" ");
        }
        System.out.println();
    }
    public static int[] odwroc(int[] tab){
        int[] odw = new int[tab.length];
        int g = 0;
        for (int i = tab.length-1; i >= 0 ; i--) {

            odw[g] = tab[i];
            g++;
        }
        return odw;
    }


    public static void metoda3(){
        final int N = 10;
        int[] tablica = new int[N];
        tablica = zapelnij(tablica);
        wypisz(tablica);
        System.out.println("Maksimum: "+max(tablica));
        System.out.println("Minimum: "+min(tablica));
        trzymaks(tablica);
        System.out.println("Srednia: "+aryt(tablica));
        wypiszodtylu(tablica);
        wypisz(odwroc(tablica));
    }

}
