package com.example.importify.Controller;

import animatefx.animation.ZoomIn;
import com.example.importify.Model.CountryConstituent;
import com.example.importify.Model.CountryImportExport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableColumn<CountryImportExport, Integer> yearColumn;

    @FXML
    private TableColumn<CountryImportExport, Double> importColumn;

    @FXML
    private TableColumn<CountryImportExport, Double> exportColumn;

    @FXML
    private TableColumn<CountryImportExport, Double> netExportColumn;

    @FXML
    private TableView<CountryConstituent> commonCountryTable1;

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
    private TableView<CountryImportExport> commonCountryTable;

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

    private final ObservableList<CountryImportExport> dataList = FXCollections.observableArrayList();
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
        setupCommonTable();
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
        setupCommonTable();
    }

    public void backFromCommonTable(ActionEvent actionEvent) {
        new ZoomIn(pnCountryCommonTablePrompt).play();
        pnCountryCommonTablePrompt.toFront();
    }

    public void backFromCatTable(ActionEvent actionEvent) {
        new ZoomIn(pnCountryCatTablePrompt).play();
        pnCountryCatTablePrompt.toFront();
    }

    public void setupCommonTable() {
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        exportColumn.setCellValueFactory(new PropertyValueFactory<>("exportValue"));
        importColumn.setCellValueFactory(new PropertyValueFactory<>("importValue"));
        netExportColumn.setCellValueFactory(new PropertyValueFactory<>("netExportValue"));

        CountryImportExport case1 = new CountryImportExport(2009, 342.43, 2009.0, 12456.9);
        CountryImportExport case2 = new CountryImportExport(2010, 243.5, 2009.5, 12456.9);
        CountryImportExport case3 = new CountryImportExport(2011, 2434.5, 2009.3, 12456.9);
        CountryImportExport case4 = new CountryImportExport(2012, 563.5, 2009.6, 12456.9);
        CountryImportExport case5 = new CountryImportExport(2013, 2567.6, 2009.2, 12456.9);
        dataList.addAll(case1, case2, case3, case4, case5);
        commonCountryTable.setItems(dataList);
    }

    public void setupCatTable() {
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        exportColumn.setCellValueFactory(new PropertyValueFactory<>("exportValue"));
        importColumn.setCellValueFactory(new PropertyValueFactory<>("importValue"));
        netExportColumn.setCellValueFactory(new PropertyValueFactory<>("netExportValue"));

        CountryImportExport case1 = new CountryImportExport(2009, 342.43, 2009.0, 12456.9);
        CountryImportExport case2 = new CountryImportExport(2010, 243.5, 2009.5, 12456.9);
        CountryImportExport case3 = new CountryImportExport(2011, 2434.5, 2009.3, 12456.9);
        CountryImportExport case4 = new CountryImportExport(2012, 563.5, 2009.6, 12456.9);
        CountryImportExport case5 = new CountryImportExport(2013, 2567.6, 2009.2, 12456.9);
        dataList.addAll(case1, case2, case3, case4, case5);
        commonCountryTable.setItems(dataList);
    }
}
