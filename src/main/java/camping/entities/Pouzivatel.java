package camping.entities;

public class Pouzivatel {

    private Long id;
    private String pozicia;
    private String meno;
    private String heslo;

    public String getPozicia() {
        return pozicia;
    }

    public void setPozicia(String pozicia) {
        this.pozicia = pozicia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getHeslo() {
        return heslo;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }

    @Override
    public String toString() {
        return "Pouzivatel:" + "id = " + id + ", pozicia = " + pozicia + ", meno = " + meno + ", heslo = " + heslo;
    }

    

}
