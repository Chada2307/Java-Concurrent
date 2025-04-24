package Zad4;
import java.util.concurrent.Semaphore;

public class Delta extends Thread{
    Semaphore delta, pierwiastki;
    Dane dane;
    int deltaValue;

    public Delta(Semaphore delta, Semaphore pierwiastki, Dane dane) {
        this.delta = delta;
        this.pierwiastki = pierwiastki;
        this.dane = dane;
    }

    public int getDeltaValue() {
        return deltaValue;
    }

    public void run() {
        try {
            delta.acquire();
            // czekaj na syngnal oblicz delta
             deltaValue = (dane.getB()*dane.getB()) - 4*dane.getA()*dane.getC();
            System.out.println("Delta wynosi: "+ deltaValue);

            // obudz watek pierwiastki
            pierwiastki.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
