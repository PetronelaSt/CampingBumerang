package camping.design;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;

public class MainSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private SplitMenuButton pouzivatelSplitMenuButton;

    @FXML
    private MenuItem admin;

    @FXML
    private MenuItem zamestnanec;

    @FXML
    private MenuItem zákazník;

    @FXML
    private Label menoLabel;

    @FXML
    private TextField menoPouzivatelaTextField;

    @FXML
    private Label hesloLabel;

    @FXML
    private PasswordField hesloPouzivatelaPasswordField;

    @FXML
    private Button potvrdeniePrihlaseniaButton;

    @FXML
    void initialize() {

    }
}
