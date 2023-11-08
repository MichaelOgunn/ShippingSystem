package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Container;
import model.ContainerShip;
import model.Pallet;
import model.Port;

import java.util.LinkedList;
import java.util.List;

public class MenuController {
    // The `@FXML` annotation is used to inject a reference to a JavaFX component defined in an FXML file into a controller
    // class. In this case, `@FXML private TextField portNameField;` is injecting a reference to a `TextField` component
    // with the id `portNameField` defined in the corresponding FXML file. This allows the controller class to access and
    // manipulate the `TextField` component.
    @FXML
    private TextField portNameField;
    @FXML
    private TextArea portTextArea;
    @FXML
    private TextField portCodeField;
    @FXML
    private TextField countryField;
     @FXML
     private TextField ShipNameField;
     @FXML
     private TextField ShipIdentifierField;
     @FXML
     private TextField ShipIdentifierFieldFind;
     @FXML
     private TextField containerNumberFieldFind;
     @FXML
     private TextField flagStateField;
     @FXML
     private TextField photographUrlField;
     @FXML
     private TextArea shipListTextArea;
    @FXML
    private TextField containerNumberField;
    @FXML
    private TextField containerSizeField;
    @FXML
    private TextArea containerListTextArea;
    @FXML
    private TextField goodsDescriptionField;
    @FXML
    private TextField quantityField;
    @FXML
    private TextField unitValueField;
    @FXML
    private TextField totalWeightField;
    @FXML
    private TextField totalSizeField;

    @FXML
    private Button addContainerButton;
    @FXML
    private Button deleteContainerButton;

    @FXML
    private Button AddPaletteButton;
    @FXML
    private Button DeletePaletteButton;

    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button addShipButton;
    @FXML
    private Button load;
    @FXML
    private Button unLoad;


    @FXML
    private ChoiceBox<String> shipStatusChoice;
    @FXML
    private ChoiceBox<String> portChoice ;
    @FXML
    private ChoiceBox<String> listOfShip;
    @FXML
    private ChoiceBox<String> portChoice1;
    @FXML
    private ChoiceBox<String> listOfContainers;

    @FXML
    private RadioButton shipOrPort;


    private GenList<Port> portList = new GenList<>();
    private GenList<ContainerShip> shipList = new GenList<>();

    private GenList<Container> containerList = new GenList<>();
    private GenList<Pallet> palletList = new GenList<>();



    public String listPorts() {
        StringBuilder portListString = new StringBuilder();
        GenList<Port>.GenNode<Port> current = portList.first;
        while (current != null) {
            Port port = current.getData();
            portListString.append(port.getPortName()).append(" (").append(port.getPortCode()).append(", ").append(port.getPortCountry()).append(")\n");
            current = current.next;
        }
        return portListString.toString();
    }
    private String listShip() {
        StringBuilder shipListString = new StringBuilder();
        GenList<ContainerShip>.GenNode<ContainerShip> current = shipList.first;
        while (current != null) {
            ContainerShip ship = current.getData();
            // Append ship details to the shipListString.
            // You can format this according to your needs.
            shipListString.append(ship.getShipName()).append(" (").append(ship.getShipIdentifier()).append(")\n");
            current = current.next;
        }
        return shipListString.toString();
    }
    public String listContainer(){
        StringBuilder containerListString = new StringBuilder();
        GenList<Container>.GenNode<Container> current = containerList.first;
        while (current != null){
            Container container = current.getData();
            containerListString.append(container.getContainerNumber()).append(" (").append(container.getContainerSize()).append(")\n");
            current = current.next;
        }
        return containerListString.toString();
    }
    public Port findPortByName(String portName) {
        GenList<Port>.GenNode<Port> current = portList.first;
        while (current != null) {
            Port port = current.getData();
            if (port.getPortName().equals(portName)) {
                return port;
            }
            current = current.next;
        }
        return null; // Port not found
    }
    public Container findContainerByNumber(String number) {
        GenList<Container>.GenNode<Container> current = containerList.first;
        while (current != null) {
            Container container = current.getData();
            if (container.getContainerNumber().equals(number)) {
                return container;
            }
            current = current.next;
        }
        return null; // Container not found
    }
    private ContainerShip findShipOnSea(String shipId) {
        GenList<ContainerShip>.GenNode<ContainerShip> current = shipList.first;
        while (current != null) {
            ContainerShip ship = current.getData();
            if (ship.getShipName().equals(shipId)) {
                return ship;
            }
            current = current.next;
        }
        return null; // Container not found
    }

    public Pallet findPalletByDescription(String description) {
        GenList<Pallet>.GenNode<Pallet> current = palletList.first;
        while (current != null) {
            Pallet palette = current.getData();
            if (palette.getGoodsDescription().equals(description)) {
                return palette;
            }
            current = current.next;
        }return null; // pallet not found
    }



