package camping.design;

import camping.dao.CampingDaoFactory;
import camping.dao.PozemokDao;
import camping.entities.Pozemok;
import java.util.List;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PozemokFxModel {

    private LongProperty cisloPozemku;
    private LongProperty kategoriaId;
    private IntegerProperty cena;
    private BooleanProperty obsadenost;
    private ObservableList<PozemokFxModel> pozemky;
//    private ObservableList<PozemokFxModel> pozemkyTab = FXCollections.observableArrayList();

    public PozemokFxModel() {
        this.cisloPozemku = new SimpleLongProperty(0L);
        this.kategoriaId = new SimpleLongProperty();
        this.cena = new SimpleIntegerProperty();
        this.obsadenost = new SimpleBooleanProperty();
        this.pozemky = FXCollections.observableArrayList();

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
        return kategoriaId;
    }

    public Long getKategoriaId() {
        return kategoriaId.get();
    }

    public void setKategoriaId(Long kategoriaId) {
        this.kategoriaId.set(kategoriaId);
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

    public ObservableList<PozemokFxModel> getPozemky() {
        readAll();
        return pozemky;

    }

    public void setPozemky(ObservableList<PozemokFxModel> pozemky) {
        this.pozemky = pozemky;
    }

    private void readAll() {
        PozemokDao pozemokDao = CampingDaoFactory.INSTANCE.getMySqlPozemokDao();
        List<PozemokFxModel> listPozemkov = pozemokDao.getAll();
        for (PozemokFxModel pozemok : listPozemkov) {
            pozemky.add(pozemok);

        }
    }

}
