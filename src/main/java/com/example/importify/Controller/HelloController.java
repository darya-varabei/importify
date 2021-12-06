package com.example.importify.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import animatefx.animation.ZoomIn;
import com.example.importify.Connection.Client;
import com.example.importify.Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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

    @FXML
    public void showCountryView(ActionEvent event) {
        btnCountries.setUnderline(true);
        btnCountries.setStyle("-fx-background-color: 0; -fx-text-fill: #354385; -fx-font-size: 18; -fx-font-family: 'SF Compact Text'");
        btnCategories.setUnderline(false);
        btnCategories.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E; -fx-font-size: 18; -fx-font-family: 'SF Compact Text'");
        btnUsers.setUnderline(false);
        btnUsers.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E; -fx-font-size: 18; -fx-font-family: 'SF Compact Text'");

        new ZoomIn(pnCountry).play();
        pnCountry.toFront();
        btnUsers.toFront();
        btnCountries.toFront();
        btnCategories.toFront();
        btnSettings.toFront();
    }

    @FXML
    public void showConstituentsView() {
        btnCategories.setUnderline(true);
        btnCategories.setStyle("-fx-background-color: 0; -fx-text-fill: #354385; -fx-font-size: 18; -fx-font-family: 'SF Compact Text'");
        btnCountries.setUnderline(false);
        btnCountries.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E; -fx-font-size: 18; -fx-font-family: 'SF Compact Text'");
        btnUsers.setUnderline(false);
        btnUsers.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E; -fx-font-size: 18; -fx-font-family: 'SF Compact Text'");

        new ZoomIn(pnConstituents).play();
        pnConstituents.toFront();
        btnUsers.toFront();
        btnCountries.toFront();
        btnCategories.toFront();
        btnSettings.toFront();
    }

    @FXML
    public void showUsersView() {
        btnUsers.setUnderline(true);
        btnUsers.setStyle("-fx-background-color: 0; -fx-text-fill: #354385; -fx-font-size: 18; -fx-font-family: 'SF Compact Text'");
        btnCategories.setUnderline(false);
        btnCategories.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E; -fx-font-size: 18; -fx-font-family: 'SF Compact Text'");
        btnCountries.setUnderline(false);
        btnCountries.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E; -fx-font-size: 18; -fx-font-family: 'SF Compact Text'");

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
        btnUsers.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E; -fx-font-size: 18; -fx-font-family: 'SF Compact Text'");
        btnCategories.setUnderline(false);
        btnCategories.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E; -fx-font-size: 18; -fx-font-family: 'SF Compact Text'");
        btnCountries.setUnderline(false);
        btnCountries.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E; -fx-font-size: 18; -fx-font-family: 'SF Compact Text'");

        new ZoomIn(pnSettings).play();
        pnCountry.setVisible(false);
        pnConstituents.setVisible(false);
        pnUsers.setVisible(false);
        pnSettings.toFront();
        btnUsers.toFront();
        btnCountries.toFront();
        btnCategories.toFront();
        btnSettings.toFront();
        lblUsername.toFront();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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

    public void closeScene(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.close();
        Client.interactionsWithServer.closeConnection();
    }

    public void setupAccess()  {
        var user = User.getInstance();

        if (user.getUserEntry() != null) {
            if (user.getUserEntry().getRole().equals("User")) {

                btnUsers.setDisable(true);
                btnUsers.setVisible(false);
            }
        }
    }

    public void movedConstituentsView(MouseEvent mouseEvent) {
        btnCategories.setUnderline(true);
        btnCategories.setStyle("-fx-background-color: 0; -fx-text-fill: #354385; -fx-font-size: 18; -fx-font-family: 'SF Compact Text'");
        btnCountries.setUnderline(false);
        btnCountries.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E; -fx-font-size: 18; -fx-font-family: 'SF Compact Text'");
        btnUsers.setUnderline(false);
        btnUsers.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E; -fx-font-size: 18; -fx-font-family: 'SF Compact Text'");
    }

    public void exidetConstituentsView(MouseEvent mouseEvent) {
        btnCategories.setUnderline(false);
        btnCategories.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E; -fx-font-size: 18; -fx-font-family: 'SF Compact Text'");
        btnCountries.setUnderline(false);
        btnCountries.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E; -fx-font-size: 18; -fx-font-family: 'SF Compact Text'");
        btnUsers.setUnderline(false);
        btnUsers.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E; -fx-font-size: 18; -fx-font-family: 'SF Compact Text'");
    }

    public void movedCountryView(MouseEvent mouseEvent) {
        btnCategories.setUnderline(false);
        btnCategories.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E; -fx-font-size: 18; -fx-font-family: 'SF Compact Text'");
        btnCountries.setUnderline(true);
        btnCountries.setStyle("-fx-background-color: 0; -fx-text-fill: #354385; -fx-font-size: 18; -fx-font-family: 'SF Compact Text'");
        btnUsers.setUnderline(false);
        btnUsers.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E; -fx-font-size: 18; -fx-font-family: 'SF Compact Text'");
    }

    public void movedUsersView(MouseEvent mouseEvent) {
        btnCategories.setUnderline(false);
        btnCategories.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E; -fx-font-size: 18; -fx-font-family: 'SF Compact Text'");
        btnCountries.setUnderline(false);
        btnCountries.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E; -fx-font-size: 18; -fx-font-family: 'SF Compact Text'");
        btnUsers.setUnderline(true);
        btnUsers.setStyle("-fx-background-color: 0; -fx-text-fill: #354385; -fx-font-size: 18; -fx-font-family: 'SF Compact Text'");
    }
}