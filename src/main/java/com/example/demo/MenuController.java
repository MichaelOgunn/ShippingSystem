package com.example.demo;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import model.Container;
import model.ContainerShip;
import model.Pallet;
import model.Port;



//import java.awt.Label;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
     private TextField searchBar;
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
    private TextArea shipLocationsTextArea;

    @FXML
    private TextArea palletTextArea;


    @FXML
    private Button addContainerButton;
    @FXML
    private Button deleteContainerButton;

    @FXML
    private Button AddPaletteButton;
    @FXML
    private Button DeletePaletteButton;

    @FXML
    private Button addPortButton;
    @FXML
    private Button deletePortButton;
    @FXML
    private Button addShipButton;
    @FXML
    private Button deleteShipButton;
    @FXML
    private Button load;
    @FXML
    private Button unLoad;

    @FXML
    private Button launchButton;
    @FXML
    private Button UnLaunchButton;


    @FXML
    private ChoiceBox<String> shipStatusChoice;
    @FXML
    private ChoiceBox<String> portChoice ;
    @FXML
    private ChoiceBox<String> listOfShip;
    @FXML
    private ChoiceBox<String> listOfShip2;
    @FXML
    private ChoiceBox<String> portChoice1;
    @FXML
    private ChoiceBox<String> portChoice2;

    @FXML
    private ChoiceBox<String> listOfContainers;
    @FXML
    private ListView allGoods;
    @FXML
    private ListView wholeSystem;
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
    /**
     * The function "listShip" iterates through a list of ports and their container ships, and returns a string containing
     * the names and identifiers of all the container ships.
     *
     * @return The method is returning a string representation of a list of ships.
     */
    public String listShip() {
        StringBuilder shipListString = new StringBuilder();

        // declaring a variable named "currentP" of type "GenNode<Port>" which is a nested class within
        // the "GenList<Port>" class. It is then assigning the value of the "first" property of the "portList" object to
        // the "currentP" variable.
//        GenList<Port>.GenNode<Port> currentP = portList.first;
        GenList<ContainerShip>.GenNode<ContainerShip> currentS = shipList.first;
//        while (currentP != null) {
//
//
//        GenList<ContainerShip>.GenNode<ContainerShip> current = currentP.getData().getShipsInPort().first;
//
//        while (current != null) {
//            ContainerShip ship = current.getData();
//            // Append ship details to the shipListString.
//            // You can format this according to your needs.
//            shipListString.append(ship.getShipName()).append(" (").append(ship.getShipIdentifier()).append(")\n");
//            current = current.next;
//        }
//
//        currentP=currentP.next;
//    }
        while (currentS != null) {
            ContainerShip ship = currentS.getData();
            // Append ship details to the shipListString.
            // You can format this according to your needs.
            shipListString.append(ship.getShipName()).append(" (").append(ship.getShipIdentifier()).append(")\n");
            currentS = currentS.next;

        }
        return shipListString.toString();
    }
