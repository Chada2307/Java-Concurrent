package Zad2;

public class DzialajacyZiemniak1  implements Runnable {


    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName());
            for (int i = 0; i < 1000; i++) {
                System.out.println(Math.max(i,2));

            }
        }
    }
}