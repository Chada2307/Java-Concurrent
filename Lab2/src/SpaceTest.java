public class SpaceTest {

    public static void main(String[] args){
    Space2D PunktA = new Space2D(2,2);
    Space2D PunktB = new Space2D(3,0);
    Space2D PunktC = new Space2D(5,2);

    PunktA.odleglosc(PunktB);
    PunktA.odlegloscod0();
    PunktA.obwodtrojkata(PunktB, PunktC);
    PunktA.poleHeron(PunktB,PunktC);

    }

}
