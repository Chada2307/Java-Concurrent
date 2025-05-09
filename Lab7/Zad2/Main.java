package Zad2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {

        AtomicInteger nr_seryjny = new AtomicInteger(0);
        ArrayBlockingQueue<Integer> tasma = new ArrayBlockingQueue<Integer>(5);
        Cukiernik czarek = new Cukiernik(tasma, 10, "czarek", nr_seryjny);
        Cukiernik tadek = new Cukiernik(tasma, 10, "tadek", nr_seryjny);

        Pakowacz marek = new Pakowacz(tasma, 20, "marek");
        Pakowacz kamil = new Pakowacz(tasma, 10, "kamil");

        czarek.start();
        tadek.start();
        marek.start();
        kamil.start();


    }
}
