package Zad3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Pakowacz extends Thread{
    String name;
    ArrayBlockingQueue<Integer> tasma_cukiernicza;
    ArrayBlockingQueue<Integer> tasma_pakowacza;

    public Pakowacz(ArrayBlockingQueue<Integer> tasma_cukiernicza, ArrayBlockingQueue<Integer> tasma_pakowacza, String name) {
        this.name = name;
        this.tasma_cukiernicza = tasma_cukiernicza;
        this.tasma_pakowacza = tasma_pakowacza;

    }
    public void run(){
        try{
            while(true) {
                Integer ciastko1 = tasma_cukiernicza.take();
                System.out.println("Ja "+name+" Biore ciastko: "+ ciastko1);
                Thread.sleep(300);
                Integer ciastko2 = tasma_cukiernicza.take();
                System.out.println("Ja "+name+" Biore ciastko: "+ ciastko2);
                Thread.sleep(300);
                System.out.println("Ja "+name+" Pakuje ciastka w sreberko: "+ ciastko1 + ciastko2);
                int sreberko = Integer.valueOf(String.valueOf(ciastko1)+String.valueOf(ciastko2));
                Thread.sleep(300);
                tasma_pakowacza.add(sreberko);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
