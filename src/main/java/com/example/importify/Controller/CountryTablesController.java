package com.example.importify.Controller;

import animatefx.animation.ZoomIn;
import com.example.importify.Connection.Client;
import com.example.importify.Connection.ServerManager;
import com.example.importify.Model.CountryAdd;
import com.example.importify.Model.CountryConstituent;
import com.example.importify.Model.CountryImportExport;
import com.example.importify.Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.io.*;
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
    private ComboBox<Integer> cmbChooseYearToUpdate;

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
        var user = User.getInstance();

        setupComboBox();
        if (user != null) {
            if (user.getUserEntry().getRole() == "User") {
                btnAddData.setDisable(true);
                btnAddData.setVisible(false);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

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

    ObservableList<CountryImportExport> data;
    public void setupCommonTable() {
        yearColumn.setCellValueFactory(new PropertyValueFactory<CountryImportExport, Integer>("year"));
        importColumn.setCellValueFactory(new PropertyValueFactory<CountryImportExport, Double>("importValue"));
        exportColumn.setCellValueFactory(new PropertyValueFactory<CountryImportExport, Double>("exportValue"));
        netExportColumn.setCellValueFactory(new PropertyValueFactory<CountryImportExport, Double>("netExportValue"));
        data = FXCollections.observableArrayList(Client.interactionsWithServer.getCountryImportExport(cmbChooseCountry.getValue()));
        commonCountryTable.setItems(data);
    }

    ObservableList<CountryConstituent> catData;
    public void setupCatTable() {
        catData = FXCollections.observableArrayList(Client.interactionsWithServer.getCountryConstituent(cmbChooseCountry1.getValue()));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        export.setCellValueFactory(new PropertyValueFactory<>("value"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("constituent"));
        commonCountryTable1.setItems(catData);
    }

    private void setupComboBox() {
        ObservableList<String> data;
        ObservableList<Integer> years;
        if (Client.interactionsWithServer != null) {
        serverManager = client.interactionsWithServer;
            data = FXCollections.observableArrayList(serverManager.getStrings("countries"));
            years = FXCollections.observableArrayList(serverManager.getYears());
            cmbChooseCountry.setItems(data);
            cmbChooseCountryToUpdate.setItems(data);
            cmbChooseCountry1.setItems(data);
            cmbChooseYearToUpdate.setItems(years);
            cmbChooseYearToUpdate.setDisable(false);
            cmbChooseCountry.setOnAction(e -> enableCommonPane());
            cmbChooseCountry1.setOnAction(e -> enableCatPane());
        }
    }

    public void addData() {
        if (txtNewCountry.getText() != "" && txtImport.getText() != "" && txtExport.getText() != "") {
            CountryAdd dataAdd = new CountryAdd(txtNewCountry.getText(), cmbChooseYearToUpdate.getValue(), Double.parseDouble(txtImport.getText()), Double.parseDouble(txtExport.getText()), Double.parseDouble(txtExport.getText()) - Double.parseDouble(txtImport.getText()));
        Client.interactionsWithServer.sendData("addCountry", dataAdd);
            lblInvalidInput.setVisible(false);
    }
        else {
            lblInvalidInput.setVisible(true);
        }
    }

    public void updateData() {
        if (cmbChooseCountryToUpdate.getValue() != "Выберите страну" && txtImport.getText() != "" && txtExport.getText() != "") {
        CountryAdd data = new CountryAdd(cmbChooseCountryToUpdate.getValue(), cmbChooseYearToUpdate.getValue(), Double.parseDouble(txtImport.getText()), Double.parseDouble(txtExport.getText()), Double.parseDouble(txtExport.getText()) - Double.parseDouble(txtImport.getText()));
        Client.interactionsWithServer.sendData("editCountry", data);
            lblInvalidInput.setVisible(false);
        }
        else {
            lblInvalidInput.setVisible(true);
        }
    }

    public void deleteData() {
        if (cmbChooseCountryToUpdate.getValue() != "Выберите страну" && txtImport.getText() != "" && txtExport.getText() != "") {
            CountryAdd data = new CountryAdd(cmbChooseCountryToUpdate.getValue(), cmbChooseYearToUpdate.getValue(), Double.parseDouble(txtImport.getText()), Double.parseDouble(txtExport.getText()), Double.parseDouble(txtExport.getText()) - Double.parseDouble(txtImport.getText()));
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

    public void saveCountryCatTable(ActionEvent actionEvent) throws Exception {
        Writer writer = null;
        try {
            File file = new File("D:\\CountryCategory.csv");
            writer = new BufferedWriter(new FileWriter(file));
            Writer finalWriter = writer;
            catData.forEach((category) -> {
                String text = category.getYear() + "," + category.getConstituent() + "," + category.getValue() + "\n";
                try {
                    finalWriter.write(text);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            writer.flush();
            writer.close();
        }
    }

    public void saveCountryCommonTable() throws Exception {
        Writer writer = null;
        try {
            File file = new File("D:\\CountryImportExport.csv");
            writer = new BufferedWriter(new FileWriter(file));
            Writer finalWriter = writer;
            data.forEach((country) -> {
                String text = country.getYear() + "," + country.getImportValue() + "," + country.getExportValue() + "," + country.getNetExportValue() + "\n";
                try {
                    finalWriter.write(text);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            writer.flush();
            writer.close();
        }
    }
}
