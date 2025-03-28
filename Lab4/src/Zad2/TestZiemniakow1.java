package Zad2;

public class TestZiemniakow1 {
    
    public static void main(String[] args) {
        DzialajacyZiemniak1 dZ = new DzialajacyZiemniak1();

        Thread t1 = new Thread(dZ, "Pierwszy ziemniak");
        Thread t2 = new Thread(dZ, "Drugi ziemniak");
        t2.setPriority(t1.getPriority() + 1);
        t1.start();
        t2.start();
    }
}
