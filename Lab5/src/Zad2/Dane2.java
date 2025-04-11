package Zad2;

import java.util.concurrent.Semaphore;
import java.util.Scanner;

public class Dane2 extends Thread{
    public int b;
    public Semaphore s1;

    public Dane2(Semaphore semaphore){
        this.s1 = semaphore;
    }
    public int getB(){
        return b;
    }

    public void run(){
        try{
            s1.acquire();

            Scanner sc = new Scanner(System.in);
            System.out.println("Podaj b: ");
            b = sc.nextInt();
            s1.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
