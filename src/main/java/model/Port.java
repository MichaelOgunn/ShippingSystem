package model;

//import com.example.demo.Container;
import com.example.demo.GenList;

public class Port {
    public String portName;
    public Port nextPort;
    public String portCode;
    public String portCountry;

    private GenList<Container> containersOnShore;
    private GenList<ContainerShip> shipsInPort;


    public Port(String portName, String internationalPortCode, String country) {
        this.portName = portName;
        this.portCode = internationalPortCode;
        this.portCountry = country;
        this.containersOnShore = new GenList<>();
        this.shipsInPort = new GenList<>();
    }
    public String getPortName() {
        return portName;
    }



    public void setPortName(String portName) {
        this.portName = portName;
    }

    public String getPortCode() {
        return portCode;
    }

    public void setPortCode(String portCode) {
        this.portCode = portCode;
    }

    public String getPortCountry() {
        return portCountry;
    }

    public void setPortCountry(String portCountry) {
        this.portCountry = portCountry;
    }

    // Add a container to on shore storage
    public void addContainerOnShore(Container container) {
        containersOnShore.add(container);
    }

    // Retrieve a list of containers on shore
    public GenList<Container> getContainersOnShore() {
        return containersOnShore;
    }


    // Method to remove a container from onshore storage
    public void removeContainerFromOnShore(Container container) {
        containersOnShore.remove(container);
    }
    public void addShipInPort(ContainerShip shipInPort) {
            shipsInPort.add(shipInPort);
    }
}


