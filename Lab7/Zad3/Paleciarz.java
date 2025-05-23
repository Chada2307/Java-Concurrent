package Zad3;

import java.util.concurrent.ArrayBlockingQueue;

public class Paleciarz extends Thread{
    ArrayBlockingQueue<Integer> tasma_pakowacza;
    String name;

    public Paleciarz(ArrayBlockingQueue<Integer> tasma_pakowacza,String name){
        this.tasma_pakowacza = tasma_pakowacza;
        this.name = name;
    }


    public void run() {
    try{
        while(true){
            System.out.println("Ja: "+ name+ " Czekam na sreberko z dwoma ciastkami");
            Integer sreberko1 = tasma_pakowacza.take();
            Thread.sleep(100);
            System.out.println("Ja: "+ name+ " Wziąłem sreberko z dwoma ciastkami o id: " + sreberko1);
            Integer sreberko2 = tasma_pakowacza.take();
            Thread.sleep(100);
            System.out.println("Ja: "+ name+ " Wziąłem sreberko z dwoma ciastkami o id: " + sreberko2);
            Integer sreberko3 = tasma_pakowacza.take();
            Thread.sleep(100);
            System.out.println("Ja: "+ name+ " Wziąłem sreberko z dwoma ciastkami o id: " + sreberko3);
            Integer sreberko4 = tasma_pakowacza.take();
            Thread.sleep(100);
            System.out.println("Ja: "+ name+ " Wziąłem sreberko z dwoma ciastkami o id: " + sreberko4);
            Thread.sleep(100);
            System.out.println("Ja: "+ name+ " Pakuje teraz cztery sreberka na jedna palete ");
            Thread.sleep(100);
            String paletapart1 = (String.valueOf(sreberko1)+String.valueOf(sreberko2));
            String paletapart2 = (String.valueOf(sreberko3)+String.valueOf(sreberko4));
            String paleta = paletapart1+paletapart2;

            Thread.sleep(500);
            System.out.println("Ja: " + name + " Wyprodukowalem palete o ID: " + paleta);

        }
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    }
}
