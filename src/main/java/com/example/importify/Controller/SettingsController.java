package com.example.importify.Controller;

import com.example.importify.Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {
    @FXML
    private Pane pnUsers;

    @FXML
    private Label lblUsername;

    @FXML
    private Label lblUserRole;

    @FXML
    private ComboBox<String> cmbChooseCountry;

    @FXML
    private ListView<?> listMessages;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnAddMessage;

    private User user = User.getInstance();

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        lblUsername.setText(user.getUserEntry().getLogin());
//        lblUserRole.setText(user.getUserEntry().getRole());
//        cmbChooseCountry.setValue(user.getCountry().getName());
    }
}
