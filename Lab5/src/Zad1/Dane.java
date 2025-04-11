package Zad1;
import java.util.Scanner;
import java.util.concurrent.Semaphore;


public class Dane extends Thread {
    public Semaphore semaphore;

    public int a;
    public int b;

    public Dane(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
    public int getA(){
        return a;
    }
    public int getB(){
        return b;
    }



    public void run() {


            Scanner sc = new Scanner(System.in);
            System.out.println("Podaj a: ");
            a = sc.nextInt();
            System.out.println("Podaj b: ");
            b = sc.nextInt();

            semaphore.release();


    }
}