    public void port(ActionEvent event) {
        String portName = portNameField.getText();
        String portCode = portCodeField.getText();
        String country = countryField.getText();

        Port newPort = new Port(portName, portCode, country);

        // Add the new port to your linked list
        // `portlist.addPort(newPort);` is calling the `addPort()` method of the `portlist` object, which is an instance of
        // the `PortLinkedList` class. This method adds the `newPort` object to the linked list, effectively adding a new
        // port to the list of ports.
        portList.add(newPort);


        // `portTextArea.setText(portlist.listPorts());` is setting the text of the `portTextArea` to the result of the
        // `listPorts()` method of the `portlist` object.
        portTextArea.setText(listPorts());

    }


    /**
     * The addPort() function creates a new Port object using the values entered in the text fields and adds it to a linked
     * list.
     */
    public void addPort() {
        String portName = portNameField.getText();
        String portCode = portCodeField.getText();
        String country = countryField.getText();

        Port newPort = new Port(portName, portCode, country);
        System.out.println("New Port Details: " + newPort);

        // Add the new port to your linked list
        // `portlist.addPort(newPort);` is calling the `addPort()` method of the `portlist` object, which is an instance of
        // the `PortLinkedList` class. This method adds the `newPort` object to the linked list, effectively adding a new
        // port to the list of ports.
        portList.add(newPort);


        // `portTextArea.setText(portlist.listPorts());` is setting the text of the `portTextArea` to the result of the
        // `listPorts()` method of the `portlist` object.
        portTextArea.setText(listPorts());
        System.out.println("PortList Size: " + portList.size());
        System.out.println("PortList Contents: " + listPorts());

    }
    public void deletePort(ActionEvent event) {
        String portName = portNameField.getText();

        Port portToDelete = findPortByName(portName);


        // Add the new port to your linked list
        // `portlist.addPort(newPort);` is calling the `addPort()` method of the `portlist` object, which is an instance of
        // the `PortLinkedList` class. This method adds the `newPort` object to the linked list, effectively adding a new
        // port to the list of ports.
        portList.remove(portToDelete);


        // `portTextArea.setText(portlist.listPorts());` is setting the text of the `portTextArea` to the result of the
        // `listPorts()` method of the `portlist` object.
        portTextArea.setText(listPorts());
    }
//    public void setPortChoice(ChoiceBox<String> portChoice) {
//        this.portChoice = portChoice;
//    }



    public void addShip(ActionEvent event) {
        String ShipName = ShipNameField.getText();
        String ShipIdentifier = ShipIdentifierField.getText();
        String flagState = flagStateField.getText();
        String photographUrl = photographUrlField.getText();



        ContainerShip newShip = new ContainerShip(ShipName, ShipIdentifier, flagState, photographUrl);
        String selectedSatus = shipStatusChoice.getValue();
        if ("In port".equals(selectedSatus)){
            String selectedPort = portChoice.getValue();

            if (selectedPort != null){
                Port port = findPortByName(selectedPort);
                if (port != null){
                    port.addShipInPort(newShip);
                }
                shipListTextArea.setText(listShip());
            }

        }
        shipList.add(newShip);

        shipListTextArea.setText(listShip());
        }
    public void addContainer(ActionEvent event) {
        boolean addtoShip = shipOrPort.isSelected();
        String containerNumber = containerNumberField.getText();
        int containerSize = Integer.parseInt(containerSizeField.getText());
        Container container = new Container(containerNumber, containerSize);

        if(addtoShip){
            String shipId = listOfShip.getValue();
            if (shipId != null) {
                ContainerShip containerShip = findShipOnSea(shipId);
                if (containerShip != null) {
                    containerShip.addContainer(container);
                    containerListTextArea.setText(listContainer());
                }
            }
        }else {
            String selectedPort = portChoice1.getValue();

            if (selectedPort != null){
                Port port = findPortByName(selectedPort);
                port.addContainerOnShore(container);
            }
        }
        containerList.add(container);

        containerListTextArea.setText(listContainer());}




    public void addPallete(ActionEvent event){
        String goodsDescription = goodsDescriptionField.getText();
        double weight = Double.parseDouble(unitValueField.getText());
        double size = Double.parseDouble(unitValueField.getText());
        int quantity = Integer.parseInt(unitValueField.getText());
        int unitValue = Integer.parseInt(unitValueField.getText());
        Pallet goods = new Pallet(goodsDescription,weight,size,quantity,unitValue);
        String selectedContainer = listOfContainers.getValue();
        if (selectedContainer != null){
            Container container= findContainerByNumber(selectedContainer);
            container.addPallet(goods);
        }
        palletList.add(goods);
    }



    private void initializeShipStatusChoice(ChoiceBox<String> shipStatusChoice) {
        shipStatusChoice.getItems().clear();
        shipStatusChoice.getItems().addAll("In Port", "At sea");
    }
    public void initialize() {
        System.out.println("Controller initialized.");
        initializeShipStatusChoice(shipStatusChoice);
        initializePortChoice(portChoice,portChoice1);
        initializeListOfShips(listOfShip);
        initializeContainer(listOfContainers);
    }

