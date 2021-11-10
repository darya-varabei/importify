package com.example.importify.Controller;

import animatefx.animation.ZoomIn;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

public class CountryTablesController {

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
    private ComboBox<?> cmbChooseCountry1;

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
    private ComboBox<?> cmbChooseCountry;

    @FXML
    private Button btnShowCommonCountryTable;

    public void setSampleController(CountryController controller) {
        this.controller = controller;
    }

    void showCommonTable() {
        new ZoomIn(pnCommonCountryTable).play();
        pnCommonCountryTable.toFront();
    }

    void showCatTable() {
        new ZoomIn(pnCatCountryTable).play();
        pnCatCountryTable.toFront();
    }
}
