package Zad1;

public class Test {
    public static void main(String[] args) {

        Watek watek1 = new Watek();
        Watek watek2 = new Watek();
        Watek watek3 = new Watek();


        watek1.setName("W1");
        watek2.setName("W2");
        watek3.setName("W3");

        watek1.start();
        watek2.start();
        watek3.start();

    }
}
