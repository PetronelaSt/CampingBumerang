package camping.design;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AdminSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private Button pridajPlatbuButton;

    @FXML
    private Button zrusPlatbuButton;

    @FXML
    private Button spravujObjednavkyButton;

    @FXML
    private Button zrusObjednavkuButton;

    @FXML
    private Button prepniUzivatelaButton;

    @FXML
    private Button pridajZamestnancaButton;

    @FXML
    private Button id1Button;

    @FXML
    private Button id8Button;

    @FXML
    private Button id7Button;

    @FXML
    private Button id6Button;

    @FXML
    private Button id5Button;

    @FXML
    private Button id4Button;

    @FXML
    private Button id3Button;

    @FXML
    private Button id2Button;

    @FXML
    private Button id19Button;

    @FXML
    private Button id18Button;

    @FXML
    private Button id17Button;

    @FXML
    private Button id16Button;

    @FXML
    private Button id15Button;

    @FXML
    private Button id14Button;

    @FXML
    private Button id13Button;

    @FXML
    private Button id12Button;

    @FXML
    private Button id11Button;

    @FXML
    private Button id10Button;

    @FXML
    private Button id9Button;

    @FXML
    private Button id32Button;

    @FXML
    private Button id31Button;

    @FXML
    private Button id30Button;

    @FXML
    private Button id28Button;

    @FXML
    private Button id27Button;

    @FXML
    private Button id26Button;

    @FXML
    private Button id25Button;

    @FXML
    private Button id24Button;

    @FXML
    private Button id23Button;

    @FXML
    private Button id62Button;

    @FXML
    private Button id55Button;

    @FXML
    private Button id48Button;

    @FXML
    private Button id41Button;

    @FXML
    private Button id36Button;

    @FXML
    private Button id29Button;

    @FXML
    private Button id22Button;

    @FXML
    private Button id21Button;

    @FXML
    private Button id20Button;

    @FXML
    private Button id40Button;

    @FXML
    private Button id39Button;

    @FXML
    private Button id64Button;

    @FXML
    private Button id57Button;

    @FXML
    private Button id50Button;

    @FXML
    private Button id43Button;

    @FXML
    private Button id38Button;

    @FXML
    private Button id35Button;

    @FXML
    private Button id34Button;

    @FXML
    private Button id63Button;

    @FXML
    private Button id56Button;

    @FXML
    private Button id49Button;

    @FXML
    private Button id42Button;

    @FXML
    private Button id37Button;

    @FXML
    private Button id33Button;

    @FXML
    private Button id60Button;

    @FXML
    private Button id53Button;

    @FXML
    private Button id52Button;

    @FXML
    private Button id67Button;

    @FXML
    private Button id59Button;

    @FXML
    private Button id66Button;

    @FXML
    private Button id65Button;

    @FXML
    private Button id58Button;

    @FXML
    private Button id51Button;

    @FXML
    private Button id44Button;

    @FXML
    private Button id46Button;

    @FXML
    private Button id45Button;

    @FXML
    private Button id54Button;

    @FXML
    private Button id68Button;

    @FXML
    private Button id61Button;

    @FXML
    private Button id70Button;

    @FXML
    private Button id69Button;

    @FXML
    private Button id47Button;

    @FXML
    private ListView<?> udajeOPozemkuListView;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    void initialize() {
        pridajZamestnancaButton.setOnAction(eh -> {
            ZamestnanecEditSceneController controller = new ZamestnanecEditSceneController();
            showZamestnanecEditWindow(controller);
        });
        spravujObjednavkyButton.setOnAction(eh -> {
            ObjednavkaEditSceneController controller = new ObjednavkaEditSceneController();
            showObjednavkaEditWindow(controller);
        });
        prepniUzivatelaButton.setOnAction(eh -> {
            MainSceneController controller = new MainSceneController();
            showMainWindow(controller);
        });
    }

    private void showZamestnanecEditWindow(ZamestnanecEditSceneController controller) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("ZamestnanecEditScene.fxml"));
            loader.setController(controller);

            Parent parentPane = loader.load();
            Scene scene = new Scene(parentPane);

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Správa zamestnancov");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    private void showObjednavkaEditWindow(ObjednavkaEditSceneController controller) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("ObjednavkaEditScene.fxml"));
            loader.setController(controller);

            Parent parentPane = loader.load();
            Scene scene = new Scene(parentPane);

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Správa objednávok");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
    private void showMainWindow(MainSceneController controller) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("MainScene.fxml"));
            loader.setController(controller);

            Parent parentPane = loader.load();
            Scene scene = new Scene(parentPane);

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Camping Bumerang: prihlásenie");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}
