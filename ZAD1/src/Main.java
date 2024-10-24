import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Main {
    public static boolean DaLiJeProst (int n){
        for(int i=2;i<=sqrt(n);i++) if(n%i==0) return false;
        return true;
    }
    public static void main(String[] args) {

        System.out.println("Unesite broj n:");
        int n;
        do {
            Scanner in = new Scanner(System.in);
            n = in.nextInt();
            if(n>500) System.out.println("Uneseni broj je prevelik!");
            if(n<2){System.out.println("Nije moguće izvršiti izračunavanje prostih brojeva."); break;}
        }while(n>500);
        for(int i=2;i<2*n;i++){
            if(DaLiJeProst(i)) System.out.println(i);
        }

    }
}