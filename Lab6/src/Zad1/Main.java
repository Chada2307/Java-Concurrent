package Zad1;

import java.util.concurrent.Semaphore;

public class Main {

    public String telefon(){

        return "Dzwonię";
    }

    public static void main(String[] args) {
        Main telefon = new Main();
        Semaphore sem = new Semaphore(2);

        Watek tata = new Watek(sem, "Tata", telefon );
        Watek mama = new Watek(sem, "Mama", telefon );
        Watek syn = new Watek(sem, "Syn", telefon );


        tata.start();
        mama.start();
        syn.start();


    }
}
