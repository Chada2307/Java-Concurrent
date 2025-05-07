package Zad3;

import java.util.concurrent.Semaphore;

public class Filozof extends Thread {
    private int id;
    public Semaphore lewywidelec;
    public Semaphore prawywidelec;
    public Semaphore zieloneswiatlo;


    public Filozof(int id, Semaphore lewywidelec,Semaphore prawywidelec,Semaphore zieloneswiatlo) {
        this.id = id;
        this.lewywidelec = lewywidelec;
        this.prawywidelec = prawywidelec;
        this.zieloneswiatlo = zieloneswiatlo;

    }

    public void mysl(){
        System.out.println("Filozof" + id + "mysli");
        try {
            Thread.sleep((long) (Math.random() * 2000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void jedz(){
        System.out.println("Filozof" + id + "je");
        try {
            Thread.sleep((long) (Math.random() * 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        int lewy = id;
        int prawy = (id + 1) % 5;
        try{
            while(true){
                mysl();
                zieloneswiatlo.acquire();

                lewywidelec.acquire();
                System.out.println("Filozof " + id + "podniosl lewy widelec");

                prawywidelec.acquire();
                System.out.println("Filozof " + id + "podniosl prawy widelec");

                jedz();

                prawywidelec.release();
                System.out.println("Filozof " + id + "odlozyl prawy widelec");
                lewywidelec.release();
                System.out.println("Filozof " + id + "odlozyl lewy widelec");

                zieloneswiatlo.release();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
