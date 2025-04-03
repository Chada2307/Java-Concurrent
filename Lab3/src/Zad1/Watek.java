package Zad1;

import java.util.Random;

public class Watek extends Thread{


    public void run() {
        Random rand = new Random();
        int ran = rand.nextInt(100);
        for (int i = 1; i <= 10; i++) {
            System.out.println("Liczba: "+i);
            System.out.println(Thread.currentThread().getName());
            System.out.println("-----------------------------");
        }
        try{
            Thread.sleep(ran);
        }catch (InterruptedException e){
            System.out.println("Error");
        }

        return ran;
    }
}