//
    public String listContainer(){
        StringBuilder containerListString = new StringBuilder();
        GenList<Container>.GenNode<Container> current = containerList.first;
        while (current != null){
            Container container = current.getData();
            containerListString.append(container.getContainerNumber()).append(" (")
                    .append(container.getContainerSize()).append(") ")
                    .append(shipStatusChoice.getValue()).append("\n");

            current = current.next;
        }
        return containerListString.toString();
    }
    public String listPallets() {
        StringBuilder palletListS = new StringBuilder();
        GenList<Pallet>.GenNode<Pallet> current = palletList.first;
        while(current != null){
            Pallet pallet = current.getData();
            palletListS.append(pallet.getGoodsDescription()).append(" (")
                    .append(pallet.getQuantity()).append(")\n");
            current= current.next;
        }
        return palletListS.toString();
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
    public ContainerShip findShipByName(String shipId) {
        GenList<ContainerShip>.GenNode<ContainerShip> current = shipList.first;
        while (current != null) {
            ContainerShip ship = current.getData();
            if (ship.getShipName().equals(shipId)) {
                return ship;
            }
            current = current.next;
        }
        return null;
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
        if ( country.isEmpty() || portName.isEmpty() || portCode.isEmpty()) {
            showMessage("Input details");
        }else

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
        if (portToDelete == null){
            showMessage("Port not found");
        }

        else
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


        if (ShipName.isEmpty() || ShipIdentifier.isEmpty() || flagState.isEmpty() || photographUrl.isEmpty()) {
            showMessage("Please input details");
        } else {
            ContainerShip newShip = new ContainerShip(ShipName, ShipIdentifier, flagState, photographUrl);
            String selectedSatus = shipStatusChoice.getValue();
            System.out.println(selectedSatus);
            if (selectedSatus == null){
                showMessage("Please select a status");
            }
           else if ("In Port".equals(selectedSatus)) {
                String selectedPort = portChoice.getValue();

                if (selectedPort == null){
                    showMessage("Please select a port");
                }

                else {
                    Port port = findPortByName(selectedPort);
                    if (port != null) {
                        port.addShipInPort(newShip);
                        shipList.add(newShip);
                    }
                    shipListTextArea.setText(listShip());
                }

            }else {
                shipList.add(newShip);

                shipListTextArea.setText(listShip());
            }
        }
    }
    public void deleteShip(ActionEvent event){
        String shipName = ShipNameField.getText();

        ContainerShip shipToDelete = findShipByName(shipName);
        if (shipToDelete == null){
            showMessage("Ship not found");
        }

        else
            // Add the new port to your linked list
            // `portlist.addPort(newPort);` is calling the `addPort()` method of the `portlist` object, which is an instance of
            // the `PortLinkedList` class. This method adds the `newPort` object to the linked list, effectively adding a new
            // port to the list of ports.
            shipList.remove(shipToDelete) ;


        // `portTextArea.setText(portlist.listPorts());` is setting the text of the `portTextArea` to the result of the
        // `listPorts()` method of the `portlist` object.
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
                ContainerShip containerShip = findShipByName(shipId);
                if (containerShip != null) {
                    containerShip.addContainer(container);
                    containerList.add(container);

                    containerListTextArea.setText(listContainer());
                }

            }
        }else {
            String selectedPort = portChoice1.getValue();

            if (selectedPort != null){
                Port port = findPortByName(selectedPort);
                port.addContainerOnShore(container);
                containerList.add(container);

            }
        }

        containerListTextArea.setText(listContainer());
    }




    public void addPallete(ActionEvent event) {
        String goodsDescription = goodsDescriptionField.getText();
        double weight = Double.parseDouble(totalWeightField.getText());
        double size = Double.parseDouble(totalSizeField.getText());
        int quantity = Integer.parseInt(quantityField.getText());
        int unitValue = Integer.parseInt(unitValueField.getText());
        if (goodsDescription.isEmpty() || unitValueField.getText().isEmpty() ||
                totalSizeField.getText().isEmpty() || quantityField.getText().isEmpty()) {
            showMessage("Please input details");
        } else {
            Pallet goods = new Pallet(goodsDescription, weight, size, quantity, unitValue);
            String selectedContainer = listOfContainers.getValue();
            // The above code is checking if the `goodsDescription` is empty or if the `weight` is null. If either of these
            // conditions is true, the code inside the if statement will be executed.

            if (selectedContainer != null) {
                Container container = findContainerByNumber(selectedContainer);
                if (container != null) {
                    container.addPallet(goods);
                    palletList.add(goods);
                }

            }else {
                showMessage("please select container");
            }
            palletTextArea.setText(listPallets());
        }
    }



    private void initializeShipStatusChoice(ChoiceBox<String> shipStatusChoice) {
        shipStatusChoice.getItems().clear();
        shipStatusChoice.getItems().addAll("In Port", "At sea");
    }
    public void initialize() {
        System.out.println("Controller initialized.");
        initializeShipStatusChoice(shipStatusChoice);
        initializePortChoice(portChoice,portChoice1,portChoice2);
        initializeListOfShips(listOfShip,listOfShip2);
        initializeContainer(listOfContainers);
        displayShipLocations();
        drillDown();
        portTextArea.setText(listPorts());
        shipListTextArea.setText(listShip());
        containerListTextArea.setText(listContainer());
        palletTextArea.setText(listPallets());
    }
    public void loadAll() {
        try {
            load();
            initialize();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * The function initializes a choice box with a list of available port names.
     */
    public void initializePortChoice(ChoiceBox<String> portChoice, ChoiceBox<String> portChoice1, ChoiceBox<String> portChoice2) {

        // The above code is declaring a variable named "portNames" of type List<String> and assigning it the value
        // returned by the method "getPortNamesFromList()".
        List<String> portNames = getPortNamesFromList();
        portChoice.getItems().clear();
        portChoice1.getItems().clear();
        portChoice2.getItems().clear();

        if(!portList.isEmpty()) {
        // Get the list of available port names from the portList


        // Add the port names to the portChoice
        portChoice.getItems().addAll(portNames);
        portChoice1.getItems().addAll(portNames);
        portChoice2.getItems().addAll(portNames);
        System.out.println("PortChoice items added successfully.");
        }else {
            System.out.println("PortList is empty. PortChoice will not be populated.");
        }

    }
    public void initializeListOfShips(ChoiceBox<String> listOfShip, ChoiceBox<String>listOfShip2) {
        // The above code is declaring a variable `shipNames` of type `List<String>` and calling two methods
        // `getShipNames()` and `getShipOnPort()`.
        List<String> shipNames = getShipNames();//getShipOnPort();
        List<String> shipNamesOnSea = getShipNamesOnSea();

        listOfShip.getItems().clear();
        listOfShip2.getItems().clear();
        if(!shipList.isEmpty()) {
            //get the list of available ship names from shiplist
            listOfShip.getItems().addAll(shipNamesOnSea);
            listOfShip2.getItems().addAll(shipNames);
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
    public List<String> getShipNamesOnSea() {
    List<String> shipNamesOnsea = new LinkedList<>();
    GenList<ContainerShip>.GenNode<ContainerShip> current = shipList.first;
    while (current != null){
        if ("At Sea".equals(current.getData().getLocationStatus())){
            shipNamesOnsea.add(current.getData().getShipName());
        }
        current= current.next;
    }
    return shipNamesOnsea;
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

        ContainerShip shipToUnload = findShipByName(shipIdentifier);
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

        ContainerShip shipToLoad = findShipByName(shipIdentifier);
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
    public void Lauch(ActionEvent event) {
        String shipName = listOfShip2.getValue();

        ContainerShip shipToLaunch = findShipByName(shipName);

         if (shipToLaunch == null) {
            showMessage("please select a ship to launch");
        }
         Port shipLocationPort = shipToLaunch.getCurrentPort();
         if (shipLocationPort==null && shipToLaunch != null) {
            showMessage("ship is not in a port");
        }else if (shipLocationPort!= null) {
             shipLocationPort.launchShip(shipToLaunch);

             showMessage("ship is now at sea");
         }

    }
    public void dock(ActionEvent event) {
        String shipName = listOfShip2.getValue();
        String portName = portChoice2.getValue();
        ContainerShip shipToDock = findShipByName(shipName);
        Port portTodock = findPortByName(portName);

        if (shipToDock == null || portTodock == null) {
            showMessage("please select a ship to dock and the port ");
        }
        else {
            portTodock.dockShip(shipToDock);
            showMessage("ship is now docked at "+ portTodock.getPortName());
        }

    }
    public void displayShipLocations() {
        StringBuilder shipLocationsString = new StringBuilder();
        GenList<ContainerShip>.GenNode<ContainerShip> currentS = shipList.first;

        while (currentS != null) {
            ContainerShip ship = currentS.getData();
            shipLocationsString.append(ship.getShipName())
                    .append(": ");

            if ("In Port".equals(ship.getLocationStatus())) {
                shipLocationsString.append("In Port at ")
                        .append(ship.getPortName());
            } else {
                shipLocationsString.append("At Sea");
            }

            shipLocationsString.append("\n");

            currentS = currentS.next;
        }

        shipLocationsTextArea.setText(shipLocationsString.toString());
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
        palletTextArea.setText(listPallets());
    }
    public void seeAllGoods() {
        allGoods.getItems().clear();
        GenList<Container>.GenNode<Container> cont = containerList.first;
        while (cont != null) {
            allGoods.getItems().add("container"+ cont.getData());
            GenList<Pallet>.GenNode<Pallet> containerPallet = cont.getData().getPallets().first;
            while (containerPallet != null) {
                allGoods.getItems().add("\tPallet"+ containerPallet.getData());

                containerPallet = containerPallet.next;
            }
            cont= cont.next;
        }


    }
    public void drillDown(){
        wholeSystem.getItems().clear();
        GenList<Port>.GenNode<Port> port = portList.first;
        while (port != null) {
            wholeSystem.getItems().add("Port"+ port.getData());
            GenList<ContainerShip>.GenNode<ContainerShip> ship = shipList.first;
            while (ship != null) {
                wholeSystem.getItems().add("\tship"+ ship.getData());
                GenList<Container>.GenNode<Container> container = containerList.first;
                while (container != null) {
                    wholeSystem.getItems().add("\t\tContainer"+ container.getData());
                    GenList<Pallet>.GenNode<Pallet> palette = palletList.first;
                    while (palette != null) {
                        wholeSystem.getItems().add("\t\t\tPalette"+ palette.getData());
                    }container= container.next;
                }ship=ship.next;
            }port = port.next;
        }
    }

    public void search(){
        allGoods.getItems().clear();
        String searchForGoods = searchBar.getText();
       Pallet foundGoods =  findPalletByDescription(searchForGoods);

        if (foundGoods != null){
            allGoods.getItems().add(foundGoods);
        }
        else{
            showMessage("no Good Found");
        }

    }
    private Container suggestedContP(Pallet  goods, GenList<Container> containers){
        Container bestMatch = null;
            double TotalSpace = Double.MAX_VALUE;
        GenList<Container>.GenNode<Container> currentc = containers.first;
         while (currentc != null ){
             Container container = currentc.getData();
             if (container.canAccomodate(goods)){
                 double goodsSpace = container.capacity();
                 if ( goodsSpace < TotalSpace){
                     TotalSpace = goodsSpace;
                     bestMatch = container;
                 }

             }currentc = currentc.next;
         }return bestMatch;
    }
    public void smartAdd(ActionEvent event){
        String goodsDescription = goodsDescriptionField.getText();
        double weight = Double.parseDouble(totalWeightField.getText());
        double size = Double.parseDouble(totalSizeField.getText());
        int quantity = Integer.parseInt(quantityField.getText());
        int unitValue = Integer.parseInt(unitValueField.getText());
        Pallet good = new Pallet(goodsDescription,weight,size,quantity,unitValue);
        if (goodsDescription.isEmpty() || unitValueField.getText().isEmpty() ||
                totalSizeField.getText().isEmpty() || quantityField.getText().isEmpty()) {
            showMessage("Please input details");
        }else {
            Container suggestedContainer = suggestedContP(good, containerList);
            if (suggestedContainer != null){
                    suggestedContainer.addPallet(good);
                    palletList.add(good);
                    showMessage("Good added successfully to:" + suggestedContainer.getContainerNumber());
            }
            else {
                showMessage("no suitable containers found pls add a new container");
            }
            palletTextArea.setText(listPallets());
        }

    }
    // The above code is using the Java annotation `@SuppressWarnings` to suppress unchecked warnings for the entire class
    // or method. This means that the code is telling the compiler to ignore any warnings related to unchecked operations,
    // such as using a generic type without specifying its type argument.
    @SuppressWarnings("unchecked")
    public void load() throws Exception {
        //list of classes that you wish to include in the serialisation, separated by a comma
        Class<?>[] classes = new Class[] { GenList.class, Port.class,ContainerShip.class, Container.class, Pallet.class};

        //setting up the xstream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        xstream.allowTypes(classes);

        //doing the actual serialisation to an XML file
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader(fileName()));
        portList = (GenList<Port>) is.readObject();
        is.close();
    }
    public void saveAll() throws Exception {
        //list of classes that you wish to include in the serialisation, separated by a comma
        Class<?>[] classes = new Class[] { Port.class,ContainerShip.class, Container.class, Pallet.class};

        //setting up the xstream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        xstream.allowTypes(classes);
        ObjectOutputStream out =  xstream.createObjectOutputStream(new FileWriter(fileName()));
        out.writeObject(portList);
        out.close();
    }
    public String fileName() {
        return "ShipmentManager.xml";
    }
    public void resetSystem(ActionEvent event) {
        // Clear data structures
        shipList.reset();
        portList.reset();
        containerList.reset();
        palletList.reset();

        // Clear GUI components
        shipListTextArea.clear();
        containerListTextArea.clear();
        palletTextArea.clear();
        shipLocationsTextArea.clear();
        wholeSystem.getItems().clear();



        showMessage("System reset successfully");
    }
    public void calculateValues(ActionEvent event){
        String containerS = listOfContainers.getValue();
        Container selectedContainer = findContainerByNumber(containerS);
        if(selectedContainer!= null){
            double value = selectedContainer.value();
            showMessage("value of good in selected container:" + value);
        }else{
            showMessage("please select a container");
        }
    }
}
