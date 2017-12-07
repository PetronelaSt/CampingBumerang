package camping.design;

import camping.entities.Objednavka;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ObjednavkaEditSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<Objednavka> zoznamObjednavokListView;

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
        // ak bude chciet odstranit objednavku, najskor mu vyhodi okno 
        // s potvrdenim prav, až po overeni hesla vykona akciu odstranenia
        odstranOjednavkuButton.setOnAction((event) -> {
            OvereniePravSceneController controller = new OvereniePravSceneController();
            showOvereniePravWindow(controller);
        });
    }
    
    private void showOvereniePravWindow(OvereniePravSceneController controller) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OvereniePravScene.fxml"));
            loader.setController(controller);
            
            Parent parentPane = loader.load();
            Scene scene = new Scene(parentPane);

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Overenie práv");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}
