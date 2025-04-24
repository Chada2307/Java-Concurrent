package Zad3;

import java.util.concurrent.Semaphore;

public class Obliczenia3 extends Thread{

    public Semaphore s1;
    public Semaphore s2;
    public Semaphore s3;
    public Dane13 dane1;
    public Dane23 dane2;

    public Obliczenia3(Semaphore s,Semaphore s2,Semaphore s3, Dane13 d1, Dane23 d2){
        this.s1 = s;
        this.dane1 = d1;
        this.dane2 = d2;
        this.s2 = s2;
        this.s3 = s3;
    }
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {

                s2.acquire();
                int wynik = dane1.getA() + dane2.getB();
                System.out.println("Wynik: " + wynik);

                s1.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
