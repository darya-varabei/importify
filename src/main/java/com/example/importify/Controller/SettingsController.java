package com.example.importify.Controller;

import com.example.importify.Connection.Client;
import com.example.importify.Connection.ServerManager;
import com.example.importify.Model.CountryImportExport;
import com.example.importify.Model.ErrorMessage;
import com.example.importify.Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private ListView<String> listMessages;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnAddMessage;

    private ServerManager serverManager = null;
//    private Scene fxmlLoader;
//    public void setSecondScene(Scene scene) {
//        fxmlLoader = scene;
//    }

    @FXML
    private TextArea fieldAddMessage;

    Client client = new Client();

    @FXML
    private void exit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Выход из аккаунта");
        alert.setHeaderText("Подтверждение");
        alert.setContentText("Вы уверены, что хотите выйти из аккаунта?");
        if(alert.showAndWait().get() == ButtonType.OK) {
            try {
                Client.interactionsWithServer.closeConnection();

                Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                primaryStage.close();
            }
            catch (Exception e) {}
        }
        else {
            alert.close();
        }
    }

    @FXML
    private void addMessage() {
        var user = User.getInstance();

        if (fieldAddMessage.getText() != "") {
            if (user.getUserEntry() != null) {
                if (user.getUserEntry().getRole() == "User") {
                    listMessages.getItems().add(fieldAddMessage.getText());
                    listMessages.refresh();
                }
            }
            Client.interactionsWithServer.sendData("error", fieldAddMessage.getText());
        }
    }

    @FXML
    private void getMessages() {
        if (client.interactionsWithServer != null) {
            ObservableList<String> data;
            data = FXCollections.observableArrayList(Client.interactionsWithServer.getUserMessages());
            listMessages.setItems(data);
            listMessages.refresh();
        }
    }

    public void setupAccess() {
        var user = User.getInstance();

        lblUsername.setText('@' + user.getUserEntry().getLogin());
        lblUserRole.setText(user.getUserEntry().getRole());
        cmbChooseCountry.setValue(user.getCountry().getName());
        ObservableList<String> data;
        if (Client.interactionsWithServer != null) {
            serverManager = client.interactionsWithServer;
            data = FXCollections.observableArrayList(serverManager.getStrings("countries"));
            cmbChooseCountry.setItems(data);
        }
        if (user.getUserEntry() != null) {
            if (user.getUserEntry().getRole() == "User") {
               listMessages.setVisible(false);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        if (user.getUserEntry() == null) {
//            listMessages.setVisible(false);
//        }
//        getMessages();
//        lblUsername.setText(user.getUserEntry().getLogin());
//        lblUserRole.setText(user.getUserEntry().getRole());
//        cmbChooseCountry.setValue(user.getCountry().getName());
    }
}
