package camping.design;

import camping.dao.CampingDaoFactory;
import camping.dao.HesloDao;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HesloFxModel {

    private StringProperty uzivatel = new SimpleStringProperty();
    private StringProperty heslo = new SimpleStringProperty();
    private StringProperty sol = new SimpleStringProperty();

    public HesloFxModel(String uzivatel) {
        HesloDao hesloDao = CampingDaoFactory.INSTANCE.getMySqlHesloDao();
        List<String> hesla = hesloDao.findByUzivatel(uzivatel);
        this.setHeslo(hesla.get(0));
        this.setSol(hesla.get(1));
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

    public String getHeslo() {
        return heslo.get();
    }

    public void setHeslo(String heslo) {
        this.heslo.set(heslo);
    }

    public StringProperty getHesloProperty() {
        return heslo;
    }

    public String getSol() {
        return sol.get();
    }

    public void setSol(String sol) {
        this.sol.set(sol);
    }

    public StringProperty getSolProperty() {
        return sol;
    }
}
