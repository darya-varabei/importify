package com.example.importify;

import animatefx.animation.FadeIn;
import com.example.importify.Connection.Client;
import com.example.importify.Controller.LoginController;
import com.example.importify.Controller.SettingsController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 970, 550);
        FXMLLoader secondPage = new FXMLLoader(HelloApplication.class.getResource("mainScreen.fxml"));
        Scene secondScene = new Scene(secondPage.load(), 1216, 790);

 //       FXMLLoader settingPage = new FXMLLoader(HelloApplication.class.getResource("settingView.fxml"));
        //Scene settingScene = new Scene(settingPage.load(), 1216, 790);

        LoginController firstPaneController = fxmlLoader.getController();
        firstPaneController.setSecondScene(secondScene);
//
//        SettingsController settingsController = settingPage.getController();
//        settingsController.setSecondScene(scene);

        stage.setScene(scene);
        stage.show();
        new FadeIn(scene.getRoot()).play();
        new FadeIn(secondScene.getRoot()).play();
    }

    public static void main(String[] args) {
//        Client client = new Client();
//        client.connectToServer();
        launch(args);
    }
}