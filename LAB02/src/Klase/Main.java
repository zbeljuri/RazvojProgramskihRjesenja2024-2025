package Klase;

import Izuzeci.PremladStudentException;
import Izuzeci.StudentBuducnostException;
import Izuzeci.DijeljenjeSNulomException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean uspjesanUnos = false;
        Student student = null;
        while (!uspjesanUnos) {
            try {
                System.out.printf("Datum rođenja (dd/mm/yyyy):");
                String datumString = scanner.nextLine();
                int godina = Integer.valueOf(datumString.substring(6)) - 1900;
                int mjesec = Integer.valueOf(datumString.substring(3, 5)) - 1;
                int dan = Integer.valueOf(datumString.substring(0, 2));
                Date datumDate = new Date(godina, mjesec, dan);
                student = new Student("Ime", "Prezime", datumDate, "12345", Odsjek.RI, 2);
                uspjesanUnos = true;
            } catch (PremladStudentException e) {
                System.out.println(e.getMessage());
                return;
            } catch (StudentBuducnostException e) {
                System.out.println(e.getMessage());
                System.out.println("Molimo ponovite unos datuma rođenja!");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


            String UnosOcj;
            UnosOcj = scanner.nextLine();
            String[] str1 = UnosOcj.split(",");
            List<Integer> l = new ArrayList<>(0);
            for (String str2 : str1) {
                l.add(Integer.valueOf(str2));
            }
            student.setOcjene(l);
            System.out.println("Unos studenta uspješan! " + student);
        }

    }
}