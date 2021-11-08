package com.example.importify.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class ConstituentsController {
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

    @FXML
    public void showConstImportTablePane() {
        btnShowConstImportTable.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
        btnShowConstExportTable.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
    }

    @FXML
    public void showConstExportTablePane() {
        btnShowConstExportTable.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
        btnShowConstImportTable.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
    }

    @FXML
    public void showCommonExportPlotPane() {
        btnShowCommonExportPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
        btnShowCountryShareExportPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
        btnShowCountryShareImportPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
    }

    @FXML
    public void showCountryShareExportPane() {
        btnShowCountryShareExportPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
        btnShowCommonExportPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
        btnShowCountryShareImportPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
    }

    @FXML
    public void showCountryShareImportPane() {
        btnShowCountryShareImportPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
        btnShowCountryShareExportPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
        btnShowCommonExportPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
    }
}
