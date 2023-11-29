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

            // The line `Stage stage = (Stage) getStarted.getScene().getWindow();` is retrieving the stage (window) that
            // contains the `getStarted` button.
            Stage stage = (Stage) getStarted.getScene().getWindow();

            stage.setScene(nextScene);
            stage.show();
        // The `catch (Exception e)` block is used to catch any exceptions that may occur during the execution of the code
        // within the `try` block. If an exception occurs, the `e.printStackTrace()` statement is called, which prints the
        // stack trace of the exception to the console. This helps in debugging and identifying the cause of the exception.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    }



