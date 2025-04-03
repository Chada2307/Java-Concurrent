package Zad3;
import java.util.Random;
public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        int n = 100_000_000;
        int[] tab = new int[n];
        for (int i = 0; i < n; i++) {
            tab[i] = random.nextInt(100_000_000-10000000)+1000000;
        }
        //for (int i = 0; i < n; i++) {
          //  System.out.print(tab[i] + " ");
        //}
        /*Watek watek1 = new Watek(tab,0,12_000_000);
        Watek watek2 = new Watek(tab,12_000_000,24_000_000);
        Watek watek3 = new Watek(tab,24_000_000,36_000_000);
        Watek watek4 = new Watek(tab,36_000_000,48_000_000);
        Watek watek5 = new Watek(tab,48_000_000,60_000_000);
        Watek watek6 = new Watek(tab,60_000_000,72_000_000);
        Watek watek7 = new Watek(tab,72_000_000,84_000_000);
        Watek watek8 = new Watek(tab,84_000_000,100_000_000);*/

        /*watek1.start();
        watek2.start();
        watek3.start();
        watek4.start();
        watek5.start();
        watek6.start();
        watek7.start();
        watek8.start();
        try {
            watek1.join();
            watek2.join();
            watek3.join();
            watek4.join();
            watek5.join();
            watek6.join();
            watek7.join();
            watek8.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


        System.out.println("----------------------------------------");
        for (int i = 0; i < Watek.minimal.length; i++) {
            System.out.print("- {" + Watek.minimal[i] + "} -");
        }
        System.out.println();
        for (int i = 0; i < Watek.maksymal.length; i++) {
            System.out.print("- {" + Watek.maksymal[i] + "} -");
        }
        System.out.println();
        System.out.println("----------------------------------------");
            for (int i = 0; i < 1; i++) {
                int mini = 0;
                int maxx = 0;
                for (int j = 0; j < 4; j++) {
                    if (Watek.minimal[j] < mini) {
                       // mini = Watek.minimal[j];
                    }
                    if (Watek.maksymal[j] > maxx) {
                       // maxx = Watek.maksymal[j];
                    }

                }
                System.out.println("Maximum to : " + maxx);
                System.out.println("Minimum to : " + mini);

            }
        System.out.println("Koniec programu: "+ System.nanoTime()+" ns");
    }

    }

