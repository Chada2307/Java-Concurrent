package Zad1;

import java.util.concurrent.Exchanger;

public class Sprzedawca extends Thread{

    String dane = "Olej rzepakowy 1L ";
    Exchanger<String> exchanger;

    public Sprzedawca(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }
    public void run() {
        try {
            System.out.println("Dzien dobry, panie kliencie, co moge dla pana zrobic?");
            Thread.sleep(200);
            System.out.println("Ahh olej tak? to bedzie 10 zł");
            Thread.sleep(200);
            System.out.println("Mam na stanie akurat -- (dane) -- " + dane);
            Thread.sleep(200);
            System.out.println("Nawiązuje z Panem transakcje");
            String otrzymal = exchanger.exchange(dane);
            System.out.println("Otrzymalem od klienta: " + otrzymal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
