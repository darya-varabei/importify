package com.example.importify.Controller;

import animatefx.animation.ZoomIn;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    private TableView<?> commonCountryTable1;

    @FXML
    private Button btnBackFromCatTable;

    @FXML
    private Button btnSaveCatTableImport;

    @FXML
    private Pane pnCatImportPrompt;

    @FXML
    private ComboBox<?> cmbChooseCat;

    @FXML
    private Button btnShowImportCat;

    @FXML
    private Pane pnCatImportTable;

    @FXML
    private Pane pnCategoryExportTable;

    @FXML
    private TableView<?> tableCategoryExport;

    @FXML
    private Button btnBackFromExportTable;

    @FXML
    private Button btnSaveExportTable;

    @FXML
    private Pane pnCategoryExportTablePrompt;

    @FXML
    private ComboBox<?> cmbChooseCountry;

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
