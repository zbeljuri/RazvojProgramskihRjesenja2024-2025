import controller.OsobaController;
import model.Osoba;
import model.Uloga;
import view.OsobaView;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        OsobaView osobaView = new OsobaView();
        Osoba osoba = new Osoba(1, "OSOBAA", "Prezime", "lok", new Date(99, 1, 9), "1121445111111", Uloga.STUDENT);
        OsobaController osobaController = new OsobaController(osoba, osobaView);
        osobaController.dajOsobeIzTxtDatoteke("src/data/osobe.txt");
        System.out.println("2) View ispisuje: " + osobaView.getPoruka());
    }
}