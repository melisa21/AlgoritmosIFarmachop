package farmacia;

public class Suero implements ISuero {
    private Comparable idSuero;
    private String descSuero;

    public Suero(Comparable id, String desc){
        this.idSuero = id;
        this.descSuero = desc;
    }

    public Comparable getIdSuero() {
        return this.idSuero;
    }

    public void setIdSuero(Comparable idSuero) {
        this.idSuero = idSuero;
    }

    public String getDescSuero() {
        return this.descSuero;
    }

    public void setDescSuero(String descSuero) {
        this.descSuero = descSuero;
    }

}
