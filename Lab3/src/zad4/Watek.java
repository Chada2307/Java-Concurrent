package zad4;

public class Watek extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 10 ; i++) {
            System.out.print(Thread.currentThread().getName());
            System.out.print(" :Watek ");
            System.out.println();
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("err");
            }

        }


    }
}
