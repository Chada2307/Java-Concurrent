package Zad3;

import java.util.concurrent.Semaphore;

public class Test3 {

    public static void main(String[] args) {
        
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(0);
        Semaphore s3 = new Semaphore(0);
        Dane13 d1 = new Dane13(s1,s3);
        Dane23 d2 = new Dane23(s1,s2,s3);
        Obliczenia3 o3 = new Obliczenia3(s1,s2,s3,d1,d2);


        d1.start();
        d2.start();
        o3.start();


    }
}
