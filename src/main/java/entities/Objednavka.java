package entities;

import java.time.LocalDateTime;

public class Objednavka {

    private long id;
    private LocalDateTime datumObjednavky;
    private LocalDateTime datumPrichodu;
    private LocalDateTime datumOdchodu;
    private long pocetDni;
    private boolean odovzdaneKluce;

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

    public boolean isOdovzdaneKluce() {
        return odovzdaneKluce;
    }

    public void setOdovzdaneKluce(boolean odovzdaneKluce) {
        this.odovzdaneKluce = odovzdaneKluce;
    }

}
