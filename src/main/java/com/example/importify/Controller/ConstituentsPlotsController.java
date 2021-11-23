package com.example.importify.Controller;

import animatefx.animation.ZoomIn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
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
    private ComboBox<String> cmbChooseCountry2;

    public void setSampleController(ConstituentsController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cmbChooseCat = new ComboBox<>();
        cmbChooseCat.getItems().add("Italy");
        cmbChooseCat.getItems().add("Spain");
        cmbChooseCat.getItems().add("Sweden");
        cmbChooseCat.getItems().add("Ireland");
        cmbChooseCat.getItems().add("Denmark");

        cmbChooseCountry2 = new ComboBox<>();
        cmbChooseCountry2.getItems().add("Italy");
        cmbChooseCountry2.getItems().add("Spain");
        cmbChooseCountry2.getItems().add("Sweden");
        cmbChooseCountry2.getItems().add("Ireland");
        cmbChooseCountry2.getItems().add("Denmark");
//        ObservableList<String> langs = FXCollections.observableArrayList("Java", "JavaScript", "C#", "Python");
//       // ComboBox<String> langsComboBox = new ComboBox<String>(langs);
//        cmbChooseCat.setValue("Java"); // устанавливаем выбранный элемент по умолчанию
//
//        Label lbl = new Label();
//
//        // получаем выбранный элемент
//        cmbChooseCat.setOnAction(event -> lbl.setText(cmbChooseCat.getValue()));
//
//        FlowPane root = new FlowPane(10, 10, cmbChooseCat, lbl);
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
