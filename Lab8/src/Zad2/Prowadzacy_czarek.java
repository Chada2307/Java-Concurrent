package Zad2;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Prowadzacy_czarek extends Thread{

    public final CyclicBarrier barrier;
    public final List<Integer> index_studencki;

    public Prowadzacy_czarek(CyclicBarrier barrier, List<Integer> index_studencki) {
        this.barrier = barrier;
        this.index_studencki = index_studencki;
    }

    public void run() {
        try{
            Thread.sleep(50);
            int ocena = 3 +(int)(Math.random()*3);
            index_studencki.add(ocena);
            System.out.println("Prowadzacy czaruś wstawił ocene: " + ocena);
            barrier.await();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
