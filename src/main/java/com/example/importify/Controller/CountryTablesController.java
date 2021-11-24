package com.example.importify.Controller;

import animatefx.animation.ZoomIn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class CountryTablesController implements Initializable {

    @FXML
    private CountryController controller;

    @FXML
    private Pane pnCountryTables;

    @FXML
    private Pane pnCatCountryTable;

    @FXML
    private Pane pnCountryCatTable;

    @FXML
    private TableView<?> commonCountryTable1;

    @FXML
    private Button btnBackFromCatTable;

    @FXML
    private Button btnSaveCountryCatTable;

    @FXML
    private Pane pnCountryCatTablePrompt;

    @FXML
    private ComboBox<String> cmbChooseCountry1;

    @FXML
    private Button btnShowCatCountryTable;

    @FXML
    private Pane pnCommonCountryTable;

    @FXML
    private Pane pnCountryCommonTable;

    @FXML
    private TableView<?> commonCountryTable;

    @FXML
    private Button btnBackFromCommonTable;

    @FXML
    private Button btnSaveCountryCommonTable;

    @FXML
    private Pane pnCountryCommonTablePrompt;

    @FXML
    private ComboBox<String> cmbChooseCountry;

    @FXML
    private Button btnShowCommonCountryTable;

    public void setSampleController(CountryController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cmbChooseCountry1.getItems().add("Italy");
        cmbChooseCountry1.getItems().add("Spain");
        cmbChooseCountry1.getItems().add("Sweden");
        cmbChooseCountry1.getItems().add("Ireland");
        cmbChooseCountry1.getItems().add("Denmark");
        cmbChooseCountry1.setOnAction(e -> enableCatPane());
        cmbChooseCountry.getItems().add("Italy");
        cmbChooseCountry.getItems().add("Spain");
        cmbChooseCountry.getItems().add("Sweden");
        cmbChooseCountry.getItems().add("Ireland");
        cmbChooseCountry.getItems().add("Denmark");
        cmbChooseCountry.setOnAction(e -> enableCommonPane());
    }

    private void enableCatPane() {
        btnShowCatCountryTable.setDisable(false);
    }

    private void enableCommonPane() {
        btnShowCommonCountryTable.setDisable(false);
    }

    void showCommonTable() {
        new ZoomIn(pnCommonCountryTable).play();
        pnCommonCountryTable.toFront();
    }

    void showCatTable() {
        new ZoomIn(pnCatCountryTable).play();
        pnCatCountryTable.toFront();
    }

    public void showCatCountryTable(ActionEvent actionEvent) {
        new ZoomIn(pnCountryCatTable).play();
        pnCountryCatTable.toFront();
    }

    public void showCommonCountryTable(ActionEvent actionEvent) {
        new ZoomIn(pnCountryCommonTable).play();
        pnCountryCommonTable.toFront();
    }
}
