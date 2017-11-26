package camping.design;

import com.sun.javafx.iio.ImageLoader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ZakaznikSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane zakaznikAnchorPane;

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
    private Button id22Button;

    @FXML
    private Button id21Button;

    @FXML
    private Button id20Button;

    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private Button prepniUzivatelaButton;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

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

        id1Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();

        });
        id2Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();
        });
        id3Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();
        });
        id4Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();
        });
        id5Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();
        });
        id6Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();
        });
        id7Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();
        });
        id8Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();
        });
        id9Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();
        });
        id10Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();
        });
        id11Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();
        });
        id12Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();
        });
        id13Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();
        });
        id14Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();
        });
        id15Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();
        });
        id16Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();
        });
        id17Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();
        });
        id18Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();
        });
        id19Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();
        });
        id20Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();
        });
        id21Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();
        });
        id22Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();
        });
        id23Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();
        });
        id24Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();
        });
        id25Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();
        });
        id26Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();
        });
        id27Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();
        });
        id28Button.setOnAction(eh -> {
            Stage stage = new Stage();

            Image foto = new Image("camping\\styles\\PozadieMainScene.jpg");
            ImageView view = new ImageView(foto);
            StackPane sp = new StackPane();
            sp.getChildren().add(view);

            Image logo = new Image("camping\\styles\\logo.png");
            Scene scene = new Scene(sp);
            stage.setScene(scene);
            stage.getIcons().add(logo);
            stage.setMaxHeight(700);
            stage.setMaxWidth(900);
            stage.centerOnScreen();
            stage.show();
        });

    }
}
