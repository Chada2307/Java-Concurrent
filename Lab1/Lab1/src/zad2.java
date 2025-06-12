import java.util.Scanner;

public class zad2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj liczbe");
        int a = sc.nextInt();
        if (isPrime(a)){
            System.out.println("Liczba "+a +" jest liczba pierwsza");
        }else {
            System.out.println("Liczba "+a + " NIE jest liczba pierwsza");
        }
        sc.close();
    }
    public static boolean isPrime(int n){
        if (n<= 1){
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}
