package camping.design;

import camping.dao.CampingDaoFactory;
import camping.dao.KategoriaDao;
import camping.dao.PozemokDao;
import camping.entities.Kategoria;
import camping.entities.Pozemok;
import com.mysql.cj.api.xdevapi.Collection;
import com.sun.javafx.scene.control.skin.DatePickerSkin;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

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
    private TableView<PozemokFxModel> pozemkyTableView;

    @FXML
    private TableColumn<PozemokFxModel, Long> cisloPozemkuColumn;

    @FXML
    private TableColumn<PozemokFxModel, Long> kategoriaPozemkuColumn;

    @FXML
    private TableColumn<PozemokFxModel, Integer> cenaPozemkuColumn;

    @FXML
    private TableColumn<PozemokFxModel, Boolean> obsadenostPozemkuColumn;

    @FXML
    private FlowPane pozemkyFlowPane;

    @FXML
    private TextField hladatPozemokTextField;

    @FXML
    private Button hladatPozemokButton;

    @FXML
    private Button vymazatPozemokButton;

    private PozemokFxModel pozemokModel = new PozemokFxModel();
    private ObservableList<PozemokFxModel> pozemky = FXCollections.observableArrayList(pozemokModel.getPozemky());

    @FXML
    void prepnutUzivatelaAction(ActionEvent event) {
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
    }

    @FXML
    void pridatPozemokAction(ActionEvent event) {
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
            //malo by zabezpečiť aby sa okno nedalo zväčšovať
            stage.setResizable(false);
            stage.show();
            stage.setOnHidden(eh -> {
                pridajPozemokButton.getScene().getWindow().hide();
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void vyhladajPodlaObjednavky(ActionEvent event) {
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
            stage.setResizable(false);
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void vyhladajPozemok(ActionEvent event) {
        try {
            PozemokDao pozemokDao = CampingDaoFactory.INSTANCE.getMySqlPozemokDao();
            PozemokFxModel pozemok = pozemokDao.findByCisloPozemku(Long.parseLong(hladatPozemokTextField.getText()));
            System.out.println(pozemok.getCisloPozemku());
            ObservableList<PozemokFxModel> najdenePozemky = FXCollections.observableArrayList();
            System.out.println();
            if (pozemok.getCisloPozemku() != 0) {
                najdenePozemky.add(pozemok);
            }

            if (najdenePozemky.size() < 1) {
                pozemkyTableView.setItems(pozemky);
                JOptionPane.showMessageDialog(null, "Pozemok z číslom " + Long.parseLong(hladatPozemokTextField.getText()) + " neexistuje");
            } else {
                pozemkyTableView.setItems(najdenePozemky);
            }
        } catch (Exception e) {
            System.out.println("Error occurred while getting pozemky information from DB.\n" + e);
            e.printStackTrace();
        }
    }

    @FXML
    void vymazPozemok(ActionEvent event) {
        try {
            int index = pozemkyTableView.getSelectionModel().getSelectedIndex();
            Long vymazat = cisloPozemkuColumn.getCellData(index);
            PozemokDao pozemokDao = CampingDaoFactory.INSTANCE.getMySqlPozemokDao();
            pozemokDao.deletePozemokByCisloPozemku(vymazat);
        } catch (Exception e) {
            System.out.println("Error occurred while getting pozemky information from DB.\n" + e);
            e.printStackTrace();
        }
    }

    @FXML
    private void hladajPozemky(ActionEvent actionEvent) {
        try {
            PozemokDao pozemokDao = CampingDaoFactory.INSTANCE.getMySqlPozemokDao();
            ObservableList<PozemokFxModel> pozemky = FXCollections.observableArrayList(pozemokDao.getAll());
            populateEmployees(pozemky);
        } catch (Exception e) {
            System.out.println("Error occurred while getting pozemky information from DB.\n" + e);
            e.printStackTrace();
        }
    }

    @FXML
    private void populateEmployees(ObservableList<PozemokFxModel> pozemky) throws ClassNotFoundException {
        if (pozemky.size() > 0) {
            pozemkyTableView.setItems(pozemky);
        } else {
            System.out.println("V liste nie su pozemky");
        }

    }

    @FXML
    void initialize() {
        cisloPozemkuColumn.setCellValueFactory(cellData -> cellData.getValue().cisloPozemkuProperty().asObject());
        kategoriaPozemkuColumn.setCellValueFactory(cellData -> cellData.getValue().kategoriaIdProperty().asObject());
        cenaPozemkuColumn.setCellValueFactory(cellData -> cellData.getValue().cenaProperty().asObject());
        obsadenostPozemkuColumn.setCellValueFactory(cellData -> cellData.getValue().obsadenostProperty());
        pozemkyTableView.setItems(pozemky);

        // dynamicke pridavanie Button-ov
        pozemkyFlowPane.setVgap(8);
        pozemkyFlowPane.setHgap(4);
        vytvorPozemok(pozemky);

    }

    private void vytvorPozemok(List<PozemokFxModel> pozemok) {
        if (pozemok.size() > 0) {
            Collections.sort(pozemok, new Comparator<PozemokFxModel>() {
                @Override
                public int compare(PozemokFxModel lp, PozemokFxModel rp) {
                    return (int) (lp.getCisloPozemku() - rp.getCisloPozemku());
                }
            });
            for (PozemokFxModel pozemok1 : pozemok) {
                String cislo = Objects.toString(pozemok1.getCisloPozemku(), null);
                Button button = new Button(cislo);
                button.setMinWidth(30);
                button.setMinHeight(10);
                button.setId("id" + pozemok1.getCisloPozemku() + "Button");
                if (pozemok1.getObsadenost()) {
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
                        //Podľa toho či chceš aby aj toto nebolo zväčšované
                        //stage.setResizable(false);
                        stage.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                pozemkyFlowPane.getChildren().add(button);
            }
        }
    }
}
