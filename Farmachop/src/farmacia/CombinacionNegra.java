package farmacia;

public class CombinacionNegra implements ICombinacionNegra {
    private Comparable farmaco;
    private Comparable suero;

    public CombinacionNegra(Comparable farmaco, Comparable suero){
        this.setFarmaco(farmaco);
        this.setSuero(suero);
    }

    public Comparable getFarmaco() {
        return this.farmaco;
    }

    public void setFarmaco(Comparable farmaco) {
        this.farmaco = farmaco;
    }

    public Comparable getSuero() {
        return this.suero;
    }

    public void setSuero(Comparable suero) {
        this.suero = suero;
    }

    

}
