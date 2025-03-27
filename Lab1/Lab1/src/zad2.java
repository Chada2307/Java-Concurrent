public class zad2 {
    public static boolean metoda2(int a){
        if (a<=1){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a%i ==0){
                return false;
            }
        }

        return true;
    }


}
