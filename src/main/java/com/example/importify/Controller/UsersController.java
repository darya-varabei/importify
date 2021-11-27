package com.example.importify.Controller;

import com.example.importify.Model.UserView;
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
import java.util.Date;
import java.util.ResourceBundle;

public class UsersController implements Initializable {
    @FXML
    private Pane pnUsers;

    @FXML
    private TableColumn<UserView, Integer> idColumn;

    @FXML
    private TableColumn<UserView, String> loginColumn;

    @FXML
    private TableColumn<UserView, Date> lastAccessColumn;

    @FXML
    private TableColumn<UserView, String> countryColumn;

    @FXML
    private TableColumn<UserView, String> roleColumn;

    @FXML
    private TableView<UserView> tableUsers;

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

    private final ObservableList<UserView> dataList = FXCollections.observableArrayList();

    @FXML
    void addUser(ActionEvent event) {
        String username = fieldUsername.getText();
        String password = fieldPassword.getText();
        Integer id = 0;
        String country = cmbCountry.getValue();
        String role = cmbRole.getValue();
        UserView userToAdd = new UserView(username, password, id, "", country, role);
   dataList.add(userToAdd);
    }

    @FXML
    void deleteUser(ActionEvent event) {
        UserView user = tableUsers.getSelectionModel().getSelectedItem();
        removeUser(user.getId());
        tableUsers.refresh();
    }

    private void removeUser(int id) {
        dataList.forEach((tab) -> {
            if (tab.getId() == id) {
                dataList.remove(tab);
            }
        });
    }

    @FXML
    void updateUser(ActionEvent event) {
        UserView user = tableUsers.getSelectionModel().getSelectedItem();
        user.setLogin(fieldUsername.getText());
        user.setPassword(fieldPassword.getText());
        user.setCountry(cmbCountry.getValue());
        user.setCountry(cmbRole.getValue());

        removeUser(user.getId());
        dataList.add(user);
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
            UserView user = tableUsers.getSelectionModel().getSelectedItem();
            fieldUsername.setText(user.getLogin());
            fieldEmail.setText(String.valueOf(user.getId()));
            fieldPassword.setText(user.getPassword());
            cmbCountry.setValue(user.getCountry());
            cmbRole.setValue(user.getRole());
        }
    }

    @FXML
    private void clearFields() {
        fieldUsername.setText("");
        fieldEmail.setText("");
        fieldPassword.setText("");
        cmbCountry.setValue("Выберите страну");
        cmbRole.setValue("Выберите роль");
        btnAddUsers.setDisable(false);
    }
}
