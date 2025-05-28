package zad1;

public class Mnozenie_jeden extends Thread{
    int [][] A,B,C;
    int SIZE;


    public Mnozenie_jeden(int[][] A, int [][] B, int[][] C, int SIZE){
        this.A = A;
        this.B = B;
        this.C = C;
        this.SIZE = SIZE;
    }


    public static int[][] mnozJednowatkowo(int[][] A, int[][] B, int[][] C,int SIZE) {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                for (int k = 0; k < SIZE; k++)
                    C[i][j] += A[i][k] * B[k][j];

        return C;
    }


    public void run() {
        mnozJednowatkowo(A,B,C,SIZE);
    }
}
