package dizajn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CampingBumerangApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        MainSceneController controller = new MainSceneController();
        FXMLLoader loader = new FXMLLoader(
                // Zatiaľ - ak chceš vidieť ako vyzerajú admin/... prepíš súbor mainScene na AdminScene.fxml atd.
                getClass().getResource("MainScene.fxml"));
        loader.setController(controller);

        Parent parentPane = loader.load();
        Scene scene = new Scene(parentPane);

        stage.setScene(scene);
        stage.setTitle("CampingBumerang");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
