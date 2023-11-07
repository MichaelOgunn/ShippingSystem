package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField portNameField;
    @FXML
    private TextField portTextArea;
    @FXML
    private TextField portCodeField;
    @FXML
    private TextField countryField;
    @FXML
    private Button getStarted;

    @FXML
    private Button addButton;
//    private PortLinkedList portlist;

    public void getStartedButtonClicked() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
            Parent root = loader.load();
            Scene nextScene = new Scene(root);

            Stage stage = (Stage) getStarted.getScene().getWindow();
            stage.setScene(nextScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    }



