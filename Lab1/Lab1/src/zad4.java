import java.util.Random;

public class zad4 {


    public static int[] zapelnij(int[] tablica) {
        for (int i = 0; i < tablica.length; i++) {
            Random rand = new Random();
            int liczba = rand.nextInt(100);
            tablica[i] = liczba;
        }
        for (int i = 0; i < tablica.length; i++) {
            System.out.print(tablica[i]+"|");

        }
        System.out.println();
        for (int i = 0; i < tablica.length; i++) {
            System.out.print(" - ");
        }
        System.out.println();
        return tablica;
    }

    public static int max(int[] tablica) {
        int maks = tablica[0];
        for (int i = 0; i < tablica.length; i++) {
            if (tablica[i] > maks) {
                maks = tablica[i];
            }
        }
        System.out.println(maks);
        return maks;
    }

    public static int maxmax(int max1, int max2, int max3) {
        int maks = 0;

        if (max1 >= max2 && max1 >= max3) {
            return max1;
        } else if (max2 >= max1 && max2 >= max3) {
            return max2;
        }
        else{
            return max3;
        }
    }




    public static void main(String[] args) {
        int[] tablica = new int[10];
        int[] tablica2 = new int[10];
        int[] tablica3 = new int[10];

        tablica = zapelnij(tablica);
        tablica2 = zapelnij(tablica2);
        tablica3 = zapelnij(tablica3);

        int max1 = max(tablica);
        int max2 = max(tablica2);
        int max3 = max(tablica3);

        int maxz3 = maxmax(max1, max2, max3);

        System.out.println("najwieksza z tych 3 to :"+maxz3);

    }



}
