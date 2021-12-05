package com.example.importify.Controller;

import animatefx.animation.ZoomIn;
import com.example.importify.Connection.Client;
import com.example.importify.Model.CountryConstituent;
import com.example.importify.Model.CountryImportExport;
import com.example.importify.Model.ExportImportConstituents;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class ConstituentsTablesController implements Initializable {

    @FXML
    public ConstituentsController controller;

    @FXML
    private Pane pnCatTables;

    @FXML
    private Pane pnCatExportTable;

    @FXML
    private Pane pnCountryCommonTable1;

    @FXML
    private TableView<ExportImportConstituents> tableCategoryImport;

    @FXML
    private TableColumn<ExportImportConstituents, Integer> yearColumn;

    @FXML
    private TableColumn<ExportImportConstituents, String> countryColumn;

    @FXML
    private TableColumn<ExportImportConstituents, Double> importColumn;

    @FXML
    private Button btnBackFromCatTable;

    @FXML
    private Button btnSaveCatTableImport;

    @FXML
    private Pane pnCatImportPrompt;

    @FXML
    private ComboBox<String> cmbChooseCat;

    @FXML
    private Button btnShowImportCat;

    @FXML
    private Pane pnCatImportTable;

    @FXML
    private Pane pnCategoryExportTable;

    @FXML
    private TableView<ExportImportConstituents> tableCategoryExport;

    @FXML
    private TableColumn<ExportImportConstituents, Integer> year;

    @FXML
    private TableColumn<ExportImportConstituents, String> country;

    @FXML
    private TableColumn<ExportImportConstituents, Double> exportColumn;

    @FXML
    private Button btnBackFromExportTable;

    @FXML
    private Button btnSaveExportTable;

    @FXML
    private Pane pnCategoryExportTablePrompt;

    @FXML
    private ComboBox<String> cmbChooseCountry;

    @FXML
    private Button btnShowCommonCategoryTable;

    public void setSampleController(ConstituentsController controller) {
        this.controller = controller;
    }

    @FXML
    private void backFromImportTable() {
        new ZoomIn(pnCatImportPrompt).play();
        pnCatImportPrompt.toFront();
    }

   @FXML
    private void backFromExportTable() {
        new ZoomIn(pnCategoryExportTablePrompt).play();
        pnCategoryExportTablePrompt.toFront();
    }

    void showExportTable() {
        new ZoomIn(pnCatExportTable).play();
        pnCatExportTable.toFront();
        setupExportTable();
    }

    void showImportTable() {
        new ZoomIn(pnCatImportTable).play();
        pnCatImportTable.toFront();
        setupImportTable();
    }

    void setupImportTable() {

        ObservableList<ExportImportConstituents> data;
        data = FXCollections.observableArrayList(Client.interactionsWithServer.getConstituent(cmbChooseCountry.getValue()));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        importColumn.setCellValueFactory(new PropertyValueFactory<>("importValue"));
        tableCategoryImport.setItems(data);
    }

    void setupExportTable() {

        ObservableList<ExportImportConstituents> data;
        data = FXCollections.observableArrayList(Client.interactionsWithServer.getConstituent(cmbChooseCountry.getValue()));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        country.setCellValueFactory(new PropertyValueFactory<>("country"));
        exportColumn.setCellValueFactory(new PropertyValueFactory<>("exportValue"));
        tableCategoryExport.setItems(data);
    }

    private void enableExportTable() {
        btnShowCommonCategoryTable.setDisable(false);
    }

    private void enableImportTable() {
        btnShowImportCat.setDisable(false);
    }

    private void setupComboBox() {
        ObservableList<String> dataCou;
        ObservableList<String> dataCat;
        //Client client = new Client();
        if (Client.interactionsWithServer != null) {
            dataCou = FXCollections.observableArrayList(Client.interactionsWithServer.getStrings("countries"));
            dataCat = FXCollections.observableArrayList(Client.interactionsWithServer.getStrings("categories"));
            cmbChooseCountry.setItems(dataCou);
            cmbChooseCat.setItems(dataCat);
            cmbChooseCountry.setOnAction(e -> enableExportTable());
            cmbChooseCat.setOnAction(e -> enableImportTable());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupComboBox();
    }
}
