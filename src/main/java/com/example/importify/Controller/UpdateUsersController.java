package com.example.importify.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class UpdateUsersController {

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

}
