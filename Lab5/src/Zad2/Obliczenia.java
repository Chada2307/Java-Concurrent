package Zad2;

import java.util.concurrent.Semaphore;

public class Obliczenia extends Thread{

    public Semaphore s1;
    public Dane1 dane1;
    public Dane2 dane2;

    public Obliczenia(Semaphore s, Dane1 d1, Dane2 d2){
        this.s1 = s;
        this.dane1 = d1;
        this.dane2 = d2;
    }
    public void run(){

        try{
            s1.acquire();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        int wynik = dane1.getA() + dane2.getB();
        System.out.println("Wynik: "+ wynik);


    }

}
