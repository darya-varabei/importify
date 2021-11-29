package com.example.importify.Controller;

import animatefx.animation.ZoomIn;
import com.example.importify.Connection.Client;
import com.example.importify.Connection.ServerManager;
import com.example.importify.Model.User;
import com.example.importify.Model.UserEntry;
import com.example.importify.Model.UserRegister;
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
    private Label lblInvalidConnection;

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
    private Label lblPasswordDoNotMatch;

    @FXML
    private Label lblLoginAlreadyExists;

    @FXML
    private Label lblEmailAlreadyExists;

    @FXML
    private Label lblInvalidRegEntry;

    @FXML
    private Label lblInvalidLoginEntry;

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
//        serverManager.sendString("Registration");
//        serverManager.sendObject(new UserEntry(txtFieldLogin.getText(), txtFieldPass.getText()));
//        User user;

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
    }

    @FXML
    public void EnterMainScreen(ActionEvent event) {
        serverManager.sendString("Authorization");
        serverManager.sendObject(new UserEntry(txtFieldLogin.getText(), txtFieldPass.getText()));
        User user = User.getInstance();

        if ((user = (User)serverManager.readObject()) != null) {
            Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            primaryStage.setScene(secondScene);
        }
        else {
            lblInvalidLoginEntry.setVisible(true);
        }
    }

    @FXML
    public void registUser(ActionEvent event) {
        serverManager.sendString("Registration");
        serverManager.sendObject(new UserRegister(txtFieldLogin.getText(), txtFieldPass1.getText(), txtFieldPassRep.getText(), txtFieldEmail.getText()));
        UserRegister user;

        if (txtFieldPass1.getText() != txtFieldPassRep.getText()) {
            lblPasswordDoNotMatch.setVisible(true);
        }

        if ((user = (UserRegister)serverManager.readObject()) != null) {
            Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            primaryStage.setScene(secondScene);
        }
        else {
            lblInvalidLoginEntry.setVisible(true);
        }
    }

    @FXML
    private void connect(ActionEvent event) {
        var client = new Client();
        client.connectToServer(eip1.getText(), Integer.parseInt(eip.getText()));
        serverManager = client.interactionsWithServer;

        if (serverManager != null) {
            lblInvalidConnection.setVisible(false);
            if (event.getSource().equals(btnSignIn)) {
                new ZoomIn(pnSignIn).play();
                pnSignIn.toFront();
            }
            else {
                new ZoomIn(pnSignUp).play();
                pnSignUp.toFront();
            }
        }
        else {
            lblInvalidConnection.setVisible(true);
        }
    }

    @FXML
    void ClickConnect(ActionEvent event)
    {
        alert.setTitle("Информация");
        alert.setHeaderText(null);
        alert.setContentText("Подключение выполнено успешно");

        String port = eip1.getText();

        try
        {
            clientSocket = new Socket(eip.getText(), Integer.parseInt(port));
            cois = clientSocket.getInputStream();
            coos = clientSocket.getOutputStream();
            bConnect.setDisable(true);
            eip.setDisable(true);
        }

        catch(Exception e)
        {
            e.printStackTrace();
            alert.setTitle("Ошибка");
            alert.setContentText(e.getMessage());
        }

        alert.showAndWait();
    }

}
