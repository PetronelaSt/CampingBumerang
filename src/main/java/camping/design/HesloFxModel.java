package camping.design;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HesloFxModel {

    private StringProperty uzivatel = new SimpleStringProperty();
    private StringProperty heslo = new SimpleStringProperty();

    public String getUzivatel() {
        return uzivatel.get();
    }

    public void setUzivatel(String uzivatel) {
        this.uzivatel.set(uzivatel);
    }

    public StringProperty getUzivatelProperty() {
        return uzivatel;
    }

    public String getHeslo() {
        return heslo.get();
    }

    public void setHeslo(String heslo) {
        this.heslo.set(heslo);
    }

    public StringProperty getHesloProperty() {
        return heslo;
    }
}
