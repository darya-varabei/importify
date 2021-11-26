package com.example.importify.Controller;

import com.example.importify.Model.CountryImportExport;
import com.example.importify.Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class UsersController implements Initializable {
    @FXML
    private Pane pnUsers;

    @FXML
    private TableColumn<User, Integer> idColumn;

    @FXML
    private TableColumn<User, String> loginColumn;

    @FXML
    private TableColumn<User, Date> lastAccessColumn;

    @FXML
    private TableColumn<User, String> countryColumn;

    @FXML
    private TableColumn<User, String> roleColumn;

    @FXML
    private TableView<User> tableUsers;

    @FXML
    private Button btnAddUsers;

    @FXML
    private Button btnUpdateUser;

    @FXML
    private Button btnDeleteUser;

    @FXML
    private TextField fieldUsername;

    @FXML
    private TextField fieldEmail;

    @FXML
    private PasswordField fieldPassword;

    @FXML
    private ComboBox<String> cmbRole;

    @FXML
    private ComboBox<String> cmbCountry;

    @FXML
    private Button btnSaveUser;

    private final ObservableList<User> dataList = FXCollections.observableArrayList();

    @FXML
    void addUser(ActionEvent event) {

    }

    @FXML
    void deleteUser(ActionEvent event) {

    }

    @FXML
    void updateUser(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        loginColumn.setCellValueFactory(new PropertyValueFactory<>("login"));
        lastAccessColumn.setCellValueFactory(new PropertyValueFactory<>("lastAccessDate"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
        tableUsers.setItems(dataList);
    }

    @FXML
    private void clickItem(MouseEvent event) {
        if (event.getClickCount() == 2) {
            btnAddUsers.setDisable(true);
            btnSaveUser.setDisable(false);
            User user = tableUsers.getSelectionModel().getSelectedItem();
            fieldUsername.setText(user.getUserEntry().getLogin());
            fieldEmail.setText(user.getEmail());
            fieldPassword.setText(user.getUserEntry().getPassword());
            cmbCountry.setValue(user.getCountry().getName());
            cmbRole.setValue(user.getUserEntry().getRole());
        }
    }

    @FXML
    private void clearFields() {
        fieldUsername.setText("");
        fieldEmail.setText("");
        fieldPassword.setText("");
        cmbCountry.setValue("");
        cmbRole.setValue("");
        btnAddUsers.setDisable(false);
    }
}
