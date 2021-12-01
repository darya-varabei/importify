package com.example.importify.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import animatefx.animation.ZoomIn;
import com.example.importify.Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HelloController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private AnchorPane anchor;

    @FXML
    private Button btnCountries;

    @FXML
    private Button btnCategories;

    @FXML
    private Button btnUsers;

    @FXML
    private Label lblUsername;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnUpdateData;

    @FXML
    private Pane pnCountry;

    @FXML
    private Pane pnSettings;

    @FXML
    private Pane pnConstituents;

    @FXML
    private Pane pnUpdates;

    @FXML
    private Pane pnUsers;

    private User user = User.getInstance();

    @FXML
    public void showCountryView(ActionEvent event) {

            btnCountries.setUnderline(true);
            btnCountries.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
            btnCategories.setUnderline(false);
            btnCategories.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
            btnUsers.setUnderline(false);
            btnUsers.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");

            new ZoomIn(pnCountry).play();
            pnCountry.toFront();
        btnUsers.toFront();
        btnCountries.toFront();
        btnCategories.toFront();;
        btnSettings.toFront();
    }

    @FXML
    public void showConstituentsView() {

            btnCategories.setUnderline(true);
            btnCategories.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
            btnCountries.setUnderline(false);
            btnCountries.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
            btnUsers.setUnderline(false);
            btnUsers.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");

            new ZoomIn(pnConstituents).play();
            pnConstituents.toFront();
        btnUsers.toFront();
        btnCountries.toFront();
        btnCategories.toFront();;
        btnSettings.toFront();
    }

    @FXML
    public void showUsersView() {

            btnUsers.setUnderline(true);
            btnUsers.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
            btnCategories.setUnderline(false);
            btnCategories.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
            btnCountries.setUnderline(false);
            btnCountries.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");

            new ZoomIn(pnUsers).play();
            pnUsers.toFront();
        btnUsers.toFront();
        btnCountries.toFront();
        btnCategories.toFront();;
        btnSettings.toFront();
    }

    @FXML
    public void showSettingsView() {
        btnUsers.setUnderline(true);
        btnUsers.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
        btnCategories.setUnderline(false);
        btnCategories.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
        btnCountries.setUnderline(false);
        btnCountries.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");

        new ZoomIn(pnSettings).play();
        pnSettings.toFront();
        btnUsers.toFront();
        btnCountries.toFront();
        btnCategories.toFront();
        btnSettings.toFront();
        lblUsername.toFront();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (user.getUserEntry() != null) {
            if (user.getUserEntry().getRole() == "") {

                btnUsers.setDisable(true);
                btnUsers.setVisible(false);
            }
        }
    }

    @FXML
    private void showDataUpdate() {
        if(pnUpdates.isVisible() != true) {
            pnUpdates.setVisible(true);
            pnUpdates.toFront();
            btnUpdateData.toFront();
            btnUpdateData.setText("Закрыть");
        }
        else {
            pnUpdates.setVisible(false);
            pnUpdates.toBack();
            //btnUpdateData.toFront();
            btnUpdateData.setText("Изменить данные");
        }
    }

    public void hideScene(ActionEvent event) {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setIconified(true);
    }

    public void closeScene(ActionEvent event) {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.close();
    }
}