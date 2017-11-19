package camping.design;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ObjednavkaEditSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<?> zoznamObjednavokListView;

    @FXML
    private Button hladajObjednavkyButton;

    @FXML
    private Button odstranOjednavkuButton;

    @FXML
    private Button upravObjednavkuButton;

    @FXML
    private Button pridajObjednavkuButton;

    @FXML
    private Label datumObjednavkyLabel;

    @FXML
    private Label idPozemkuLabel;

    @FXML
    private DatePicker datumObjednavkyDatePicker;

    @FXML
    private TextField idPozemkuTextField;

    @FXML
    void initialize() {

    }
}
