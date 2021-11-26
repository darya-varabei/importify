package com.example.importify.Controller;

import animatefx.animation.ZoomIn;
import com.example.importify.Connection.Client;
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
    private TableColumn<CountryConstituent, Integer> year;

    @FXML
    private TableColumn<CountryConstituent, Double> importC;

    @FXML
    private TableColumn<CountryConstituent, Double> export;

    @FXML
    private TableColumn<CountryConstituent, String> categoryColumn;

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

//        cmbChooseCountry1.getItems().add("Italy");
//        cmbChooseCountry1.getItems().add("Spain");
//        cmbChooseCountry1.getItems().add("Sweden");
//        cmbChooseCountry1.getItems().add("Ireland");
//        cmbChooseCountry1.getItems().add("Denmark");
//        cmbChooseCountry1.setOnAction(e -> enableCatPane());
//        cmbChooseCountry.getItems().add("Italy");
//        cmbChooseCountry.getItems().add("Spain");
//        cmbChooseCountry.getItems().add("Sweden");
//        cmbChooseCountry.getItems().add("Ireland");
//        cmbChooseCountry.getItems().add("Denmark");
//        cmbChooseCountry.setOnAction(e -> enableCommonPane());
        setupComboBox();
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
        setupCatTable();
    }

    public void showCatCountryTable() {
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

        ObservableList<CountryImportExport> data;
        data = FXCollections.observableArrayList(Client.interactionsWithServer.getCountryImportExport(cmbChooseCountry.getValue()));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        exportColumn.setCellValueFactory(new PropertyValueFactory<>("exportValue"));
        importColumn.setCellValueFactory(new PropertyValueFactory<>("importValue"));
        netExportColumn.setCellValueFactory(new PropertyValueFactory<>("netExportValue"));
        commonCountryTable.setItems(data);
    }

    public void setupCatTable() {
        ObservableList<CountryConstituent> data;
        data = FXCollections.observableArrayList(Client.interactionsWithServer.getCountryConstituent(cmbChooseCountry1.getValue()));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        export.setCellValueFactory(new PropertyValueFactory<>("exportValue"));
        importC.setCellValueFactory(new PropertyValueFactory<>("importValue"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        commonCountryTable1.setItems(data);
    }

    private void setupComboBox() {
        ObservableList<String> data;
        if (Client.interactionsWithServer != null) {
            data = FXCollections.observableArrayList(Client.interactionsWithServer.getStrings("countries"));
            cmbChooseCountry.setItems(data);
            cmbChooseCountry1.setItems(data);
            cmbChooseCountry.setOnAction(e -> enableCommonPane());
            cmbChooseCountry1.setOnAction(e -> enableCatPane());
        }
    }
}