    /**
     * The function initializes a choice box with a list of available port names.
     */
    private void initializePortChoice(ChoiceBox<String> portChoice, ChoiceBox<String> portChoice1) {

        // The above code is declaring a variable named "portNames" of type List<String> and assigning it the value
        // returned by the method "getPortNamesFromList()".
        List<String> portNames = getPortNamesFromList();
        portChoice.getItems().clear();
        portChoice1.getItems().clear();

        if(!portList.isEmpty()) {
        // Get the list of available port names from the portList


        // Add the port names to the portChoice
        portChoice.getItems().addAll(portNames);
        portChoice1.getItems().addAll(portNames);
        System.out.println("PortChoice items added successfully.");
        }else {
            System.out.println("PortList is empty. PortChoice will not be populated.");
        }

    }
    private void initializeListOfShips(ChoiceBox<String> listOfShip) {
        List<String> shipNames = getShipNames();
        listOfShip.getItems().clear();
        if(!shipList.isEmpty()) {
            //get the list of available ship names from shiplist
            listOfShip.getItems().addAll(shipNames);
            System.out.println("listOfShip items added successfully");
        }else{
            System.out.println("ListOfShips is empty. listOfShips will not be populated.");
        }
    }
    public void initializeContainer(ChoiceBox<String> listOfContainers){
        List<String> containerNumbers = getContainerNumbers();
        listOfContainers.getItems().clear();
        if(!containerList.isEmpty()){
            listOfContainers.getItems().addAll(containerNumbers);
            System.out.println("ListOfContainers items added successfully");
        }else{
            System.out.println("ListOfContainers is empty. listOfContainers will not be populated");
        }

    }
    public List<String> getShipNames(){
        List<String> shipNames = new LinkedList<>();
        GenList<ContainerShip>.GenNode<ContainerShip> current = shipList.first;
        while (current != null){
            ContainerShip ship = current.getData();
            shipNames.add(ship.getShipName());
            current = current.next;
        }
        return shipNames;
    }
    public List<String> getPortNamesFromList() {
        List<String> portNames = new LinkedList<>();
        GenList<Port>.GenNode<Port> current = portList.first;

        while (current != null) {
            Port port = current.getData();
            portNames.add(port.getPortName());
            current = current.next;
        }
        return portNames;
    }
    public List<String> getContainerNumbers() {
        List<String> containerNumbers = new LinkedList<>();
        GenList<Container>.GenNode<Container> current = containerList.first;
        while (current != null) {
            Container container = current.getData();
            containerNumbers.add(container.getContainerNumber());
            current = current.next;
        }
        return containerNumbers;
    }
    public void loadContainer(ActionEvent event) {
        String shipIdentifier = ShipIdentifierFieldFind.getText();
        String containerNumber = containerNumberFieldFind.getText();

        ContainerShip shipToUnload = findShipOnSea(shipIdentifier);
        Container containerToLoad = findContainerByNumber(containerNumber);

        if (shipToUnload != null && containerToLoad != null) {
            shipToUnload.loadContainer(containerToLoad);

            Port port = shipToUnload.getCurrentPort();
            if (port !=null) {
                port.removeContainerFromOnShore(containerToLoad);
            }
            shipListTextArea.setText(listShip());
            containerListTextArea.setText(listContainer());
            showMessage("Container loaded onto the ship successfully.");
        }else {
            showMessage("Container not loaded, Container or ship not found");
        }
    }
    public void unloadContainer(ActionEvent event) {
        String shipIdentifier = ShipIdentifierFieldFind.getText();
        String containerNumber = containerNumberFieldFind.getText();

        ContainerShip shipToLoad = findShipOnSea(shipIdentifier);
        Container containerToUnload = findContainerByNumber(containerNumber);

        if (shipToLoad != null && containerToUnload != null) {
            shipToLoad.unloadContainer(containerToUnload);

            Port port = shipToLoad.getCurrentPort();
            if (port !=null) {
                port.removeContainerFromOnShore(containerToUnload);
            }
            shipListTextArea.setText(listShip());
            containerListTextArea.setText(listContainer());
            showMessage("Container Unloaded From the ship successfully.");
        }else {
            showMessage("Container not Unloaded, Container or ship not found");
        }
    }

    public void showMessage(String message) {
        // The above code is creating an instance of the Alert class and setting its type to INFORMATION.
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }







    public void removeContainer(ActionEvent event) {
        String containerNumber = containerNumberField.getText();

        Container containerToDelete = findContainerByNumber(containerNumber);
        containerList.remove(containerToDelete);
        containerListTextArea.setText(listContainer());
    }

    public void deletePallet(ActionEvent event) {
        String description = goodsDescriptionField.getText();

        Pallet palletToDelete = findPalletByDescription(description);

        if (palletToDelete != null) {
            palletList.remove(palletToDelete);
        }
    }




}
