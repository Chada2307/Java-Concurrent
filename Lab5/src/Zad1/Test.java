package Zad1;

import java.util.concurrent.Semaphore;
public class Test {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(0);

        Dane dane = new Dane(semaphore);
        Obliczenia obliczenia = new Obliczenia(dane,semaphore);


        obliczenia.start();
        dane.start();

    }

}
