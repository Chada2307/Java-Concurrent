package zad3;

public class Watek1 implements Runnable{


    public void run() {
        for (int i = 0; i <= 20; i++) {
            System.out.print("Liczba: "+i+", ");
            System.out.println("Watek: "+Thread.currentThread());
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                System.out.println("error");
            }
        }
    }
}
