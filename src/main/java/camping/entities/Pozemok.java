package camping.entities;

import java.time.LocalDateTime;
import java.util.List;

public class Pozemok {

    private long id;
    private long cisloPozemku;
    private String kategoria;
    private boolean obsadenost;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCisloPozemku() {
        return cisloPozemku;
    }

    public void setCisloPozemku(long cisloPozemku) {
        this.cisloPozemku = cisloPozemku;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public boolean isObsadenost() {
        return obsadenost;
    }

    public void setObsadenost(boolean obsadenost) {
        this.obsadenost = obsadenost;
    }

    @Override
    public String toString() {
        return "id:" + id + ". Cislo Pozemku:" + cisloPozemku +". Kategoria:" + kategoria + ". Obsadenost:" + obsadenost;
    }

}
