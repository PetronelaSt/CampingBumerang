package camping.model;

import camping.entities.Heslo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HesloFxModel {

    private StringProperty uzivatel = new SimpleStringProperty();
    //premenované z heslo na hesloUzivatela aby sa nekrylo s entitou 
    //s nazvom Heslo - chceme get Hesla(entity)
    private StringProperty hesloUzivatela = new SimpleStringProperty();

    public HesloFxModel() {
    }

    public Heslo getHeslo() {
        Heslo heslo = new Heslo();
        heslo.setHeslo(getHesloUzivatela());
        heslo.setUzivatel(getUzivatel());
        return heslo;
    }

    public String getUzivatel() {
        return uzivatel.get();
    }

    public void setUzivatel(String uzivatel) {
        this.uzivatel.set(uzivatel);
    }

    public StringProperty getUzivatelProperty() {
        return uzivatel;
    }

    public String getHesloUzivatela() {
        return hesloUzivatela.get();
    }

    public void setHeslo(String heslo) {
        this.hesloUzivatela.set(heslo);
    }

    public StringProperty getHesloUzivatelaProperty() {
        return hesloUzivatela;
    }
}
