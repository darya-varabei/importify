package com.example.importify.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import animatefx.animation.ZoomIn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class HelloController {
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
    private Pane pnCountry;

    @FXML
    private Pane pnSettings;

    @FXML
    private Pane pnConstituents;

    @FXML
    private Pane pnUsers;

    public void switchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

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
}