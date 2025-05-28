package zad1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int SIZE = 899;
        int[][] A = new int[SIZE][SIZE];
        int[][] B = new int[SIZE][SIZE];
        int[][] C = new int[SIZE][SIZE];
        int[][] D = new int[SIZE][SIZE];

        fill_matrix_A(A);
        fill_matrix_B(B);


        Mnozenie_jeden mnz = new Mnozenie_jeden(A, B, C, SIZE);
//----------------------------------------------------------
        long pomiar_1 = System.nanoTime();
        mnz.start();
        mnz.join();
        long end_pomiar_1 = System.nanoTime();
        double czas1 = (end_pomiar_1 - pomiar_1) / 1000000;

//----------------------------------------------------------
        int liczba_watkow = 4;
        Thread[] watki = new Thread[liczba_watkow];
        int wiersze = (int) Math.ceil((double) SIZE / liczba_watkow);

        long pomiar_2 = System.nanoTime();

        for (int i = 0; i < liczba_watkow; i++) {
            int start = i*wiersze;
            int end = Math.min(start + wiersze, SIZE);
            watki[i] = new Mnozenie_wiele(A, B, D ,start, end, SIZE);
            watki[i].start();
        }
        for (Thread w : watki) {
            try {
                w.join();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long end_pomiar_2 = System.nanoTime();
/*-------------------------------------------------------------------------------------*/
        double czas2 = (end_pomiar_2 - pomiar_2) / 1000000;
        System.out.println("Czas 1 watek: "+ czas1+ " ns");
        System.out.println("Czas dla 4 watkow: "+ czas2+ " ns");
        System.out.printf("Mnożenie 4-wątkowe było %.2f razy szybsze%n", czas1 / czas2);

        boolean test = porownaj(C, D, SIZE);
        if (test) {
            System.out.println("Macierze sa takie same");
        }
        else System.out.println("Macierze nie sa takie same");

    }

/*-------------------------------------------------------------------------------------------------*/
    public static boolean porownaj(int[][] C, int[][] D,int SIZE) {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (C[i][j] != D[i][j]) return false;
        return true;
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
            System.out.println("");
        }
    }
}
