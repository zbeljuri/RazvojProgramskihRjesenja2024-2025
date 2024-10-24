import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static Double Plus(Double broj1, Double broj2){
        return broj1+broj2;
    }
    public static Double Podijeljeno(Double broj1, Double broj2) throws Exception{
        if(broj2==0) throw new Exception("Dijeljenje nulom nije definisano!");
        return broj1/broj2;
    }
    public static void main(String[] args) {
        String odabir;
        System.out.println("Unesite operaciju('plus' za sabiranje, 'podijeljeno' za dijeljenje): ");
        Scanner in=new Scanner(System.in);
        odabir=in.nextLine();
        List<Double> kolekcija=new ArrayList<Double>();
        double d;
        System.out.println("Unesite brojeve: ");
        do{
            Scanner inp=new Scanner(System.in);
            d=inp.nextDouble();
            if(d!=-400)
            kolekcija.add(d);

        }while(d!=-400);

        if (Objects.equals(odabir, "plus")) {
            double suma;
            suma = Plus(kolekcija.get(0), kolekcija.get(1));
            for (int i=2;i<kolekcija.size();i++){
                suma=Plus(suma, kolekcija.get(i));
            }
            System.out.println("Suma iznosi: "+suma);
        }

        if(Objects.equals(odabir, "dijeljenje")){
            double di;
         try {
             di = Podijeljeno(kolekcija.get(0), kolekcija.get(1));
             for (int i = 2; i < kolekcija.size(); i++) {
                 di = Podijeljeno(di, kolekcija.get(i));
             }
             System.out.println("Suma iznosi: " + di);
         }catch(Exception  e){
             System.out.println(e.getMessage());
         }


        }
    }
}