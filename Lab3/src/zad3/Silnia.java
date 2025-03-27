package zad3;

import java.util.Scanner;

public class Silnia {
    private class Watek extends Thread{
     private int liczba;
     private Silnia silnia;

     public void run(){
         System.out.println(Thread.currentThread().getName()+"["+liczba+"] ! = "+silnia.licz(liczba));
     }
    }
    public synchronized int licz(int wartosc){
        try{
            if (wartosc <=1)
                    return 1;
            else
                    return wartosc * licz(wartosc-1);
        }finally {
            System.out.println(Thread.currentThread().getName() + " ==[liczbe]==> " + wartosc);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj liczbe: ");

        int liczba = sc.nextInt();
        sc.close();
        if (liczba < 16) {
            Silnia silnia = new Silnia();
            for (int i = 0; i < liczba; i++) {
                Watek watek = silnia.new Watek();
                watek.silnia = silnia;
                watek.liczba = liczba;
                watek.start();
            }
        }else{
            System.out.println("Licze max do !15");
        }
    }
}

// po usunieciu sync nadal silnia jest poprawnie liczona
// po usunieciu sync nadal silnia jest poprawnie liczona
// poniewaz nie pracujemy na zmiennej globalnej tylko kazdy watek pracuje na wlasnej zmiennej
// dlatego w kazdym wypadku program bedzie dzialac prawidlowo