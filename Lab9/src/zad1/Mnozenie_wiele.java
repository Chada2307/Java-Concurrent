package zad1;

public class Mnozenie_wiele extends Thread{
    int [][] A,B,D;
    int start,end, SIZE;

    public Mnozenie_wiele(int [][] A, int [][] B, int [][] D, int start, int end, int SIZE) {
        this.A = A;
        this.B = B;
        this.D = D;
        this.start = start;
        this.end = end;
        this.SIZE = SIZE;
    }
    public static void mnozenie_wiele(int[][] A, int [][] B, int [][] D, int start, int end, int SIZE) {
        for (int i = start; i < end; i++)
            for (int j = 0; j < SIZE; j++)
                for (int k = 0; k < SIZE; k++)
                    D[i][j] += A[i][k] * B[k][j];
    }
    public void run(){

        mnozenie_wiele(A,B,D,start,end, SIZE);
    }



}
