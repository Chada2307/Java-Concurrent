package Zad1;

import java.util.concurrent.Exchanger;

public class Klient extends Thread{

    String dane = "10 polskich zlotych";
    Exchanger<String> exchanger;

    public Klient(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }
    public void run() {
        try {
            System.out.println("Dzien dobry");
            Thread.sleep(200);
            System.out.println("Chcialbym kupic olej");
            Thread.sleep(200);
            System.out.println("Fajnie akurat mam przy sobie -- (dane) --" + dane);
            Thread.sleep(200);
            System.out.println("Nawiązuje z Panem transakcje");
            String otrzymal = exchanger.exchange(dane);
            System.out.println("Otrzymalem od sprzedawcy: " + otrzymal);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}
