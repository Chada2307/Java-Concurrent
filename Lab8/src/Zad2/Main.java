package Zad2;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        int liczba_prowadzacych = 3;
        CyclicBarrier bariera = new CyclicBarrier(liczba_prowadzacych, () -> {
            System.out.println("Wszyscy prowadzący wystawili oceny.");
        });
        CopyOnWriteArrayList <Integer> index_studencki = new CopyOnWriteArrayList<>();


    }
}
