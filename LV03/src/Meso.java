import java.util.List;

public class Meso extends Hrana{
    private VrstaMesa vrsta;
    public Meso(String zP, List<Float> nV, Float kZ, VrstaMesa vr){
        super(zP,nV,kZ);
        vrsta=vr;
    }
    @Override
    public Float DajBrojKalorija(){
        Float sum= (float) 0;
        for(Float x: nutritivneVr) sum+=x;
        return (float) (1.2*sum);
    }
    @Override
    public boolean Zdravlje(){
        if ( koeficijentZdravlja>0.95) return true;
        return false;
    }

}
