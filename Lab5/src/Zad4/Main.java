package Zad4;

import java.util.concurrent.Semaphore;

public class Main {


    public static void main(String[] args) {
        Semaphore cykl = new Semaphore(1);
        Semaphore delta = new Semaphore(0);
        Semaphore pierwiastki = new Semaphore(0);

        Dane dane = new Dane(cykl, delta);
        Delta deltium = new Delta(delta, pierwiastki,dane);
        Pierwiastki pierw = new Pierwiastki(cykl, pierwiastki, deltium, dane);

        dane.start();
        deltium.start();
        pierw.start();

    }
}
