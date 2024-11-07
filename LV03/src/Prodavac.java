public class Prodavac implements Interfejs{
    private String Ime, Prezime;
    private int brojStanda;
    private int Id;
    public Prodavac(  String ime, String prezime,
     int rojStanda,
     int d){
        Ime=ime;
        Prezime=prezime;
        brojStanda=rojStanda;
        Id=d;

    }

    public boolean Zdravlje(){
        if(Id%100==1) return true;
        return false;
    }


}
