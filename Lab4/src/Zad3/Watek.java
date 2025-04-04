package Zad3;

public class Watek extends Thread{
    private int[] tab;
    private int od;
    private int doo;
    public static int info;
    public static int[] minimal = new int[1000];
    public static int[] maksymal = new int[1000];


    public Watek(int[] tab, int od, int doo) {
        this.tab = tab;
        this.od= od;
        this.doo= doo;
    }
    public int mini(int[] tab, int od, int doo) {
        int minn = 0;
        for (int i = od; i < doo; i++) {
            if (tab[i] < minn) {
                minn = tab[i];
            }
        }
        System.out.println("Minimum: " + minn+" "+System.nanoTime()+"ns");
        info++;
        return minn;
    }
    public int maxi(int[] tab, int od, int doo) {
        int maxx = 0;
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
