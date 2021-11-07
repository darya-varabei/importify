package com.example.importify.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class SettingsController {
    @FXML
    private Pane pnUsers;

    @FXML
    private Label lblUsername;

    @FXML
    private Label lblUserRole;

    @FXML
    private ComboBox<?> cmbChooseCountry;

    @FXML
    private ListView<?> listMessages;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnAddMessage;

    @FXML
    private TextArea fieldAddMessage;
}
