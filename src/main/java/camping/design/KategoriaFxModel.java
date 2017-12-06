package camping.design;

import camping.dao.CampingDaoFactory;
import camping.dao.KategoriaDao;
import camping.entities.Kategoria;
import java.util.List;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KategoriaFxModel {

    private StringProperty nazov = new SimpleStringProperty();
    private ObservableList<String> nazvy = FXCollections.observableArrayList();

    public KategoriaFxModel() {
        KategoriaDao kategoria = CampingDaoFactory.INSTANCE.getMySqlKategoriaDao();
        List<Kategoria> kategorie = kategoria.getAll();
        for (Kategoria kategoria1 : kategorie) {
            nazvy.add(kategoria1.getNazov());
        }
    }

    public String getNazov() {
        return nazov.get();
    }

    public void setNazov(String nazov) {
        this.nazov.set(nazov);
    }

    public StringProperty getNazovProperty() {
        return nazov;
    }
    
    public ObservableList<String> getNazvy() {
        return nazvy;
    }

    public void setNazvy(ObservableList<String> nazvy) {
        this.nazvy = nazvy;
    }
}
