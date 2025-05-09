package Zad2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Cukiernik extends Thread{
    private static AtomicInteger nr_seryjny;
    String name;
    int N;
    ArrayBlockingQueue<Integer> tasma;

    public Cukiernik(ArrayBlockingQueue<Integer> tasma, int N, String name, AtomicInteger nr_seryjny) {
        this.name = name;
        this.tasma = tasma;
        this.N = N;
        this.nr_seryjny = nr_seryjny;
    }
    public void run(){
        try{
            for (int i = 0; i < N; i++) {
                Integer id = nr_seryjny.getAndIncrement();
                System.out.println("Ja: "+ name +" Produkuje ciastko nr seryjny: "+ id);
                tasma.put(id);
                Thread.sleep(1000);

            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
