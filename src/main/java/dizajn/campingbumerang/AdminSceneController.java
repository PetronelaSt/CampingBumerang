package dizajn.campingbumerang;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;

public class AdminSceneController {
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
    private Tab zamestnanciList;

    @FXML
    private Button prepniUžívateľa;

    @FXML
    private Button pridajObjednávku;

    @FXML
    private Button zrušObjednávku;

    @FXML
    private Button pridajPlatbu;

    @FXML
    private Button zrušPlatbu;

    @FXML
    void initialize() {
        assert adminScene != null : "fx:id=\"adminScene\" was not injected: check your FXML file 'AdminScene.fxml'.";
        assert adminTable != null : "fx:id=\"adminTable\" was not injected: check your FXML file 'AdminScene.fxml'.";
        assert objednávkyList != null : "fx:id=\"objednávkyList\" was not injected: check your FXML file 'AdminScene.fxml'.";
        assert financieList != null : "fx:id=\"financieList\" was not injected: check your FXML file 'AdminScene.fxml'.";
        assert zamestnanciList != null : "fx:id=\"zamestnanciList\" was not injected: check your FXML file 'AdminScene.fxml'.";
        assert prepniUžívateľa != null : "fx:id=\"prepniUžívateľa\" was not injected: check your FXML file 'AdminScene.fxml'.";
        assert pridajObjednávku != null : "fx:id=\"pridajObjednávku\" was not injected: check your FXML file 'AdminScene.fxml'.";
        assert zrušObjednávku != null : "fx:id=\"zrušObjednávku\" was not injected: check your FXML file 'AdminScene.fxml'.";
        assert pridajPlatbu != null : "fx:id=\"pridajPlatbu\" was not injected: check your FXML file 'AdminScene.fxml'.";
        assert zrušPlatbu != null : "fx:id=\"zrušPlatbu\" was not injected: check your FXML file 'AdminScene.fxml'.";

    }
}