package com.example.importify.Controller;

import animatefx.animation.ZoomIn;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

public class ConstituentsPlotsController {

    @FXML
    private ConstituentsController controller;

    @FXML
    private Pane pnCatPlots;

    @FXML
    private Pane pnCatWorldShareBase;

    @FXML
    private Pane pnCatWorldSharePrompt;

    @FXML
    private ComboBox<?> cmbChooseCat;

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
    private ComboBox<?> cmbChooseCountry21;

    @FXML
    private Button btnShowCommonCountryTable21;

    @FXML
    private ComboBox<?> cmbChooseCountry;

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
    private ComboBox<?> cmbChooseCountry1;

    @FXML
    private Button btnShowDiag;

    @FXML
    private ComboBox<?> cmbChooseCountry2;

    public void setSampleController(ConstituentsController controller) {
        this.controller = controller;
    }

    void showWorldSharePlot() {
        new ZoomIn(pnCatWorldShareBase).play();
        pnCatWorldShareBase.toFront();
    }

    void showWorldexportShare() {
        new ZoomIn(pnCatWorldexportShare).play();
        pnCatWorldexportShare.toFront();
    }

    void showWorldImportShare() {
        new ZoomIn(pnCatWorldImportShare).play();
        pnCatWorldImportShare.toFront();
    }
}
