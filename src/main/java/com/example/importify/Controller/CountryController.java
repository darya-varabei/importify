package com.example.importify.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class CountryController {

    @FXML
    private Pane pnCountries;

    @FXML
    private Button btnShowCommonTable;

    @FXML
    private Button btnShowCountryCatTable;

    @FXML
    private Button btnShowCommonPlot;

    @FXML
    private Button btnShowShare;

    @FXML
    public void showCommonTablePane() {
        btnShowCommonTable.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
        btnShowCountryCatTable.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
    }

    @FXML
    public void showCountryCatTablePane() {
        btnShowCountryCatTable.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
        btnShowCommonTable.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
    }

    @FXML
    public void showCommonPlotPane() {
        btnShowCommonPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
        btnShowShare.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
    }

    @FXML
    public void showSharePane() {
        btnShowShare.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
        btnShowCommonPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
    }
}
