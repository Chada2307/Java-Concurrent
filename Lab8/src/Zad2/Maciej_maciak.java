package Zad2;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;

public class Maciej_maciak extends Thread{
    CyclicBarrier bariera;
    CopyOnWriteArrayList<Integer> index_studencki;
    public Maciej_maciak(CyclicBarrier bariera, CopyOnWriteArrayList<Integer> index_studencki) {
        this.bariera = bariera;
        this.index_studencki = index_studencki;
    }

    
    public void run() {
    try{
        System.out.println("Dzien dobry, panstwu nazywam sie Maciej Maciak");
        System.out.println("Maciej Maciak wystawia oceny");
        Thread.sleep(300);
        System.out.println("M.Maciak: Co by pan zrobil gdyby wladimir putin chcial wyleczyc panskie dziecko za darmo?");
        Thread.sleep(100);
        System.out.println("Odpowiedz: niech pan nie zartuje co to jest za pytanie??");
        Thread.sleep(100);
        System.out.println("M.Maciak: niestety 2");
        Thread.sleep(100);
        System.out.println("M.Maciak: Czy podziwia pan putina?");
        Thread.sleep(100);
        System.out.println("Odpowiedz: Tak podziwiam putina");
        Thread.sleep(100);
        System.out.println("M.Maciak: Super, 5");
        Thread.sleep(100);
        System.out.println("M.Maciak: Czy podglada pan sąsiadow?");
        Thread.sleep(100);
        System.out.println("Odpowiedz: Tak mam kamery na sasiadow");
        Thread.sleep(100);
        System.out.println("M.Maciak: Super, 5");
        Thread.sleep(100);
        System.out.println("M.Maciak: Towarzyszu, 2, 5, 5 proponuje 3");
        index_studencki.add(3);
    }catch(InterruptedException e){
        e.printStackTrace();
    }    
    }
}
