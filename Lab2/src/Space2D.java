import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Space2D {
    double x;
    double y;

    public Space2D(){
        this.x = 0;
        this.y = 0;
    }
    public Space2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public void wyswietl(){
        System.out.println("Wartosc x: "+this.x);
        System.out.println("Wartosc y: "+this.y);
    }
    public double odleglosc(Space2D Space2D){
        double wynik = sqrt(pow((Space2D.x - this.x),2)+(pow((Space2D.y - this.y),2)));
        System.out.println("Odleglosc :"+ (wynik));

        return wynik;
    }
    public double odlegloscod0(){
        double wynik = sqrt(pow((0 - this.x),2)+pow((0-this.y),2));
        System.out.println("Odleglosc od 0,0: "+wynik);
        return wynik;
    }
    @Override
    public String toString() {
        return "Space2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    public double obwodtrojkata(Space2D punktB, Space2D punktC){
        double AdoB = sqrt(pow((punktB.x - this.x),2)+pow((punktB.y-this.y),2));
        double AdoC = sqrt(pow((punktC.x - this.x),2)+pow((punktC.y-this.y),2));
        double BdoC = sqrt(pow((punktC.x - punktB.x),2)+pow((punktC.y- punktB.y),2));
        double wynik = AdoB+AdoC+BdoC;
        System.out.println("Wynik obwodu wynosi: "+wynik);
        return wynik;
    }

    public double poleHeron(Space2D punktB, Space2D punktC){
        double a = sqrt(pow((punktB.x - this.x),2)+pow((punktB.y-this.y),2));
        double b = sqrt(pow((punktC.x - this.x),2)+pow((punktC.y-this.y),2));
        double c = sqrt(pow((punktC.x - punktB.x),2)+pow((punktC.y- punktB.y),2));
        double p = (a+b+c)/2;
        double wynikheron = sqrt(p*(p-a)*(p-b)*(p-c));
        System.out.println("Pole wyznaczone wzorem herona wynosi:"+wynikheron);
        return wynikheron;
    }
}

