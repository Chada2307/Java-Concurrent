package Zad2;

public class TestWatkow {
    public static void main(String[] args) {
        int tnum  = Integer.parseInt(args[0]);
        int count = Integer.parseInt(args[1]);
       // int tnum = 5;
       // int count = 200;

        LicznikWatkow licznik = new LicznikWatkow();

        WatekLiczacy[] thread = new WatekLiczacy[tnum];
        for (int i = 0; i < tnum; i++)
            thread[i] = new WatekLiczacy("Watek "+ (i + 1), licznik, count);

        try{
            for (int i = 0; i < tnum; i++) {thread[i].join();}
            }catch(InterruptedException e){
                System.exit(1);
            }

        System.out.println("Koniec Programu");
    }
}
