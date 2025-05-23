package Zad2;

import java.util.List;

public class Srednia extends Thread {

    public List<Integer> index_studencki;


    public Srednia(List<Integer> index_studencki) {
        this.index_studencki = index_studencki;
    }

    public void run() {
            double sum = 0;
            for(Integer i : index_studencki) {
                sum += i;
            }
            double srednia  = sum / index_studencki.size();
            System.out.println("Witam srednia: "+ srednia);

    }
}