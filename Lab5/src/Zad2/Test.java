package Zad2;

import java.util.concurrent.Semaphore;

public class Test {

    public static void main(String[] args) {
        
        Semaphore s1 = new Semaphore(2);

        Dane1 d1 = new Dane1(s1);
        Dane2 d2 = new Dane2(s1);
        Obliczenia o = new Obliczenia(s1, d1, d2);


        d1.start();
        d2.start();
        o.start();

    }
}
