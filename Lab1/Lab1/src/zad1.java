public class zad1 {
    public static void metoda(){
        int n = 1;
        int x = 5;
        for (int i = 0; i < 6 ; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
            if (n<10){
                n+=2;
                x--;
            } else if (n>10) {
                n=1;
                x=5;

                for (int j = 0; j < 3; j++) {
                    System.out.print("     ");
                    System.out.print("*");
                    System.out.println();
                }

            }
        }
    }
}
