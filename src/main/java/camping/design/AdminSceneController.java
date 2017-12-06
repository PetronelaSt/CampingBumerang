package camping.design;

import camping.entities.Pozemok;
import com.sun.javafx.scene.control.skin.DatePickerSkin;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AdminSceneController {

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private Button spravujFinancieButton;

    @FXML
    private Button spravujObjednavkyButton;

    @FXML
    private Button zrusObjednavkuButton;

    @FXML
    private Button prepniUzivatelaButton;

    @FXML
    private Button pridajPozemokButton;

    @FXML
    private Button vyhladajPozemokButton;

    @FXML
    private ListView<Pozemok> pozemkyListView;
//    @FXML
//    private TableView<PozemokFxModel> pozemkyTableView;
//
//    @FXML
//    private TableColumn<PozemokFxModel, Long> cisloPozemkuColumn;
//
//    @FXML
//    private TableColumn<PozemokFxModel, Kategoria> kategoriaPozemkuColumn;
//
//    @FXML
//    private TableColumn<PozemokFxModel, Integer> cenaPozemkuColumn;
//
//    @FXML
//    private TableColumn<PozemokFxModel, Boolean> obsadenostPozemkuColumn;

    @FXML
    private HBox pozemkyHBox;

    private PozemokFxModel pozemokModel = new PozemokFxModel();
    private ObservableList<Pozemok> vsetkyPozemky = pozemokModel.getPozemky();

    public AdminSceneController() {

    }

    @FXML
    void initialize() {

        prepniUzivatelaButton.setOnAction(eh -> {
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("MainScene.fxml"));
                Parent parentPane = loader.load();
                Scene scene = new Scene(parentPane);

                Stage stage = new Stage();
                Image logo = new Image("camping\\styles\\logo.png");
                stage.setScene(scene);
                stage.setTitle("Camping Bumerang");
                stage.getIcons().add(logo);
                prepniUzivatelaButton.getScene().getWindow().hide();
                stage.show();

            } catch (IOException ex) {
                Logger.getLogger(ZakaznikSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        if (pozemokModel.getPozemky().size() > 0) {
            pozemkyListView.setItems(pozemokModel.getPozemky());
            pozemkyListView.setEditable(true);

        }

        vyhladajPozemokButton.setOnAction(eh -> {
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("VyhladatPozemokPodlaKriteriaScene.fxml"));
                Parent parentPane = loader.load();
                Scene scene = new Scene(parentPane);

                Stage stage = new Stage();
                Image logo = new Image("camping\\styles\\logo.png");
                stage.setScene(scene);
                stage.setTitle("Camping Bumerang");
                stage.getIcons().add(logo);
                stage.show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        pridajPozemokButton.setOnAction(eh -> {
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("PridatPozemokScene.fxml"));
                Parent parentPane = loader.load();
                Scene scene = new Scene(parentPane);

                Stage stage = new Stage();
                Image logo = new Image("camping\\styles\\logo.png");
                stage.setScene(scene);
                stage.setTitle("Camping Bumerang");
                stage.getIcons().add(logo);
                stage.show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // dynamicke pridavanie Button-ov
        pozemkyHBox.setSpacing(10);
        vytvorPozemok(vsetkyPozemky);

    }

    private void vytvorPozemok(List<Pozemok> pozemok) {
        if (pozemok.size() > 0) {
            for (Pozemok pozemok1 : pozemok) {
                String cislo = Objects.toString(pozemok1.getCisloPozemku(), null);
                Button button = new Button(cislo);
                button.setMinWidth(30);
                button.setMinHeight(10);
                button.setId("id" + pozemok1.getCisloPozemku() + "Button");
                if (pozemok1.isObsadenost()) {
                    button.setStyle("-fx-background-color: #04B404;");
                } else {
                    button.setStyle("-fx-background-color: #FF0000;");
                }
                button.setOnAction(eh -> {
                    try {
                        BorderPane root = new BorderPane();
                        Scene scene = new Scene(root, 400, 210);

                        DatePickerSkin datePickerSkin = new DatePickerSkin(new DatePicker(LocalDate.now()));
                        Node popupContent = datePickerSkin.getPopupContent();

                        root.setCenter(popupContent);

                        Stage stage = new Stage();
                        Image logo = new Image("camping\\styles\\logo.png");
                        stage.setTitle("Camping Bumerang");
                        stage.getIcons().add(logo);

                        stage.setScene(scene);
                        stage.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                pozemkyHBox.getChildren().add(button);
            }
        }
    }
}
