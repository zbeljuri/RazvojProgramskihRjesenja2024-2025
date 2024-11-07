import java.util.List;

public class Voce extends Hrana{
    private String latinskiNaziv;
    public Voce(String zP, List<Integer> nV, Float kZ, String lN){
        super(zP,nV,kZ);
        latinskiNaziv=lN;
    }
    @Override
    public boolean Zdravlje(){
        if (this.DajBrojKalorija()<50 && koeficijentZdravlja>0.75) return true;
        return false;
    }


}
