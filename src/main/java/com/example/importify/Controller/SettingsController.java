package com.example.importify.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
    private Scene fxmlLoader;

    public void setSecondScene(Scene scene) {
        fxmlLoader = scene;
    }
    @FXML
    private TextArea fieldAddMessage;

    @FXML
    private void exit(ActionEvent event) {
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(fxmlLoader);
    }
}
