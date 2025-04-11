package Zad2;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Dane1 extends Thread {

    public int a;
    public Semaphore s1;


    public Dane1(Semaphore semaphore){
        this.s1 = semaphore;
    }
    public int getA(){
        return a;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj a: ");
        a = sc.nextInt();
        s1.release();
    }
}
