package Zad1;

import java.util.concurrent.Semaphore;

public class Obliczenia extends Thread{
    public Semaphore semaphore;
    public Dane dane;
    public int wynik;

    public Obliczenia(Dane dane, Semaphore semaphore) {
        this.semaphore = semaphore;
        this.dane = dane;

    }
    public void run() {

        try{
            semaphore.acquire();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        wynik = dane.getA()+dane.getB();
        System.out.println("Wynik dodawania: " + wynik);

    }
}
