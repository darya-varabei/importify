package com.example.importify.Controller;

import animatefx.animation.ZoomIn;
import animatefx.animation.ZoomOut;
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
    private Button btnShowCatExportPlot1;

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
    private ComboBox<String> cmbChooseCategory;

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
    private Button btnShowCatExportPlot;

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
        new ZoomIn(pnCategoryExportTablePrompt).play();
        pnCategoryExportTablePrompt.toFront();
    }

    public void backFromImportTable(ActionEvent actionEvent) {
        new ZoomIn(pnCatImportPrompt).play();
        pnCatImportPrompt.toFront();
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
        if (cmbChooseCatWorld.getValue() != "Выбрать страну") {
            btnShowCatExportPlot1.setDisable(false);
        }
        else
        {
            btnShowCatExportPlot1.setDisable(true);
        }
    }

    private void enableWorldExportSharePlot() {
        if (cmbChooseCategory.getValue() != "Выберите категорию" && cmbChooseYear.getValue() != 0) {
            btnShowCatExportPlot.setDisable(false);
        }
        else
        {
            btnShowCatExportPlot.setDisable(true);
        }
    }

    private void enableWorldImportSharePlot() {
        if (cmbChooseCountry1.getValue() != "Выберите категорию" && cmbChooseCountry2.getValue() != 0) {
            btnShowDiag.setDisable(false);
        }
        else
        {
            btnShowDiag.setDisable(true);
        }
    }

    public void showCatExportPlot1(ActionEvent actionEvent) {
        new ZoomIn(pnCatWorldShare).play();
        pnCatWorldShare.toFront();
        setupWorldShare();
    }

    @FXML
    private void showShareDiag() {
        new ZoomIn(pnCatWorldimportShare).play();
        pnCatWorldimportShare.toFront();
        setupImportShare();
    }

    @FXML
    private void showCatExportPlot() {
        new ZoomIn(pnCatWorldExportShare).play();
        pnCatWorldExportShare.toFront();
        setupExportShare();
    }

    private void setupComboBoxes() {
        btnShowCommonCategoryTable.setDisable(true);
        btnShowImportCat.setDisable(true);
        btnShowDiag.setDisable(true);
        btnShowCatExportPlot.setDisable(true);
        btnShowCatExportPlot1.setDisable(true);

        ObservableList<Integer> year;
        ObservableList<String> category;

        ObservableList<String> dataCou;
        ObservableList<String> dataCat;
        Client client = new Client();
        if (Client.interactionsWithServer != null) {

            dataCou = FXCollections.observableArrayList(client.interactionsWithServer.getStrings("countries"));
            category = FXCollections.observableArrayList(Client.interactionsWithServer.getStrings("categories"));
            year = FXCollections.observableArrayList(Client.interactionsWithServer.getYears());
            cmbChooseCountry1.setItems(category);
            cmbChooseCountry2.setItems(year);
            cmbChooseCountry.setItems(category);
            cmbChooseYear.setItems(year);
            cmbChooseCategory.setItems(category);
            //cmbChooseCountry21.setItems(category);

            cmbChooseCat.setItems(category);
//            cmbChooseCat.setOnAction(e -> enableWorldSharePlot());
//            cmbChooseCountry1.setOnAction(e -> enableWorldImportSharePlot());
//            cmbChooseCountry2.setOnAction(e -> enableWorldImportSharePlot());
//            cmbChooseCountry.setOnAction(e -> enableWorldExportSharePlot());

            cmbChooseCatWorld.setOnAction(e -> enableWorldSharePlot());
            cmbChooseCategory.setOnAction(e -> enableWorldExportSharePlot());
            cmbChooseYear.setOnAction(e -> enableWorldExportSharePlot());
            cmbChooseCountry1.setOnAction(e -> enableWorldImportSharePlot());
            cmbChooseCountry2.setOnAction(e -> enableWorldImportSharePlot());

            //cmbChooseCountry21.setOnAction(e -> enableWorldExportSharePlot());

            //cmbChooseCountry.setItems(dataCat);
            //cmbChooseCat.setItems(dataCat);
            cmbChooseCatWorld.setItems(dataCou);
            cmbChooseCountry.setOnAction(e -> enableExportTable());
            cmbChooseCat.setOnAction(e -> enableImportTable());
        }
    }

    @FXML
    private void backFromImportTable() {
        new ZoomIn(pnCatImportPrompt).play();
        pnCatImportPrompt.toFront();
    }

    void showExportTable() {
        new ZoomIn(pnCatExportTable).play();
        pnCatExportTable.toFront();
        //setupExportTable();
    }

    void showImportTable() {
        new ZoomIn(pnCatImportTable).play();
        pnCatImportTable.toFront();
        //setupImportTable();
    }

    void setupImportTable() {

        ObservableList<ExportImportConstituents> data;
        System.out.println("Import table *********************************");
        data = FXCollections.observableArrayList(Client.interactionsWithServer.getConstituent(cmbChooseCat.getValue()));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        importColumn.setCellValueFactory(new PropertyValueFactory<>("importValue"));
         tableCategoryImport.setItems(data);
    }

    void setupExportTable() {

        ObservableList<ExportImportConstituents> data;
        System.out.println("Export table *********************************");
        data = FXCollections.observableArrayList(Client.interactionsWithServer.getConstituent(cmbChooseCountry.getValue()));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        exportColumn.setCellValueFactory(new PropertyValueFactory<>("exportValue"));
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
        data = FXCollections.observableArrayList(Client.interactionsWithServer.getCategoryShare("import", cmbChooseCountry1.getValue(), cmbChooseCountry2.getValue()));
        var pieChartData = new LinkedList<PieChart.Data>();

        data.forEach((category) -> {
                    pieChartData.add(new PieChart.Data(category.getCategory(), category.getValue()));
                }
        );
        pltCatImportShare.setData(FXCollections.observableArrayList(pieChartData));
    }

    void setupExportShare() {
        ObservableList<CategoryShare> data;
        data = FXCollections.observableArrayList(Client.interactionsWithServer.getCategoryShare("export", cmbChooseCategory.getValue(), cmbChooseYear.getValue()));
        var pieChartData = new LinkedList<PieChart.Data>();

        data.forEach((category) -> {
                    pieChartData.add(new PieChart.Data(category.getCategory(), category.getValue()));
                }
        );
        pltCatExportShare.setData(FXCollections.observableArrayList(pieChartData));
    }

    private void enableExportTable() {
        if (cmbChooseCountry.getValue() != "Выбрать категорию") {
            btnShowCommonCategoryTable.setDisable(false);
        }
        else {
            btnShowCommonCategoryTable.setDisable(true);
        }
    }

    private void enableImportTable() {
        if (cmbChooseCat.getValue() != "Выбрать категорию") {
            btnShowImportCat.setDisable(false);
        }
        else {
            btnShowImportCat.setDisable(true);
        }
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

    public void BackFromPlot1(ActionEvent actionEvent) {
        new ZoomIn(pnCatWorldImportSharePrompt1).play();
        pnCatWorldImportSharePrompt1.toFront();
    }

    public void BackFromPlot(ActionEvent actionEvent) {
        new ZoomIn(pnCatWorldExportSharePrompt).play();
        pnCatWorldExportSharePrompt.toFront();
    }

    public void BackFromCatWorldShare(ActionEvent actionEvent) {
        new ZoomIn(pnCatWorldSharePrompt);
        pnCatWorldSharePrompt.toFront();
    }
}
