import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AsistentTest {
    @Test
    void dajInformacije() {
        Asistent p = new Asistent("Ime", "Prezime", "Adresa", new Date(99,0,1),40,2004,"19616","Lab","12.00");
        String ocekivaniRezultat = "Ime i prezime: Ime Prezime";
        assertEquals(p.DajInformacije(), ocekivaniRezultat);
    }


}