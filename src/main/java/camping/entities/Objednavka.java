package camping.entities;

import java.time.LocalDateTime;

public class Objednavka {

    private long id;
    private long pozemokId;
    private long pouzivatelId;
    private LocalDateTime datumObjednavky;
    private LocalDateTime datumPrichodu;
    private LocalDateTime datumOdchodu;
    private long pocetDni;
    private boolean platba;

    public long getPozemokId() {
        return pozemokId;
    }

    public void setPozemokId(long pozemokId) {
        this.pozemokId = pozemokId;
    }

    public long getPouzivatelId() {
        return pouzivatelId;
    }

    public void setPouzivatelId(long pouzivatelId) {
        this.pouzivatelId = pouzivatelId;
    }

    public boolean isPlatba() {
        return platba;
    }

    public void setPlatba(boolean platba) {
        this.platba = platba;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDatumObjednavky() {
        return datumObjednavky;
    }

    public void setDatumObjednavky(LocalDateTime datumObjednavky) {
        this.datumObjednavky = datumObjednavky;
    }

    public LocalDateTime getDatumPrichodu() {
        return datumPrichodu;
    }

    public void setDatumPrichodu(LocalDateTime datumPrichodu) {
        this.datumPrichodu = datumPrichodu;
    }

    public LocalDateTime getDatumOdchodu() {
        return datumOdchodu;
    }

    public void setDatumOdchodu(LocalDateTime datumOdchodu) {
        this.datumOdchodu = datumOdchodu;
    }

    public long getPocetDni() {
        return pocetDni;
    }

    public void setPocetDni(long pocetDni) {
        this.pocetDni = pocetDni;
    }

    @Override
    public String toString() {
        return "Objednavka:" + "id = " + id + ", datumObjednavky = " + datumObjednavky + ", datumPrichodu = " + datumPrichodu + ", datumOdchodu = " + datumOdchodu + ", pocetDni = " + pocetDni + ", platba = " + platba;
    }

}
