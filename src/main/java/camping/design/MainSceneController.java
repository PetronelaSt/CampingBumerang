package camping.design;

import camping.dao.HesloDao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MainSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox vBoxPane;

    @FXML
    private AnchorPane parentPane;

    @FXML
    private Label hesloLabel;

    @FXML
    private PasswordField hesloPouzivatelaPasswordField;

    @FXML
    private Button OKButton;

    @FXML
    private Button bossButton;

    @FXML
    private Button userButton;

    @FXML
    private Button customerButton;

    @FXML
    private Label typUseraLabel;

    private String uzivatel;
    private HesloDao hesla = camping.dao.CampingDaoFactory.INSTANCE.getMySqlHesloDao();
    
    @FXML
    void initialize() {

        bossButton.setOnAction(eh -> {
            typUseraLabel.setText("Zadajte heslo administratora");
            System.out.println(hesla.getHeslo("Administrator"));

        });
        
        
        userButton.setOnAction(eh -> {
            typUseraLabel.setText("Zadajte heslo zamestnanca");

        });

        customerButton.setOnAction(eh -> {
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("ZakaznikScene.fxml"));
                Parent parentPane = loader.load();
                Scene scene = new Scene(parentPane);

                Stage stage = new Stage();
                Image logo = new Image("camping\\styles\\logo.png");
                stage.setScene(scene);
                stage.setTitle("Camping Bumerang");
                stage.getIcons().add(logo);
                customerButton.getScene().getWindow().hide();
                stage.show();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}
