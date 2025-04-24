package Zad3;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Dane23 extends Thread{
    public int b;

    public Semaphore s1;
    public Semaphore s2;
    public Semaphore s3;

    public Dane23(Semaphore s1,Semaphore s2,Semaphore s3){
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }
    public int getB(){
        return b;
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            try{
                s3.acquire();
                System.out.println("Podaj b: ");
                b = sc.nextInt();
                s2.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }}
    }

