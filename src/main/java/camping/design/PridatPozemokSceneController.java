package camping.design;

import camping.dao.CampingDaoFactory;
import camping.dao.PozemokDao;
import camping.entities.Kategoria;
import camping.entities.Pozemok;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PridatPozemokSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label cisloPozemkuLabel;

    @FXML
    private TextField cisloPozemkuTextField;

    @FXML
    private ChoiceBox<String> kategoriaPozemkuChoiceBox;

    @FXML
    private TextField cenaPozemkuTextField;

    @FXML
    private CheckBox obsadenostPozemkuCheckBox;

    @FXML
    private Button pridatPozemokButton;
    private KategoriaFxModel kategoriaModel = new KategoriaFxModel();

    @FXML
    void initialize() {
        kategoriaPozemkuChoiceBox.setItems(FXCollections.observableArrayList(kategoriaModel.getNazvy()));
        pridatPozemokButton.setOnAction(eh -> {
            Pozemok pozemok = new Pozemok();
            pozemok.setCisloPozemku(Long.parseLong(cisloPozemkuTextField.getText()));
            pozemok.setKategoria_id((long) kategoriaPozemkuChoiceBox.getSelectionModel().getSelectedIndex());
            pozemok.setCena(Integer.parseInt(cenaPozemkuTextField.getText()));
            if (obsadenostPozemkuCheckBox.selectedProperty().getValue()) {
                pozemok.setObsadenost(true);
            } else {
                pozemok.setObsadenost(false);
            }
            PozemokDao pozemokDao = CampingDaoFactory.INSTANCE.getMySqlPozemokDao();
            pozemokDao.createPozemok(pozemok);
            pridatPozemokButton.getScene().getWindow().hide();
        });
    }
}
