package com.example.importify.Controller;

import animatefx.animation.ZoomIn;
import com.example.importify.Connection.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ConstituentsPlotsController implements Initializable {

    @FXML
    private ConstituentsController controller;

    @FXML
    private Pane pnCatPlots;

    @FXML
    private Pane pnCatWorldShareBase;

    @FXML
    private Pane pnCatWorldSharePrompt;

    @FXML
    private ComboBox<String> cmbChooseCat;

    @FXML
    private Button btnShowCommonCountryTable111;

    @FXML
    private Pane pnCatWorldShare;

    @FXML
    private Button btnBackFromCatWorldShare;

    @FXML
    private Button btnSaveCatWorldShare;

    @FXML
    private AreaChart<?, ?> pltWorldShare;

    @FXML
    private Pane pnCatWorldexportShare;

    @FXML
    private Pane pnCatWorldExportSharePrompt;

    @FXML
    private ComboBox<String> cmbChooseCountry21;

    @FXML
    private Button btnShowCommonCountryTable21;

    @FXML
    private ComboBox<Integer> cmbChooseCountry;

    @FXML
    private Pane pnCatWorldExportShare;

    @FXML
    private Button btnBackFromPlot;

    @FXML
    private Button btnSavePlot;

    @FXML
    private PieChart pltCatExportShare;

    @FXML
    private Pane pnCatWorldImportShare;

    @FXML
    private Pane pnCatWorldimportShare;

    @FXML
    private Button btnBackFromPlot1;

    @FXML
    private Button btnSavePlot1;

    @FXML
    private PieChart pltCatImportShare;

    @FXML
    private Pane pnCatWorldImportSharePrompt1;

    @FXML
    private ComboBox<String> cmbChooseCountry1;

    @FXML
    private Button btnShowDiag;

    @FXML
    private ComboBox<Integer> cmbChooseCountry2;

    public void setSampleController(ConstituentsController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupComboBoxes();
    }

    void showWorldSharePlot() {
        new ZoomIn(pnCatWorldShareBase).play();
        pnCatWorldShareBase.toFront();
    }

    void showWorldExportShare() {
        new ZoomIn(pnCatWorldexportShare).play();
        pnCatWorldexportShare.toFront();
    }

    void showWorldImportShare() {
        new ZoomIn(pnCatWorldImportShare).play();
        pnCatWorldImportShare.toFront();
    }

    private void enableWorldSharePlot() {
       btnShowCommonCountryTable111.setDisable(false);
    }

    private void enableWorldExportSharePlot() {
        if (cmbChooseCountry21.getValue() != "Выберите категорию" && cmbChooseCountry.getValue() != 0) {
            btnShowCommonCountryTable21.setDisable(false);
        }
    }

    private void enableWorldImportSharePlot() {
        if (cmbChooseCountry1.getValue() != "Выберите категорию" && cmbChooseCountry2.getValue() != 0) {
            btnShowDiag.setDisable(false);
        }
    }

    private void setupComboBoxes() {

        ObservableList<Integer> year;
        ObservableList<String> category;
        if (Client.interactionsWithServer != null) {

            category = FXCollections.observableArrayList(Client.interactionsWithServer.getStrings("categories"));
            year = FXCollections.observableArrayList(Client.interactionsWithServer.getYears());
            cmbChooseCountry1.setItems(category);
            cmbChooseCountry2.setItems(year);
            cmbChooseCountry.setItems(year);
            cmbChooseCountry21.setItems(category);
            cmbChooseCat.setItems(category);
            cmbChooseCat.setOnAction(e -> enableWorldSharePlot());
            cmbChooseCountry1.setOnAction(e -> enableWorldImportSharePlot());
            cmbChooseCountry2.setOnAction(e -> enableWorldImportSharePlot());
            cmbChooseCountry.setOnAction(e -> enableWorldExportSharePlot());
            cmbChooseCountry21.setOnAction(e -> enableWorldExportSharePlot());
        }
    }
}
