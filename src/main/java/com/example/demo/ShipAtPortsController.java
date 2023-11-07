//package com.example.demo;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.ChoiceBox;
//import javafx.scene.control.TextField;
//import model.ContainerShip;
//
//import java.util.List;
//
//public class ShipAtPortsController {
//    @FXML
//    private Button addShipButton;
//    @FXML
//    private ChoiceBox<String> shipStatusChoice;
//    @FXML
//    private TextField ShipNameField;
//    @FXML
//    private TextField ShipIdentifierField;
//    @FXML
//    private TextField flagStateField;
//    @FXML
//    private TextField photographUrlField;
//
//
//    @FXML
//    private ChoiceBox<String> portChoice;
//
//
//
//
//
//
//    public void addShip(ActionEvent event) {
//        String ShipName = ShipNameField.getText();
//        String ShipIdentifier = ShipIdentifierField.getText();
//        String flagState = flagStateField.getText();
//        String photographUrl = photographUrlField.getText();
//
//        ContainerShip newShip = new ContainerShip(ShipName, ShipIdentifier, flagState, photographUrl);
//
//
//            String ChoiceOfPort = portChoice.getSelectionModel().getSelectedItem();
//
//
//
//
//    }
//    private void initializeShipStatusChoice(ChoiceBox<String> shipStatusChoice) {
//        shipStatusChoice.getItems().addAll("In Port", "At sea");
//    }
//    public void initialize() {
//        initializeShipStatusChoice(shipStatusChoice);
//        initializePortChoice();
//    }
//
//    /**
//     * The function initializes a choice box with a list of available port names.
//     */
//    private void initializePortChoice() {
//        List<String> portNames = portlist.getAllPortNames();
//
//        portChoice.getItems().addAll(portNames);
//
//    }
//    public void handlePortchoice(ActionEvent event) {
//        String selectedPort = portChoice.getValue();
//        // handling the selected port to display information
//
//    }
//}
