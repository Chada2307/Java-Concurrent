package Zad3;

import java.util.concurrent.Semaphore;

public class Main {

    public static final int LICZBA_FILOZOFOW = 5;

    public static void main(String[] args) {
        Semaphore[] widelce = new Semaphore[LICZBA_FILOZOFOW];
        Semaphore zieloneswiatlo = new Semaphore(LICZBA_FILOZOFOW-1);

        for (int i = 0; i < LICZBA_FILOZOFOW; i++) {
        widelce[i] = new Semaphore(1);
        }

        for (int i = 0; i < LICZBA_FILOZOFOW; i++) {
            Semaphore lewywidelec = widelce[i];
            //modulo 5 bo ostatni filozof chcialby widelec z indexem 5
            Semaphore prawywidelec = widelce[(i+1)%LICZBA_FILOZOFOW];
            Filozof filozof = new Filozof(i, lewywidelec, prawywidelec, zieloneswiatlo);
            filozof.start();
        }

    }
}
