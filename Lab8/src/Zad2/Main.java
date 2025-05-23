package Zad2;

import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static List<Integer> index_studencki = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        Srednia srednia = new Srednia(index_studencki);
        int liczba_prowadzacych = 3;
        CyclicBarrier bariera = new CyclicBarrier(liczba_prowadzacych,srednia);
        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(new Prowadzacy_czarek(bariera, index_studencki));
        executor.submit(new Prowadzacy_krzychu(bariera, index_studencki));
        executor.submit(new Prowadzacy_maras(bariera, index_studencki));

        executor.shutdown();
    }
}
