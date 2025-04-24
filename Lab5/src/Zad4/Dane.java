package Zad4;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Dane extends Thread{

    int a,b,c;
    Semaphore cykl, delta;

    public Dane(Semaphore cykl, Semaphore delta) {
        this.cykl = cykl;
        this.delta = delta;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
    public int getC() {
        return c;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        try{
            cykl.acquire();
            // wez wartosci
            System.out.println("Podaj a:");
            a = sc.nextInt();
            System.out.println("Podaj b:");
            b = sc.nextInt();
            System.out.println("Podaj c:");
            c = sc.nextInt();

            // obudz delta
            delta.release();

            }catch (InterruptedException e){
                e.printStackTrace();
            }

    }
}
