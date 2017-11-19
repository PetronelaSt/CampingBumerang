package camping.design;

import camping.dao.MySqlPozemokDao;
import camping.dao.PozemokDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CampingBumerangApp extends Application {

    @Override
    public void start(Stage stage) {
        try {
            MainSceneController controller = new MainSceneController();
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("MainScene.fxml"));
            loader.setController(controller);

            Parent parentPane = loader.load();
            Scene scene = new Scene(parentPane);

            stage.setScene(scene);
            stage.setTitle("Camping Bumerang");
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
