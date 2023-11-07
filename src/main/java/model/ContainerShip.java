package model;

//import com.example.demo.Container;
import com.example.demo.GenList;

public class ContainerShip {
    private String ShipName;
    private String ShipIdentifier;
    private  String flagState;
    private String photographUrl;
    private Port currentPort;
    private GenList<Container> containersOnShip;


    public ContainerShip(String ShipName, String ShipIdentifier, String flagState, String photographUrl) {
        this.ShipName = ShipName;
        this.ShipIdentifier = ShipIdentifier;
        this.flagState = flagState;
        this.photographUrl = photographUrl;
        this.currentPort = null;
        this.containersOnShip = new GenList<>();

    }

    public String getShipName() {
        return ShipName;
    }

    public void setShipName(String shipName) {
        ShipName = shipName;
    }

    public String getShipIdentifier() {
        return ShipIdentifier;
    }

    public void setShipIdentifier(String shipIdentifier) {
        ShipIdentifier = shipIdentifier;
    }

    public String getFlagState() {
        return flagState;
    }

    public void setFlagState(String flagState) {
        this.flagState = flagState;
    }

    public String getPhotographUrl() {
        return photographUrl;
    }

    public void setPhotographUrl(String photographUrl) {
        this.photographUrl = photographUrl;
    }

    public void setCurrentPort(Port currentPort) {
        this.currentPort = currentPort;
    }
    public Port  getCurrentPort() {
        return currentPort;
    }

    public void dockAtPort(Port port) {
        currentPort = port;
    }

    public void launchAtSea(){
        currentPort = null;
    }
    // Load a container onto the ship
    public void loadContainer(Container container) {
        containersOnShip.add(container);
    }

    // Unload a container from the ship
    public void unloadContainer(Container container) {
        containersOnShip.remove(container);
    }


    public void addContainer(Container containerOnShip) {
        containersOnShip.add(containerOnShip);

    }
}
