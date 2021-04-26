package farmacia;

public class Farmaco implements IFarmaco{
    private Comparable idFarmaco;
    private String descFarmaco;

    public Farmaco (Comparable idFarmaco, String descFarmaco){
        this.setIdFarmaco(idFarmaco);
        this.setDescFarmaco(descFarmaco);
    }

    public Comparable getIdFarmaco() {
        return this.idFarmaco;
    }

    public void setIdFarmaco(Comparable idFarmaco) {
        this.idFarmaco = idFarmaco;
    }

    public String getDescFarmaco() {
        return this.descFarmaco;
    }

    public void setDescFarmaco(String descFarmaco) {
        this.descFarmaco = descFarmaco;
    }


}
