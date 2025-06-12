import java.util.Random;

public class watekdo5 extends Thread {
    int[][] matrix = new int[5][5];
     synchronized public static int[][] zapelnij(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Random rand = new Random();
                int liczba = rand.nextInt(100);
                matrix[i][j] = liczba;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" | ");
            }
        }
         System.out.println();
        System.out.println( " macierz wykonana watkiem "+ Thread.currentThread().getId());
        return matrix;
    }
    synchronized public int[][] mnozenie(int m1[][], int m2[][])
    {
        int tab[][] = new int[m1.length][m2[0].length];
        int c=0;
        if (m1[0].length == m2.length)
        {
            for(int i=0; i<tab.length; i++)
            {
                for(int j=0; j<tab[i].length; j++)
                {
                    for (int k = 0; k < m1[0].length; k++) {
                        tab[i][j] += m1[i][k] * m2[k][j];
                    }
                }
            }
        }
        else
        {
            System.out.println("Nie mozna pomnozc takiej macierzy");
        }
        System.out.println( " mnozenie wykonane watkiem "+ Thread.currentThread().getId());
        return tab;

    }



    public void run() {
        matrix = zapelnij(matrix);
    }
}
