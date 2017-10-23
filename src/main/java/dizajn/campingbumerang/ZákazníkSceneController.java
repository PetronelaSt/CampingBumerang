package dizajn.campingbumerang;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaView;

public class ZákazníkSceneController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane adminScene;

    @FXML
    private TabPane adminTable;

    @FXML
    private Tab zákazníkObjednávkyList;

    @FXML
    private Tab fotografieList;

    @FXML
    private ImageView fotografieView;

    @FXML
    private Tab videáList;

    @FXML
    private MediaView videáView;

    @FXML
    private Button prepniUžívateľa;

    @FXML
    private Button pridajObjednávku;

    @FXML
    void initialize() {
        assert adminScene != null : "fx:id=\"adminScene\" was not injected: check your FXML file 'ZákazníkScene.fxml'.";
        assert adminTable != null : "fx:id=\"adminTable\" was not injected: check your FXML file 'ZákazníkScene.fxml'.";
        assert zákazníkObjednávkyList != null : "fx:id=\"zákazníkObjednávkyList\" was not injected: check your FXML file 'ZákazníkScene.fxml'.";
        assert fotografieList != null : "fx:id=\"fotografieList\" was not injected: check your FXML file 'ZákazníkScene.fxml'.";
        assert fotografieView != null : "fx:id=\"fotografieView\" was not injected: check your FXML file 'ZákazníkScene.fxml'.";
        assert videáList != null : "fx:id=\"videáList\" was not injected: check your FXML file 'ZákazníkScene.fxml'.";
        assert videáView != null : "fx:id=\"videáView\" was not injected: check your FXML file 'ZákazníkScene.fxml'.";
        assert prepniUžívateľa != null : "fx:id=\"prepniUžívateľa\" was not injected: check your FXML file 'ZákazníkScene.fxml'.";
        assert pridajObjednávku != null : "fx:id=\"pridajObjednávku\" was not injected: check your FXML file 'ZákazníkScene.fxml'.";

    }
}