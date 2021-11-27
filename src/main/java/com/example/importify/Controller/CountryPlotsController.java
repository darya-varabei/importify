package com.example.importify.Controller;

import animatefx.animation.ZoomIn;
import com.example.importify.Connection.Client;
import com.example.importify.Model.CountryConstituent;
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

public class CountryPlotsController implements Initializable {

    private Client client;

    @FXML
    private CountryController controller;

    @FXML
    private Pane pnCountryPlots;

    @FXML
    private Pane pnExportShareDiag;

    @FXML
    private Pane pnCountryImpotyPlot;

    @FXML
    private Button btnBackFromExportDiag;

    @FXML
    private Button btnSaveCountryExportDiag;

    @FXML
    private PieChart pltCountryExportShare;

    @FXML
    private Pane pnCountryImportPlotPrompt;

    @FXML
    private ComboBox<String> cmbChooseCountry11;

    @FXML
    private Button btnShowCommonCountryTable11;

    @FXML
    private ComboBox<Integer> cmbChooseYear;

    @FXML
    private Pane pnCommonCountryPlot;

    @FXML
    private Pane pnCountryCommonPlot;

    @FXML
    private Button btnBackFromCommonPlot;

    @FXML
    private Button btnSaveCountryCommonPlot;

    @FXML
    private AreaChart<?, ?> countryImportExportPlot;

    @FXML
    private Pane pnCountryCommonPlotPrompt;

    @FXML
    private ComboBox<String> cmbChooseCountry2;

    @FXML
    private Button btnShowCommonCountryTable2;

    public void setSampleController(CountryController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupComboBox();
    }

    private void enableCommonPlot() {
        btnShowCommonCountryTable2.setDisable(false);
    }

    private void enableSharePlot() {
        btnShowCommonCountryTable11.setDisable(false);
    }

    @FXML
    public void showCommonCountryPlot() {
        new ZoomIn(pnCountryCommonPlot).play();
        pnCountryCommonPlot.toFront();
    }

    @FXML
    public void showShareCountryPlot() {
        showShareDiag();
    }

    @FXML
    void showCommonCountryChart() {
        new ZoomIn(pnCountryCommonPlot).play();
        pnCountryCommonPlot.toFront();
    }

    void showCommonPlot() {
       new ZoomIn(pnCommonCountryPlot).play();
        pnCommonCountryPlot.toFront();
    }

    void setupCommonPlot() {

    }

    void setupSharePlot() {

    }

    void setupShareDiag() {

    }

    void showSharePlot() {
        new ZoomIn(pnExportShareDiag).play();
        pnExportShareDiag.toFront();
    }

    void showShareDiag() {
        new ZoomIn(pnCountryImpotyPlot).play();
        pnCountryImpotyPlot.toFront();
    }

    @FXML
    void backFromExportDiag() {
        new ZoomIn(pnCountryImportPlotPrompt).play();
        pnCountryImportPlotPrompt.toFront();
    }

    @FXML
    void backFromCommonPlot() {
        new ZoomIn(pnCountryCommonPlotPrompt).play();
        pnCountryCommonPlotPrompt.toFront();
    }

    private void setupComboBox() {
        ObservableList<String> data;
        ObservableList<Integer> years;
        if (Client.interactionsWithServer != null) {
            data = FXCollections.observableArrayList(Client.interactionsWithServer.getStrings("countries"));
            years = FXCollections.observableArrayList(Client.interactionsWithServer.getYears());
            cmbChooseCountry11.setItems(data);
            cmbChooseCountry2.setItems(data);
            cmbChooseYear.setItems(years);
            cmbChooseYear.setOnAction(e -> enableSharePlot());
            cmbChooseCountry11.setOnAction(e -> enableSharePlot());
            cmbChooseCountry2.setOnAction(e -> enableCommonPlot());
        }
    }
}
