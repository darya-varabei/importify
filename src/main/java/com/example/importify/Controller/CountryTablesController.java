package com.example.importify.Controller;

import animatefx.animation.ZoomIn;
import com.example.importify.Connection.Client;
import com.example.importify.Connection.ServerManager;
import com.example.importify.Model.CountryAdd;
import com.example.importify.Model.CountryConstituent;
import com.example.importify.Model.CountryImportExport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class CountryTablesController implements Initializable {

    private Client client = new Client();

    @FXML
    private CountryController controller;

    @FXML
    private Pane pnCountryTables;

    @FXML
    private ComboBox<String> cmbChooseCountryToUpdate;

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

//    @FXML
//    private TableColumn<CountryConstituent, Double> importC;

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
    private Button btnShowAddData;

    @FXML
    private Button btnShowUpdateData;

    @FXML
    private Pane pnCountryCommonTablePrompt;

    @FXML
    private Pane pnAddCommonData;

    @FXML
    private ComboBox<String> cmbChooseCountry;

    @FXML
    private Button btnShowCommonCountryTable;

//    @FXML
//    private AnchorPane pnAddCommonData;

    @FXML
    private TextField txtNewCountry;

    @FXML
    private TextField txtImport;

    @FXML
    private TextField txtExport;

    @FXML
    private Label lblActivity;

    @FXML
    private Button btnAddData;

    @FXML
    private Button btnUpdateData;

    @FXML
    private Button btnDeleteData;

    @FXML
    private Label lblInvalidInput;

    @FXML
    private Button btnClearData;

    private ServerManager serverManager = null;

    public void setSampleController(CountryController controller) {
        this.controller = controller;
    }

    @FXML
    private void setupData() {
        setupComboBox();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        setupComboBox();
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

    public void showCatCountryTable() {
        new ZoomIn(pnCountryCatTable).play();
        pnCountryCatTable.toFront();
        setupCatTable();
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
        export.setCellValueFactory(new PropertyValueFactory<>("value"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("constituent"));
        commonCountryTable1.setItems(data);
    }

    private void setupComboBox() {
        ObservableList<String> data;
        if (Client.interactionsWithServer != null) {
        serverManager = client.interactionsWithServer;
            data = FXCollections.observableArrayList(serverManager.getStrings("countries"));
            cmbChooseCountry.setItems(data);
            cmbChooseCountryToUpdate.setItems(data);
            cmbChooseCountry1.setItems(data);
            cmbChooseCountry.setOnAction(e -> enableCommonPane());
            cmbChooseCountry1.setOnAction(e -> enableCatPane());
        }
    }

    public void addData() {
        if (txtNewCountry.getText() != "" && txtImport.getText() != "" && txtExport.getText() != "") {
            CountryAdd data = new CountryAdd(txtNewCountry.getText(), Double.parseDouble(txtImport.getText()), Double.parseDouble(txtExport.getText()), Double.parseDouble(txtExport.getText()) - Double.parseDouble(txtImport.getText()));
        Client.interactionsWithServer.sendData("addCountry", data);
            lblInvalidInput.setVisible(false);
    }
        else {
            lblInvalidInput.setVisible(true);
        }
    }

    public void updateData() {
        if (cmbChooseCountryToUpdate.getValue() != "Выберите страну" && txtImport.getText() != "" && txtExport.getText() != "") {
        CountryAdd data = new CountryAdd(cmbChooseCountryToUpdate.getValue(), Double.parseDouble(txtImport.getText()), Double.parseDouble(txtExport.getText()), Double.parseDouble(txtExport.getText()) - Double.parseDouble(txtImport.getText()));
        Client.interactionsWithServer.sendData("editCountry", data);
            lblInvalidInput.setVisible(false);
        }
        else {
            lblInvalidInput.setVisible(true);
        }
    }

    public void deleteData() {
        if (cmbChooseCountryToUpdate.getValue() != "Выберите страну" && txtImport.getText() != "" && txtExport.getText() != "") {
            CountryAdd data = new CountryAdd(cmbChooseCountryToUpdate.getValue(), Double.parseDouble(txtImport.getText()), Double.parseDouble(txtExport.getText()), Double.parseDouble(txtExport.getText()) - Double.parseDouble(txtImport.getText()));
            Client.interactionsWithServer.sendData("deleteCountry", data);
            lblInvalidInput.setVisible(false);
        }
        else {
            lblInvalidInput.setVisible(true);
        }
    }

    public void showUpdateCommonData() {
        new ZoomIn(pnAddCommonData).play();
        pnAddCommonData.toFront();
    }

    public void showAddData() {
        txtNewCountry.toFront();
        txtNewCountry.setVisible(true);
        btnShowAddData.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
        btnShowUpdateData.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
        btnAddData.setDisable(false);
        btnUpdateData.setDisable(true);
        btnDeleteData.setDisable(true);
    }

    public void showUpdateData() {
        cmbChooseCountryToUpdate.toFront();
        txtNewCountry.setVisible(false);
        btnShowUpdateData.setStyle("-fx-background-color: 0; -fx-text-fill: #354385");
        btnShowAddData.setStyle("-fx-background-color: 0; -fx-text-fill: #72778E");
        btnAddData.setDisable(true);
        btnUpdateData.setDisable(false);
        btnDeleteData.setDisable(false);
    }
}
