package Zad1;

import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> tasma = new ArrayBlockingQueue<Integer>(5);

        Cukiernik cukiernik = new Cukiernik(tasma, 10);
        Pakowacz pakowacz = new Pakowacz(tasma, 10);

        cukiernik.start();
        pakowacz.start();


    }
}
