package Zad4;

import Zad3.Watek;
import java.util.Random;
public class Test {

    public static void main(String[] args) {

        final int lw = 500; // liczba watkow
        Random r = new Random();
        Watek[] watki = new Watek[lw];
        int n = 500_000_000;
        //int[] tabi = new int[n];
        double[] tabd = new double[n];


       // for (int i = 0; i < n; i++) {
            // tabi[i] = r.nextInt(1_000_000_000);
       // }
        for (int i = 0; i < n; i++) {
            tabd[i] = r.nextDouble(1_000_000_000);
        }
        System.out.println("Koniec losowania-");
        long startTime  = System.nanoTime();

        for (int i = 0; i < lw; i++) {
            int od = i * (n / lw);
            int doo = (i + 1) * (n / lw);
            watki[i] = new Watek(tabd, od, doo);
            watki[i].start();

        }
        for (int i = 0; i < lw; i++) {
            try {
                watki[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        /*for (int i = 0; i < Watek.minimal.length; i++) {
            System.out.print("- {" + Watek.minimal[i] + "} -");
        }
        System.out.println();
        for (int i = 0; i < Watek.maksymal.length; i++) {
            System.out.print("- {" + Watek.maksymal[i] + "} -");
        }*/


        for (int i = 0; i < 1; i++) {
            double mini = 0;
            double maxx = 0;
            for (int j = 0; j < 4; j++) {
                if (Watek.minimal[j] < mini) {
                    mini = Watek.minimal[j];
                }
                if (Watek.maksymal[j] > maxx) {
                    maxx = Watek.maksymal[j];
                }

            }
        }
        System.out.println("Koniec programu: "+ (System.nanoTime()-startTime)/1_000_000+" s");
    }
    }

