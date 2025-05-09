package Zad1;

import java.util.concurrent.ArrayBlockingQueue;

public class Cukiernik extends Thread{
    int N;
    ArrayBlockingQueue<Integer> tasma;
    public Cukiernik(ArrayBlockingQueue<Integer> tasma, int N){
        this.tasma = tasma;
        this.N = N;
    }
    public void run(){
        try{
            for (int i = 0; i < N; i++) {
                System.out.println("Produkuje ciastko nr seryjny: "+ i);
                tasma.put(i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
