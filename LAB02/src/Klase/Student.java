package Klase;

import Izuzeci.PremladStudentException;
import Izuzeci.StudentBuducnostException;
import Izuzeci.DijeljenjeSNulomException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Student
{
    String ime, prezime, brojIndeksa;
    Odsjek odsjek;
    Date datumRodjenja;
    Integer godinaStudija;
    List<Integer> ocjene;

    public Student(String ime, String prezime, Date datumRodjenja, String brojIndeksa,
                   Odsjek odsjek, Integer godinaStudija) throws Exception
    {
        setIme(ime);
        setPrezime(prezime);
        setDatumRodjenja(datumRodjenja);
        setBrojIndeksa(brojIndeksa);
        setOdsjek(odsjek);
        setGodinaStudija(godinaStudija);
        setOcjene(new ArrayList<Integer>());
    }

    public Double Prosjek() throws DijeljenjeSNulomException {
        if(ocjene.isEmpty()) throw new DijeljenjeSNulomException("Student nema ni jednu ocjenu!");
        Double prosjek = 0.0;
        for (Integer ocjena : ocjene)
            prosjek += ocjena;
        return prosjek / ocjene.size();
    }


    public String toString() {
        try{
        return "Klase.Student: " + ime + " " + prezime + ", broj indeksa: " + brojIndeksa + ", prosjek: " + Prosjek();
    } catch(DijeljenjeSNulomException e){
        System.out.println(e.getMessage());
    }
    return " Nije moguce ispisati podatke ";
    }


    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public Odsjek getOdsjek() {
        return odsjek;
    }

    public void setOdsjek(Odsjek odsjek) {
        this.odsjek = odsjek;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }


    public List<Integer> getOcjene() {
        return ocjene;
    }

    public void setOcjene(List<Integer> ocjene) {
        this.ocjene = ocjene;
    }


    public void setDatumRodjenja(Date datumRodjenja) throws StudentBuducnostException, PremladStudentException {
        Date today = new Date();
        if (datumRodjenja.compareTo(today) >= 0)
            throw new StudentBuducnostException("Datum rođenja ne može biti u budućnosti!");


        else if (today.getYear() - datumRodjenja.getYear() < 16)
            throw new PremladStudentException("Klase.Student ne može biti mlađi od 16 godina!");


        this.datumRodjenja = datumRodjenja;
    }


    public void setGodinaStudija(Integer godinaStudija) {
        if (this.odsjek != Odsjek.RS && godinaStudija > 0 && godinaStudija < 6)
            this.godinaStudija = godinaStudija;
        else if (this.odsjek == Odsjek.RS && godinaStudija > 0 && godinaStudija <= 2)
            this.godinaStudija = godinaStudija;
    }


}
