package com.example.importify.Controller;

import animatefx.animation.ZoomIn;
import com.example.importify.Connection.Client;
import com.example.importify.Connection.ServerManager;
import com.example.importify.Model.User;
import com.example.importify.Model.UserEntry;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
//import animatefx.*;

public class LoginController implements Initializable{

    @FXML
    private AnchorPane anchRoot;

    @FXML
    private ImageView imageStart;

    @FXML
    private Pane pnSignUp;

    @FXML
    private Label lblEntryTitle;

    @FXML
    private Label lblEntrySubtitle;

    @FXML
    private Label lblLogin;

    @FXML
    private TextField txtFieldLogin;

    @FXML
    private Label lblPassword;

    @FXML
    private PasswordField txtFieldPass;

    @FXML
    private Button btnForgotPass;

    @FXML
    private Button btnAccept;

    @FXML
    private Button btnSignIn;

    @FXML
    private Pane pnSignIn;

    @FXML
    private Button btnSignUp;

    @FXML
    private Button btnCreate;

    @FXML
    private PasswordField txtFieldPass1;

    @FXML
    private TextField txtFieldEmail;

    @FXML
    private Label lblRegistSubtitle;

    @FXML
    private Label lblRegistTitle;

    @FXML
    private Label lblPassword1;

    @FXML
    private Label lblLogin1;

    @FXML
    private TextField txtFieldLogin11;

    @FXML
    private Label lblEmail;

    @FXML
    private PasswordField txtFieldPassRep;

    @FXML
    private Label lblPasswordRep;

    @FXML
    private Button bConnect;

    @FXML
    private TextField eip;

    @FXML
    private TextField eip1;

    private Scene secondScene;

    private Socket clientSocket = null;
    private OutputStream coos = null;
    private InputStream cois = null;
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);
    private ServerManager serverManager = null;


    public void setSecondScene(Scene scene) {
        secondScene = scene;
    }

    @FXML
    private void handleAuthorizationAction(ActionEvent event) {
        if (event.getSource().equals(btnSignIn)) {
            new ZoomIn(pnSignIn).play();
            pnSignIn.toFront();
        }
        else {
            new ZoomIn(pnSignUp).play();
            pnSignUp.toFront();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {





        /*btnSignUp.setOnAction(actionEvent -> {
            serverManager.sendString(new UserRegistration(txtFieldEmail.getText(), txtFieldLogin11.getText(), txtFieldPass1.getText()));
            var isRegister = (boolean)serverManager.readObject();
        });*/
    }

    @FXML
    public void EnterMainScreen(ActionEvent event) {
        serverManager.sendString("Authorization");
        serverManager.sendObject(new UserEntry(txtFieldLogin.getText(), txtFieldPass.getText()));
        User user;

        if ((user = (User)serverManager.readObject()) != null) {
            Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            primaryStage.setScene(secondScene);
        }
    }

    @FXML
    private void connect(ActionEvent event) {
        var client = new Client();
        client.connectToServer(eip1.getText(), Integer.parseInt(eip.getText()));
        serverManager = client.interactionsWithServer;

        if (serverManager != null) {
            if (event.getSource().equals(btnSignIn)) {
                new ZoomIn(pnSignIn).play();
                pnSignIn.toFront();
            }
            else {
                new ZoomIn(pnSignUp).play();
                pnSignUp.toFront();
            }
        }
    }

//    @FXML
//    void ClickConnect(ActionEvent event)
//    {
//        alert.setTitle("Информация");
//        alert.setHeaderText(null);
//        alert.setContentText("Подключение выполнено успешно");
//
//        String port = ePort.getText();
//
//        try
//        {
//            clientSocket = new Socket(eip.getText(), Integer.parseInt(port));//установление //соединения между локальной машиной и указанным портом узла сети
//            cois = clientSocket.getInputStream();//создание //потока ввода
//            coos = clientSocket.getOutputStream();//создание //потока вывода
//            bConnect.setDisable(true);
//            bDisconnect.setDisable(false);
//            bSend.setDisable(false);
//            eString1.setDisable(false);
//            ePort.setDisable(true);
//            eip.setDisable(true);
//        }
//
//        catch(Exception e)
//        {
//            e.printStackTrace();//выполнение метода исключения е
//            alert.setTitle("Ошибка");
//            alert.setContentText(e.getMessage());
//        }
//
//        alert.showAndWait();
//    }

}
