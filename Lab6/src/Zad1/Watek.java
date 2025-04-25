package Zad1;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Watek extends Thread{

    Semaphore sem;
    Main telefon;

    public Watek(Semaphore sem, String name, Main telefon) {
        Thread.currentThread().setName(name);
        this.sem = sem;
        this.telefon = telefon;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            Random r = new Random();
            int los = r.nextInt(1000);
            try {
                System.out.println("Czytam ksiazke - " + Thread.currentThread().getName());
                Thread.sleep(los);
                System.out.println("Pije herbatę - " + Thread.currentThread().getName());
                Thread.sleep(los);
                System.out.println("Pracuje przy komputerze -  " + Thread.currentThread().getName());
                System.out.println();
                try {
                    sem.acquire();
                    System.out.println(Thread.currentThread().getName() + " Korzystam z telefonu");
                    Thread.sleep(los);
                    System.out.println(telefon.telefon() +"-"+ Thread.currentThread().getName());
                    sem.release();
                    System.out.println(Thread.currentThread().getName() + " zakończył dzwonić");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    sem.release();
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }


        }
    }
}
