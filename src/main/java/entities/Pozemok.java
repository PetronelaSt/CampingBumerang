package entities;

import java.time.LocalDateTime;
import java.util.List;

public class Pozemok {

    private long id;
    private boolean obsadenost;
    private String kategoria;
//      private List<String> obsahPozemku;

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isObsadenost() {
        return obsadenost;
    }

    public void setObsadenost(boolean obsadenost) {
        this.obsadenost = obsadenost;
    }

//    public List<String> getObsahPozemku() {
//        return obsahPozemku;
//    }
//
//    public void setObsahPozemku(List<String> obsahPozemku) {
//        this.obsahPozemku = obsahPozemku;
//    }
}
