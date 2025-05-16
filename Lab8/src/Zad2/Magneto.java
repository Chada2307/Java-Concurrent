package Zad2;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;

public class Magneto extends Thread{
    CyclicBarrier bariera;
    CopyOnWriteArrayList<Integer> index_studencki;
    public Magneto(CyclicBarrier bariera, CopyOnWriteArrayList<Integer> index_studencki) {
        this.bariera = bariera;
        this.index_studencki = index_studencki;
    }
    public void run() {
        try{

            System.out.println("Dzien dobry, panstwu nazywam sie Magneto");
            System.out.println("Magneto wystawia oceny");
            Thread.sleep(300);
            System.out.println("Magneto: Wejsciowka wskazniki");
            Thread.sleep(100);
            System.out.println("Odpowiedz: o boze tab.**(*(tab[].(*wsk)))");
            Thread.sleep(100);
            System.out.println("Magneto: niestety 2");
            Thread.sleep(100);
            System.out.println("Magneto: Wejsciowka konstruktory");
            Thread.sleep(100);
            System.out.println("Odpowiedz: ee tam proscizna void Object(Int a){wartosc = a}");
            Thread.sleep(100);
            System.out.println("Dr.Hladowski: Super, 3");
            Thread.sleep(100);
            System.out.println("Dr.Hladowski: Wejsciowka konstruktory kopiujace");
            Thread.sleep(100);
            System.out.println("Odpowiedz: uhuhu konstruktor kopiujacy to konstruktor ktory przyjmuje obiekt tej samej klasy");
            Thread.sleep(100);
            System.out.println("Dr.Hladowski: Super, 3");
            Thread.sleep(100);
            System.out.println("M.Maciak: Szanowny panie, 2, 3, 3 proponuje 3");
            index_studencki.add(3);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
