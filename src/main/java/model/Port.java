package model;

//import com.example.demo.Container;
import com.example.demo.GenList;
import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("ports")
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
            //curent will be null if the next line isnt not put in
            shipInPort.setCurrentPort(this);
    }

    public GenList<ContainerShip> getShipsInPort() {
        return shipsInPort;
    }


    public void setShipsInPort(GenList<ContainerShip> shipsInPort) {
        this.shipsInPort = shipsInPort;
    }
    public void launchShip(ContainerShip ship) {
        if (ship!=null&& shipsInPort.contains(ship)) {
            // Remove the ship from the list of ships in the port
            shipsInPort.remove(ship);
            ship.launchAtSea();
            ship.setCurrentPort(null);
            System.out.println("ship" + ship.getShipName() + " launched from port ");
        }
        else {
            System.out.println("ship is not in the list of ships in the port");
        }
    }
    public void dockShip(ContainerShip ship) {
        if (!shipsInPort.contains(ship)) {
            addShipInPort(ship); // If the ship is not already in the port, add it
            ship.setCurrentPort(this);  // Set the port for the ship
        }
    }
    //    public void findShipInPort(ContainerShip ship){
//        GenList<ContainerShip>.GenNode<ContainerShip> current=shipsInPort.first;
//        while (current!=null) {
//            ContainerShip ship = current.getData();
//            if (ship.getShipName().equals(shipName)){
//                return ship;
//            }
//            current = current.next;
//        }
//        return null;
//    }
//    public ContainerShip findShipOnPort(String shipName){
//        GenList<ContainerShip>.GenNode<ContainerShip> current=shipInPort.first;
//
//    }


    @Override
    public String toString() {
        return "Port{" +
                "portName='" + portName + '\'' +
//                ", nextPort=" + nextPort +
                ", portCode='" + portCode + '\'' +
                ", portCountry='" + portCountry + '\'' +
//                ", containersOnShore=" + containersOnShore +
//                ", shipsInPort=" + shipsInPort +
                '}';
    }
}


