package com.example.importify.Controller;

import animatefx.animation.ZoomIn;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class CountryController implements Initializable {

    @FXML private CountryTablesController countryTablesController;
    @FXML private CountryPlotsController countryPlotsController;

    @FXML
    private Pane pnCountries;

    @FXML
    private Pane pnCountryTables;

    @FXML
    private Pane pnCountryPlots;

    @FXML
    private Button btnShowCommonTable;

    @FXML
    private Button btnShowCountryCatTable;

    @FXML
    private Button btnShowCommonPlot;

    @FXML
    private Button btnShowShare;

    public void initialize(URL url, ResourceBundle rb){
        new ZoomIn(pnCountryTables).play();
        pnCountryTables.toFront();
        btnShowCommonPlot.toFront();
        btnShowShare.toFront();
        btnShowCommonTable.toFront();
        btnShowCountryCatTable.toFront();
        countryTablesController.setSampleController(this);
        countryPlotsController.setSampleController(this);
    }

    @FXML
    public void showCommonTablePane() {
        btnShowCommonTable.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
        btnShowCountryCatTable.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
        countryTablesController.showCommonTable();
    }

    @FXML
    public void showCountryCatTablePane() {
        btnShowCountryCatTable.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
        btnShowCommonTable.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
        countryTablesController.showCatTable();
    }

    @FXML
    public void showCommonPlotPane() {
        btnShowCommonPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
        btnShowShare.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
        countryPlotsController.showCommonPlot();
    }

    @FXML
    public void showSharePane() {
        btnShowShare.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
        btnShowCommonPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
        countryPlotsController.showSharePlot();
    }
}
