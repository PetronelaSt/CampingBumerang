package camping.entities;

import java.time.LocalDateTime;
import java.util.List;

public class Pozemok {

    private Long id;
    private Long cisloPozemku;
    private String kategoria;
    private int cena;
    private boolean obsadenost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCisloPozemku() {
        return cisloPozemku;
    }

    public void setCisloPozemku(Long cisloPozemku) {
        this.cisloPozemku = cisloPozemku;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public boolean isObsadenost() {
        return obsadenost;
    }

    public void setObsadenost(boolean obsadenost) {
        this.obsadenost = obsadenost;
    }

    @Override
    public String toString() {
        return "Pozemok - id:" + id + ". Cislo Pozemku:" + cisloPozemku + ". Kategoria:" + kategoria + ". Cena:" + cena + ". Obsadenost:" + obsadenost;
    }

}
