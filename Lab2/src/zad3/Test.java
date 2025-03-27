package zad3;

public class Test {

    public static void main(String[] args){
    Watek1 watek1 = new Watek1();
    Watek2 watek2 = new Watek2();

    Thread t1 = new Thread(watek1);
    Thread t2 = new Thread(watek2);

    t1.start();
    t2.start();

        System.out.println("Koniec programu");
    }

}
