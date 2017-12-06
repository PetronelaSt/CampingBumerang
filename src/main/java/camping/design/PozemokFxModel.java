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

    private LongProperty cisloPozemku = new SimpleLongProperty();
    private LongProperty kategoria_id = new SimpleLongProperty();
    private IntegerProperty cena = new SimpleIntegerProperty();
    private BooleanProperty obsadenost = new SimpleBooleanProperty();
    private ObservableList<Pozemok> pozemky = FXCollections.observableArrayList();
//    private ObservableList<PozemokFxModel> pozemkyTab = FXCollections.observableArrayList();

    public PozemokFxModel() {
        readAll();
    }

    private void readAll() {
        PozemokDao pozemokDao = CampingDaoFactory.INSTANCE.getMySqlPozemokDao();
        List<Pozemok> listPozemkov = pozemokDao.getAll();
        for (Pozemok pozemok : listPozemkov) {
            pozemky.add(pozemok);

        }
//        nacitajPozemkyTab();
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

//    public void nacitajPozemkyTab() {
//        pozemkyTab.clear();
//        for (Pozemok pozemok : pozemky) {
//            PozemokFxModel model = new PozemokFxModel();
//            model.setCisloPozemku(pozemok.getCisloPozemku());
//            model.setKategoria_id(pozemok.getKategoria_id());
//            model.setCena(pozemok.getCena());
//            model.setObsadenost(pozemok.isObsadenost());
//            pozemkyTab.add(model);
//        }
//        setPozemkyTab(pozemkyTab);
//    }

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

    public ObservableList<Pozemok> getPozemky() {
        return pozemky;
    }

    public void setPozemky(ObservableList<Pozemok> pozemky) {
        this.pozemky = pozemky;
    }

//    public ObservableList<PozemokFxModel> getPozemkyTab() {
//        return pozemkyTab;
//    }
//    public void setPozemkyTab(ObservableList<PozemokFxModel> pozemky) {
//        this.pozemkyTab = pozemkyTab;
//    }
}
