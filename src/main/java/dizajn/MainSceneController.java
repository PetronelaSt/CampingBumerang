package dizajn;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class MainSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane prihlasovacieOkno;

    @FXML
    private TextField menoPoužívateľa;

    @FXML
    private PasswordField hesloPoužívateľa;

    @FXML
    private SplitMenuButton používateľ;

    @FXML
    private MenuItem admin;

    @FXML
    private MenuItem zamestnanec;

    @FXML
    private MenuItem zákazník;

    @FXML
    private Button potvrdeniePrihlásenia;

    @FXML
    private Label menoLabel;

    @FXML
    private Label hesloLabel;

    @FXML
    void initialize() {
        assert prihlasovacieOkno != null : "fx:id=\"prihlasovacieOkno\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert menoPoužívateľa != null : "fx:id=\"menoPoužívateľa\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert hesloPoužívateľa != null : "fx:id=\"hesloPoužívateľa\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert používateľ != null : "fx:id=\"používateľ\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert admin != null : "fx:id=\"admin\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert zamestnanec != null : "fx:id=\"zamestnanec\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert zákazník != null : "fx:id=\"zákazník\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert potvrdeniePrihlásenia != null : "fx:id=\"potvrdeniePrihlásenia\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert menoLabel != null : "fx:id=\"menoLabel\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert hesloLabel != null : "fx:id=\"hesloLabel\" was not injected: check your FXML file 'MainScene.fxml'.";
    }
}