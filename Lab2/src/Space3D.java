import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Space3D extends Space2D {
    Space2D punktxy = new Space2D();
    double z;

    public Space3D() {
        this.punktxy.x = 0;
        this.punktxy.y = 0;
        this.z = 0;
    }

    public Space3D(double x, double y, double z) {
        punktxy.x = x;
        punktxy.y = y;
        this.z = z;
    }

    public double getPunktx() {
        return punktxy.x;
    }

    public double getPunkty() {
        return punktxy.y;
    }

    public double getPunktz() {
        return z;
    }

    public void setPunktx(double x) {
        this.punktxy.x = x;
    }

    public void setPunktxy(double y) {
        this.punktxy.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public void wyswietl() {
        super.wyswietl();
        System.out.println("Wartosc z :" + z);
    }


    public double odleglosc(Space3D Space3D) {
        double wynik = sqrt(pow((Space3D.x - this.x),2)+(pow((Space3D.y - this.y),2))+sqrt(pow((Space3D.z-this.z),2)));
        System.out.println("Odleglosc: "+wynik);
        return wynik;
    }
    public double odlegloscod0(){
        double wynik = sqrt(pow((0 - this.x),2)+(pow((0 - this.y),2))+sqrt(pow((0-this.z),2)));
        return wynik;
    }
}
