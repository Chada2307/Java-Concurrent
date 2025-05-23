package Zad3;

import java.util.List;

public class Watek_prime_single extends Thread{

    private final int start;

    private final int maks;
    private final List<Integer> wynik;

    public Watek_prime_single(int start, int maks, List<Integer> wynik) {
        this.start = start;
        this.maks = maks;
        this.wynik = wynik;
    }

    private boolean Prime(int n){
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public void run() {
        for(int i = start; i<= maks; i++ ){
            if (Prime(i)) wynik.add(i);
        }
    }
}
