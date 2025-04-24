package Zad3;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Dane13 extends Thread {

    public int a;
    public Semaphore s1;
    public Semaphore s3;


    public Dane13(Semaphore s1,Semaphore s3){
        this.s1 = s1;
        this.s3 = s3;
    }
    public int getA(){
        return a;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            try {
                s1.acquire();
                System.out.println("Podaj a: ");
                a = sc.nextInt();
                s3.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        }
    }
