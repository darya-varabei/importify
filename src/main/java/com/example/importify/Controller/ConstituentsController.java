package com.example.importify.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ConstituentsController {
    @FXML private ConstituentsTablesController constituentsTablesController;
    @FXML private ConstituentsPlotsController constituentsPlotsController;

    @FXML
    private Pane pnCategories;

    @FXML
    private Button btnShowConstImportTable;

    @FXML
    private Button btnShowConstExportTable;

    @FXML
    private Button btnShowCommonExportPlot;

    @FXML
    private Button btnShowCountryShareExportPlot;

    @FXML
    private Button btnShowCountryShareImportPlot;

    public void initialize(URL url, ResourceBundle rb){
        constituentsTablesController.setSampleController(this);
        constituentsPlotsController.setSampleController(this);
    }

    @FXML
    public void showConstImportTablePane() {
        btnShowConstImportTable.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
        btnShowConstExportTable.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
        constituentsTablesController.showImportTable();
    }

    @FXML
    public void showConstExportTablePane() {
        btnShowConstExportTable.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
        btnShowConstImportTable.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
        constituentsTablesController.showExportTable();
    }

    @FXML
    public void showCommonExportPlotPane() {
        btnShowCommonExportPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
        btnShowCountryShareExportPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
        btnShowCountryShareImportPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
        constituentsPlotsController.showWorldSharePlot();
    }

    @FXML
    public void showCountryShareExportPane() {
        btnShowCountryShareExportPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
        btnShowCommonExportPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
        btnShowCountryShareImportPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
        constituentsPlotsController.showWorldexportShare();
    }

    @FXML
    public void showCountryShareImportPane() {
        btnShowCountryShareImportPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
        btnShowCountryShareExportPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
        btnShowCommonExportPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
        constituentsPlotsController.showWorldImportShare();
    }
}
