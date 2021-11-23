package com.example.importify.Controller;

import animatefx.animation.ZoomIn;
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

        cmbChooseYear.getItems().add(2009);
        cmbChooseYear.getItems().add(2010);
        cmbChooseYear.getItems().add(2011);
        cmbChooseYear.getItems().add(2012);
        cmbChooseYear.getItems().add(2013);
        cmbChooseYear.setOnAction(e -> enableSharePlot());

        cmbChooseCountry2.getItems().add("Italy");
        cmbChooseCountry2.getItems().add("Spain");
        cmbChooseCountry2.getItems().add("Sweden");
        cmbChooseCountry2.getItems().add("Ireland");
        cmbChooseCountry2.getItems().add("Denmark");

        cmbChooseCountry2.setOnAction(e -> enableCommonPlot());
        cmbChooseCountry11.getItems().add("Italy");
        cmbChooseCountry11.getItems().add("Spain");
        cmbChooseCountry11.getItems().add("Sweden");
        cmbChooseCountry11.getItems().add("Ireland");
        cmbChooseCountry11.getItems().add("Denmark");
        cmbChooseCountry11.setOnAction(e -> enableSharePlot());
    }

    private void enableCommonPlot() {
        btnShowCommonCountryTable2.setDisable(false);
    }

    private void enableSharePlot() {
        btnShowCommonCountryTable11.setDisable(false);
    }

    @FXML
    private void showCommonCountryPlot() {
        showCommonPlot();
    }

    @FXML
    private void showShareCountryPlot() {
        showShareDiag();
    }

    void showCommonPlot() {
        new ZoomIn(pnCountryCommonPlot).play();
        pnCountryCommonPlot.toFront();
    }

    void showSharePlot() {
        new ZoomIn(pnCountryImpotyPlot).play();
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
}
