package Zad3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static final int N = 1_000_000;

    public static void main(String[] args) throws InterruptedException {
        List<Integer> lista1 = new CopyOnWriteArrayList<>();
        ExecutorService executor_single = Executors.newSingleThreadExecutor();
        long start = System.currentTimeMillis();
        executor_single.submit(new Watek_prime_single(2, N, lista1));
        executor_single.shutdown();
        executor_single.awaitTermination(Long.MAX_VALUE, java.util.concurrent.TimeUnit.NANOSECONDS);

        long end = System.currentTimeMillis();
        System.out.println("Czas 1-wątkowy: " + (end - start) + " ms");


        List<Integer> lista2 = Collections.synchronizedList(new ArrayList<>());
        ExecutorService executor = Executors.newFixedThreadPool(4);

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 4; i++) {
            executor.submit(new Watek_prime(2 + i, 4, N, lista2));
        }
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, java.util.concurrent.TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end2 = System.currentTimeMillis();

        Collections.sort(lista2);
        System.out.println("Czas 4-wątkowy: " + (end2 - start2) + " ms");
        boolean same = lista1.equals(lista2);
        System.out.println("Czy są takie same? " + same);


    }
}
