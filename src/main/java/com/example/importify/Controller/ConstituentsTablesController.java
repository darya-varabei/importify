package com.example.importify.Controller;

import animatefx.animation.ZoomIn;
import com.example.importify.Model.CountryImportExport;
import com.example.importify.Model.ExportImportConstituents;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

public class ConstituentsTablesController {

    @FXML
    private ConstituentsController controller;

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

    void showExportTable() {
        new ZoomIn(pnCatExportTable).play();
        pnCatExportTable.toFront();
    }

    void showImportTable() {
        new ZoomIn(pnCatImportTable).play();
        pnCatImportTable.toFront();
    }
}
