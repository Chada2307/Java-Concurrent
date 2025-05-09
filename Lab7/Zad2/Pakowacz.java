package Zad2;

import java.util.concurrent.ArrayBlockingQueue;

public class Pakowacz extends Thread{

    String name;
    int N;
    ArrayBlockingQueue<Integer> tasma;
    public Pakowacz(ArrayBlockingQueue<Integer> tasma, int N, String name) {
        this.name = name;
        this.tasma = tasma;
        this.N = N;
    }
    public void run(){
        try{
            for (int i = 0; i < N; i++) {
                Integer ciastko = tasma.take();
                System.out.println("Ja "+name+" Pakuje ciastko: "+ ciastko);
                Thread.sleep(1000);

            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
