import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void dajInformacije() {
        Student p = new Student("Ime", "Prezime", "Adresa", new Date(99,0,1),"19616",2,8.1);
        String ocekivaniRezultat = "Student: Ime Prezime, broj indeksa: 19616";
        assertEquals(p.DajInformacije(), ocekivaniRezultat);
    }
}