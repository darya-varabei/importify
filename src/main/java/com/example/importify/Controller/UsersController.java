package com.example.importify.Controller;

import com.example.importify.Model.CountryImportExport;
import com.example.importify.Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class UsersController implements Initializable {
    @FXML
    private Pane pnUsers;

    @FXML
    private TableColumn<User, Integer> idColumn;

    @FXML
    private TableColumn<User, String> loginColumn;

    @FXML
    private TableColumn<User, Date> lastAccessColumn;

    @FXML
    private TableColumn<User, String> countryColumn;

    @FXML
    private TableColumn<User, String> roleColumn;

    @FXML
    private TableView<User> tableUsers;

    @FXML
    private Button btnAddUsers;

    @FXML
    private Button btnUpdateUser;

    @FXML
    private Button btnDeleteUser;
    private final ObservableList<User> dataList = FXCollections.observableArrayList();

    @FXML
    void addUser(ActionEvent event) {

    }

    @FXML
    void deleteUser(ActionEvent event) {

    }

    @FXML
    void updateUser(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        loginColumn.setCellValueFactory(new PropertyValueFactory<>("login"));
        lastAccessColumn.setCellValueFactory(new PropertyValueFactory<>("lastAccessDate"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));

//        User case1 = new User(1, "wdcwed", new LocalDate(12, 12, 12), 12456.9);
//        User case2 = new User(2, "wefjkn", new LocalDate(12, 12, 12), 12456.9);
//        User case3 = new User(3, "ewyuh", new LocalDate(12, 12, 12), 12456.9);
//        User case4 = new User(4, "weduwe", new LocalDate(12, 12, 12), 12456.9);
//        User case5 = new User(5, "ehgd", "LocalDate(12, 12, 12)", 12456.9);
//        dataList.addAll(case1, case2, case3, case4, case5);
        tableUsers.setItems(dataList);
    }

    @FXML
    private void clickItem(MouseEvent event) {
        if (event.getClickCount() == 2) {

        }
    }
}
