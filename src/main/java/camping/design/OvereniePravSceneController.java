package camping.design;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class OvereniePravSceneController {
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label zadajHesloLabel;

    @FXML
    private PasswordField hesloAdminaPasswordField;

    @FXML
    private Button potvrdHesloButton;

    @FXML
    void initialize() {
        // pri potvrdHesloButton sa overí heslo a ak je správne vykoná akciu
    }
}
