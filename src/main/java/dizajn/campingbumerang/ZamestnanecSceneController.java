package dizajn.campingbumerang;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;

public class ZamestnanecSceneController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane adminScene;

    @FXML
    private TabPane adminTable;

    @FXML
    private Tab objednávkyList;

    @FXML
    private Tab financieList;

    @FXML
    private Button prepniUžívateľa;

    @FXML
    private Button pridajObjednávku;

    @FXML
    private Button pridajPlatbu;

    @FXML
    void initialize() {
        assert adminScene != null : "fx:id=\"adminScene\" was not injected: check your FXML file 'ZamestnanecScene.fxml'.";
        assert adminTable != null : "fx:id=\"adminTable\" was not injected: check your FXML file 'ZamestnanecScene.fxml'.";
        assert objednávkyList != null : "fx:id=\"objednávkyList\" was not injected: check your FXML file 'ZamestnanecScene.fxml'.";
        assert financieList != null : "fx:id=\"financieList\" was not injected: check your FXML file 'ZamestnanecScene.fxml'.";
        assert prepniUžívateľa != null : "fx:id=\"prepniUžívateľa\" was not injected: check your FXML file 'ZamestnanecScene.fxml'.";
        assert pridajObjednávku != null : "fx:id=\"pridajObjednávku\" was not injected: check your FXML file 'ZamestnanecScene.fxml'.";
        assert pridajPlatbu != null : "fx:id=\"pridajPlatbu\" was not injected: check your FXML file 'ZamestnanecScene.fxml'.";

    }
}