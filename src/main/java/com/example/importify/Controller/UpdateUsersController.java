package com.example.importify.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class UpdateUsersController {

    @FXML private UsersController usersController;

    @FXML
    private Pane pnUpdateUser;

    @FXML
    private TextField fieldUsername;

    @FXML
    private PasswordField fieldPassword;

    @FXML
    private ComboBox<?> cmbRole;

    @FXML
    private ComboBox<?> cmbCountry;

    @FXML
    private Button btnSaveUser;

    public void setSampleController(UsersController controller) {
        this.usersController = controller;
    }

    public void setFieldUsername(String username) {
        fieldUsername.setText(username);
    }

}
