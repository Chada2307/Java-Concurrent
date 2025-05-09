package Zad3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {

        AtomicInteger nr_seryjny = new AtomicInteger(0);
        ArrayBlockingQueue<Integer> tasma_cukiernicza = new ArrayBlockingQueue<Integer>(5);
        ArrayBlockingQueue<Integer> tasma_pakowacza = new ArrayBlockingQueue<Integer>(5);


        Cukiernik czarek = new Cukiernik(tasma_cukiernicza, 10, "czarek", nr_seryjny);
        Cukiernik tadek = new Cukiernik(tasma_cukiernicza, 10, "tadek", nr_seryjny);

        Pakowacz marek = new Pakowacz(tasma_cukiernicza,tasma_pakowacza,"marek");
        Pakowacz kamil = new Pakowacz(tasma_cukiernicza,tasma_pakowacza,"kamil");

        Paleciarz radek  = new Paleciarz(tasma_pakowacza, "radek");
        Paleciarz marian = new Paleciarz(tasma_pakowacza, "marian");

        czarek.start();
        tadek.start();

        marek.start();
        kamil.start();

        radek.start();
        marian.start();

    }
}
