package camping.model;

import camping.entities.Pozemok;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PozemokFxModel {

    //privatne premenne podla entity, pricom id uzivatel nezadava-preto tu nie je
    //pre cislo pozemku možeme dať "1" (ale muselo by byť typu final v entite?)
    //-nemusí byť, ale môže byť ako predvolené pre začiatočne pridávanie pozemkov
    private LongProperty cisloPozemku = new SimpleLongProperty();
    private LongProperty kategoria_id = new SimpleLongProperty();
    private IntegerProperty cena = new SimpleIntegerProperty();
    private BooleanProperty obsadenost = new SimpleBooleanProperty();

    //zatial praqzdny konštruktor pre fx model
    public PozemokFxModel() {
    }

    //get pre pozemok
    public Pozemok getPozemok() {
        Pozemok pozemok = new Pozemok();
        pozemok.setCisloPozemku(getCisloPozemku());
        pozemok.setKategoria_id(getKategoriaId());
        pozemok.setCena(getCena());
        pozemok.setObsadenost(getObsadenost());
        return pozemok;
    }

    //getery, setery a property
    public LongProperty cisloPozemkuProperty() {
        return cisloPozemku;
    }

    public Long getCisloPozemku() {
        return cisloPozemku.get();
    }

    public void setCisloPozemku(Long cisloPozemku) {
        this.cisloPozemku.set(cisloPozemku);
    }

    public LongProperty kategoriaIdProperty() {
        return kategoria_id;
    }

    public Long getKategoriaId() {
        return kategoria_id.get();
    }

    public void setKategoria_id(Long kategoria_id) {
        this.kategoria_id.set(kategoria_id);
    }

    public IntegerProperty cenaProperty() {
        return cena;
    }

    public Integer getCena() {
        return cena.get();
    }

    public void setCena(Integer cena) {
        this.cena.set(cena);
    }

    public BooleanProperty obsadenostProperty() {
        return obsadenost;
    }

    public Boolean getObsadenost() {
        return obsadenost.get();
    }

    public void setObsadenost(Boolean obsadenost) {
        this.obsadenost.set(obsadenost);
    }

}
