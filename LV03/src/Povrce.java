import java.util.List;

public class Povrce extends Hrana {
    private String latinskiNaziv;
    public Povrce(String zP, List<Integer> nV, Float kZ, String lN){
        super(zP,nV,kZ);
        latinskiNaziv=lN;
    }
    @Override
    public boolean Zdravlje(){
        if (this.DajBrojKalorija()<100 && koeficijentZdravlja>0.5&&koeficijentZdravlja<0.7) return true;
        return false;
    }

}
