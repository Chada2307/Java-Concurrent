package Zad3;

public class Watek extends Thread{
    private double[] tab;
    private int od;
    private int doo;
    public static int info;
    public static double[] minimal = new double[1000];
    public static double[] maksymal = new double[1000];


    public Watek(double[] tab, int od, int doo) {
        this.tab = tab;
        this.od= od;
        this.doo= doo;
    }
    public double mini(double[] tab, int od, int doo) {
        double minn = 0;
        for (int i = od; i < doo; i++) {
            if (tab[i] < minn) {
                minn = tab[i];
            }
        }
        System.out.println("Minimum: " + minn+" "+System.nanoTime()+"ns");
        info++;
        return minn;
    }
    public double maxi(double[] tab, int od, int doo) {
        double maxx = 0;
        for (int i = od; i < doo; i++) {
            if (tab[i] > maxx) {
                maxx = tab[i];
            }
        }
        System.out.println("Maximum: " + maxx+" "+System.nanoTime()+"ns");
        info++;
        return maxx;

    }
    @Override
    public void run() {
        System.out.println("Thread: " + this.getName()+
                "szukam w tablicy od "+od+" do "+doo);

        minimal[info] = mini(tab,od, doo);
        maksymal[info] = maxi(tab,od, doo);

    }
}
