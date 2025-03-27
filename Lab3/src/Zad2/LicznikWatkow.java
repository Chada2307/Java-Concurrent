package Zad2;


public class LicznikWatkow {
    private int wartoscKrytyczna;

    public synchronized int policzMnie(){

        // po uzyciu synchronized watki maja dostep do wartosci krytycznej w odpowiedniej kolejnosci i program
        // wykonywany jest poprawnie
        // synchronizacja wplywa na czas wykonywania

        wartoscKrytyczna += 1;
       /* try{
        Thread.sleep(0,2);}
        catch (InterruptedException e){
            System.exit(1);
        }*/
        wartoscKrytyczna--;
        return wartoscKrytyczna;
    }
}
