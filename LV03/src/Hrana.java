import java.util.List;

public abstract class Hrana implements Interfejs{
    //region atributi
    protected String zemljaPorijekla;
    protected List<Float> nutritivneVr;
    protected Float koeficijentZdravlja;
    //endregion
    public Hrana( String zP, List<Float> nV, Float kZ){
        zemljaPorijekla=zP;
        nutritivneVr=nV;
        koeficijentZdravlja=kZ;
    }
    public Float DajBrojKalorija(){
        float sum= 0.0F;
        for(Float x: nutritivneVr) sum+=x;
        return sum;
    }
    public abstract boolean Zdravlje();
}
