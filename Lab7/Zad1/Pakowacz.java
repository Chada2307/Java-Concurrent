package Zad1;

import java.util.concurrent.ArrayBlockingQueue;

public class Pakowacz extends Thread{
    int N;
    ArrayBlockingQueue<Integer> tasma;
    public Pakowacz(ArrayBlockingQueue<Integer> tasma, int N){
        this.tasma = tasma;
        this.N = N;
    }
    public void run(){
        try{
            for (int i = 0; i < N; i++) {
                Integer ciastko = tasma.take();
                System.out.println("Pakuje ciastko: "+ ciastko);
                Thread.sleep(5000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
