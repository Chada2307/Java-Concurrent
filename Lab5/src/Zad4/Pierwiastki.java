package Zad4;

import java.util.concurrent.Semaphore;

public class Pierwiastki extends Thread{
    Semaphore cykl, pierwiastki;
    Dane dane;
    double pierwiastek1, pierwiastek2;
    Delta delta;
    public Pierwiastki(Semaphore cykl, Semaphore pierwiastki, Delta delta, Dane dane) {
        this.cykl = cykl;
        this.pierwiastki = pierwiastki;
        this.delta = delta;
        this.dane = dane;
    }


    public void run() {
        try{
        pierwiastki.acquire();
        if(delta.getDeltaValue() < 0) {
            System.out.println("Brak pierwiastków rzeczywistych");
            System.exit(0);
        }
        else if(delta.getDeltaValue() > 0) {
            pierwiastek1 = (-dane.getB() + Math.sqrt(delta.getDeltaValue())) / (2*dane.getA());
            pierwiastek2 = (-dane.getB() - Math.sqrt(delta.getDeltaValue())) / (2*dane.getA());
            System.out.println("Pierwiastki to: " + pierwiastek1 + " i " + pierwiastek2);
        }
        else if(delta.getDeltaValue() == 0) {
            pierwiastek1 = -dane.getB() / (2*dane.getA());
            System.out.println("Pierwiastek podwójny: " + pierwiastek1);
        }
        cykl.release();
    } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
