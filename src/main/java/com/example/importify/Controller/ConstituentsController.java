package com.example.importify.Controller;

import animatefx.animation.ZoomIn;
import com.example.importify.Connection.Client;
import com.example.importify.Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class ConstituentsController implements Initializable {

    @FXML
    private Pane pnCategories;

    @FXML
    private Button btnShowConstImportTable;

    @FXML
    private Button btnShowConstExportTable;

    @FXML
    private Button btnShowCommonExportPlot;

    @FXML
    private Button btnShowCountryShareExportPlot;

    @FXML
    private Button btnShowCountryShareImportPlot;

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

    @FXML
    private Pane pnCatWorldShareBase;

    @FXML
    private Pane pnCatWorldSharePrompt;

    @FXML
    private ComboBox<String> cmbChooseCatWorld;

    @FXML
    private Button btnShowCommonCountryTable111;

    @FXML
    private Pane pnCatWorldShare;

    @FXML
    private Button btnBackFromCatWorldShare;

    @FXML
    private Button btnSaveCatWorldShare;

    @FXML
    private AreaChart<WorldShare, ?> pltWorldShare;

    @FXML
    private Pane pnCatWorldexportShare;

    @FXML
    private Pane pnCatWorldExportSharePrompt;

    @FXML
    private ComboBox<String> cmbChooseCountry21;

    @FXML
    private Button btnShowCommonCountryTable21;

    @FXML
    private ComboBox<Integer> cmbChooseYear;

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
    private Pane pnCatImportTableView;

    @FXML
    private ComboBox<String> cmbChooseCountry1;

    @FXML
    private Button btnShowDiag;

    @FXML
    private ComboBox<Integer> cmbChooseCountry2;

    private Boolean flag = false;

    public void setupData() {
        if (flag == false) {
            setupComboBoxes();
        }

    }

    public void initialize(URL url, ResourceBundle rb){

    }

    @FXML
    public void showConstImportTablePane() {
        btnShowConstImportTable.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
        btnShowConstExportTable.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
        showImportTable();
    }

    @FXML
    public void showConstExportTablePane() {
        btnShowConstExportTable.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
        btnShowConstImportTable.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
        showExportTable();
    }

    @FXML
    public void showCommonExportPlotPane() {
        btnShowCommonExportPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
        btnShowCountryShareExportPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
        btnShowCountryShareImportPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
        showWorldSharePlot();
    }

    @FXML
    public void showCountryShareExportPane() {
        btnShowCountryShareExportPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
        btnShowCommonExportPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
        btnShowCountryShareImportPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
        showWorldExportShare();
    }

    @FXML
    public void showCountryShareImportPane() {
        btnShowCountryShareImportPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
        btnShowCountryShareExportPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
        btnShowCommonExportPlot.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
            showWorldImportShare();
    }

    public void backFromExportTable(ActionEvent actionEvent) {
    }

    public void backFromImportTable(ActionEvent actionEvent) {
    }

    void showWorldSharePlot() {
        new ZoomIn(pnCatWorldShareBase).play();
        pnCatWorldShareBase.toFront();
    }

    void showWorldExportShare() {
        new ZoomIn(pnCatWorldexportShare).play();
        pnCatWorldexportShare.toFront();
    }

    void showWorldImportShare() {
        new ZoomIn(pnCatWorldImportShare).play();
        pnCatWorldImportShare.toFront();
    }

    private void enableWorldSharePlot() {
        btnShowCommonCountryTable111.setDisable(false);
    }

    private void enableWorldExportSharePlot() {
        if (cmbChooseCountry21.getValue() != "Выберите категорию" && cmbChooseCatWorld.getValue() != "Выберите категорию") {
            btnShowCommonCountryTable21.setDisable(false);
        }
    }

    private void enableWorldImportSharePlot() {
        if (cmbChooseCountry1.getValue() != "Выберите категорию" && cmbChooseCountry2.getValue() != 0) {
            btnShowDiag.setDisable(false);
        }
    }

    @FXML private void showShareDiag() {
        new ZoomIn(pnCatWorldImportShare).play();
        pnCatWorldImportShare.toFront();
    }

    @FXML private void showCatExportPlot() {
        new ZoomIn(pnCatWorldShare).play();
        pnCatWorldShare.toFront();
    }

    private void setupComboBoxes() {
        btnShowDiag.setDisable(false);
        btnShowCommonCountryTable21.setDisable(false);
        btnShowCommonCountryTable111.setDisable(false);
        btnShowCommonCategoryTable.setDisable(false);
        btnShowImportCat.setDisable(false);
        ObservableList<Integer> year;
        ObservableList<String> category;

        ObservableList<String> dataCou;
        ObservableList<String> dataCat;
        Client client = new Client();
        if (Client.interactionsWithServer != null) {

            category = FXCollections.observableArrayList(Client.interactionsWithServer.getStrings("categories"));
            year = FXCollections.observableArrayList(Client.interactionsWithServer.getYears());
            cmbChooseCountry1.setItems(category);
            cmbChooseCountry2.setItems(year);
            cmbChooseYear.setItems(year);
            cmbChooseCountry21.setItems(category);
            cmbChooseCat.setItems(category);
            cmbChooseCat.setOnAction(e -> enableWorldSharePlot());
            cmbChooseCountry1.setOnAction(e -> enableWorldImportSharePlot());
            cmbChooseCountry2.setOnAction(e -> enableWorldImportSharePlot());
            cmbChooseCountry.setOnAction(e -> enableWorldExportSharePlot());
            cmbChooseCountry21.setOnAction(e -> enableWorldExportSharePlot());

            dataCou = FXCollections.observableArrayList(client.interactionsWithServer.getStrings("countries"));
            dataCat = FXCollections.observableArrayList(client.interactionsWithServer.getStrings("categories"));
            cmbChooseCountry.setItems(dataCou);
            cmbChooseCat.setItems(dataCat);
            cmbChooseCountry.setOnAction(e -> enableExportTable());
            cmbChooseCat.setOnAction(e -> enableImportTable());
        }
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
        System.out.println("Import table *********************************");
        data = FXCollections.observableArrayList(Client.interactionsWithServer.getConstituent(cmbChooseCountry.getValue()));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        importColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
         tableCategoryImport.setItems(data);
    }

    void setupExportTable() {

        ObservableList<ExportImportConstituents> data;
        System.out.println("Export table *********************************");
        data = FXCollections.observableArrayList(Client.interactionsWithServer.getConstituent(cmbChooseCountry.getValue()));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        exportColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        country.setCellValueFactory(new PropertyValueFactory<>("country"));
        tableCategoryExport.setItems(data);
    }

    void setupWorldShare() {
        pltWorldShare.getData().removeAll(pltWorldShare.getData());

        ObservableList<WorldConstituentExport> data;
        data = FXCollections.observableArrayList(Client.interactionsWithServer.getWorldConstituentExport(cmbChooseCatWorld.getValue()));
        XYChart.Series seriesImport = new XYChart.Series();

        seriesImport.setName("Import");

        data.forEach((year) -> {
            seriesImport.getData().add(new XYChart.Data(String.valueOf(year.getYear()), year.getValue()));
        });

        pltWorldShare.getData().addAll(seriesImport);
    }

    void setupImportShare() {
        ObservableList<CategoryShare> data;
        data = FXCollections.observableArrayList(Client.interactionsWithServer.getCategoryShare("import", cmbChooseCountry21.getValue(), cmbChooseYear.getValue()));
        var pieChartData = new LinkedList<PieChart.Data>();

        data.forEach((category) -> {
                    pieChartData.add(new PieChart.Data(category.getCategory(), category.getValue()));
                }
        );
        pltCatImportShare.setData(FXCollections.observableArrayList(pieChartData));
    }

    void setupExportShare() {
        ObservableList<CategoryShare> data;
        data = FXCollections.observableArrayList(Client.interactionsWithServer.getCategoryShare("export", cmbChooseCountry21.getValue(), cmbChooseYear.getValue()));
        var pieChartData = new LinkedList<PieChart.Data>();

        data.forEach((category) -> {
                    pieChartData.add(new PieChart.Data(category.getCategory(), category.getValue()));
                }
        );
        pltCatExportShare.setData(FXCollections.observableArrayList(pieChartData));
    }

    private void enableExportTable() {
        btnShowCommonCategoryTable.setDisable(false);
    }

    private void enableImportTable() {
        btnShowImportCat.setDisable(false);
    }

    @FXML private void showExportTablePane() {
        setupExportTable();
        new ZoomIn(pnCategoryExportTable).play();
        pnCategoryExportTable.toFront();
    }

    @FXML private void showImportTablePane() {
        setupImportTable();
        new ZoomIn(pnCatImportTableView).play();
        pnCatImportTableView.toFront();
    }
}
