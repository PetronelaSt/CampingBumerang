package camping.model;

import camping.entities.Objednavka;
import java.time.LocalDate;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleLongProperty;

public class ObjednavkaFxModel {
    //id som nedávala
    private LongProperty pozemokId = new SimpleLongProperty();
    private LongProperty pouzivatelId = new SimpleLongProperty();
    //pretypovanie pre 
    /*private LocalDate datumObjednavky;
    private LocalDate datumPrichodu;
    private LocalDate datumOdchodu;*/
    private LongProperty pocetDni = new SimpleLongProperty();
    private BooleanProperty platba = new SimpleBooleanProperty();

    //zatial praqzdny konštruktor pre fx model
    public ObjednavkaFxModel() {
    }
    
    public Objednavka getObjednavka() {
        Objednavka objednavka = new Objednavka();
        objednavka.setPozemokId(getPozemokId());
        objednavka.setPouzivatelId(getPouzivatelId());
        //datum objednavky nastavujem ako datetime now-teda aktualny čas
        objednavka.setDatumObjednavky(LocalDate.now());
        //datetimes
        objednavka.setPocetDni(getPocetDni());
        objednavka.setPlatba(getPlatba());
        return objednavka;
    }    
    
    public LongProperty pozemokIdProperty() {
        return pozemokId;
    }
    
    public Long getPozemokId() {
        return pozemokId.get();
    }

    public void setPozemokId(Long pozemokId) {
        this.pozemokId.set(pozemokId);
    }

    public LongProperty pouzivatelIdProperty() {
        return pouzivatelId;
    }
    
    public Long getPouzivatelId() {
        return pouzivatelId.get();
    }

    public void setPouzivatelId(Long pouzivatelId) {
        this.pouzivatelId.set(pouzivatelId);
    }

    public LongProperty pocetDniProperty() {
        return pocetDni;
    }
    
    public Long getPocetDni() {
        return pocetDni.get();
    }

    public void setPocetDni(Long pocetDni) {
        this.pocetDni.set(pocetDni);
    }    

    public BooleanProperty platbaProperty() {
        return platba;
    }
    
    public Boolean getPlatba() {
        return platba.get();
    }

    public void setPlatba(Boolean platba) {
        this.platba.set(platba);
    }
}
