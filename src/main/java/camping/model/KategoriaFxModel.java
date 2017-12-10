package camping.model;

import camping.entities.Kategoria;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class KategoriaFxModel {

    private StringProperty nazov = new SimpleStringProperty();

    public KategoriaFxModel() {
    }

    public Kategoria getKategoria() {
        Kategoria kategoria = new Kategoria();
        kategoria.setNazov(getNazov());
        return kategoria;
    }

    public StringProperty getNazovProperty() {
        return nazov;
    }

    public String getNazov() {
        return nazov.get();
    }

    public void setNazov(String nazov) {
        this.nazov.set(nazov);
    }

}
